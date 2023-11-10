package com.fastcampus.helloecommeradmin.service;

import com.fastcampus.helloecommeradmin.domain.customer.Customer;
import com.fastcampus.helloecommeradmin.domain.order.Order;
import com.fastcampus.helloecommeradmin.domain.order.OrderDetailView;
import com.fastcampus.helloecommeradmin.exception.NotFoundCustomerException;
import com.fastcampus.helloecommeradmin.repository.CustomerRepository;
import com.fastcampus.helloecommeradmin.repository.OrderRepository;
import com.fastcampus.helloecommeradmin.service.dto.OrderDTO;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public List<OrderDetailView> findAllOrderDetailView() {
        return orderRepository.findAllOrderDetailView();
    }

    public Optional<OrderDTO> findById(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (!optionalOrder.isPresent()) {
            return Optional.ofNullable(null);
        }
        Order order = optionalOrder.get();
        Customer customer = customerRepository.findById(order.getCustomerId())
            .orElseThrow(() -> new NotFoundCustomerException("주문 고객 정보를 찾을 수 없습니다."));
        OrderDTO orderDTO = OrderDTO.of(order.getOrderId(), order.getAmount(),
            order.getCustomerId(), customer.getCustomerName(), order.getPayType(),
            order.getOrderStatus(), order.getCreatedAt());
        return Optional.of(orderDTO);
    }
}