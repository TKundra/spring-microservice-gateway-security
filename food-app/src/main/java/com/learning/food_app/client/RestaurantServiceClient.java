package com.learning.food_app.client;

import com.learning.food_app.dto.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestaurantServiceClient {
    @Autowired
    private RestTemplate restTemplate;

    public OrderResponseDto fetchOrderStatus(String orderId) {
        return restTemplate.getForObject(
                "http://RESTAURANT-SERVICE/restaurant/orders/status/" + orderId,
                OrderResponseDto.class
        );
    }
}
