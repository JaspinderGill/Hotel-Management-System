package com.developer.Hotel_Management_System.Service;


import com.developer.Hotel_Management_System.Entity.User_Info;
import com.developer.Hotel_Management_System.Repository.User_Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class User_Service {
    
    @Autowired
    private User_Repository repository;
    
     public List<User_Info> getAllUser() {
        List<User_Info> lst = new ArrayList<>();

        try {
            repository.findAll().forEach(lst::add);
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            lst.clear();
            return lst;
        }

    }
     
     
      public boolean addUser(User_Info user)
    {
        	try {
			repository.save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
     
        
        
    }
      
      public User_Info getUser(int user_id)
      {
        try {
            Optional<User_Info> opt
                    = repository.findById(user_id);
      

            if (opt.isPresent()) {
                User_Info user = opt.get();
                return user;
            } else {
                return null;
            }
        } catch (Exception exc) {
            exc.printStackTrace();
            return null;
        }
      
      
    }
}