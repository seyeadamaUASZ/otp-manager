# **_OTP manager_**

Cette librairie vous permet de générer rapidement des 
codes OTP selon une longueur que vous définissez. Nous avons
différents parametres de configuration:

- Type de code OTP à générer :
    type de l'OTP  (**NUMBER, ALPHABET, ALPHA_NUMERIC**)       

- Durée de validité :  la durée de validité du code OTP

- Le format de durée : le format en heure, minute ou seconde
  (**HOUR, MINUTE,SECONDS**)

Nous pouvons avoir un exemple d'utilisation:

Signature de la méthode de génération du code OTP :

`String generateCodeOtp(String type, String typeDuration, long duration, int len);`

- type : le type de code généré (**NUMBER, ALPHABET, ALPHA_NUMERIC**)
- typeDuration : la validité soit seconde,minute ou heure (**HOUR, MINUTE,SECONDS**)
- duration : temps de validité (en type long) 
- len : la longueur du code OTP

`public class Main {
private IOTPConfiguration OTPConfiguration;`

    public Main(IOTPConfiguration OTPConfiguration) {
        this.OTPConfiguration = OTPConfiguration;
    }
    public String  genecode(){
        return this.OTPConfiguration.generateCodeOtp("NUMBER","MINUTE",2,4);
    }

    public boolean verification(String code) throws OTPException {
        return this.OTPConfiguration.verifyCode(code);
    }

    public static void OTPApplication(String[] args) throws OTPException {
        OTPManager otpManager = new OTPManager();
        Main OTPApplication = new Main(otpManager);
        String code = OTPApplication.genecode();
        System.out.println("code generated is "+ code);

        System.out.println("************** verification ******************");

        System.out.println("is valide code "+ OTPApplication.verification(code));

        System.out.println("after remove this "+OTPApplication.verification(code));

    }
}
