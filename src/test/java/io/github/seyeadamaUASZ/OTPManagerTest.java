package io.github.seyeadamaUASZ;

import io.github.seyeadamaUASZ.service.OTPManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Adama SEYE
 */
@ExtendWith(MockitoExtension.class)
class OTPManagerTest {

    @InjectMocks
    private OTPManager otpManager;

    @Test
    void should_generate_otp(){
        String result = otpManager.generateCodeOtp("NUMBER","SECONDS",1,4);
        assertNotNull(result);
        assertEquals(4,result.length());
    }


    //verify code
    @Test
    void should_verify_code() {
        String code = otpManager.generateCodeOtp("NUMBER","SECONDS",1,4);
        boolean result = otpManager.verifyCode(code);
        assertTrue(result);
    }

    @Test
    void should_hasExpiration(){
        boolean expiration = hasNoExpiration(1695727225263L);
        assertFalse(expiration);
    }

    private boolean hasNoExpiration(long time){
        return ((new Date()).getTime() - time) < 0L;
    }


}
