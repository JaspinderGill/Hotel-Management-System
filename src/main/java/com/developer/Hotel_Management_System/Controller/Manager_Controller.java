package com.developer.Hotel_Management_System.Controller;

import com.developer.Hotel_Management_System.Entity.Booking_Rooms;
import com.developer.Hotel_Management_System.Entity.Room_Info;
import com.developer.Hotel_Management_System.Repository.Booking_Repository;
import com.developer.Hotel_Management_System.Service.Room_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class Manager_Controller {
    
    
    @Autowired
    private Room_Service service;
    
  
    
   // URL:  http://localhost:5082/available_rooms
    @GetMapping("/available_rooms")
    public String getAllAvailableRooms(Model model) {        
        model.addAttribute("room_info", service.getAllAvailableRoom());
        return "room_details";
    }
    
    
     // URL:  http://localhost:5082/get_all_rooms
    @GetMapping("/get_all_rooms")
    public String getAllRooms(Model model) {        
        model.addAttribute("room_info", service.getAllRoom());
        return "room_details";
    }
    
    
    
    
     // URL:  http://localhost:5082/book_rooms_/101
    @GetMapping("/book_rooms/{room_no}")
    public String bookRooms(@PathVariable("room_no") String room_id1  , Model model)
    {
       int room_no=Integer.parseInt(room_id1);
        model.addAttribute("room_info", service.getRoomInfo(room_no));
        return "booking_status";
    
    }
    
     // URL:  http://localhost:5082/final_check/101
    @PostMapping("/book_rooms/final_check/{room_id}/{customer_id}/{no_of_days}")
    public String bookRoomFinalCheck(@PathVariable("room_id") String room_id1,@PathVariable("customer_id") String customer_id1, @PathVariable("no_of_days") String days )
    {
       int customer_id=Integer.parseInt(customer_id1);
       int room_id=Integer.parseInt(room_id1);
       int no_of_days=Integer.parseInt(days);
       
       boolean status=service.book_rooms(room_id, customer_id, room_id);
       
       if(status)
       {
        return "booking success";
       }
       else{
        return"booking_error";
       }
    }
    
    
    

}
