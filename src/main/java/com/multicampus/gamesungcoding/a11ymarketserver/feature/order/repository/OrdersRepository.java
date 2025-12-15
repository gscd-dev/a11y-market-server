package com.multicampus.gamesungcoding.a11ymarketserver.feature.order.repository;

import com.multicampus.gamesungcoding.a11ymarketserver.feature.order.entity.OrderStatus;
import com.multicampus.gamesungcoding.a11ymarketserver.feature.order.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrdersRepository extends JpaRepository<Orders, UUID> {

    // 내 주문 목록
    List<Orders> findAllByUserEmailOrderByCreatedAtDesc(String userEmail);

    //내 주문 상세
    Optional<Orders> findByOrderIdAndUserEmail(UUID orderId, String userEmail);

    // 관리자 주문 목록 조회 필터링
    @Query("""
            SELECT o FROM Orders o
            WHERE (:status IS NULL OR o.orderStatus = :status)
            AND (
                :searchType IS NULL OR :keyword IS NULL OR
                (
                    (:searchType = 'userName' AND LOWER(o.userName) LIKE LOWER(CONCAT('%', :keyword, '%')))
                    OR (:searchType = 'receiverName' AND LOWER(o.receiverName) LIKE LOWER(CONCAT('%', :keyword, '%')))
                    OR (:searchType = 'userPhone' AND o.userPhone LIKE CONCAT('%', :keyword, '%'))
                    OR (:searchType = 'receiverPhone' AND o.receiverPhone LIKE CONCAT('%', :keyword, '%'))
                    OR (:searchType = 'orderId' AND CAST(o.orderId AS string) LIKE CONCAT('%', :keyword, '%'))
                )
            )
            AND (:startDate IS NULL OR o.createdAt >= CAST(:startDate AS timestamp))
            AND (:endDate IS NULL OR o.createdAt <= CAST(:endDate AS timestamp))
            ORDER BY o.createdAt DESC
            """)
    List<Orders> searchOrders(
            @Param("searchType") String searchType,
            @Param("keyword") String keyword,
            @Param("status") OrderStatus status,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate
    );

}
