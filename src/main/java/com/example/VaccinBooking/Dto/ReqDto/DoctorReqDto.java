package com.example.VaccinBooking.Dto.ReqDto;

import com.example.VaccinBooking.Enum.Gender;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorReqDto {
    String name;

    int age;

    String emailId;

    String contactNo;

    Gender gender;

    int centreId;
}
