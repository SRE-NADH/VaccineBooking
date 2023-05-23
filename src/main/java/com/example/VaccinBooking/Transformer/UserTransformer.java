package com.example.VaccinBooking.Transformer;

import com.example.VaccinBooking.Dto.ReqDto.UserReqDto;
import com.example.VaccinBooking.Dto.ResDto.UserResDto;
import com.example.VaccinBooking.Model.User;

public class UserTransformer {

    public static User reqDtoToUser(UserReqDto userReqDto) {
        return User.builder().age(userReqDto.getAge()).emailId(userReqDto.getEmailId()).name(userReqDto.getName()).
                contactNo(userReqDto.getContactNo()).gender(userReqDto.getGender()).build();
    }

    public static UserResDto userToResDto(User savedUser,String Message) {
        return UserResDto.builder().name(savedUser.getName()).message(Message).build();
    }
}
