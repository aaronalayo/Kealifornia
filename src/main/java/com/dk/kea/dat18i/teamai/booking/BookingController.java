package com.dk.kea.dat18i.teamai.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookingController {
    @Autowired
    BookingRepo bookingRepo;

    @GetMapping("/bookings")
        public String findAll(Model model){
            List<Booking> bookingList = bookingRepo.findAll();
            model.addAttribute("Bookings", bookingList);
            return "show-bookings";
    }

    @PostMapping("/bookings/{id}")
    public int saveOne(@RequestBody Booking newBooking){
    int bookingId=bookingRepo.addBooking(newBooking);
    return bookingId;
    }

    @PutMapping("/bookings/{id}")
    public void updateOne(@PathVariable int id, @RequestBody Booking booking){
    bookingRepo.updateOne(id, booking);
    }

    @DeleteMapping("/bookings/{id}")
    public void deleteOne(@PathVariable int id){
        bookingRepo.deleteOne(id);

    }


}
