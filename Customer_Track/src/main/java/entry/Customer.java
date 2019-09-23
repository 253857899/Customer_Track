package entry;

public class Customer {
	private int id;
	private String name;
	private int sex;
	public static String[] sex_name = {"男","女"};
	private String tel;
	private String qq;
	private String email;
	private String infos;
	private int linkstatus;
	private int clientstatus;
	private int purposestatus;
	private int assessstatus;
	private int execstatus;
	private int status;
	public static String[] linkstatus_name = {"未指定","秒挂","未接通","有交流","深入交流"};
	public static String[] clientstatus_name = {"未指定","排斥","推脱","后续","较好"};
	public static String[] purposestatus_name = {"未指定","N","C","B","A","Y"};
	public static String[] assessstatus_name = {"未指定","截至","无果","有预约"};
	public static String[] execstatus_name = {"正常","转出","完成"};
	public static String[] status_name = {"正常 ","公共","资料不全","无效"};
	private int clienttypeid;
	private String operatorids;
	private int createoperatorid;
	private String createdate;
	private int srcid;
	private int count;
	private String comments;
	private String operatornames;
	
	private String createoperatorname;
	private String typename;
	private String srcname;
	private String operators;
	
	
	
	public String getOperatornames() {
		return operatornames;
	}

	public void setOperatornames(String operatornames) {
		this.operatornames = operatornames;
	}

	public String getOperators() {
		return operators;
	}

	public String getSex_name() {
		return sex_name[sex];
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

	public String getExecstatus_name() {
		return execstatus_name[execstatus];
	}

	public String getStatus_name() {
		return status_name[status];
	}
	
	public String getTypename() {
		return typename;
	}

	public String getSrcname() {
		return srcname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
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

	public int getExecstatus() {
		return execstatus;
	}

	public void setExecstatus(int execstatus) {
		this.execstatus = execstatus;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getClienttypeid() {
		return clienttypeid;
	}

	public void setClienttypeid(int clienttypeid) {
		this.clienttypeid = clienttypeid;
	}

	public String getOperatorids() {
		return operatorids;
	}

	public void setOperatorids(String operatorids) {
		this.operatorids = operatorids;
	}

	public int getCreateoperatorid() {
		return createoperatorid;
	}

	public void setCreateoperatorid(int createoperatorid) {
		this.createoperatorid = createoperatorid;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public int getSrcid() {
		return srcid;
	}

	public void setSrcid(int srcid) {
		this.srcid = srcid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCreateoperatorname() {
		return createoperatorname;
	}
	
}
