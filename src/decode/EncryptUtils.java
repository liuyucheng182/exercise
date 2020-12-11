package decode;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.regex.Pattern;

/**
 * Title:com.example.demo.encode.EncryptUtils
 * Description: 描述【加解密工具类】
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author yangxy
 * @version 1.0
 * @ChagedBy dangqp
 * @created 2018/12/18 10:38
 */
public class EncryptUtils {

    private static final Logger log = LoggerFactory.getLogger(EncryptUtils.class);
    /**
     * 解密后的字符集，解决乱码问题
     */
    private static final String CHARSET_NAME = "UTF-8";

    /**
     * “算法/模式/填充”
     */
    private static String transformation = "AES/ECB/PKCS5Padding";

    /**
     * AES算法  AES的区块长度固定为128 比特，密钥长度则可以是128，192或256比特
     */
    private static String secretKey = "AES";

    /**
     * 秘钥 加密的key值
     */
    private static String encodetKey = getencodetKey();


    /**
     * TODO
     * 秘钥 加密的key值
     *
     * @return
     */
    private static String getencodetKey() {
        return "shanxidianxin001";
    }

    /**
     * 加密后拼接字段
     */
    private static String X = "Ⅱ";

    /**
     * 对字符串进行解密密操作
     *
     * @param str 代解密的字段
     * @return 解密密值
     */
    public static String decodeStr(String str) {
        if (StringUtils.isEmpty(str)) return "";
        //处理加密时拼接的字符
        if (isEncode(str)) {
            String subStr = StringUtils.substring(str, str.indexOf(X) + 1, str.lastIndexOf(X));
            //截取字符为空，返回原字符串
            if (StringUtils.isEmpty(subStr)) return subStr;
            return Decrypt(subStr, encodetKey);
        }
        return str;
    }

    /**
     * 对字符串进行加密操作
     *
     * @param str 代加密的字段
     * @return 加密值  为空时返回原值，报错时返回null
     */
    public static String encodeStr(String str) {
        if (StringUtils.isEmpty(str)) return "";
        //处理重复加密问题 必须判断
        if (isEncode(str)) {
            return str;
        }
        String encrypt = null;
        try {
            encrypt = Encrypt(str, encodetKey);
            return StringUtils.join(X, encrypt, X);
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }


    /**
     * 加密
     *
     * @param sSrc
     * @param sKey
     * @return
     * @throws Exception
     */
    private static String Encrypt(String sSrc, String sKey) throws Exception {
        if (StringUtils.isEmpty(sSrc)) return null;
        if (sKey == null) {
            log.error("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            log.error("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes();
        /**生成一个密钥**/
        SecretKeySpec skeySpec = new SecretKeySpec(raw, secretKey);
        /**创建密码器“算法/模式/填充”或“算法”**/
        Cipher cipher = Cipher.getInstance(transformation);
        /**以加密模式初始化**/
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes(CHARSET_NAME));
        return byte2hex(encrypted);
    }

    /**
     * 解密
     *
     * @param sSrc
     * @param sKey
     * @return
     * @throws Exception
     */
    private static String Decrypt(String sSrc, String sKey) {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes();
            /**生成一个密钥**/
            SecretKeySpec skeySpec = new SecretKeySpec(raw, secretKey);
            /**创建密码器“算法/模式/填充”或“算法”**/
            Cipher cipher = Cipher.getInstance(transformation);
            /**以加密模式初始化**/
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] decrypted = hex2byte(sSrc);
            try {
                byte[] original = cipher.doFinal(decrypted);
                return new String(original, CHARSET_NAME);
            } catch (Exception e) {
                log.error(e.toString());
                return null;
            }
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }

    /**
     * 字符串转换为16进制
     *
     * @param strhex
     * @return
     */
    private static byte[] hex2byte(String strhex) {
        if (StringUtils.isEmpty(strhex)) {
            return null;
        }
        int strLength = strhex.length();
        if (strLength % 2 == 1) {
            return null;
        }
        byte[] resoulst = new byte[strLength / 2];
        for (int i = 0; i != strLength / 2; i++) {
            resoulst[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2), 16);
        }
        return resoulst;
    }

    /**
     * 16进制转化为字符
     *
     * @param b
     * @return
     */
    private static String byte2hex(byte[] b) {
        StringBuffer sb = new StringBuffer();
        for (int n = 0; n < b.length; n++) {
            String stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                stmp = "0" + stmp;
            }
            sb.append(stmp.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 是否已经加密，且解密后的加密最小长度34
     *
     * @param str
     * @return true 已经加密 false 没有
     */
    public static boolean isEncode(String str) {
        if (!ObjectUtils.allNotNull(str)) return false;
        boolean check = StringUtils.startsWithIgnoreCase(str, X) && StringUtils.endsWithIgnoreCase(str, X) && str.length() >= 34;
        return check;
    }

}
