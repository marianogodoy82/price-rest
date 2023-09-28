package com.challenge.pricerest.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.challenge.pricerest.infrastructure.rest.spring.dto.PriceDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@RunWith(SpringRunner.class)
@SpringBootTest
class PriceControllerTest {

   @Test
   void given14thDayAt10_whenPriceIsRetrieved_then200IsReceived() throws IOException {

      try(CloseableHttpClient httpclient = HttpClients.createDefault()) {

         final ClassicHttpRequest httpRequest = ClassicRequestBuilder
               .get("http://localhost:8080/prices/price")
               .addParameter("applicationDate", "2020-06-14T10:00:00")
               .addParameter("productId", "35455")
               .addParameter("brandId", "1")
               .build();

         final PriceDto priceDto = httpclient.execute(httpRequest, PriceControllerTest::handleResponse);

         assertEquals(BigDecimal.valueOf(35.50).setScale(2) , priceDto.getPrice());
      }
   }

   @Test
   void given14thDayAt16_whenPriceIsRetrieved_then200IsReceived() throws IOException {

      try(CloseableHttpClient httpclient = HttpClients.createDefault()) {
         final ClassicHttpRequest httpRequest = ClassicRequestBuilder
               .get("http://localhost:8080/prices/price")
               .addParameter("applicationDate", "2020-06-14T16:00:00")
               .addParameter("productId", "35455")
               .addParameter("brandId", "1")
               .build();

         final PriceDto priceDto = httpclient.execute(httpRequest, PriceControllerTest::handleResponse);

         assertEquals(BigDecimal.valueOf(25.45).setScale(2) , priceDto.getPrice());
      }
   }


   @Test
   void given14thDayAt21_whenPriceIsRetrieved_then200IsReceived() throws IOException {

      try(CloseableHttpClient httpclient = HttpClients.createDefault()) {
         final ClassicHttpRequest httpRequest = ClassicRequestBuilder
               .get("http://localhost:8080/prices/price")
               .addParameter("applicationDate", "2020-06-14T21:00:00")
               .addParameter("productId", "35455")
               .addParameter("brandId", "1")
               .build();


         final PriceDto priceDto = httpclient.execute(httpRequest, PriceControllerTest::handleResponse);

         assertEquals(BigDecimal.valueOf(35.50).setScale(2) , priceDto.getPrice());
      }
   }
   @Test
   void given15thDayAt10_whenPriceIsRetrieved_then200IsReceived() throws IOException {

      try(CloseableHttpClient httpclient = HttpClients.createDefault()) {
         final ClassicHttpRequest httpRequest = ClassicRequestBuilder
               .get("http://localhost:8080/prices/price")
               .addParameter("applicationDate", "2020-06-15T10:00:00")
               .addParameter("productId", "35455")
               .addParameter("brandId", "1")
               .build();

         final PriceDto priceDto = httpclient.execute(httpRequest, PriceControllerTest::handleResponse);

         assertEquals(BigDecimal.valueOf(30.50).setScale(2) , priceDto.getPrice());
      }
   }

   @Test
   void given16thDayAt21_whenPriceIsRetrieved_then200IsReceived() throws IOException {

      try(CloseableHttpClient httpclient = HttpClients.createDefault()) {
         final ClassicHttpRequest httpRequest = ClassicRequestBuilder
               .get("http://localhost:8080/prices/price")
               .addParameter("applicationDate", "2020-06-16T21:00:00")
               .addParameter("productId", "35455")
               .addParameter("brandId", "1")
               .build();

         final PriceDto priceDto = httpclient.execute(httpRequest, PriceControllerTest::handleResponse);

         assertEquals(BigDecimal.valueOf(38.95).setScale(2) , priceDto.getPrice());
      }
   }

   private static PriceDto handleResponse(ClassicHttpResponse response) throws IOException, ParseException {
      return new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .registerModule(new JavaTimeModule())
            .readValue(EntityUtils.toString(response.getEntity()), PriceDto.class);
   }
}
