package de.fspeer.backend.controller;

import de.fspeer.backend.models.Guest;
import de.fspeer.backend.repository.GuestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GuestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GuestRepository guestRepository;

    @DirtiesContext
    @Test
    void findAll_returnEmpty_ifDBEmpty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/guest"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @DirtiesContext
    @Test
    void findAll_getGuest_withGuestInDB() throws Exception {
        guestRepository.save(new Guest("1", "test", "test", "test", "test", "test", "test", "test", "test", "test", 1,"test","test","test"));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/guest"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    [
                        {
                            "guestId": "1",
                            "groupName": "test",
                            "arrivalDate": "test",
                            "departureDate": "test",
                            "firstName": "test"
                        }
                    ]
                    """));
    }

    @DirtiesContext
    @Test
    void findById_getGuest_withGuestInDB() throws Exception {
            guestRepository.save(new Guest("1", "test", "test", "test", "test", "test", "test", "test", "test", "test", 1,"test","test","test"));

            mockMvc.perform(MockMvcRequestBuilders.get("/guest/1"))
                    .andExpect(status().isOk())
                    .andExpect(content().json("""
                    {
                        "guestId": "1",
                        "groupName": "test",
                        "arrivalDate": "test"
                    }
                    """));
        }

    @DirtiesContext
    @Test
    void saveGuest_shouldReturnNewGuest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/guest")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                               "firstName": "Ferdinand",
                               "lastName": "Speer",
                               "birthDate": "19-02-1990",
                               "nationality": "German",
                               "street": "Siechenstrasse 37b",
                               "city": "Bamberg",
                               "zip": 96052,
                               "email": "ferdinandspeer@gmail.com",
                               "phoneNumber": "017670126560",
                               "travelDocumentNumber": "GHJI987KL"
                             }
                        """)
                )
                .andExpect(status().isOk())
                .andExpect(content().json("""
                            {
                               "firstName": "Ferdinand",
                               "lastName": "Speer",
                               "birthDate": "19-02-1990",
                               "nationality": "German",
                               "street": "Siechenstrasse 37b",
                               "city": "Bamberg",
                               "zip": 96052,
                               "email": "ferdinandspeer@gmail.com",
                               "phoneNumber": "017670126560",
                               "travelDocumentNumber": "GHJI987KL"
                             }"""));
    }

    @DirtiesContext
    @Test
    void deleteGuestById() throws Exception {
    guestRepository.save(new Guest("1", "test", "test", "test", "test", "test", "test", "test", "test", "test", 1,"test","test","test"));

    mockMvc.perform(MockMvcRequestBuilders.delete("/guest/1"))
            .andExpect(status().isOk());

    assertTrue(guestRepository.findAll().isEmpty());
    }

    @DirtiesContext
    @Test
    void updateGuest_whenGuestInDB() throws Exception {
        guestRepository.save(new Guest("1", "test", "test", "test", "test", "test", "test", "test", "test", "test", 1,"test","test","test"));

        mockMvc.perform(MockMvcRequestBuilders.put("/guest/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                        "guestId": "1",
                        "firstName": "Ferdinand",
                        "lastName": "Speer",
                        "birthDate": "19-02-1990"
                        }
                """)
                )
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    {
                        "guestId": "1",
                        "firstName": "Ferdinand",
                        "lastName": "Speer",
                        "birthDate": "19-02-1990"
                    }
                """));

    }
}