package com.multicampus.gamesungcoding.a11ymarketserver.feature.address.model;

import com.multicampus.gamesungcoding.a11ymarketserver.feature.user.entity.Users;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "default_addresses")
public class DefaultAddress {
    @Id
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", updatable = false, nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Users user;

    @Column(length = 16, nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private UUID addressId;

    public void changeDefaultAddress(UUID addressId) {
        this.addressId = addressId;
    }
}
