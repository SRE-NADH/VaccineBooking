package com.example.VaccinBooking.Dto.ResDto;

import com.example.VaccinBooking.Enum.CenterType;
import com.example.VaccinBooking.Model.Doctor;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Builder
public class CentreResDto {
    String name;

    String location;


    CenterType centerType;

}
