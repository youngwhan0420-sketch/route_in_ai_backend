package com.routeinai.backend.user.controller;


import com.routeinai.backend.user.dto.request.ChangeUsername;
import com.routeinai.backend.user.entity.User;
import com.routeinai.backend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/{username}/exist")
    public ResponseEntity<Boolean> getExistUsername(@PathVariable String username) {
        boolean exist = userService.getUserExistByUsername(username);
        return ResponseEntity.ok(exist);
    }
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }
    @PatchMapping("/change/username/{userId}")
    public ResponseEntity<Void> changeUsername(@PathVariable Integer userId,
                                               @RequestBody ChangeUsername changeUsername) {
        userService.getUserByChangeUsername(
                userId,
                changeUsername.getUsername()
        );
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/delete/{userId}")
    public ResponseEntity<Void> withdrawUser(@PathVariable Integer userId) {
        userService.withdraw(userId);
        return ResponseEntity.ok().build();
    }

}
