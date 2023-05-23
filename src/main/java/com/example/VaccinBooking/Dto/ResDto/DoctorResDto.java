package com.example.VaccinBooking.Dto.ResDto;

import com.example.VaccinBooking.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DoctorResDto{
    String name;

    CentreResDto centreResDto;
}
