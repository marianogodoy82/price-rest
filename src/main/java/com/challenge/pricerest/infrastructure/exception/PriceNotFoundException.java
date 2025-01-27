package com.challenge.pricerest.infrastructure.exception;

public class PriceNotFoundException extends RuntimeException {
   public PriceNotFoundException(String message) {
      super(message);
   }
}
