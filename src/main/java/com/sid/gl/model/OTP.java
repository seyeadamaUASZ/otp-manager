package com.sid.gl.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * classe de génération et de validation de l'otp généré avec les différentes regles de validité
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OTP {
    private String code;
    private long durationValidity;
    private boolean alreadyValidated;
    private String caractere;
    private TypeOTP typeOTP;
    private double durationOtpValue;
    private Duration duration;

}
