package com.example.VaccinBooking.Service;

import com.example.VaccinBooking.Dto.ReqDto.AppoinmentReqDto;
import com.example.VaccinBooking.Dto.ResDto.AppoinmentResDto;
import com.example.VaccinBooking.Enum.DoseNo;
import com.example.VaccinBooking.Exception.DoctorNotFoundException;
import com.example.VaccinBooking.Exception.DoseNotTakenException;
import com.example.VaccinBooking.Exception.DoseAlreadyTakenException;
import com.example.VaccinBooking.Exception.UserNotFoundException;
import com.example.VaccinBooking.Extra.Certificate;

public interface AppointmentService {

    AppoinmentResDto BookAppoinment(AppoinmentReqDto appoinmentReqDto) throws UserNotFoundException,DoctorNotFoundException, DoseNotTakenException,
            DoseAlreadyTakenException;

    Certificate getCertificate(String emailId, DoseNo doseNo) throws UserNotFoundException, DoseNotTakenException;

}
