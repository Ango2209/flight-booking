package com.nguyenngo.userservice.controller;

import com.nguyenngo.userservice.dto.UserSignInDTO;
import com.nguyenngo.userservice.dto.UserSignUpDTO;
import com.nguyenngo.userservice.dto.UserUpdateDTO;
import com.nguyenngo.userservice.models.User;
import com.nguyenngo.userservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody UserSignUpDTO userSignUpDTO) {
        if(userService.signUp(userSignUpDTO) != null)
            return ResponseEntity.ok("create account successfully");
        return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body("create account failed");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody UserUpdateDTO userUpdateDTO, @PathVariable Long id) {
        if(userService.update(userUpdateDTO, id))
            return ResponseEntity.ok("update user successfully");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user with user_id = " + id + " not exists");
    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody UserSignInDTO userSignInDTO) {
        if(userService.signIn(userSignInDTO))
            return ResponseEntity.ok("login successfully");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("email or password not correct");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> optionalUser = userService.findById(id);
        if(optionalUser.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(optionalUser.get());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }





}
