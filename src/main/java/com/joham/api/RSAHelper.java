package com.joham.api;


import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by joham on 2016/3/2.
 */
public class RSAHelper {
    private static final String modulus_usr_debug = "D6ED8E8176110A134D63088B3FF172D3CDB5679FFF5F6EEE5E9737E30D8BA73839C36B682AEE1ED480BCA70D57708CD0ABC51F95F625330EE5F7E6BCAFE491367AEEFA3525D2B9C18D90E6B96F6D57E5EDE903E80AD86750D246AFCE772A96ED1A11FDA3F6B3E67BB1C5CC2A7BCC28691C30BFF1ABA0FE01D7BA16FC25E3A21F";
    private static final String modulus_card_debug = "D1C2A153CD67626108B346F0A4DAA4894DF51AFA5AF35224570DA6137AFFF82FCAB5345BEA7A3432D6366CE8B57D5256F022C4013A7C6680025704AD9EFA111A41AFA2D6B966DC3A042B791771592EA37920E5F644CA87E6C157FF53DAD18A80027F669DCE200E37D9C0356532ADE9F6082C959ABA6D48AF3C95E761C6A403FB";
    private static final String exponent = "00010001";

    //new
    public static final String modulus_usr = "D9BB61E418730023EDD72DA6E37183468239E19D837390CC762D9BDE9C4BCA658F50973C1E036F2F645A35338128AAB407144E7806B4E8550031830CB5E3CE5F164D5050B0A1BC94CAAFBF3ED6037AF2BD417C2120814667EC2B011AF278152A83C1022DDE89A0B4B2DE2DF0B5C4D2E17F0B4D71AE6B7CFCA4465E2216C95129";
    private static final String modulus_card = "A582B986B697A849D8B3A0B9A4507AA2A6BDCAEF737312FBAEB50BD57E016F63C00120BA9862ADB83F48ABBA79439BAF3B5AEBD07AB52571A76F605F6857C6E9FB3BC8C2FF5BADB7A375CC65D8F7417525A5F205696F26BDCCBA3E1B141077923B76CE3E8E187BFAF7ECD0D5878BA98413DF293ABFBE9FBDF57C485B48548087";
//	//old
//    private static final String modulus_usr = "C05A33F8317962ED88B101E77C2BD7C9D9F399C3C4B272F629289560BC4CADB9EF3CBA2783582E8FEC4BF86D46D74A070F373B3632CE772885CEFC0795329DBCDE7A262BBAFCAB73B5754F31ABF706504F0E7E1CF2C89500A6B95DBB4E4B5B36CFA0E44A4DC3FCD59E83AB1069FEB63AE665DC6B9532B1EA8CA51153397E6A93";
//    private static final String modulus_card= "ABCF9CAFB95B7204594B17F77B0F64D3C46BAD2A4DF9274DA8C3BB24DFC964D2558F2FB4295036FB770A4C16C8A3D684B781786BF452F2288951FA567AEA3D40F1472DFBBD23A6CF192B1F1AA79E7077FBA18C2327B1F444C94135C3BB049CFE1203714AFC4A164C48C04962150D0393620535F129D7289BB0D86879B83C16E5";

    private PublicKey getPublicKey(int keyType) throws Exception {

        BigInteger e = new BigInteger(exponent, 16);
        BigInteger m;

        if (true) {
            if (keyType == 1)
                m = new BigInteger(modulus_usr_debug, 16);
            else
                m = new BigInteger(modulus_card_debug, 16);
        } else {
            if (keyType == 1)
                m = new BigInteger(modulus_usr, 16);
            else
                m = new BigInteger(modulus_card, 16);
        }


        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(m, e);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }


    public String EncryptByRSAPublicKey(String in, int keyType) {
        String resultStr = "";
        try {
            //加解密类
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            //明文
            byte[] plainText = in.getBytes();
            //加密
            cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(keyType));
            byte[] enBytes = cipher.doFinal(plainText);
            resultStr = toHexString(enBytes, "");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultStr;
    }

    private String toHexString(byte[] bytes, String separator) {
        String s1 = "", s2 = "";
        for (int i = 0; i < bytes.length; i++) {
            s1 = Integer.toHexString(0xFF & bytes[i]);
            if (s1.length() == 1) {
                s2 += "0";
            }
            s2 += s1;
            s2 += separator;
        }
        return s2;
    }

    /**
     * 登录密码加密*
     */
    public String getPwdEncipher(String pwd, String phoneNumber) {
        String str = "00000000";
        if (Integer.toString(pwd.length()).length() % 2 == 1) {
            str = str + "0" + Integer.toString(pwd.length());
        } else {
            str = str + Integer.toString(pwd.length());
        }
        str += pwd;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
        Date date = new Date();
        str += sdf.format(date);
        str += phoneNumber;
        String mszPwd = EncryptByRSAPublicKey(str, 1);
        return mszPwd;
    }

    public String EncryptByRSAPublicKey(String in, String key) {
        String resultStr = "";
        try {
            // 加解密类
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            // 明文
            byte[] plainText = in.getBytes();
            // 加密
            cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(key));
            byte[] enBytes = cipher.doFinal(plainText);
            resultStr = toHexString(enBytes, "");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultStr;
    }

    private PublicKey getPublicKey(String key) throws Exception {

        BigInteger e = new BigInteger(exponent, 16);
        BigInteger m;

        m = new BigInteger(key, 16);

        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(m, e);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }
}
