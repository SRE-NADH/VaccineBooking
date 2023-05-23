package com.example.VaccinBooking.Controller;

import com.example.VaccinBooking.Dto.ReqDto.UserReqDto;
import com.example.VaccinBooking.Dto.ResDto.UserResDto;
import com.example.VaccinBooking.Service.ServiceImp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImp userServiceImp;
    @PostMapping("/add")
    public ResponseEntity AddUser(@RequestBody UserReqDto userReqDto){
        UserResDto user= userServiceImp.addUser(userReqDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
