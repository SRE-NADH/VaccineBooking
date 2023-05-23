package com.example.VaccinBooking.Dto.ReqDto;

import com.example.VaccinBooking.Enum.DoseNo;
import com.example.VaccinBooking.Enum.VaccinType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppoinmentReqDto {
  DoseNo doseNo;

  int userId;

  int doctorId;

  VaccinType vaccinType;
}
