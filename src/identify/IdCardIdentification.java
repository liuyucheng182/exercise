package identify;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class IdCardIdentification {
	
	public static String encode64Image(String filePath) throws IOException {
		FileInputStream fi = new FileInputStream(filePath);
		byte[] data = new byte[fi.available()];
		fi.read(data);
		fi.close();
		Base64 base64 = new Base64();
		return new String(base64.encode(data),"utf-8");
	}
	
	@Test
	public void test() {
		try {
			System.out.println(encode64Image("F:\\Photoshop\\身份证背面缩小版.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testJsonToMap() throws ParseException {
		String body = "{\"outputs\":[{\"outputLabel\":\"ocr_idcard\",\"outputMulti\":{},\"outputValue\":{\"dataType\":50,\"dataValue\":\"{\\\"config_str\\\":\\\"{\\\\\\\"side\\\\\\\":\\\\\\\"back\\\\\\\"}\\\",\\\"end_date\\\":\\\"20250626\\\",\\\"issue\\\":\\\"安平县公安局\\\",\\\"request_id\\\":\\\"20180131164546_90eb3d12e91699662638a6f95f0c28ec\\\",\\\"start_date\\\":\\\"20150626\\\",\\\"success\\\":true}\"}}]}";
		String outputs = JSON.parseObject(body).getString("outputs");
//		System.out.println(outputs);
		String outputValue = JSON.parseObject(JSON.parseArray(outputs).get(0).toString()).getString("outputValue");
//		System.out.println(outputValue);
		String dataValue = JSON.parseObject(outputValue).getString("dataValue");
//		System.out.println(dataValue);
		JSONObject json = JSON.parseObject(dataValue);
		System.out.println("签发机关："+json.get("issue"));
		//有效期限格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String startDate = DateFormatUtils.format(sdf.parse(json.get("start_date").toString()), "yyyy.MM.dd");
		String endDate = DateFormatUtils.format(sdf.parse(json.get("end_date").toString()), "yyyy.MM.dd");
		System.out.println("有效期限："+startDate+"-"+endDate);
	}
	
	public static void main(String[] args) throws IOException {
	    String host = "https://dm-51.data.aliyun.com";
	    String path = "/rest/160601/ocr/ocr_idcard.json";
	    String method = "POST";
	    String appcode = "d273352d30ce41c686faa66d7a30c1b7";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    //根据API的要求，定义相对应的Content-Type
	    headers.put("Content-Type", "application/json; charset=UTF-8");
	    Map<String, String> querys = new HashMap<String, String>();
//	    String image64Code = encode64Image("F:\\Photoshop\\身份证背面缩小版.png");
	    String image64Code = encode64Image("F:\\Photoshop\\timg.jpg");
	    String bodys = "{\"inputs\":[{\"image\":{\"dataType\":50,\"dataValue\":\""+ image64Code +"\"},\"configure\":{\"dataType\":50,\"dataValue\":\"{\\\"side\\\":\\\"back\\\"}\"}}]}";

	    try {
	    	/**
	    	* 重要提示如下:
	    	* HttpUtils请从
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* 下载
	    	*
	    	* 相应的依赖请参照
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
	    	//获取response的body
	    	String body = EntityUtils.toString(response.getEntity());
	    	//解析body
	    	String outputs = JSON.parseObject(body).getString("outputs");
			String outputValue = JSON.parseObject(JSON.parseArray(outputs).get(0).toString()).getString("outputValue");
			String dataValue = JSON.parseObject(outputValue).getString("dataValue");
			JSONObject json = JSON.parseObject(dataValue);
			System.out.println("签发机关："+json.get("issue"));
			//有效期限格式化
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String startDate = DateFormatUtils.format(sdf.parse(json.get("start_date").toString()), "yyyy.MM.dd");
			String endDate = DateFormatUtils.format(sdf.parse(json.get("end_date").toString()), "yyyy.MM.dd");
			System.out.println("有效期限："+startDate+"-"+endDate);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}
