package com.example.VaccinBooking.Service.ServiceImp;

import com.example.VaccinBooking.Dto.ReqDto.DoctorReqDto;
import com.example.VaccinBooking.Dto.ResDto.CentreResDto;
import com.example.VaccinBooking.Dto.ResDto.DoctorResDto;
import com.example.VaccinBooking.Exception.CentreNotFoundException;
import com.example.VaccinBooking.Model.Doctor;
import com.example.VaccinBooking.Model.VaccinationCentre;
import com.example.VaccinBooking.Repocitory.CentreRepocitory;
import com.example.VaccinBooking.Service.DocterService;
import com.example.VaccinBooking.Transformer.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImp implements DocterService {
    @Autowired
    CentreRepocitory centreRepocitory;

    @Override
    public DoctorResDto addDoctor(DoctorReqDto doctorReqDto) throws CentreNotFoundException{
        Optional<VaccinationCentre> Optionalcentre =  centreRepocitory.findById(doctorReqDto.getCentreId());

        if(Optionalcentre.isEmpty()){
             throw new CentreNotFoundException("Centre is not found");
        }
        Doctor doctor = DoctorTransformer.ReqToDoctor(doctorReqDto);
        VaccinationCentre centre = Optionalcentre.get();
        doctor.setVaccinationCentre(centre);

        centre.getDoctors().add(doctor);
        centreRepocitory.save(centre);

        return DoctorTransformer.DoctorToRes(doctor);

    }
}
