package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.model.UserProfile;
import com.example.demo.service.UserProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserProfileController {

    @Autowired
    private UserProfileService service;

    @PostMapping
    public ApiResponse<UserProfile> createUser(@Valid @RequestBody UserProfile userProfile){
      userProfile =  service.createUser(userProfile);
        return ApiResponse.<UserProfile>builder()
                .status("success")
                .message("User created successfully")
                .data(userProfile)
                .build();


    }

    @GetMapping
    public ApiResponse<List<UserProfile>> getAllUsers(){
        return ApiResponse.<List<UserProfile>>builder()
                .status("success")
                .message("All users fetched successfully")
                .data(service.getAllUsers())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<UserProfile> getUserById(@PathVariable Long id) {
        UserProfile user = service.getUserById(id);

        if (user == null) {
            return ApiResponse.<UserProfile>builder()
                    .status("error")
                    .message("User with ID " + id + " not found")
                    .data(null)
                    .build();
        }

        return ApiResponse.<UserProfile>builder()
                .status("success")
                .message("User fetched successfully")
                .data(user)
                .build();
    }


    @DeleteMapping("/{id}")
    public  ApiResponse<String> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ApiResponse.<String>builder()
                .status("success")
                .message("User deleted successfully")
                .data("Deleted User id "+id)
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<UserProfile> updateUser(@PathVariable Long id, @RequestBody UserProfile updatedUser) {

        return ApiResponse.<UserProfile>builder()
                .status("success")
                .message("user updated successfully")
                .data(service.updateUser(id,updatedUser))
                .build();
    }
}
