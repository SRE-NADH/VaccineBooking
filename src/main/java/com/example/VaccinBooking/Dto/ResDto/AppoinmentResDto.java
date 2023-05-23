package com.example.VaccinBooking.Dto.ResDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AppoinmentResDto {
      String userName;

     String doctorName;

     Date appointmentDate;

     String centreName;

     String message;
}
