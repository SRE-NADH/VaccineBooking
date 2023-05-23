package com.example.VaccinBooking.Dto.ReqDto;

import com.example.VaccinBooking.Enum.CenterType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CentreReqDto {

    String name;
    String location;
    CenterType centerType;
}