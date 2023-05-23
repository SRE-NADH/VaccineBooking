package com.example.VaccinBooking.Transformer;

import com.example.VaccinBooking.Enum.DoseNo;
import com.example.VaccinBooking.Extra.Certificate;
import com.example.VaccinBooking.Model.Appoinment;
import com.example.VaccinBooking.Model.Dose1;

public class CertificateTransformer {

    public static Certificate buidCertificate(Appoinment appoinment, Dose1 dose1, DoseNo doseNo) {
        return Certificate.builder().doctorName(appoinment.getDoctor().getName()).centreName(appoinment.getDoctor().getVaccinationCentre().getName())
                .date(appoinment.getAppointmentDate()).vaccinType(dose1.getVaccintype())
                .userName(appoinment.getUser().getName()).doseNo(doseNo).build();
    }
}
