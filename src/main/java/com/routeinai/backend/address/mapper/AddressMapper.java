package com.routeinai.backend.address.mapper;

import com.routeinai.backend.address.entity.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface AddressMapper {
    Optional<Address> findByUserId(Integer userId);
    void updateAddress(Address address);
    void insertAddress(Address address);
}
