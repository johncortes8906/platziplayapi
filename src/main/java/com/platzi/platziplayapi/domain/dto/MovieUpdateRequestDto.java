package com.platzi.platziplayapi.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MovieUpdateRequestDto(
        String title,
        LocalDate releaseDate,
        double rating
) {

}
