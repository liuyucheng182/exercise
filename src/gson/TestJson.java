/*
 * Copyright © 2019 中国电信集团系统集成有限责任公司 版权所有
 *
 * 所有文字、代码资料，版权均属中国电信集团系统集成有限责任公司
 * 任何公司或个人未经本司协议授权，不得复制、下载、存储或公开
 * 显示。违者本公司将依法追究责任。
 */

package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gson.pojo.AccelerationRequest;
import org.junit.Test;

import java.util.Map;

/**
 * Description:
 *
 * @author liuyucheng
 * @date 2019/5/31 17:20
 */

public class TestJson {


    String req = "{\n" +
            "\t\"User_Mdn\": \"13301234567\",\n" +
            "    \"Partner_ID\": \"123456\", \n" +
            "    \"UserIdentifier\": {\n" +
            "        \"IP\": \"10.82.41.167\", \n" +
            "        \"PublicIP\": \"49.92.144.83\", \n" +
            "        \"PublicPORT\": \"21253\"\n" +
            "    }, \n" +
            "    \"security_token\": \"jsQosIct_1517384703571_QY1602001_tencent_7FA997E0370C8B240CC08A09EFFD9AE9DCA1D049521CC11395CD7B1C0FC368BDCF98EF2FCC88DB2D15C7CF4C9B2F796CDEDC2FA550EA3300E3DE85220221C2D53DDDBBCB4419A4D16D5E7C4FE3FF720A0500E351944DFE505B856D8B316D0EE0\", \n" +
            "    \"OTTchargingId\": \"1600485197\", \n" +
            "    \"ServiceId\": \"TencentGames\", \n" +
            "    \"Duration\": 3600, \n" +
            "    \"CallBackURL\": \"http://msdk.qq.com/\", \n" +
            "    \"ResourceFeatureProperties\": [\n" +
            "        {\n" +
            "            \"Type\": 1, \n" +
            "            \"Priority\": 1, \n" +
            "            \"FlowProperties\": [\n" +
            "                {\n" +
            "                    \"Direction\": 2, \n" +
            "                    \"SourceIpAddress\": \"10.82.41.167\", \n" +
            "                    \"DestinationIpAddress\": \"61.129.8.103\", \n" +
            "                    \"Protocol\": \"ip\", \n" +
            "                    \"MaximumUpStreamSpeedRate\": 50000, \n" +
            "                    \"MaximumDownStreamSpeedRate\": 100000\n" +
            "                }\n" +
            "            ], \n" +
            "            \"MinimumUpStreamSpeedRate\": 50000, \n" +
            "            \"MinimumDownStreamSpeedRate\": 100000\n" +
            "        }\n" +
            "    ]\n" +
            "}";


    /**
     * json格式化为对象
     */
    @Test
    public void test(){
        //创建json序列化工具，serializeNulls()方法表示序列化null值对应的key
        Gson accelerationGson = new GsonBuilder().serializeNulls().create();
        //将json格式的请求转换为对象格式
        AccelerationRequest accelerationRequest = accelerationGson.fromJson(req, AccelerationRequest.class);
        System.out.println(accelerationRequest.toString());


        ////创建json序列化工具，默认是不序列化null值对应的key的
        Gson qosGson = new GsonBuilder().create();
        //qosRequestObj请求是CQoS平台向4GQoS平台发起提速请求时的参数对象
        AccelerationRequest qosRequestObj = accelerationRequest;
        //将qosRequest提速请求参数对象的userMdn属性设置为null（目的是转换为json字符串时，去掉userMdn对应的key）
        qosRequestObj.setUserMdn(null);
        //然后用qosGson将对象转换为json字符串(qosReq请求参数的json字符串中不含有User_Mdn这个key)
        String qosReq = qosGson.toJson(qosRequestObj);
        System.out.println(qosReq);
    }

    /**
     * json格式化为map
     */
    @Test
    public void testMap(){
        //创建json序列化工具，serializeNulls()方法表示序列化null值对应的key
        Gson accelerationGson = new GsonBuilder().serializeNulls().create();
        //将json格式的请求转换为map格式
        Map map = accelerationGson.fromJson(req, Map.class);
        System.out.println(accelerationGson.toJson(map));

        map.remove("User_Mdn");
        String qosRequest = accelerationGson.toJson(map);
        System.out.println(qosRequest);

    }
}
