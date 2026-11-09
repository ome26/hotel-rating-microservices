package com.om.user_service.external;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rating {


        private Long id;
        private Long userId;
        private Long hotelId;
        private Integer rating;
        private String feedback;


}
