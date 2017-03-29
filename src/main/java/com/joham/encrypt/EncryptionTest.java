package com.joham.encrypt;

import org.junit.Test;

import java.util.Map;

/**
 * 加密工具类测试类
 *
 * @author qiaoyu
 */
public class EncryptionTest {

    //待加密文件
    public static final String DATA = "Hello World!";

    //keystore证书地址
    public static final String KEYSTORE = "/Users/joham/Projects/test/src/main/java/com/joham/encrypt/my-release-key.keystore";

    //cer证书地址
    public static final String CER = "/Users/joham/Projects/test/src/main/java/com/joham/encrypt/my.cer";

    /**
     * MD5加密
     */
    @Test
    public void TestMD5() {
        //MD5加密
        String MDs = Encryption.MD5Encode(DATA);
        System.out.println("MD5加密后" + MDs);
    }

    /**
     * SHA1加密
     */
    @Test
    public void TestSHA() {
        //SHA1加密
        String SHAs = Encryption.SHAEncode(DATA);
        System.out.println("SHA1加密后" + SHAs);
    }

    /**
     * HMAC加密
     */
    @Test
    public void TestHMAC() {
        //生成key
        String key = "test";
        //HMAC加密
        String HMACs = Encryption.HMACEncode(DATA, key);
        System.out.println("HMAC加密后：" + HMACs);
    }

    /**
     * Des加密解密
     */
    @Test
    public void TestDES() {
        //生成key
        String key = Encryption.generateDESKey("Java");
        //Des加密
        String ENDESs = Encryption.DESEncrypt(DATA, key);
        System.out.println("Des加密后:" + ENDESs);
        String DEDESs = Encryption.DESDecrypt(ENDESs, key);
        System.out.println("Des解密后:" + DEDESs);
    }

    /**
     * PBE加密解密
     */
    @Test
    public void TestPBE() {
        //生成盐
        String salt = Encryption.generatePBESalt();
        //设定密码
        String password = "test";
        //加密
        String enPBEs = Encryption.PBEEncrypt(DATA, password, salt);
        System.out.println("PBE加密后:" + enPBEs);
        String dePEBs = Encryption.PBEDecrypt(enPBEs, password, salt);
        System.out.println("PBE解密后:" + dePEBs);
    }

    /**
     * AES加密解密
     */
    @Test
    public void TestAES() {
        //生成key
        String key = Encryption.generateAESKey(128, "test");
        String enAESs = Encryption.AESEncrypt(DATA, key, "1234567890123456");
        System.out.println("AES加密后:" + enAESs);
        String deAESs = Encryption.AESDecrypt(enAESs, key, "1234567890123456");
        System.out.println("AES解密后:" + deAESs);
    }

    /**
     * RSA加密解密
     */
    @Test
    public void testRSA() {
        //初始化一对公私钥
        Map<String, Object> keyMap = Encryption.initRSAKey();
        String RSAPublicKey = Encryption.getRSAPublicKey(keyMap);
        System.out.println("公钥:" + RSAPublicKey);
        String RSAPrivateKey = Encryption.getRSAPrivateKey(keyMap);
        System.out.println("私钥" + RSAPrivateKey);
        //公钥加密
        String enRSAsByPublic = Encryption.RSAEncryptByPublicKey(DATA, RSAPublicKey);
        System.out.println("公钥加密后:" + enRSAsByPublic);
        //私钥解密
        String deRSAsByPrivate = Encryption.RSADecryptByPrivateKey(enRSAsByPublic, RSAPrivateKey);
        System.out.println("私钥解密后:" + deRSAsByPrivate);

        //私钥加密
        String enRSAsByPrivate = Encryption.RSAEncryptByPrivateKey(DATA, RSAPrivateKey);
        System.out.println("私钥加密后:" + enRSAsByPrivate);
        //公钥解密
        String deRSAsByPublic = Encryption.RSADecryptByPublicKey(enRSAsByPrivate, RSAPublicKey);
        System.out.println("公钥解密后:" + deRSAsByPublic);

        //私钥生成签名
        String enSigns = Encryption.RSASign(enRSAsByPrivate, RSAPrivateKey);
        //公钥验证签名是否正确
        boolean iSsignTrue = Encryption.RSAVerify(enRSAsByPrivate, RSAPublicKey, enSigns);
        System.out.println("验证签名:" + iSsignTrue);
    }

    /**
     * DH加密解密
     */
    @Test
    public void testDH() {
        //初始化甲方公私钥
        Map<String, Object> keyMap = Encryption.initDHKey();
        String DHPublicKey = Encryption.getDHPublicKey(keyMap);
        System.out.println("甲方公钥:" + DHPublicKey);
        String DHPrivateKey = Encryption.getDHPrivateKey(keyMap);
        System.out.println("甲方私钥:" + DHPrivateKey);

        //根据甲方公钥生成乙方公私钥
        Map<String, Object> keyMap1 = Encryption.initDHKey(DHPublicKey);
        String DHPublicKey1 = Encryption.getDHPublicKey(keyMap1);
        System.out.println("乙方公钥:" + DHPublicKey1);
        String DHPrivateKey1 = Encryption.getDHPrivateKey(keyMap1);
        System.out.println("乙方私钥:" + DHPrivateKey1);
        //通过甲方公钥乙方私钥DH加密
        String enDHs = Encryption.DHEncrypt(DATA, DHPublicKey, DHPrivateKey1);
        System.out.println("甲方公钥乙方私钥DH加密后:" + enDHs);
        //通过乙方公钥甲方私钥DH解密
        String deDHs = Encryption.DHDecrypt(enDHs, DHPublicKey1, DHPrivateKey);
        System.out.println("乙方公钥甲方私钥DH解密后:" + deDHs);
    }

    /**
     * KeyStore证书加密
     */
    @Test
    public void testKeyStore() {
        //KeyStore证书私钥加密
        String enKeyStore = Encryption.encryptByPrivateKey(DATA, KEYSTORE, "my-key-alias", "123456");
        System.out.println("KeyStore证书私钥加密后:" + enKeyStore);
        ///cer证书公钥解密
        String deKeyStore = Encryption.decryptByPublicKey(enKeyStore, CER);
        System.out.println("cer证书公钥解密后:" + deKeyStore);
        //KeyStore证书公钥加密
        String enKeyStore1 = Encryption.encryptByPublicKey(DATA, CER);
        System.out.println("KeyStore证书公钥加密后:" + enKeyStore1);
        //cer证书私钥解密
        String deKeyStore1 = Encryption.decryptByPrivateKey(enKeyStore1, KEYSTORE, "my-key-alias", "123456");
        System.out.println("KeyStore证书公钥加密后:" + deKeyStore1);
        //生成签名
        String sign = Encryption.sign(enKeyStore, KEYSTORE, "my-key-alias", "123456");
        System.out.println("签名" + sign);
        //验证签名是否正确
        System.out.println("验证签名是否正确:" + Encryption.verify(enKeyStore, sign, CER));
    }
}
