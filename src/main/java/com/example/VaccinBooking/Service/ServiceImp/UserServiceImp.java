package com.example.VaccinBooking.Service.ServiceImp;

import com.example.VaccinBooking.Dto.ReqDto.UserReqDto;
import com.example.VaccinBooking.Dto.ResDto.UserResDto;
import com.example.VaccinBooking.Model.User;
import com.example.VaccinBooking.Repocitory.UserRepocitory;
import com.example.VaccinBooking.Service.UserService;
import com.example.VaccinBooking.Transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepocitory userRepocitory;
    @Override
    public UserResDto addUser(UserReqDto userReqDto) {
        User user =UserTransformer.reqDtoToUser(userReqDto);

      User savedUser = userRepocitory.save(user);

       return UserTransformer.userToResDto(savedUser,"successfully Registerd");
    }
}
