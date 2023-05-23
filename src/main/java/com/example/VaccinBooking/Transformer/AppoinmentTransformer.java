package com.example.VaccinBooking.Transformer;

import com.example.VaccinBooking.Dto.ReqDto.AppoinmentReqDto;
import com.example.VaccinBooking.Dto.ResDto.AppoinmentResDto;
import com.example.VaccinBooking.Model.Appoinment;
import com.example.VaccinBooking.Model.Doctor;
import com.example.VaccinBooking.Model.User;

import java.util.UUID;

public class AppoinmentTransformer {


    public static Appoinment reqToAppoinment(AppoinmentReqDto appoinmentReqDto, User user, Doctor doctor) {
        return Appoinment.builder().AppoinmentNo(String.valueOf(UUID.randomUUID())).user(user).doctor(doctor).doseNo(appoinmentReqDto.getDoseNo())
                .build();

    }

    public static AppoinmentResDto AppoinmentToRes(Appoinment appoinment, String yourAppointmentIsBookedSuccessfully) {
        return AppoinmentResDto.builder().doctorName(appoinment.getDoctor().getName()).userName(appoinment.getUser().getName()).message(yourAppointmentIsBookedSuccessfully).centreName(appoinment.getDoctor().getVaccinationCentre().getName())
                .appointmentDate(appoinment.getAppointmentDate()).build();
    }
}
