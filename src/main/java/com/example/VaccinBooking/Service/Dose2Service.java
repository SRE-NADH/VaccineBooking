package com.example.VaccinBooking.Service;

import com.example.VaccinBooking.Enum.VaccinType;
import com.example.VaccinBooking.Model.Dose2;
import com.example.VaccinBooking.Model.User;
import org.springframework.stereotype.Service;

@Service
public interface Dose2Service {

    Dose2 build(VaccinType vaccinType, User user);
}
