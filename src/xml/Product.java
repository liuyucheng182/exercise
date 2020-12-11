package xml;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String productInstID;
	protected String prodOpType;
	protected String productType;
	protected String productValue;
	protected String parentType;
	protected String productParentInstID;

	public String getProductInstID() {
		return productInstID;
	}

	public void setProductInstID(String productInstID) {
		this.productInstID = productInstID;
	}

	public String getProdOpType() {
		return prodOpType;
	}

	public void setProdOpType(String prodOpType) {
		this.prodOpType = prodOpType;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductValue() {
		return productValue;
	}

	public void setProductValue(String productValue) {
		this.productValue = productValue;
	}

	public String getParentType() {
		return parentType;
	}

	public void setParentType(String parentType) {
		this.parentType = parentType;
	}

	public String getProductParentInstID() {
		return productParentInstID;
	}

	public void setProductParentInstID(String productParentInstID) {
		this.productParentInstID = productParentInstID;
	}

}
