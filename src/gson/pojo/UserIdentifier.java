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

/**
 * Description:
 *
 * @author liuyucheng
 * @date 2019/5/31 15:47
 */

public class UserIdentifier implements Serializable {

    private static final long serialVersionUID = 2875652052089820212L;

    /**
     * 用户手机内网ip
     */
    @SerializedName("IP")
    private String ip;
    /**
     * 公网ip
     */
    @SerializedName("PublicIP")
    private String publicIp;
    /**
     * 公网端口
     */
    @SerializedName("PublicPORT")
    private String publicPort;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPublicIp() {
        return publicIp;
    }

    public void setPublicIp(String publicIp) {
        this.publicIp = publicIp;
    }

    public String getPublicPort() {
        return publicPort;
    }

    public void setPublicPort(String publicPort) {
        this.publicPort = publicPort;
    }
}
