package com.developer.Hotel_Management_System.Controller;

import com.developer.Hotel_Management_System.Entity.User_Info;
import com.developer.Hotel_Management_System.Service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


public class User_Controller {
    
    @Autowired
    private User_Service service;
    
    
    // URL:  http://localhost:5082/customer/new_customer
    @GetMapping("/customer/new_customer")
    public String createCustomerForm(Model model)
    { 
        User_Info user=new User_Info();
        model.addAttribute("user",user);
        return "add_customer";
     
    
    }
    
    // URL:  http://localhost:5082/customer/saveCustomer
    @PostMapping("/customer/saveCustomer")
    public String saveCustomer(@ModelAttribute("user") User_Info user)
    {
        try{
        service.addUser(user);
        return "register_success";
        } catch(Exception e)
        {
         e.printStackTrace();
         return "register_failed";
        }
        
    }
    
    
    
    // URL:  http://localhost:5082/customer/getAllCustomer
    @GetMapping("/customer/getAllCustomer")
    public String getAllCustomer(Model model) {        
        model.addAttribute("user_info", service.getAllUser());
        return "user_details";
    }
    
  
    
}
