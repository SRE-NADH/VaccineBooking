package com.example.VaccinBooking.Service.ServiceImp;

import com.example.VaccinBooking.Enum.VaccinType;
import com.example.VaccinBooking.Model.Dose1;
import com.example.VaccinBooking.Model.User;
import com.example.VaccinBooking.Service.Dose1Service;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Dose1ServiceImp implements Dose1Service {
    @Override
    public Dose1 build(VaccinType vaccinType, User user) {
        return Dose1.builder().doseId(String.valueOf(UUID.randomUUID())).vaccintype(vaccinType)
                .user(user).build();
    }
}
