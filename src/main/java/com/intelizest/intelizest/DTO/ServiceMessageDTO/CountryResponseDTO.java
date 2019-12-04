package com.intelizest.intelizest.DTO.ServiceMessageDTO;

import com.intelizest.intelizest.Entity.Country;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryResponseDTO {

    Country country;
    boolean value;
    String message;
}
