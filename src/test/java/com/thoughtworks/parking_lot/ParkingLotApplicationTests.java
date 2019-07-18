package com.thoughtworks.parking_lot;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingLotApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void should_return_ok_when_delete_parking_lot() throws Exception{
        this.mockMvc.perform(delete("/parking-lots/83862bdc-743c-4d84-aa95-b5b3c33758bd")).andDo(print()).andExpect(status().isOk());
    }
    @Test
    public void should_return_all_parking_lot() throws Exception{
        String string=this.mockMvc.perform(get("/parking-lots")).andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        JSONArray json = JSONArray.fromObject(string);
        Assertions.assertEquals("panda",json.getJSONObject(0).getString("name"));
    }
    @Test
    public void should_return_all_parking_lot_with_page_size_2() throws Exception{
        String string=this.mockMvc.perform(get("/parking-lots").param("page","1").param("pageSize","2")).andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        JSONArray json = JSONArray.fromObject(string);
        Assertions.assertEquals(2,json.size());
    }
    @Test
    public void should_return_all_parking_lot_with_page_size_default() throws Exception{
        String string=this.mockMvc.perform(get("/parking-lots").param("page","1")).andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        JSONArray json = JSONArray.fromObject(string);
        Assertions.assertEquals(3,json.size());
    }
    @Test
    public void should_return_parking_lot_when_search_by_id() throws Exception{
        String string=this.mockMvc.perform(get("/parking-lots/83862bdc-743c-4d84-aa95-b5b3c33758bd")).andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        JSONObject jsonObject=JSONObject.fromObject(string);
        Assertions.assertEquals("panda",jsonObject.getString("name"));
    }
    @Test
    public void should_return_ok_and_updated_parking_lot_when_update_parking_lot_by_id() throws Exception{
        JSONObject jsonObject= JSONObject.fromObject(new ParkingLot("milo",22,"north"));
        String string=this.mockMvc.perform(put("/parking-lots/83862bdc-743c-4d84-aa95-b5b3c33758bd").contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8).content(jsonObject.toString())).andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        JSONObject jsonObject1=JSONObject.fromObject(string);
        Assertions.assertEquals("milo",jsonObject1.getString("name"));
    }
}
