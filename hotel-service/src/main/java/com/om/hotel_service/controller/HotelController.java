package com.om.hotel_service.controller;

import com.om.hotel_service.entity.Hotel;
import com.om.hotel_service.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public Hotel saveHotel(@RequestBody Hotel hotel) {
        return hotelService.saveHotel(hotel);
    }

    @GetMapping("/{hotelId}")
    public Hotel getHotel(@PathVariable Long hotelId) {
        return hotelService.getHotel(hotelId);
    }

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }
    @DeleteMapping("/{hotelId}")
    public String deleteHotel(@PathVariable Long hotelId) {
        hotelService.deleteHotel(hotelId);
        return "Hotel deleted successfully";
    }
    @PutMapping("/{hotelId}")
    public Hotel updateHotel(@PathVariable Long hotelId,
                             @RequestBody Hotel hotel) {

        return hotelService.updateHotel(hotelId, hotel);
    }
    @PatchMapping("/{hotelId}")
    public Hotel patchHotel(@PathVariable Long hotelId,
                            @RequestBody Hotel hotel) {

        return hotelService.patchHotel(hotelId, hotel);
    }
}