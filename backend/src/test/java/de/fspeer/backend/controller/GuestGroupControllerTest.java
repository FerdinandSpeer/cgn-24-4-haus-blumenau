package de.fspeer.backend.controller;

import de.fspeer.backend.models.GuestGroup;
import de.fspeer.backend.repository.GuestGroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class GuestGroupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GuestGroupRepository guestGroupRepository;

    @DirtiesContext
    @Test
    void findAll_returnEmpty_ifDBIsEmpty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/guest-group"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @DirtiesContext
    @Test
    void findAll_returnGuestGroup_ifDBHasGuestGroups() throws Exception {
        guestGroupRepository.save(new GuestGroup("1", List.of()));

        mockMvc.perform(MockMvcRequestBuilders.get("/guest-group"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    [
                        {
                            "groupId": "1",
                            "guestsDTO": []
                        }
                    ]
                    """));
    }

    @DirtiesContext
    @Test
    void findById_returnGuestGroup_ifIdExists() throws Exception {
        guestGroupRepository.save(new GuestGroup("1", List.of()));

        mockMvc.perform(MockMvcRequestBuilders.get("/guest-group/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    {
                        "guestsDTO": []
                    }
                    """));

    }

    @DirtiesContext
    @Test
    void saveGuestGroup_returnNewGuestGroup(){

    }

}