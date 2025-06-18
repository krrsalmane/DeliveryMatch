package com.deliverymatch.controller;



import com.deliverymatch.dto.UpdateUserRequest;
import com.deliverymatch.model.User;
import com.deliverymatch.repository.UserRepository;
import com.deliverymatch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody UpdateUserRequest request,
                                           @RequestParam Long userId) {
        User updated = userService.updateUser(userId, request);
        return ResponseEntity.ok(updated);
    }
}
