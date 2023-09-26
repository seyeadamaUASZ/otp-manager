package com.sid.gl.utils;

import com.sid.gl.model.TypeOTP;
import org.apache.commons.lang3.StringUtils;

import java.util.Random;

/**
 * @author Adama SEYE :
 * cette interface gere tout ce qui est lié a la génération
 * du code OTP selon la longueur
 */
public interface OtpGeneration {

    static  String generateCode(String type, int len){
        if(StringUtils.equals(TypeOTP.NUMBER.name(),type)){
            return generateOtpNumbers(len);
        }
        else if(StringUtils.equals(TypeOTP.ALPHA_NUMERIC.name(),type)){
            return generateOtpAlphaNumeric(len);
        }
        else{
            return null;
        }
    }

    private static String generateOtpNumbers(int len){
        String numbers ="0123456789";
        Random random = new Random();
        char[] otp = new char[len];
        for(int i=0;i<len;i++) {
            otp[i]=numbers.charAt(random.nextInt(numbers.length()));
        }
        return String.valueOf(otp);
    }

    private static String generateOtpAlphaNumeric(int len) {
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";
        String values = Capital_chars + Small_chars +
                numbers + symbols;

        // Using random method
        Random rndm_method = new Random();

        char[] otp = new char[len];

        for (int i = 0; i < len; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            otp[i] =
                    values.charAt(rndm_method.nextInt(values.length()));

        }
        return String.valueOf(otp);
    }

}
