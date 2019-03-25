package decode; 

/*
 * EncryptTools
 * V 1.0.0
 * 2014/11/28
 * <p>
 * Copyright © 2014 中国电信股份有限公司电子渠道运营中心 版权所有
 * <p>
 * 所有文字、代码资料，版权均属中国电信股份有限公司电子渠道运营中心
 * 所有，任何公司或个人未经本司协议授权，不得复制、下载、存储或公开
 * 显示。违者本公司将依法追究责任。
 */


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Security;

public class EncryptTools {

    private static final Logger logger = LoggerFactory.getLogger(EncryptTools.class);
    private static final String Algorithm = "DESede"; //定义 加密算法,可用 DES,DESede,Blowfish
    /**
     * 优惠券密钥
     */
    public static String KEYBYTESYHQ = "31211F2324310402724254161CCBDA566777914C63140362";
    /**
     * 虚拟赠品密钥
     */
    public static String KEYBYTESXNZP = "1040772425216456711F28A81CAAD556633791436AA40362";

    /**
     * 优惠券加密
     *
     * @param src 原文
     * @return 密文
     */
    public static String encryptForYHQ(String src) {
        // byte[] encodedBytes = Base64.encodeBase64("Test".getBytes());
        // return (new BASE64Encoder()).encodeBuffer(encryptMode(HexString2Bytes(KEYBYTESYHQ), src.getBytes())).trim().replaceAll("\\r", "").replaceAll("\\n", "");

        byte[] encrypt = Base64.encodeBase64(encryptMode(HexString2Bytes(KEYBYTESYHQ), src.getBytes(StandardCharsets.UTF_8)));
        if (encrypt != null && encrypt.length > 0) {
            return new String(encrypt, StandardCharsets.UTF_8).trim().replaceAll("\\r", "").replaceAll("\\n", "");
        }

        return null;
    }
    
    /**
     * 优惠券加密
     *
     * @param src 原文
     * @return 密文
     */
	public static String encryptSafeForYHQ(String src) {
		String encrypt = Base64.encodeBase64URLSafeString(encryptMode(HexString2Bytes(KEYBYTESYHQ), src.getBytes(StandardCharsets.UTF_8)));
		if (StringUtils.isNotBlank(encrypt)) {
			return encrypt.trim().replaceAll("\\r", "").replaceAll("\\n", "");
		}
		return null;
	}

    /**
     * 虚拟赠品加密
     *
     * @param src 原文
     * @return 密文
     */
    public static String encryptForXNZP(String src) {
        // return (new BASE64Encoder()).encodeBuffer(encryptMode(HexString2Bytes(KEYBYTESXNZP), src.getBytes())).trim().replaceAll("\\r", "").replaceAll("\\n", "");

        byte[] encrypt = Base64.encodeBase64(encryptMode(HexString2Bytes(KEYBYTESXNZP), src.getBytes(StandardCharsets.UTF_8)));

        if (encrypt != null && encrypt.length > 0) {
            return new String(encrypt, StandardCharsets.UTF_8).trim().replaceAll("\\r", "").replaceAll("\\n", "");
        }

        return null;
    }

    //keybyte为加密密钥，长度为24字节
    //src为被加密的数据缓冲区（源）
    private static byte[] encryptMode(byte[] keybyte, byte[] src) {
        try {
            //添加新安全算法,如果用JCE就要把它添加进去
            Security.addProvider(new com.sun.crypto.provider.SunJCE());
            //生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);

            //加密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            return c1.doFinal(src);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    private static byte[] HexString2Bytes(String src) {
        byte[] ret = new byte[src.length() / 2];
        byte[] tmp = src.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < tmp.length / 2; i++) {
            ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
        }
        return ret;
    }

    /**
     * 将两个ASCII字符合成一个字节；
     * 如："EF"--> 0xEF
     *
     * @param src0 byte
     * @param src1 byte
     * @return byte
     */
    private static byte uniteBytes(byte src0, byte src1) {
        byte _b0 = Byte.decode("0x" + new String(new byte[]{src0}, StandardCharsets.UTF_8)).byteValue();
        _b0 = (byte) (_b0 << 4);
        byte _b1 = Byte.decode("0x" + new String(new byte[]{src1}, StandardCharsets.UTF_8)).byteValue();
        byte ret = (byte) (_b0 ^ _b1);
        return ret;
    }

}
