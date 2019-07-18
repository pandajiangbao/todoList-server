package com.thoughtworks.parking_lot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingLotApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void should_return_ok_and_list_size_when_delete_parking_lot() throws Exception{
        this.mockMvc.perform(delete("/parking-lots/83862bdc-743c-4d84-aa95-b5b3c33758bd")).andDo(print()).andExpect(status().isOk());
    }

}
