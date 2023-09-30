package io.github.seyeadamaUASZ.service;

import io.github.seyeadamaUASZ.exception.OTPException;
import io.github.seyeadamaUASZ.model.Duration;
import io.github.seyeadamaUASZ.model.OTP;
import io.github.seyeadamaUASZ.model.TypeOTP;
import io.github.seyeadamaUASZ.utils.OtpGeneration;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Adama SEYE
 */

 public class OTPManager implements OTPConfiguration {
   public static Map<String, OTP> otpStore=new HashMap<>();
    /**
     * generation du code selon different critere
     * NUMERIC,ALPHANUMERIC OR ALPHABET
     * Duration
     * Longueur de la chaine
     * Génerer le code et le sauvegarder dans un map
     * @param  type String : type d'OTP NUMBER,ALPHABET,ALPHA_NUMERIC
     * @param typeDuration String : MINUTE,SECONDS,HOUR
     * @param duration long : valeur de durée de validité
     * @param len int : longueur du code généré
     */

    @Override
    public String generateCodeOtp(String type, String typeDuration, long duration, int len) {
        OTP otp = new OTP();
        otp.setTypeOTP(TypeOTP.valueOf(type));
        //générer du code otp ici
        String code = OtpGeneration.generateCode(type,len);
        otp.setAlreadyValidated(false);
        // verify duration type
        long timer = 0;
        if(StringUtils.equalsIgnoreCase(Duration.MINUTE.name(),typeDuration)){
             timer = (new Date()).getTime() + (duration * 60000);
        }
        if(StringUtils.equalsIgnoreCase(Duration.HOUR.name(),typeDuration)){
            timer = (new Date()).getTime() + (duration * 60*60*1000);
        }
        if(StringUtils.equalsIgnoreCase(Duration.SECONDS.name(),typeDuration)){
            timer = (new Date()).getTime() + (duration*1000);
        }
        otp.setDurationValidity(timer);
        //store this on hasmap
        otpStore.put(code,otp);
        return code;
    }

     /**
      * vérifier le code OTP
      * @param code
      * @return
      * @throws OTPException
      */

    @Override
    public boolean verifyCode(String code) throws OTPException {
        //verifier l'ensemble des elements de vérification
        if(otpStore.containsKey(code)){
            OTP otp = otpStore.get(code);
            if(hasNoExpiration(otp.getDurationValidity())){
                //remove after vérification
                removeOtpOnMap(code);
                return true;
            }else{
                throw new OTPException("code not valid or already validate");
            }
        }
        return false;
    }

     /**
      * Supprimer le code présent au niveau du map
      * cette méthode est invoquée après validatation de l'otp
      * @param code
      */
    private void removeOtpOnMap(String code){
        otpStore.remove(code);
    }

     /**
      * vérifier si la durée de validité est expirée
      * @param time
      * @return
      */
    private boolean hasNoExpiration(long time){
        return ((new Date()).getTime() - time) < 0L;
    }
}
