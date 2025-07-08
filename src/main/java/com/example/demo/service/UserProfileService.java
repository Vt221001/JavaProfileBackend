package com.example.demo.service;

import com.example.demo.model.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository repository;

    public UserProfile createUser(UserProfile userProfile) {
        return repository.save(userProfile);
    }

    public List<UserProfile> getAllUsers() {
        return repository.findAll();
    }

    public UserProfile getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public UserProfile updateUser(Long id, UserProfile updatedUser) {
        Optional<UserProfile> optionalUser = repository.findById(id);
        if (optionalUser.isPresent()) {
            UserProfile existingUser = optionalUser.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setMobile(updatedUser.getMobile());
            existingUser.setAddress(updatedUser.getAddress());
            return repository.save(existingUser);
        } else {
            return null;
        }
    }
}
