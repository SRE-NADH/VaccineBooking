package com.example.VaccinBooking.Repocitory;

import com.example.VaccinBooking.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepocitory extends JpaRepository<Doctor,Integer> {
}
