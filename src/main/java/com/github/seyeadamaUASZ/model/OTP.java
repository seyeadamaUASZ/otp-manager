package com.github.seyeadamaUASZ.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Adama SEYE :
 * classe de génération et de validation de l'otp généré avec les différentes regles de validité
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OTP {
    private long durationValidity;
    private boolean alreadyValidated;
    private TypeOTP typeOTP;
    private Duration duration;

}
