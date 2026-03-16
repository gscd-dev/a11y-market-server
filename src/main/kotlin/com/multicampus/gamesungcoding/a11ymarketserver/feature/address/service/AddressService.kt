package com.multicampus.gamesungcoding.a11ymarketserver.feature.address.service

import com.multicampus.gamesungcoding.a11ymarketserver.common.exception.DataNotFoundException
import com.multicampus.gamesungcoding.a11ymarketserver.common.exception.InvalidRequestException
import com.multicampus.gamesungcoding.a11ymarketserver.common.exception.UserNotFoundException
import com.multicampus.gamesungcoding.a11ymarketserver.feature.address.dto.AddressRequest
import com.multicampus.gamesungcoding.a11ymarketserver.feature.address.dto.AddressResponse
import com.multicampus.gamesungcoding.a11ymarketserver.feature.address.entity.AddressInfo
import com.multicampus.gamesungcoding.a11ymarketserver.feature.address.entity.Addresses
import com.multicampus.gamesungcoding.a11ymarketserver.feature.address.mapper.toResponse
import com.multicampus.gamesungcoding.a11ymarketserver.feature.address.repository.AddressRepository
import com.multicampus.gamesungcoding.a11ymarketserver.feature.user.entity.Users
import com.multicampus.gamesungcoding.a11ymarketserver.feature.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
@Transactional(readOnly = true)
class AddressService(
    private val addressRepository: AddressRepository,
    private val userRepository: UserRepository
) {

    fun getAddressList(userEmail: String): List<AddressResponse> {
        return addressRepository.findByUserUserEmailOrderByCreatedAtDesc(userEmail)
            .map { it.toResponse() }
    }

    @Transactional
    fun insertAddress(userEmail: String, req: AddressRequest): AddressResponse {
        var address = Addresses(
            user = getUserByEmail(userEmail),
            address = AddressInfo(
                addressName = req.addressName,
                receiverName = req.receiverName,
                receiverPhone = req.receiverPhone,
                receiverZipcode = req.receiverZipcode,
                receiverAddr1 = req.receiverAddr1,
                receiverAddr2 = req.receiverAddr2
            ),
            isDefault = false
        )

        address = addressRepository.save(address)
        if (req.isDefault == true) {
            setDefaultAddressByAddressId(userEmail, requireNotNull(address.addressId))
        }

        return address.toResponse()
    }

    @Transactional
    fun updateAddress(userEmail: String, addressId: String, dto: AddressRequest): AddressResponse {
        val uuid = UUID.fromString(addressId)

        addressRepository.findByAddressIdAndUserUserEmail(uuid, userEmail)
            ?: throw DataNotFoundException("해당 사용자의 주소를 찾을 수 없습니다.")

        val address = addressRepository.findByIdOrNull(uuid)
            ?: throw DataNotFoundException("해당 주소를 찾을 수 없습니다.")

        if (dto.isDefault == true) {
            setDefaultAddressByAddressId(userEmail, uuid)
        }

        address.updateAddrInfo(
            AddressInfo(
                addressName = dto.addressName,
                receiverName = dto.receiverName,
                receiverPhone = dto.receiverPhone,
                receiverZipcode = dto.receiverZipcode,
                receiverAddr1 = dto.receiverAddr1,
                receiverAddr2 = dto.receiverAddr2
            )
        )

        return address.toResponse()
    }

    @Transactional
    fun deleteAddress(userEmail: String, addressId: String) {
        val address = addressRepository.findByAddressIdAndUserUserEmail(UUID.fromString(addressId), userEmail)
            ?: throw DataNotFoundException("해당 사용자의 주소를 찾을 수 없습니다.")

        if (address.isDefault) {
            throw InvalidRequestException("기본 배송지는 삭제할 수 없습니다.")
        }
        addressRepository.delete(address)
    }

    fun getDefaultAddress(userEmail: String): AddressResponse {
        val address = addressRepository.findByUserUserEmailAndIsDefaultTrue(userEmail)
            ?: throw DataNotFoundException("기본 배송지가 설정되어 있지 않습니다.")
        return address.toResponse()
    }

    @Transactional
    fun setDefaultAddress(userEmail: String, addressId: UUID) {
        val defaultAddress = addressRepository.findByUserUserEmailAndIsDefaultTrue(userEmail)

        if (defaultAddress != null) {
            if (defaultAddress.addressId == addressId) return
            defaultAddress.setDefault(false)
        }

        setDefaultAddressByAddressId(userEmail, addressId)
    }

    private fun setDefaultAddressByAddressId(userEmail: String, addressId: UUID) {
        val address = addressRepository.findByIdOrNull(addressId)
            ?: throw DataNotFoundException("Address not found")

        if (address.user.userEmail != userEmail) {
            throw InvalidRequestException("Address does not belong to the user")
        }

        addressRepository.findByUserUserEmailAndIsDefaultTrue(userEmail)?.let {
            if (it.addressId != addressId) it.setDefault(false)
        }

        address.setDefault(true)
    }

    private fun getUserByEmail(userEmail: String): Users {
        return userRepository.findByUserEmail(userEmail)
            ?: throw UserNotFoundException("사용자를 찾을 수 없습니다.")
    }
}