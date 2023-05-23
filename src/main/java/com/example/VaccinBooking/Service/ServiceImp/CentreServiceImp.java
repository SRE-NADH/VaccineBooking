package com.example.VaccinBooking.Service.ServiceImp;

import com.example.VaccinBooking.Dto.ReqDto.CentreReqDto;
import com.example.VaccinBooking.Dto.ResDto.CentreResDto;
import com.example.VaccinBooking.Model.VaccinationCentre;
import com.example.VaccinBooking.Repocitory.CentreRepocitory;
import com.example.VaccinBooking.Service.CentreService;
import com.example.VaccinBooking.Transformer.CentreTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CentreServiceImp implements CentreService {
    @Autowired
    CentreRepocitory centreRepocitory;
    @Override
    public CentreResDto addCentre(CentreReqDto centreReqDto) {
        VaccinationCentre centre = CentreTransformer.ReqToCentre(centreReqDto);

        VaccinationCentre savedCentre = centreRepocitory.save(centre);
         return CentreTransformer.CentreToRes(savedCentre);
    }
}
