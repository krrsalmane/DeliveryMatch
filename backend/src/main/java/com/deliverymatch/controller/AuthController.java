package com.deliverymatch.controller;
import com.deliverymatch.dto.RegisterRequest;
import com.deliverymatch.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register/{role}")

    public ResponseEntity<?> register(@RequestBody RegisterRequest request, @PathVariable String role) {
        authService.register(request,role);
        return ResponseEntity.ok("register success");
    }
} 