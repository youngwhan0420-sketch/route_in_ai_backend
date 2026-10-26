package com.routeinai.backend.address.controller;

import com.routeinai.backend.address.dto.request.ChangeAddress;
import com.routeinai.backend.address.entity.Address;
import com.routeinai.backend.address.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/{userId}")
    public ResponseEntity<Address> getAddress (@PathVariable Integer userId) {
        Address address = addressService.getAddressByUserId(userId);
        return ResponseEntity.ok(address);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> changeAddress(@PathVariable Integer userId, @RequestBody ChangeAddress changeAddress) {
        addressService.changeAddress(userId, changeAddress);
        return ResponseEntity.ok().build();
    }


}
