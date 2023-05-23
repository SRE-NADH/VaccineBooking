package com.example.VaccinBooking.Extra;

import com.example.VaccinBooking.Enum.DoseNo;
import com.example.VaccinBooking.Enum.VaccinType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Certificate {

    String userName;

    String doctorName;

    String centreName;

    DoseNo doseNo;

    VaccinType vaccinType;

    Date date;
}
