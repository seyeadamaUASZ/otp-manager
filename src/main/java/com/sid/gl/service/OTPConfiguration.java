package com.sid.gl.service;

import com.sid.gl.exception.OTPException;

/**
 * @author Adama SEYE :
 * Interface utilisée pour la génération du code OTP
 * et la vérification du code OTP
 */

public interface OTPConfiguration {
    String generateCodeOtp(String type, String typeDuration, long duration, int len);
    boolean verifyCode(String code) throws OTPException;


}
