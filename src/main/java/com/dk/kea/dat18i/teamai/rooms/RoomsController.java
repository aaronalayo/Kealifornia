package com.dk.kea.dat18i.teamai.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RoomsController {

    @Autowired
    private RoomsRepository roomsRepo;

    @GetMapping("/roomview")
    public Rooms showRoom(){

        Rooms room = roomsRepo.findRoom(1);

        return room;
    }

    @GetMapping("/rooms")
    public String rooms(Model model) {

        List<Rooms> roomsList = roomsRepo.findAllRooms();
        model.addAttribute("roomslist", roomsList);

        return "show-rooms";
    }

    @GetMapping("/addroom")
    public String addRoom(Model model) {

        Rooms room = new Rooms();
        model.addAttribute( "room", room);

        return "add-room";
    }
    @PostMapping("/saveroom")
    public String saveRoom(@ModelAttribute Rooms room){
        Rooms newRoom = new Rooms();

        newRoom.setCapacity(room.getCapacity());
        newRoom.setPrice(room.getPrice());
        newRoom.setDescription(room.getDescription());


        roomsRepo.createRoom(newRoom);

        return "redirect:/rooms";
    }
}
