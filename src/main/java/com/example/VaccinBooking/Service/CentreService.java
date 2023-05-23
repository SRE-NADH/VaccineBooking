package com.example.VaccinBooking.Service;

import com.example.VaccinBooking.Dto.ReqDto.CentreReqDto;
import com.example.VaccinBooking.Dto.ResDto.CentreResDto;

public interface CentreService {

    CentreResDto addCentre(CentreReqDto centreReqDto);
}
