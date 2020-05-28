package com.nongguoguo.Website.config;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by J on 2020/5/26 17:33
 */
@Slf4j
public class OpenidUtil {

//    public static String decodeSecData(byte[] data, byte[] iv, byte[] key) {
//        int base = 16;
//        if (key.length % base != 0) {
//            int groups = key.length / base + 1;
//            byte[] temp = new byte[groups * base];
//            Arrays.fill(temp, (byte) 0);
//            System.arraycopy(key, 0, temp, 0, key.length);
//            key = temp;
//        }
//        try {
//            Security.addProvider(new BouncyCastleProvider());
//            Key secretKeySpec = new SecretKeySpec(key, ALGORITHM_KEY);
//
//            Cipher cipher = Cipher.getInstance(ALGORITHM_STR, "BC");
//
//            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(iv));
//            final byte[] bytes = cipher.doFinal(data);
//            return new String(bytes);
//        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | InvalidAlgorithmParameterException | NoSuchProviderException ignore) {
//            log.warn("解密失败", ignore);
//            throw new RuntimeException(ignore);
//        }
//    }
//    public static String decodeSecData() {
//        Map map = new HashMap();
//        try {
//            byte[] resultByte = AES.decrypt(Base64.decodeBase64(encryptedData),
//                    Base64.decodeBase64(session_key),
//                    Base64.decodeBase64(iv));
//            if (null != resultByte && resultByte.length > 0) {
//                String userInfo = new String(resultByte, "UTF-8");
//                map.put("status", "1");
//                map.put("msg", "解密成功");
//                map.put("userInfo", userInfo);
//            } else {
//                map.put("status", "0");
//                map.put("msg", "解密失败");
//            }
//        } catch (InvalidAlgorithmParameterException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        String s = JSONUtil.toJsonStr(map);
//        System.out.println(s);
//        return s;
//
//    }
}
