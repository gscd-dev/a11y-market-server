package com.multicampus.gamesungcoding.a11ymarketserver.user.controller;

import com.multicampus.gamesungcoding.a11ymarketserver.user.model.AddressDTO;
import com.multicampus.gamesungcoding.a11ymarketserver.user.service.AddressService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AddressController {

    private final AddressService addressService;

    // 배송지 목록 조회
    @GetMapping("/v1/users/me/address")
    public ResponseEntity<List<AddressDTO>> getAddressList(HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        List<AddressDTO> address = addressService.getAddressList(userId);
        return ResponseEntity.ok(address);
    }

    // 배송지 등록
    @PostMapping("/v1/users/me/address")
    public ResponseEntity<AddressDTO> insertAddress(
            HttpSession session,
            @RequestBody AddressDTO addressDTO) {
        String userId = (String) session.getAttribute("userId");
        AddressDTO insertAddress = addressService.insertAddress(userId, addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(insertAddress);
    }

    // 배송지 정보 수정
    @PutMapping("/v1/users/me/address/{addressId}")
    public ResponseEntity<AddressDTO> updateAddress(
            HttpSession session,
            @PathVariable String addressId,
            @RequestBody AddressDTO addressDTO) {
        String userId = (String) session.getAttribute("userId");
        AddressDTO updateAddress = addressService.updateAddress(userId, addressId, addressDTO);
        return ResponseEntity.ok(updateAddress);
    }

    // 배송지 삭제
    @DeleteMapping("/v1/users/me/address/{addressId}")
    public ResponseEntity<Void> deleteAddress(
            HttpSession session,
            @PathVariable String addressId) {
        String userId = (String) session.getAttribute("userId");
        addressService.deleteAddress(userId, addressId);
        return ResponseEntity.noContent().build();
    }
}
