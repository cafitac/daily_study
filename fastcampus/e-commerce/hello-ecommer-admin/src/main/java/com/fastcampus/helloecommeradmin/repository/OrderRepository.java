package com.fastcampus.helloecommeradmin.repository;

import com.fastcampus.helloecommeradmin.domain.order.Order;
import com.fastcampus.helloecommeradmin.domain.order.OrderDetailView;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends
    JpaRepository<Order, Long> {

    @Query(
        "SELECT new com.fastcampus.helloecommeradmin.domain.order.OrderDetailView(o.orderId, o.customerId, c.customerName, o.amount, o.orderStatus, o.payType, o.createdAt) "
            +
            "FROM Order o JOIN Customer c ON o.customerId = c.customerId"
    )
    List<OrderDetailView> findAllOrderDetailView();
}