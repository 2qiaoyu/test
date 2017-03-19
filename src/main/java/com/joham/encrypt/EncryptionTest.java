package com.joham.encrypt;

import org.junit.Test;

/**
 * 加密工具类测试类
 *
 * @author qiaoyu
 */
public class EncryptionTest {

    //待加密文件
    public static final String DATA = "Hello World!";

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
}
