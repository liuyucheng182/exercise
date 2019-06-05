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
 * @date 2019/5/31 16:38
 */

public class FlowProperties implements Serializable {


    private static final long serialVersionUID = -6669951600745455217L;

    /**
     * 方向，默认2
     */
    @SerializedName("Direction")
    private int direction;

    /**
     * 源ip地址，可不传
     */
    @SerializedName("SourceIpAddress")
    private String sourceIpAddress;

    /**
     * 目的地ip地址，必传，填加速目的服务器的ip地址
     */
    @SerializedName("DestinationIpAddress")
    private String destinationIpAddress;

    /**
     * 协议，默认为ip
     */
    @SerializedName("Protocol")
    private String protocol;

    /**
     * 最大上行速度，默认为50000
     */
    @SerializedName("MaximumUpStreamSpeedRate")
    private int maximumUpStreamSpeedRate;

    /**
     * 最大下行速度，默认为100000
     */
    @SerializedName("MaximumDownStreamSpeedRate")
    private int maximumDownStreamSpeedRate;

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getSourceIpAddress() {
        return sourceIpAddress;
    }

    public void setSourceIpAddress(String sourceIpAddress) {
        this.sourceIpAddress = sourceIpAddress;
    }

    public String getDestinationIpAddress() {
        return destinationIpAddress;
    }

    public void setDestinationIpAddress(String destinationIpAddress) {
        this.destinationIpAddress = destinationIpAddress;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getMaximumUpStreamSpeedRate() {
        return maximumUpStreamSpeedRate;
    }

    public void setMaximumUpStreamSpeedRate(int maximumUpStreamSpeedRate) {
        this.maximumUpStreamSpeedRate = maximumUpStreamSpeedRate;
    }

    public int getMaximumDownStreamSpeedRate() {
        return maximumDownStreamSpeedRate;
    }

    public void setMaximumDownStreamSpeedRate(int maximumDownStreamSpeedRate) {
        this.maximumDownStreamSpeedRate = maximumDownStreamSpeedRate;
    }
}
