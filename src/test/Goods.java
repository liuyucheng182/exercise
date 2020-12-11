package test;

public class Goods {

	private String num;
	private String name;
	private double price;
	
	public Goods(String num, String name, double price) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		return this.num == obj.toString();
	}
	
	public static void main(String[] args) {
		Goods good1 = new Goods("001", "苹果", 0.05);
		Goods good2 = new Goods("002", "桃", 0.08);
		System.out.println(good1.equals("001"));
		System.out.println(good2.equals("007"));
	}
}
