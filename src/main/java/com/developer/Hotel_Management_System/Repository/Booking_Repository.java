/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.developer.Hotel_Management_System.Repository;

import com.developer.Hotel_Management_System.Entity.Booking_Rooms;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mehul
 */
public interface Booking_Repository extends CrudRepository<Booking_Rooms, Integer> {
    
}
