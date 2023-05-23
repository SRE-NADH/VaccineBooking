package com.example.VaccinBooking.Transformer;

import com.example.VaccinBooking.Dto.ReqDto.DoctorReqDto;
import com.example.VaccinBooking.Dto.ResDto.CentreResDto;
import com.example.VaccinBooking.Dto.ResDto.DoctorResDto;
import com.example.VaccinBooking.Model.Doctor;
import com.example.VaccinBooking.Model.VaccinationCentre;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


public class DoctorTransformer{

    public static Doctor ReqToDoctor(DoctorReqDto doctorReqDto) {
        return Doctor.builder().name(doctorReqDto.getName()).age(doctorReqDto.getAge()).
                gender(doctorReqDto.getGender()).emailId(doctorReqDto.getEmailId()).contactNo(doctorReqDto.getContactNo())
                .build();
    }
    public static DoctorResDto DoctorToRes(Doctor doctor){
        VaccinationCentre centre= doctor.getVaccinationCentre();
        CentreResDto centreResDto = CentreTransformer.CentreToRes(centre);
        return DoctorResDto.builder().name(doctor.getName()).centreResDto(centreResDto).build();
    }
}
