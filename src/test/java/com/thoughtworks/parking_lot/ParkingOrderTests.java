package com.thoughtworks.parking_lot;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.entity.ParkingOrder;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import com.thoughtworks.parking_lot.repository.ParkingOrderRepository;
import com.thoughtworks.parking_lot.service.ParkingOrderService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingOrderTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private ParkingOrderRepository parkingOrderRepository;
    @Autowired
    private ParkingOrderService parkingOrderService;
    @Test
    public void should_return_parking_order_when_save_parking_order() throws Exception{
        ParkingOrder parkingOrder = new ParkingOrder("milo","123456789", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        ParkingOrder save = parkingOrderRepository.save(parkingOrder);
        Assertions.assertEquals(parkingOrder,save);
    }

    @Test
    public void should_return_ok_when_save_parking_order() throws Exception{
        parkingLotRepository.saveAndFlush(new ParkingLot("panda",10,"south"));
        ParkingOrder parkingOrder = new ParkingOrder("panda","987456");
        JSONObject jsonObject=JSONObject.fromObject(parkingOrder);
        this.mockMvc.perform(post("/parking-orders").contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8)
                .content(jsonObject.toString()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void should_return_ok_and_order_status_is_false_when_close_parking_order() throws Exception{
        parkingLotRepository.saveAndFlush(new ParkingLot("panda",10,"south"));
        parkingOrderService.createOrder(new ParkingOrder("panda","987456"));
        String string=this.mockMvc.perform(put("/parking-orders/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        JSONObject jsonObject=JSONObject.fromObject(string);
        Assertions.assertEquals(false,jsonObject.getBoolean("status"));
    }
}
