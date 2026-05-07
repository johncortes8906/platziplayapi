package com.platzi.platziplayapi.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MovieUpdateRequestDto(
        @NotBlank(message = "Title value is mandatory")
        String title,
        @PastOrPresent(message = "No future dates allowed")
        LocalDate releaseDate,
        @Min(value = 0, message = "Rating must be more than 0")
        @Max(value = 5, message = "Rating must be less than 5")
        double rating
) {

}
