package qosRequestHeader;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;
public class QosUtils {


    public static String getXWSSE(String userName, String pwd){
        String result="";
        String Nonce=getNonce();
        String timestamp=getQosTimestamp();
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("UsernameToken ");
        stringBuilder.append("Username=\"");
        stringBuilder.append(userName);
        stringBuilder.append("\",");
        stringBuilder.append("PasswordDigest=\"");
        stringBuilder.append(getPasswordDigest(Nonce+timestamp+pwd));
        stringBuilder.append("\",");
        stringBuilder.append("Nonce=\"");
        stringBuilder.append(Nonce);
        stringBuilder.append("\",");
        stringBuilder.append("Timestamp=\"");
        stringBuilder.append(timestamp);
        stringBuilder.append("\"");
        result=stringBuilder.toString();
        System.out.println("X-WSSE:"+result);

        return result;

    }

    public static String getPasswordDigest(String info){
        //使用 java 标准Base64
        String result= null;
        //       if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
        try {
            result = Base64.getEncoder().encodeToString(DigestUtils.sha256(info.getBytes("utf-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //       }
        return result;
    }

    public static String getNonce() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    public static String getQosTimestamp(){
        return getUTCTime("yyyy-MM-dd'T'HH:mm:ss'Z'");

    }

    /**
     * 获得世界协调时的近似值
     * @return  Date
     */
    public static Date getUTCTime(){

        Calendar cal = Calendar.getInstance();
        //获得时区和 GMT-0 的时间差,偏移量
        int offset = cal.get(Calendar.ZONE_OFFSET);
        //获得夏令时  时差
        int dstoff = cal.get(Calendar.DST_OFFSET);
//        cal.add(Calendar.MILLISECOND, - (offset + dstoff));
        //取北京时间
        cal.add(Calendar.MILLISECOND, 0);
        return cal.getTime();

    }


    /**
     *  获得世界协调时的近似值
     * @param format	格式化的时间格式
     * @return   String
     */
    public static String getUTCTime(String format){
        String formatDate = format(getUTCTime(), format);
        return formatDate;
    }
    /**
     * 使用用户格式格式化日期
     * @param date 日期
     * @param pattern 日期格式
     * @return
     */
    public static String format(Date date, String pattern) {
        String returnValue = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
//            df.setTimeZone(TimeZone.getTimeZone("GMT"));
            returnValue = df.format(date);
        }
        return (returnValue);
    }




    public static void main(String[] args){

        getXWSSE("tianyiduijiang","tianyiduijiang_!@#");
    }

}
