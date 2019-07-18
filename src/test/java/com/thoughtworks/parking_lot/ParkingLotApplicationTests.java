package com.thoughtworks.parking_lot;

import net.sf.json.JSONArray;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
    @Test
    public void should_return_all_parking_lot() throws Exception{
        String string=this.mockMvc.perform(get("/parking-lots")).andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        JSONArray json = JSONArray.fromObject(string);
        Assertions.assertEquals("panda",json.getJSONObject(0).getString("name"));
    }
}
