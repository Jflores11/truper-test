package com.truper.prueba.controller;

import com.truper.prueba.TO.UserTO;
import com.truper.prueba.security.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthService authService;

  @PostMapping
  public ResponseEntity login(@RequestBody UserTO user) {
    return ResponseEntity.ok(authService.generateToken(user));
  }

}
