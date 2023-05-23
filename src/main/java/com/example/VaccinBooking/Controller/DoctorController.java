package com.example.VaccinBooking.Controller;

import com.example.VaccinBooking.Dto.ReqDto.DoctorReqDto;
import com.example.VaccinBooking.Dto.ResDto.CentreResDto;
import com.example.VaccinBooking.Dto.ResDto.DoctorResDto;
import com.example.VaccinBooking.Exception.CentreNotFoundException;
import com.example.VaccinBooking.Model.Doctor;
import com.example.VaccinBooking.Service.DocterService;
import com.example.VaccinBooking.Service.ServiceImp.DoctorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorServiceImp doctorServiceImp;

    @PostMapping("/add")
    public ResponseEntity AddDoctor(@RequestBody DoctorReqDto doctorReqDto) {
        try {
            DoctorResDto doctorResDto= doctorServiceImp.addDoctor(doctorReqDto);
            return new ResponseEntity(doctorResDto,HttpStatus.CREATED);
        }
        catch(CentreNotFoundException e){ 
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
