package com.example.VaccinBooking.Repocitory;

import com.example.VaccinBooking.Model.VaccinationCentre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CentreRepocitory extends JpaRepository<VaccinationCentre,Integer> {

}
