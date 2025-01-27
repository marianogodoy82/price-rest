package com.challenge.pricerest.resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.challenge.pricerest.infrastructure.config.spring.SpringBootService;

@SpringBootTest(
      webEnvironment = SpringBootTest.WebEnvironment.MOCK,
      classes = SpringBootService.class)
@AutoConfigureMockMvc
class PriceControllerTest {

   @Autowired
   private MockMvc mvc;
   @Test
   void given14thDayAt10_whenPriceIsRetrieved_then200IsReceived() throws Exception {
      mvc.perform( get("/prices/price")
               .queryParam("applicationDate", "2020-06-14T10:00:00")
               .queryParam("productId", "35455")
               .queryParam("brandId", "1")
               .contentType(MediaType.APPLICATION_JSON)
         )
         .andExpect(status().isOk())
         .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
         .andExpect(jsonPath("price").value(BigDecimal.valueOf(35.5)));
   }

   @Test
   void given14thDayAt16_whenPriceIsRetrieved_then200IsReceived() throws Exception {
      mvc.perform( get("/prices/price")
               .queryParam("applicationDate", "2020-06-14T16:00:00")
               .queryParam("productId", "35455")
               .queryParam("brandId", "1")
               .contentType(MediaType.APPLICATION_JSON)
         )
         .andExpect(status().isOk())
         .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
         .andExpect(jsonPath("price").value(BigDecimal.valueOf(25.45)));
   }


   @Test
   void given14thDayAt21_whenPriceIsRetrieved_then200IsReceived() throws Exception {
      mvc.perform( get("/prices/price")
               .queryParam("applicationDate", "2020-06-14T21:00:00")
               .queryParam("productId", "35455")
               .queryParam("brandId", "1")
               .contentType(MediaType.APPLICATION_JSON)
         )
         .andExpect(status().isOk())
         .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
         .andExpect(jsonPath("price").value(BigDecimal.valueOf(35.50)));
   }
   @Test
   void given15thDayAt10_whenPriceIsRetrieved_then200IsReceived() throws Exception {
      mvc.perform( get("/prices/price")
               .queryParam("applicationDate", "2020-06-15T10:00:00")
               .queryParam("productId", "35455")
               .queryParam("brandId", "1")
               .contentType(MediaType.APPLICATION_JSON)
         )
         .andExpect(status().isOk())
         .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
         .andExpect(jsonPath("price").value(BigDecimal.valueOf(30.50)));
   }

   @Test
   void given16thDayAt21_whenPriceIsRetrieved_then200IsReceived() throws Exception {
      mvc.perform( get("/prices/price")
               .queryParam("applicationDate", "2020-06-16T21:00:00")
               .queryParam("productId", "35455")
               .queryParam("brandId", "1")
               .contentType(MediaType.APPLICATION_JSON)
         )
         .andExpect(status().isOk())
         .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
         .andExpect(jsonPath("price").value("38.95"));
   }

   @Test
   void testHandlePriceNotFoundException() throws Exception {
      // Simula una solicitud que lanza PriceNotFoundException
      mvc.perform( get("/prices/price")
                   .queryParam("applicationDate", "2020-06-14T10:00:00")
                   .queryParam("productId", "99999") // Producto no existente
                   .queryParam("brandId", "1")
                   .contentType(MediaType.APPLICATION_JSON)
            )
             .andExpect(status().isNotFound())
             .andExpect(jsonPath("$.message").value("Price not found")); // Mensaje personalizado
   }
}
