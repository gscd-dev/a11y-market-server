package com.multicampus.gamesungcoding.a11ymarketserver.user.repository;

import com.multicampus.gamesungcoding.a11ymarketserver.user.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    // 전체 배송지 조회 (최신순)
    List<Address> findByUserIdOrderByCreatedAtDesc(String userId);

    // 사용자 특정 배송지 조회
    Optional<Address> findByAddressIdAndUserId(String addressId, String userId);

}
