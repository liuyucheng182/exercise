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
 * Description: 4GQoS提速响应消息体
 *
 * @author liuyucheng
 * @date 2019/5/31 08:33
 */

public class AccelerationResponse implements Serializable {

    private static final long serialVersionUID = 7064910588405836809L;

    @SerializedName("ResultCode")
    private String resultCode;

    @SerializedName("ResultMessage")
    private String resultMessage;

    /**
     * 响应成功时候返回的请求id，用来唯一标识一次提速请求
     */
    @SerializedName("CorrelationId")
    private String correlationId;

    public AccelerationResponse(String resultCode, String resultMessage, String correlationId) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.correlationId = correlationId;
    }

    public AccelerationResponse(String resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }
}
