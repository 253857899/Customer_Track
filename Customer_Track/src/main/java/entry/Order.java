package entry;

public class Order {
	private int id;
	private String name;
	private int clientid;
	private String createdate;
	private String compdate;
	private String orderdate;
	private String startdate;
	private String enddate;
	private int operatorid;
	private String info;
	private String files;
	private String compoperatorids;
	private String compweight;
	private int status;
	private double amount;
	private String comments;
	private String operatornames;
	
	public static String[] status_name= {"未审核","已审核","暂缓业绩","作废"};
	
	private String clientname;
	private String username;
	
	
	
	public String getOperatornames() {
		return operatornames;
	}
	public void setOperatornames(String operatornames) {
		this.operatornames = operatornames;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus_name() {
		return status_name[status];
	}
	public String getClientname() {
		return clientname;
	}
	public String getUsername() {
		return username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClientid() {
		return clientid;
	}
	public void setClientid(int clientid) {
		this.clientid = clientid;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getCompdate() {
		return compdate;
	}
	public void setCompdate(String compdate) {
		this.compdate = compdate;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public int getOperatorid() {
		return operatorid;
	}
	public void setOperatorid(int operatorid) {
		this.operatorid = operatorid;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	public String getCompoperatorids() {
		return compoperatorids;
	}
	public void setCompoperatorids(String compoperatorids) {
		this.compoperatorids = compoperatorids;
	}
	public String getCompweight() {
		return compweight;
	}
	public void setCompweight(String compweight) {
		this.compweight = compweight;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	

}	
