package com.example.VaccinBooking.Service.ServiceImp;

import com.example.VaccinBooking.Dto.ReqDto.AppoinmentReqDto;
import com.example.VaccinBooking.Dto.ResDto.AppoinmentResDto;
import com.example.VaccinBooking.Enum.DoseNo;
import com.example.VaccinBooking.Exception.DoctorNotFoundException;
import com.example.VaccinBooking.Exception.DoseNotTakenException;
import com.example.VaccinBooking.Exception.DoseAlreadyTakenException;
import com.example.VaccinBooking.Exception.UserNotFoundException;
import com.example.VaccinBooking.Extra.Certificate;
import com.example.VaccinBooking.Model.*;
import com.example.VaccinBooking.Repocitory.DoctorRepocitory;
import com.example.VaccinBooking.Repocitory.UserRepocitory;
import com.example.VaccinBooking.Service.AppointmentService;
import com.example.VaccinBooking.Transformer.AppoinmentTransformer;
import com.example.VaccinBooking.Transformer.CertificateTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentServiceImp implements AppointmentService {
    @Autowired
    UserRepocitory userRepocitory;
    @Autowired
    DoctorRepocitory doctorRepocitory;
    @Autowired
    Dose1ServiceImp dose1Service;

    @Autowired
    Dose2ServiceImp dose2Service;

    @Override
    public AppoinmentResDto BookAppoinment(AppoinmentReqDto appoinmentReqDto) throws UserNotFoundException, DoctorNotFoundException, DoseAlreadyTakenException, DoseNotTakenException {
        Optional<User> userOptional = userRepocitory.findById(appoinmentReqDto.getUserId());
        Optional<Doctor> doctorOptional = doctorRepocitory.findById(appoinmentReqDto.getDoctorId());
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("user not found");
        }
        if (doctorOptional.isEmpty()) {
            throw new DoctorNotFoundException("Doctor is not found");
        }
        User user = userOptional.get();
        Doctor doctor = doctorOptional.get();
        if (appoinmentReqDto.getDoseNo() == DoseNo.DOSE1) {
            if (user.isDose1()) {
                throw new DoseAlreadyTakenException("you alredy taken " + DoseNo.DOSE1);
            }
            user.SetisDose1(true);
            Dose1 dose1 = dose1Service.build(appoinmentReqDto.getVaccinType(), user);
            user.setDose1(dose1);
        } else {
            if (!user.isDose1()) {
                throw new DoseNotTakenException("you are not taken " + DoseNo.DOSE1);
            }
            if (user.isDose2()) {
                throw new DoseAlreadyTakenException("you alredy taken" + DoseNo.DOSE2);
            }
            user.SetisDose2(true);
            Dose2 dose2 = dose2Service.build(appoinmentReqDto.getVaccinType(), user);
            user.setDose2(dose2);
        }
        Appoinment appoinment = AppoinmentTransformer.reqToAppoinment(appoinmentReqDto, user, doctor);
        user.getAppoinmentList().add(appoinment);
        User savedUser = userRepocitory.save(user);
        doctor.getAppoinmentList().add(savedUser.getAppoinmentList().get(savedUser.getAppoinmentList().size() - 1));

        return AppoinmentTransformer.AppoinmentToRes(savedUser.getAppoinmentList().get(savedUser.getAppoinmentList().size()-1), "your Appointment is Booked successfully");
    }

    @Override
    public Certificate getCertificate(String emailId,DoseNo doseNo) throws UserNotFoundException, DoseNotTakenException {
        User user = userRepocitory.findByEmailId(emailId);
        if(user==null){
            throw new UserNotFoundException("user not found");
        }
        if(DoseNo.DOSE1==doseNo && !user.isDose1()){
            throw new DoseNotTakenException("you are not taken " + DoseNo.DOSE1);
        }
        if(DoseNo.DOSE2==doseNo && !user.isDose2()){
            throw new DoseNotTakenException("you are not taken " + DoseNo.DOSE2);
        }
        if(doseNo==DoseNo.DOSE1) {
            Appoinment appoinment = user.getAppoinmentList().get(0);
            return CertificateTransformer.buidCertificate(appoinment, user.getDose1(), DoseNo.DOSE1);
        }
        else{
            Appoinment appoinment = user.getAppoinmentList().get(1);
            return CertificateTransformer.buidCertificate(appoinment, user.getDose1(), DoseNo.DOSE2);
        }
    }


}
