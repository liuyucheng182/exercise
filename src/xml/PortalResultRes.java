package xml;

import java.io.Serializable;
import java.util.List;

public class PortalResultRes implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String streamingNo;
	protected String oPFlag;
	protected String productID;
	protected String offerID;
	protected String bizID;
	protected String areaCode;
	protected String custID;
	protected String custAccount;
	protected String custName;
	protected List<Product> productInfo;
	protected String userID;
	protected String accType;
	protected String accName;
	protected String returnStatus;
	protected String summary;

	public String getStreamingNo() {
		return streamingNo;
	}

	public void setStreamingNo(String streamingNo) {
		this.streamingNo = streamingNo;
	}

	public String getOPFlag() {
		return oPFlag;
	}

	public void setOPFlag(String flag) {
		oPFlag = flag;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getOfferID() {
		return offerID;
	}

	public void setOfferID(String offerID) {
		this.offerID = offerID;
	}

	public String getBizID() {
		return bizID;
	}

	public void setBizID(String bizID) {
		this.bizID = bizID;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getCustID() {
		return custID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
	}

	public String getCustAccount() {
		return custAccount;
	}

	public void setCustAccount(String custAccount) {
		this.custAccount = custAccount;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public List<Product> getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(List<Product> productInfo) {
		this.productInfo = productInfo;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
