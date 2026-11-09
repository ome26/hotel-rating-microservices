package com.om.user_service.dto;

import com.om.user_service.external.Rating;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String about;
    private List<Rating> ratings;
}
