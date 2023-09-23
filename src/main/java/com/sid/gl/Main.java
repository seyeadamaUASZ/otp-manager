package com.sid.gl;


import com.sid.gl.exception.OTPException;
import com.sid.gl.service.IOTPConfiguration;
import com.sid.gl.service.OTPManager;

public class Main {
    private IOTPConfiguration iotpConfiguration;

    public Main(IOTPConfiguration iotpConfiguration) {
        this.iotpConfiguration = iotpConfiguration;
    }
    public String  genecode(){
        return this.iotpConfiguration.generateCodeOtp("NUMBER","MINUTE",2,4);
    }

    public boolean verification(String code) throws OTPException {
        return this.iotpConfiguration.verifyCode(code);
    }

    public static void main(String[] args) throws OTPException {
        OTPManager otpManager = new OTPManager();
        Main main = new Main(otpManager);
        String code = main.genecode();
        System.out.println("code generated is "+ code);

        System.out.println("************** verification ******************");

        System.out.println("is valide code "+ main.verification(code));

        System.out.println("after remove this "+main.verification(code));

    }
}