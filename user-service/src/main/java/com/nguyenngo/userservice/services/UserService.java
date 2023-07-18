package com.nguyenngo.userservice.services;

import com.nguyenngo.userservice.dto.UserSignInDTO;
import com.nguyenngo.userservice.dto.UserSignUpDTO;
import com.nguyenngo.userservice.dto.UserUpdateDTO;
import com.nguyenngo.userservice.models.User;
import com.nguyenngo.userservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private boolean flag = false;

    public User signUp(UserSignUpDTO userSignUpDTO) {
        User user = User.builder().
                email(userSignUpDTO.getEmail()).
                password(userSignUpDTO.getPassword()).
                firstName(userSignUpDTO.getFirstName()).
                lastName(userSignUpDTO.getLastName()).
                build();
        return userRepository.save(user);
    }

    public boolean update(UserUpdateDTO userUpdateDTO, Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            user.setAddress(userUpdateDTO.getAddress());
            user.setFirstName(userUpdateDTO.getFirstName());
            user.setLastName(userUpdateDTO.getLastName());
            user.setNumberPhone(userUpdateDTO.getNumberPhone());
            user.setPassword(userUpdateDTO.getPassword());
            userRepository.save(user);
            return true;
        }

        return false;
    }

    public boolean signIn(UserSignInDTO userSignInDTO) {
        if(userRepository.findByEmailAndPassword(userSignInDTO.getEmail(), userSignInDTO.getPassword()).isPresent()) {
            flag = true;
            return true;
        }
        return false;
    }

    public Optional<User> findById(Long id) {
       return userRepository.findById(id);
    }

    public boolean checkLogin() {
        if(flag)
            return true;
        return false;
    }
}
