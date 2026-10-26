package com.routeinai.backend.address.service;

import com.routeinai.backend.address.dto.request.ChangeAddress;
import com.routeinai.backend.address.entity.Address;
import com.routeinai.backend.address.mapper.AddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressMapper addressMapper;

    public Address getAddressByUserId(Integer userId) {
        return addressMapper.findByUserId(userId).orElseThrow(() -> new RuntimeException("등록된 주소가 없습니다."));

    }

    public void changeAddress(Integer userId, ChangeAddress changeAddress) {
        Address address = Address.builder()
                .userId(userId)
                .zipCode(changeAddress.getZipCode())
                .baseAddress(changeAddress.getBaseAddress())
                .detailAddress(changeAddress.getDetailAddress())
                .build();

        boolean exist = addressMapper.findByUserId(userId).isPresent();

        if (exist) {
           addressMapper.updateAddress(address);
        } else {
            addressMapper.insertAddress(address);
        }
    }
}
