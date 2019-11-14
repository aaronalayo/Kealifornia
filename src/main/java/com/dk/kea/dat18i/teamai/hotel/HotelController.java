package com.dk.kea.dat18i.teamai.hotel;

import com.dk.kea.dat18i.teamai.rooms.Rooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HotelController {

    @Autowired
    private HotelRepo hotelRepo;

    @GetMapping("/happyholiday")
    public String indexForHHD(){
        return "HHD-Index";
    }

    @GetMapping("/kealifornia")
    public String indexForKealifornia(){
        return "Kealifornia-index";}

    @GetMapping("/bookhhd")
    public String bookForHHD(Model Model){
        List<Rooms> roomsList = hotelRepo.findAllRooms();
        Model.addAttribute("rooms", roomsList);

        return "show-rooms";

    }
}
