package com.learning.restaurant_service.service;

import com.learning.restaurant_service.dao.RestaurantOrderDao;
import com.learning.restaurant_service.dto.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantOrderDao orderDAO;

    public String greeting() {
        return "Welcome to Swiggy Restaurant service";
    }

    public OrderResponseDto getOrder(String orderId) {
        return orderDAO.getOrders(orderId);
    }
}
