package test;

public enum TestEnum {

	春天("s","spring");
//	private String code;
//	private String value;
	private TestEnum(String code,String value){
//		this.code = code;
//		this.value = value;
	}
	
	public static void main(String[] args) {
		System.out.println(春天.ordinal());
	}
}
