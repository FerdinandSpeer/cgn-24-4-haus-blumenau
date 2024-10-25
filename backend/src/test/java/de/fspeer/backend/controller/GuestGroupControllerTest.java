package de.fspeer.backend.controller;

import de.fspeer.backend.models.GuestGroup;
import de.fspeer.backend.repository.GuestGroupRepository;
import de.fspeer.backend.service.IdService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)

class GuestGroupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IdService idService;

    @Autowired
    private GuestGroupRepository guestGroupRepository;

    @DirtiesContext
    @Test
    void findAll_returnEmpty_ifDBIsEmpty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/guestGroup"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @DirtiesContext
    @Test
    void findAll_returnGuestGroup_ifDBHasGuestGroups() throws Exception {
        guestGroupRepository.save(new GuestGroup("1", "test", List.of()));

        mockMvc.perform(MockMvcRequestBuilders.get("/guestGroup"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    [
                        {
                            "id": "1",
                            "groupName": "test",
                            "guestsDTO": []
                        }
                    ]
                    """));
    }

    @DirtiesContext
    @Test
    void findById_returnGuestGroup_ifIdExists() throws Exception {
        guestGroupRepository.save(new GuestGroup("1", "test", List.of()));

        mockMvc.perform(MockMvcRequestBuilders.get("/guestGroup/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    {
                        "id": "1",
                        "guestsDTO": []
                    }
                    """));
    }

    @DirtiesContext
    @Test
    void findById_returnException_ifIdNotExists() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/guestGroup/1"))
                .andExpect(status().isNotFound());
    }

    @DirtiesContext
@Test
void createGuestGroup_returnNewGuestGroup() throws Exception {
        when(idService.generateId()).thenReturn("1");
        mockMvc.perform(
            MockMvcRequestBuilders.post("/guestGroup")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""
                        [
                            {
                                "firstName": "test",
                                "lastName": "test",
                                "birthDate": "2000-01-01",
                                "nationality": "test",
                                "street": "test",
                                "city": "test",
                                "zip": 12345,
                                "email": "test@test.com",
                                "phoneNumber": "1234567890",
                                "travelDocumentNumber": "A1234567"
                            }
                        ]
                    """)
    )
            .andExpect(status().isOk())
            .andExpect(content().json("""
                {
                    "id": "1",
                    "guestsDTO": [
                        {
                            "firstName": "test",
                            "lastName": "test",
                            "birthDate": "2000-01-01",
                            "nationality": "test",
                            "street": "test",
                            "city": "test",
                            "zip": 12345,
                            "email": "test@test.com",
                            "phoneNumber": "1234567890",
                            "travelDocumentNumber": "A1234567"
                        }]
                }
                """)
    );
}
@DirtiesContext
    @Test
    void deleteGuestGroup_whenIdFound() throws Exception {
        guestGroupRepository.save(new GuestGroup("1", "test", List.of()));

        mockMvc.perform(MockMvcRequestBuilders.delete("/guestGroup/1"))
                .andExpect(status().isOk());

        assertTrue(guestGroupRepository.findAll().isEmpty());
    }

    @DirtiesContext
    @Test
    void updateGuestGroup_whenIdFoundInDB() throws Exception {
        guestGroupRepository.save(new GuestGroup("1", "test", List.of()));


        mockMvc.perform(MockMvcRequestBuilders.put("/guestGroup/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                        "id": "1",
                        "groupName": "Update",
                        "guestsDTO": []
                    }
                    """))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    {
                        "id": "1",
                        "groupName": "Update",
                        "guestsDTO": []
                    }
                    """));
    }


}