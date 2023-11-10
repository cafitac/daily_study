package com.fastcampus.helloecommeradmin.controller;

import com.fastcampus.helloecommeradmin.domain.order.OrderDetailView;
import com.fastcampus.helloecommeradmin.exception.NotFoundOrderException;
import com.fastcampus.helloecommeradmin.service.OrderService;
import com.fastcampus.helloecommeradmin.service.dto.OrderDTO;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class OrderController {

    public static final String MENU_KEY = "orders";
    private final OrderService orderService;

    @GetMapping({"/orders/", "/orders"})
    public String index(Model model) {
        List<OrderDetailView> orderDetailViews = orderService.findAllOrderDetailView();
        model.addAttribute("orders", orderDetailViews);
        model.addAttribute("menuId", MENU_KEY);
        return "/orders/orders";
    }

    @GetMapping("/orders/order-detail")
    public String detail(@RequestParam Long orderId, Model model) {
        Optional<OrderDTO> optionalOrderDTO = orderService.findById(orderId);
        OrderDTO orderDTO = optionalOrderDTO.orElseThrow(
            () -> new NotFoundOrderException("Not found order info"));
        model.addAttribute("order", orderDTO);
        model.addAttribute("menuId", MENU_KEY);
        return "/orders/order-detail";
    }
}