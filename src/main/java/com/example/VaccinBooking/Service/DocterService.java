package com.example.VaccinBooking.Service;

import com.example.VaccinBooking.Dto.ReqDto.DoctorReqDto;
import com.example.VaccinBooking.Dto.ResDto.CentreResDto;
import com.example.VaccinBooking.Dto.ResDto.DoctorResDto;
import com.example.VaccinBooking.Exception.CentreNotFoundException;

public interface DocterService {
    DoctorResDto addDoctor(DoctorReqDto doctorReqDto) throws CentreNotFoundException;
}
