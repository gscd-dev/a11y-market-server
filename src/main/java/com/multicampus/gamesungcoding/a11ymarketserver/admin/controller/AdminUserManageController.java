package com.multicampus.gamesungcoding.a11ymarketserver.admin.controller;

import com.multicampus.gamesungcoding.a11ymarketserver.admin.service.AdminUserManageService;
import com.multicampus.gamesungcoding.a11ymarketserver.user.model.UserAdminDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AdminUserManageController {
    private final AdminUserManageService userService;

    // 관리자 - 전체 사용자 조회
    @GetMapping("/v1/admin/users")
    public List<UserAdminDTO> inquireUsers() {
        log.info("AdminUserManageController - inquireUsers");

        return userService.listAll();
    }

    // 관리자 - 사용자 권한 변경
    @PatchMapping("/v1/admin/users/{userId}/permission")
    public String changeUserPermission(@PathVariable String userId, @RequestParam String role) {
        log.info("AdminUserManageController - changeUserPermission");

        return userService.changePermission(userId, role);
    }

    // 관리자 - 판매자 승인 대기 목록 조회 (미구현)
    @GetMapping("/v1/admin/sellers/pending")
    public String inquirePendingSellers() {
        log.info("AdminUserManageController - inquirePendingSellers");

        // Placeholder for future implementation
        return "Pending sellers inquiry functionality is under development.";
    }

    // 관리자 - 판매자 상태 변경 (미구현)
    @PatchMapping("/v1/admin/sellers/{sellerId}/status")
    public String changeSellerStatus(@PathVariable String sellerId, @RequestParam String status) {
        log.info("AdminUserManageController - changeSellerStatus");

        // Placeholder for future implementation
        return "Change seller status functionality is under development.";
    }

    // 관리자 - 판매자 정보 수정 (미구현)
    @PatchMapping("/v1/admin/sellers/{sellerId}")
    public String updateSellerInfo(@PathVariable String sellerId, @RequestBody String sellerInfo) {
        log.info("AdminUserManageController - updateSellerInfo");

        // Placeholder for future implementation
        return "Update seller information functionality is under development.";
    }

    // 관리자 - 상품 승인 대기 목록 조회 (미구현)
    @GetMapping("/v1/admin/products/pending")
    public String inquirePendingProducts() {
        log.info("AdminUserManageController - inquirePendingProducts");

        // Placeholder for future implementation
        return "Pending products inquiry functionality is under development.";
    }

    // 관리자 - 상품 상태 변경 (미구현)
    @PatchMapping("/v1/admin/products/{productId}/status")
    public String changeProductStatus(@PathVariable String productId, @RequestParam String status) {
        log.info("AdminUserManageController - changeProductStatus");

        // Placeholder for future implementation
        return "Change product status functionality is under development.";
    }

    // 관리자 - 전체 주문 조회 (미구현)
    @GetMapping("/v1/admin/orders")
    public String inquireAllOrders() {
        log.info("AdminUserManageController - inquireAllOrders");

        // Placeholder for future implementation
        return "All orders inquiry functionality is under development.";
    }

    // 관리자 - 특정 주문 조회 (미구현)
    @GetMapping("/v1/admin/orders/{orderId}")
    public String inquireOrderDetails(@PathVariable String orderId) {
        log.info("AdminUserManageController - inquireOrderDetails");

        // Placeholder for future implementation
        return "Order details inquiry functionality is under development.";
    }

    // 관리자 - 주문 상태 변경 (미구현)
    @PatchMapping("/v1/admin/orders/{orderId}")
    public String changeOrderStatus(@PathVariable String orderId, @RequestParam String status) {
        log.info("AdminUserManageController - changeOrderStatus");

        // Placeholder for future implementation
        return "Change order status functionality is under development.";
    }
}
