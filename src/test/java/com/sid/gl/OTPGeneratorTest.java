package com.sid.gl;

import com.sid.gl.utils.OtpGeneration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Adama SEYE
 */
class OTPGeneratorTest {

    @Test
    void should_test_generatecode(){
        String result = OtpGeneration.generateCode("NUMBER",4);
        assertNotNull(result);
        assertEquals(4,result.length());
    }
}
