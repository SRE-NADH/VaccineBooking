package com.example.VaccinBooking.Model;

import com.example.VaccinBooking.Enum.DoseNo;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "appoinment")
@Builder
public class Appoinment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;

    @Column(name = "appoinment_no")
    String AppoinmentNo; //UUID

    @Column(name = "appointment_date")
    @CreationTimestamp
    Date AppointmentDate;


    @Column(name = "doseno")
    @Enumerated(EnumType.STRING)
    DoseNo doseNo;

    @ManyToOne
    @JoinColumn
    User user;

    @ManyToOne
    @JoinColumn
    Doctor doctor;
}
