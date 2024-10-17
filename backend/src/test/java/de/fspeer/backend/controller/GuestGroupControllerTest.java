package de.fspeer.backend.controller;

import de.fspeer.backend.repository.GuestGroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;



@SpringBootTest
@AutoConfigureMockMvc
class GuestGroupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GuestGroupRepository guestGroupRepository;

    @DirtiesContext
    @Test
    void findAll_returnEmpty_ifDBIsEmpty(){

    }

    @DirtiesContext
    @Test
    void findAll_returnGuestGroup_ifDBHasGuestGroup(){

    }

    @DirtiesContext
    @Test
    void findById_returnGuestGroup_ifIdExists(){

    }

    @DirtiesContext
    @Test
    void saveGuestGroup_returnNewGuestGroup(){

    }

}