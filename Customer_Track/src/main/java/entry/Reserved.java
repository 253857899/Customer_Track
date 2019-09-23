package entry;



public class Reserved {
	private int id;
	private int revisitid;
	private int clientid;
	private String createdate;
	private int operatorid;
	private String date;
	private int execoperatorid;
	private int type;
	private int status;
	private int execstatus;
	private String result;
	
	public static String[] type_name = {"回访预约","上门预约"};
	public static String[] execstatus_name = {"正常","违约","延期","下次继续"};
	public static String[] status_name = {"未处理 ","已处理"};
	
	private String revisitname;
	private String clientname;
	private String username;
	private String execoperatorname;
	
	
	
	public String getExecoperatorname() {
		return execoperatorname;
	}

	public int getExecoperatorid() {
		return execoperatorid;
	}

	public void setExecoperatorid(int execoperatorid) {
		this.execoperatorid = execoperatorid;
	}

	public String getRevisitname() {
		return revisitname;
	}

	public String getClientname() {
		return clientname;
	}

	public String getUsername() {
		return username;
	}

	public String getType_name() {
		return type_name[type];
	}
	
	public String getExecstatus_name() {
		return execstatus_name[execstatus];
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
	public int getRevisitid() {
		return revisitid;
	}
	public void setRevisitid(int revisitid) {
		this.revisitid = revisitid;
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
	public int getOperatorid() {
		return operatorid;
	}
	public void setOperatorid(int operatorid) {
		this.operatorid = operatorid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getExecstatus() {
		return execstatus;
	}
	public void setExecstatus(int execstatus) {
		this.execstatus = execstatus;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	

}
