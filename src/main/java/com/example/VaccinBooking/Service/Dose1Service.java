package com.example.VaccinBooking.Service;

import com.example.VaccinBooking.Enum.VaccinType;
import com.example.VaccinBooking.Model.Dose1;
import com.example.VaccinBooking.Model.User;

public interface Dose1Service {
    Dose1 build(VaccinType vaccinType, User user);
}
