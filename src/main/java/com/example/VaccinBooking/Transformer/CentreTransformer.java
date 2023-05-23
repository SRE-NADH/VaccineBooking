package com.example.VaccinBooking.Transformer;

import com.example.VaccinBooking.Dto.ReqDto.CentreReqDto;
import com.example.VaccinBooking.Dto.ResDto.CentreResDto;
import com.example.VaccinBooking.Model.VaccinationCentre;

public class CentreTransformer {


    public static VaccinationCentre ReqToCentre(CentreReqDto centreReqDto) {
        return VaccinationCentre.builder().name(centreReqDto.getName()).location(centreReqDto.getLocation()).
                centerType(centreReqDto.getCenterType()).build();
    }
    public static CentreResDto CentreToRes(VaccinationCentre centre) {
        return CentreResDto.builder().name(centre.getName()).location(centre.getLocation()).
                centerType(centre.getCenterType()).build();
    }
}
