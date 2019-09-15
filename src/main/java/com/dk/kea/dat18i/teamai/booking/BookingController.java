package com.dk.kea.dat18i.teamai.booking;

import com.dk.kea.dat18i.teamai.customer.Customer;
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

    public String booking(Model model) {
        List<Booking> bookingList = bookingRepo.findAll();
        model.addAttribute("bookings", bookingList);

        return "show-bookings";


    }

    @GetMapping("/bookroom")
    public String saveOne(Model model){

        Booking newBooking = new Booking();
        model.addAttribute("newbooking", newBooking);

    return "book-room";
    }

    @PostMapping("/savebooking")
    public String saveBooking(@ModelAttribute Booking booking){

            Booking newBooking = new Booking();

            newBooking.setCheck_in(booking.getCheck_in());
            newBooking.setCheck_out(booking.getCheck_out());
            newBooking.setPersons(booking.getPersons());
            newBooking.setNumber_of_rooms(booking.getNumber_of_rooms());



            bookingRepo.addBooking(newBooking);


            return  "redirect:/select/rooms";
    }
   @GetMapping("/customerinfo")
   public String customerInfo(Model model){

        Customer newCustomer= new Customer();
        model.addAttribute(newCustomer);

        return "customer-info";
   }

    @PutMapping("/bookings/{id}")
    public void updateOne(@PathVariable int id, @RequestBody Booking booking){
    bookingRepo.updateOne(booking);
    }



    @DeleteMapping("/bookings/{id}")
    public void deleteOne(@PathVariable int id){
        bookingRepo.deleteOne(id);

    }






}
