
package com.om.user_service.service;
import com.om.user_service.dto.UserResponse;
import com.om.user_service.entity.User;
import com.om.user_service.external.Rating;
import com.om.user_service.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public User saveUser(User user) {

        return userRepository.save(user);
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    public User updateUser(Long userId, User updatedUser) {

        User existingUser = userRepository.findById(userId).orElse(null);

        if (existingUser != null) {
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setAbout(updatedUser.getAbout());

            return userRepository.save(existingUser);
        }

        return null;
    }
    public User patchUser(Long userId, User updatedUser) {

        User existingUser = userRepository.findById(userId).orElse(null);

        if (existingUser != null) {

            if (updatedUser.getName() != null) {
                existingUser.setName(updatedUser.getName());
            }

            if (updatedUser.getEmail() != null) {
                existingUser.setEmail(updatedUser.getEmail());
            }

            if (updatedUser.getAbout() != null) {
                existingUser.setAbout(updatedUser.getAbout());
            }

            return userRepository.save(existingUser);
        }

        return null;
    }


    public List<Rating> getRatingsByUserId(Long userId) {

        String url = "http://localhost:8083/ratings/users/" + userId;

        ResponseEntity<List<Rating>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Rating>>() {}
        );

        return response.getBody();
    }
    public UserResponse getUserWithRatings(Long userId) {

        User user = getUser(userId);

        if (user == null) {
            return null;
        }

        List<Rating> ratings = getRatingsByUserId(userId);

        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setAbout(user.getAbout());
        response.setRatings(ratings);

        return response;
    }
}