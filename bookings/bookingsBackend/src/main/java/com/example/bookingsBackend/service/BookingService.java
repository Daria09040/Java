package com.example.bookingsBackend.service;

import com.example.bookingsBackend.model.Booking;
import com.example.bookingsBackend.model.Client;
import com.example.bookingsBackend.model.Room;
import com.example.bookingsBackend.repository.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    public List<Booking> getBookingByRoomId(Room roomId){
        return bookingRepository.findByRoomId(roomId);
    }

    public List<Booking> getBookingByClientId(Client clientId){
        return bookingRepository.findByClientId(clientId);
    }

    public List<Booking> getBookingByCheckInDate(LocalDateTime checkInDate){
        return bookingRepository.findByCheckInDate(checkInDate);
    }

    public List<Booking> getBookingByCheckOutDate(LocalDateTime checkOutDate){
        return bookingRepository.findByCheckOutDate(checkOutDate);
    }

    public List<Booking> getBookingByTotalCost(Double totalCost){
        return bookingRepository.findByTotalCost(totalCost);
    }

    public void saveBooking(Booking booking){
        bookingRepository.save(booking);
    }

    public void deleteBooking(Integer id){
        bookingRepository.deleteById(id);
    }

    public Booking getBookingById(Integer id){
        return bookingRepository.findById(id).orElse(null);
    }
}
