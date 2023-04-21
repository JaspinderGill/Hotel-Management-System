package com.developer.Hotel_Management_System.Controller;

import com.developer.Hotel_Management_System.Entity.Items;
import com.developer.Hotel_Management_System.Entity.User_Info;
import com.developer.Hotel_Management_System.Repository.Item_Repository;
import com.developer.Hotel_Management_System.Service.Item_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



public class Item_Controller {
    
    @Autowired
    private Item_Service service;
    
    
    // URL:  http://localhost:5082/items/new_item
    @GetMapping("/items/new_item")
    public String createItemForm(Model model)
    { 
        Items item=new Items();
        model.addAttribute("item",item);
        return "add_item";
     
    
    }
    
    // URL:  http://localhost:5082/items/save_item
    @PostMapping("/items/save_item")
    public String saveItem(@ModelAttribute("item") Items item)
    {
        try{
        service.addItems(item);
        return "item_saved_successfull";
        } catch(Exception e)
        {
         e.printStackTrace();
         return "item_saved_error";
        }
        
    }
    
    
    
    // URL:  http://localhost:5082/items/getAllItems
    @GetMapping("/items/getAllItems")
    public String getAllCustomer(Model model) {        
        model.addAttribute("items", service.getAllItems());
        return "display_items";
    }
    
    
    
}
