package entry;

public class Revisit {
	private int id;
	private String name;
	private int clientid;
	private int linkstatus;
	private int clientstatus;
	private int purposestatus;
	private int assessstatus;
	public static String[] linkstatus_name = {"秒挂","未接通","有交流","深入交流"};
	public static String[] clientstatus_name = {"排斥","推脱","后续","较好"};
	public static String[] purposestatus_name = {"N","C","B","A","Y"};
	public static String[] assessstatus_name = {"截至","无果","有预约"};
	public static String[] status_name = {"正常 ","隐藏"};
	private String askinfo;
	private String followinfo;
	private String probleminfo;
	private int status;
	private String comments;
	
	private String clientname;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public  String getLinkstatus_name() {
		return linkstatus_name[linkstatus];
	}

	public String getClientstatus_name() {
		return clientstatus_name[clientstatus];
	}

	public String getPurposestatus_name() {
		return purposestatus_name[purposestatus];
	}

	public String getAssessstatus_name() {
		return assessstatus_name[assessstatus];
	}



	public String getStatus_name() {
		return status_name[status];
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
	public int getLinkstatus() {
		return linkstatus;
	}
	public void setLinkstatus(int linkstatus) {
		this.linkstatus = linkstatus;
	}
	public int getClientstatus() {
		return clientstatus;
	}
	public void setClientstatus(int clientstatus) {
		this.clientstatus = clientstatus;
	}
	public int getPurposestatus() {
		return purposestatus;
	}
	public void setPurposestatus(int purposestatus) {
		this.purposestatus = purposestatus;
	}
	public int getAssessstatus() {
		return assessstatus;
	}
	public void setAssessstatus(int assessstatus) {
		this.assessstatus = assessstatus;
	}

	public String getAskinfo() {
		return askinfo;
	}
	public void setAskinfo(String askinfo) {
		this.askinfo = askinfo;
	}
	public String getFollowinfo() {
		return followinfo;
	}
	public void setFollowinfo(String followinfo) {
		this.followinfo = followinfo;
	}
	public String getProbleminfo() {
		return probleminfo;
	}
	public void setProbleminfo(String probleminfo) {
		this.probleminfo = probleminfo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getClientname() {
		return clientname;
	}
	
	

 } 
