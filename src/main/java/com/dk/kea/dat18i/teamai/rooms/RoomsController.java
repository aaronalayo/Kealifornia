package com.dk.kea.dat18i.teamai.rooms;

import com.dk.kea.dat18i.teamai.booking.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoomsController {

    @Autowired
    private RoomsRepository roomsRepo;

    @Autowired

    @GetMapping("/roomview")
    public Rooms showRoom(){

        Rooms room = roomsRepo.findRoom(1);

        return room;
    }

    @GetMapping("/rooms")
    public String rooms(Model model) {

        List<Rooms> roomsList = roomsRepo.findAllRooms();
        model.addAttribute("rooms", roomsList);

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

        newRoom.setRoom_number(room.getRoom_number());
        newRoom.setCapacity(room.getCapacity());
        newRoom.setPrice(room.getPrice());
        newRoom.setDescription(room.getDescription());


        roomsRepo.createRoom(newRoom);

        return "redirect:/rooms";
    }

    @RequestMapping(value = "rooms/delete/{room_id}")
    public String removeScreening(@PathVariable int room_id) {

        roomsRepo.deleteRoom(room_id);

        return "redirect:/rooms";
    }


    @GetMapping("/rooms/edit/{room_id}")
    public String editRoom (Model m, @PathVariable(name = "room_id")int room_id){

        Rooms roomToEdit= roomsRepo.findRoom(room_id);
        m.addAttribute("editroom",roomToEdit);

        return "edit-room";
    }

    @RequestMapping(value = "/updateroom", method= RequestMethod.POST)
    public String saveEditRoom(@ModelAttribute Rooms room){

        room.setRoom_number(room.getRoom_number());
        room.setCapacity(room.getCapacity());
        room.setPrice(room.getPrice());
        room.setDescription(room.getDescription());

        roomsRepo.update(room);

        return "redirect:/rooms";
    }
    @GetMapping("/select/rooms")
    public String selectRoom(Model m){
        List<Rooms> roomsList = roomsRepo.findAllRooms();
        m.addAttribute("rooms", roomsList);
        return "select-room";

    }
}
