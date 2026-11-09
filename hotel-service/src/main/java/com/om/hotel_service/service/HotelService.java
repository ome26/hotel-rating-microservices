package com.om.hotel_service.service;

import com.om.hotel_service.entity.Hotel;
import com.om.hotel_service.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel getHotel(Long hotelId) {
        return hotelRepository.findById(hotelId).orElse(null);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
    public void deleteHotel(Long hotelId) {
        hotelRepository.deleteById(hotelId);
    }
    public Hotel updateHotel(Long hotelId, Hotel updatedHotel) {

        Hotel existingHotel = hotelRepository.findById(hotelId).orElse(null);

        if (existingHotel != null) {
            existingHotel.setName(updatedHotel.getName());
            existingHotel.setLocation(updatedHotel.getLocation());
            existingHotel.setAbout(updatedHotel.getAbout());

            return hotelRepository.save(existingHotel);
        }

        return null;
    }
    public Hotel patchHotel(Long hotelId, Hotel updatedHotel) {

        Hotel existingHotel = hotelRepository.findById(hotelId).orElse(null);

        if (existingHotel != null) {

            if (updatedHotel.getName() != null) {
                existingHotel.setName(updatedHotel.getName());
            }

            if (updatedHotel.getLocation() != null) {
                existingHotel.setLocation(updatedHotel.getLocation());
            }

            if (updatedHotel.getAbout() != null) {
                existingHotel.setAbout(updatedHotel.getAbout());
            }

            return hotelRepository.save(existingHotel);
        }

        return null;
    }
}