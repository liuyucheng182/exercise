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
 * Description:
 *
 * @author liuyucheng
 * @date 2019/5/31 16:13
 */

public class ResourceFeatureProperties implements Serializable {

    private static final long serialVersionUID = 5177088214010534469L;

    /**
     * 加速类型，默认1
     */
    @SerializedName("Type")
    private int type;

    /**
     * 优先级，默认1
     */
    @SerializedName("Priority")
    private int priority;

    /**
     * 最小上行速度，默认填50000
     */
    @SerializedName("MinimumUpStreamSpeedRate")
    private int minimumUpStreamSpeedRate;

    /**
     * 最小下行速度，默认填100000
     */
    @SerializedName("MinimumDownStreamSpeedRate")
    private int minimumDownStreamSpeedRate;

    /**
     * 流信息数组，多个目的地要设置多个目前支持最大为3
     */
    @SerializedName("FlowProperties")
    private List<FlowProperties> flowPropertiesList;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getMinimumDownStreamSpeedRate() {
        return minimumDownStreamSpeedRate;
    }

    public void setMinimumDownStreamSpeedRate(int minimumDownStreamSpeedRate) {
        this.minimumDownStreamSpeedRate = minimumDownStreamSpeedRate;
    }

    public int getMinimumUpStreamSpeedRate() {
        return minimumUpStreamSpeedRate;
    }

    public void setMinimumUpStreamSpeedRate(int minimumUpStreamSpeedRate) {
        this.minimumUpStreamSpeedRate = minimumUpStreamSpeedRate;
    }

    public List<FlowProperties> getFlowPropertiesList() {
        return flowPropertiesList;
    }

    public void setFlowPropertiesList(List<FlowProperties> flowPropertiesList) {
        this.flowPropertiesList = flowPropertiesList;
    }
}
