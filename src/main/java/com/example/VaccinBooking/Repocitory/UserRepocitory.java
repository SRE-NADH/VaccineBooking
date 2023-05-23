package com.example.VaccinBooking.Repocitory;

import com.example.VaccinBooking.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepocitory extends JpaRepository<User,Integer> {
    User findByEmailId(String emailId);
}
