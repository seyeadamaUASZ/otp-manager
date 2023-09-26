package com.sid.gl;

import com.sid.gl.exception.OTPException;
import com.sid.gl.service.OTPConfiguration;
import com.sid.gl.service.OTPManager;

public class OTPApplication {
    private OTPConfiguration OTPConfiguration;

    public OTPApplication(OTPConfiguration OTPConfiguration) {
        this.OTPConfiguration = OTPConfiguration;
    }
    public String  genecode(){
        return this.OTPConfiguration.generateCodeOtp("NUMBER","MINUTE",2,4);
    }

    public boolean verification(String code) throws OTPException {
        return this.OTPConfiguration.verifyCode(code);
    }

    public static void main(String[] args) throws OTPException {
        OTPManager otpManager = new OTPManager();
        OTPApplication OTPApplication = new OTPApplication(otpManager);
        String code = OTPApplication.genecode();
        System.out.println("code generated is "+ code);

        System.out.println("************** verification ******************");

        System.out.println("is valide code "+ OTPApplication.verification(code));

        System.out.println("after remove this "+ OTPApplication.verification(code));

    }
}