package com.example.VaccinBooking.Service;

import com.example.VaccinBooking.Dto.ReqDto.UserReqDto;
import com.example.VaccinBooking.Dto.ResDto.UserResDto;

public interface UserService {
    UserResDto addUser(UserReqDto user);
}
