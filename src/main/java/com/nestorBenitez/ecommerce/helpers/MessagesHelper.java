package com.nestorBenitez.ecommerce.helpers;

import java.util.UUID;

public class MessagesHelper {
  public static String OrderCreated(UUID id){
    return "A new order with id: " + id + " was created.";
  }
}
