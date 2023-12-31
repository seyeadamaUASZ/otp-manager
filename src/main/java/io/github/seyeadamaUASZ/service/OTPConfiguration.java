package io.github.seyeadamaUASZ.service;

/**
 * @author Adama SEYE :
 * Interface utilisée pour la génération du code OTP
 * et la vérification du code OTP
 */

public interface OTPConfiguration {
    String generateCodeOtp(String type, String typeDuration, long duration, int len);
    boolean verifyCode(String code);


}
