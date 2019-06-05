/*
 * Copyright © 2019 中国电信集团系统集成有限责任公司 版权所有
 *
 * 所有文字、代码资料，版权均属中国电信集团系统集成有限责任公司
 * 任何公司或个人未经本司协议授权，不得复制、下载、存储或公开
 * 显示。违者本公司将依法追究责任。
 */

package gson.pojo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Description: 终端APP向CQoS平台发起的提速请求参数（与QoSRequest对象的区别为：多了一个用户手机号，用于验证此号码是否开通天翼对讲功能）
 *
 * @author liuyucheng
 * @date 2019/5/31 15:38
 */

public class AccelerationRequest implements Serializable {

    private static final long serialVersionUID = 3746764154494794896L;

    /**
     * 用户手机号
     */
    @SerializedName("User_Mdn")
    private String userMdn;

    @SerializedName("Partner_ID")
    private String partnerId;
    /**
     * 用户信息（可不传，从token里解析）
     */
    @SerializedName("UserIdentifier")
    private UserIdentifier userIdentifier;

    /**
     * 鉴权码，从鉴权接口获取
     */
    @SerializedName("security_token")
    private String securityToken;

    @SerializedName("OTTchargingId")
    private String ottChargingId;

    /**
     * 业务id，例如：TencentGames
     */
    @SerializedName("ServiceId")
    private String serviceId;

    /**
     * 加速维持的时长，单位为秒，最多一小时
     */
    @SerializedName("Duration")
    private int duration;

    /**
     * 回调地址
     */
    @SerializedName("CallBackURL")
    private String callBackURL;

    /**
     * 业务类型、业务流信息和 QoS 信息等，可以包含多个实例，如视频包含音频和视频流。
     */
    @SerializedName("ResourceFeatureProperties")
    private List<ResourceFeatureProperties> resourceFeaturePropertiesList;


    public String getUserMdn() {
        return userMdn;
    }

    public void setUserMdn(String userMdn) {
        this.userMdn = userMdn;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public UserIdentifier getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(UserIdentifier userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    public String getOttChargingId() {
        return ottChargingId;
    }

    public void setOttChargingId(String ottChargingId) {
        this.ottChargingId = ottChargingId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCallBackURL() {
        return callBackURL;
    }

    public void setCallBackURL(String callBackURL) {
        this.callBackURL = callBackURL;
    }

    public List<ResourceFeatureProperties> getResourceFeaturePropertiesList() {
        return resourceFeaturePropertiesList;
    }

    public void setResourceFeaturePropertiesList(List<ResourceFeatureProperties> resourceFeaturePropertiesList) {
        this.resourceFeaturePropertiesList = resourceFeaturePropertiesList;
    }
}
