package com.multicampus.gamesungcoding.a11ymarketserver.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @Column(length = 36)
    private String addressId;

    @Column(length = 36, nullable = false)
    private String userId;

    @Column(length = 30)
    private String receiverName;

    @Column(length = 13)
    private String receiverPhone;

    private Integer receiverZipcode;

    @Column(length = 100)
    private String receiverAddr1;

    @Column(length = 200)
    private String receiverAddr2;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    // 배송지 정보 수정
    public void updateAddrInfo(String receiverName, String receiverPhone,
                               Integer receiverZipcode, String receiverAddr1, String receiverAddr2) {

        if (receiverName != null) {
            this.receiverName = receiverName;
        }
        if (receiverPhone != null) {
            this.receiverPhone = receiverPhone;
        }
        if (receiverZipcode != null) {
            this.receiverZipcode = receiverZipcode;
        }
        if (receiverAddr1 != null) {
            this.receiverAddr1 = receiverAddr1;
        }
        if (receiverAddr2 != null) {
            this.receiverAddr2 = receiverAddr2;
        }

    }
}
