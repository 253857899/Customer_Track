package entry;

public class Orderdetails {
	private int id;
	private int orderid;
	private int productid;
	private double count;
	private double amount;
	private double desc;
	private String comments;
	
	private String ordername;
	private String productname;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count = count;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getDesc() {
		return desc;
	}
	public void setDesc(double desc) {
		this.desc = desc;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getOrdername() {
		return ordername;
	}
	public String getProductname() {
		return productname;
	}
	

	

}	
