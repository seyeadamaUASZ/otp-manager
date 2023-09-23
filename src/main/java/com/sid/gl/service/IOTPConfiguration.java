package com.sid.gl.service;

import com.sid.gl.exception.OTPException;

public interface IOTPConfiguration {
    String generateCodeOtp(String type, String typeDuration, long duration, int len);
    boolean verifyCode(String code) throws OTPException;


}
