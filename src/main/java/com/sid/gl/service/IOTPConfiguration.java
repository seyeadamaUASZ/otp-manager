package com.sid.gl.service;

public interface IOTPConfiguration {
    String generateCodeOtp(String type, String typeDuration, long duration, int len);
    boolean verifyCode(String code);

}
