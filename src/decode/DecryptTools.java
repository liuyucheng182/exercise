package decode; 

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Security;

public class DecryptTools {
   private static final String Algorithm = "DESede"; //定义 加密算法,可用 DES,DESede,Blowfish
    private static final Logger logger = LoggerFactory.getLogger(DecryptTools.class);

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

    /**
     * 优惠券解密
     *
     * @param src 密文
     * @return 原文
     */
    public static String decryptForYHQ(String src) {
        try {
            // return decryptMode(HexString2Bytes(KEYBYTESYHQ), (new BASE64Decoder()).decodeBuffer(src));
            return decryptMode(HexString2Bytes(EncryptTools.KEYBYTESYHQ), Base64.decodeBase64(src.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            logger.error("优惠券解密错误【" + src + "】", e);
        }
        return null;
    }

    /**
     * 虚拟赠品解密
     *
     * @param src 密文
     * @return 原文
     */
    public static String decryptForXNZP(String src) {
        try {
            // return decryptMode(HexString2Bytes(KEYBYTESXNZP), (new BASE64Decoder()).decodeBuffer(src));
            return decryptMode(HexString2Bytes(EncryptTools.KEYBYTESXNZP), Base64.decodeBase64(src.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            logger.error("虚拟赠品解密错误【" + src + "】", e);
        }
        return null;
    }

    //keybyte为加密密钥，长度为24字节
    //src为加密后的缓冲区
    private static String decryptMode(byte[] keybyte, byte[] src) {
        try {
            //添加新安全算法,如果用JCE就要把它添加进去
            Security.addProvider(new com.sun.crypto.provider.SunJCE());
            //生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);

            //解密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);
            return new String(c1.doFinal(src), StandardCharsets.UTF_8);
        } catch (Exception e) {
            logger.error("解密错误", e);
        }
        return null;
    }
}
