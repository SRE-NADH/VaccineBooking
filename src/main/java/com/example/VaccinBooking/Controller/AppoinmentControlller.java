package com.example.VaccinBooking.Controller;

import com.example.VaccinBooking.Dto.ReqDto.AppoinmentReqDto;
import com.example.VaccinBooking.Dto.ResDto.AppoinmentResDto;
import com.example.VaccinBooking.Enum.DoseNo;
import com.example.VaccinBooking.Exception.DoctorNotFoundException;
import com.example.VaccinBooking.Exception.DoseNotTakenException;
import com.example.VaccinBooking.Exception.DoseAlreadyTakenException;
import com.example.VaccinBooking.Exception.UserNotFoundException;
import com.example.VaccinBooking.Extra.Certificate;
import com.example.VaccinBooking.Service.ServiceImp.AppointmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appoinment")
public class AppoinmentControlller {
    @Autowired
    AppointmentServiceImp appointmentServiceImp;

    @PostMapping("/booking")
    public ResponseEntity BookAppoinment(@RequestBody AppoinmentReqDto appoinmentReqDto) {
        try {
            AppoinmentResDto appoinmentResDto = appointmentServiceImp.BookAppoinment(appoinmentReqDto);
            return new ResponseEntity<>(appoinmentResDto, HttpStatus.CREATED);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (DoctorNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (DoseNotTakenException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (DoseAlreadyTakenException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // certificate for dose 1;
    @PutMapping("/get_certificate/Dose1")
    public ResponseEntity getCertificate(@RequestParam String emailId){
        try {
            Certificate certificate = appointmentServiceImp.getCertificate(emailId,DoseNo.DOSE1);
            return new ResponseEntity(certificate,HttpStatus.ACCEPTED);
        }
        catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

        catch (DoseNotTakenException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/get_certificate/Dose2")
    public ResponseEntity getCertificateDose2(@RequestParam String emailId){
        try {
            Certificate certificate = appointmentServiceImp.getCertificate(emailId, DoseNo.DOSE2);
            return new ResponseEntity(certificate,HttpStatus.ACCEPTED);
        }
        catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

        catch (DoseNotTakenException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
