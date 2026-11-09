package com.om.user_service.controller;

import com.om.user_service.dto.UserResponse;
import com.om.user_service.entity.User;
import com.om.user_service.external.Rating;
import com.om.user_service.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{userId}")
    public UserResponse getUser(@PathVariable Long userId) {
        return userService.getUserWithRatings(userId);
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return "User deleted successfully";
    }
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId,
                           @RequestBody User user) {

        return userService.updateUser(userId, user);
    }
    @PatchMapping("/{userId}")
    public User patchUser(@PathVariable Long userId,
                          @RequestBody User user) {

        return userService.patchUser(userId, user);
    }
    @GetMapping("/{userId}/ratings")
    public List<Rating> getRatingsByUserId(@PathVariable Long userId) {
        return userService.getRatingsByUserId(userId);
    }
}