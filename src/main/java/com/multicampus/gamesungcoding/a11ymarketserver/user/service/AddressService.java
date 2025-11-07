package com.multicampus.gamesungcoding.a11ymarketserver.user.service;

import com.multicampus.gamesungcoding.a11ymarketserver.user.model.AddressDTO;

import java.util.List;

public interface AddressService {

    // 배송지 목록 조회
    List<AddressDTO> getAddressList(String userId);

    // 배송지 추가
    AddressDTO insertAddress(String userId, AddressDTO addressDTO);

    // 배송지 수정
    AddressDTO updateAddress(String userId, String addressId, AddressDTO addressDTO);

    // 배송지 삭제
    void deleteAddress(String userId, String addressId);
}
