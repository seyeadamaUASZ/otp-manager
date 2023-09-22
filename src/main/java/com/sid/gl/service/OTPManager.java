package com.sid.gl.service;

import com.sid.gl.model.Duration;
import com.sid.gl.model.OTP;
import com.sid.gl.model.TypeOTP;
import com.sid.gl.utils.OtpGeneration;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Map;

/**
 * La configuration de la generation de l'OTP et la verification de validité
 * la configuration selon le choix du format de caractere
 * le type de duration selon le minute ou heure
 * verification si toujours valide ou expiré
 */
public class OTPManager implements IOTPConfiguration{
   static  Map<String,OTP> mapOtp;
    /**
     * generation du code selon different critere
     * NUMERIC,ALPHANUMERIC OR ALPHABET
     * Duration
     * Longueur de la chaine
     * Génerer le code et le sauvegarder dans un map
     */

    @Override
    public String generateCodeOtp(String type, String typeDuration, long duration, int len) {
        OTP otp = new OTP();
        otp.setTypeOTP(TypeOTP.valueOf(type));
        otp.setCaractere(type);
        //generate code selon le type
        String code = OtpGeneration.generateCode(type,len);
        otp.setCode(code);
        otp.setAlreadyValidated(false);

        // verify duration type
        long timer = 0;
        if(StringUtils.equalsIgnoreCase(Duration.MINUTE.name(),typeDuration)){
             timer = (new Date()).getTime() + (duration * 60000);
        }
        if(StringUtils.equalsIgnoreCase(Duration.HOUR.name(),typeDuration)){
            timer = (new Date()).getTime() + (duration * 60*60*1000);
        }
        otp.setDurationValidity(timer);
        //store this on hasmap
        mapOtp.put(code,otp);
        return code;
    }

    @Override
    public boolean verifyCode(String code) {
        //TODO verification du code
        return false;
    }

    private void removeOtpOnMap(OTP otp){
        // TODO supprimer le code généré apres verification
    }
}
