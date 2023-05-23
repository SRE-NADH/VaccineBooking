package com.example.VaccinBooking.Controller;

import com.example.VaccinBooking.Dto.ReqDto.CentreReqDto;
import com.example.VaccinBooking.Dto.ResDto.CentreResDto;
import com.example.VaccinBooking.Service.CentreService;
import com.example.VaccinBooking.Service.ServiceImp.CentreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/centre")
public class CentreController {
    @Autowired
    CentreServiceImp centreServiceImp;

    @PostMapping("/add")
    public ResponseEntity AddCentre(@RequestBody CentreReqDto centreReqDto){
        CentreResDto centr = centreServiceImp.addCentre(centreReqDto);
        return new ResponseEntity<>(centr, HttpStatus.CREATED);
    }

}
