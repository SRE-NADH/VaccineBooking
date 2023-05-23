package com.example.VaccinBooking.Model;

import com.example.VaccinBooking.Enum.VaccinType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "dose2")
@Builder
public class Dose2 {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;

    @Column(name = "dose_id")
    String doseId;

    @Enumerated(EnumType.STRING)
    @Column(name="vaccintype")
    VaccinType vaccintype;

    @OneToOne
    @JoinColumn
    User user;
}
