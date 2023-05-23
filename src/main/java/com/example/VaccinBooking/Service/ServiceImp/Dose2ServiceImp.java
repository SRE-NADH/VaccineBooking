package com.example.VaccinBooking.Service.ServiceImp;

import com.example.VaccinBooking.Enum.VaccinType;
import com.example.VaccinBooking.Model.Dose2;
import com.example.VaccinBooking.Model.User;
import com.example.VaccinBooking.Service.Dose2Service;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class Dose2ServiceImp implements Dose2Service {
    @Override
    public Dose2 build(VaccinType vaccinType, User user) {
        return Dose2.builder().doseId(String.valueOf(UUID.randomUUID())).user(user).vaccintype(vaccinType).build();
    }
}
