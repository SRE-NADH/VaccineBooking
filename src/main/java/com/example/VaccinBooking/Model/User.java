package com.example.VaccinBooking.Model;

import com.example.VaccinBooking.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "user")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;

    @Column(name = "name")
    String name;

    @Column(name ="age")
    int age;

    @Column(name = "email_id",unique = true,nullable = false)
    String emailId;

    @Column(name="contact_no",unique = true,nullable = false)
    String contactNo;

    @Column(name = "is_dose1")
    boolean isDose1;

    @Column(name = "is_dose2")
    boolean isDose2;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    Dose1 dose1;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    Dose2 dose2;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Appoinment> appoinmentList = new ArrayList<>();
    public void SetisDose1(boolean flg) {
        isDose1 = flg;
    }
    public void SetisDose2(boolean flg) {
        isDose2= flg;
    }
    
    }