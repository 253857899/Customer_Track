package entry;

public class Operator {
	private int id;
	private String name;
	private String pass;
	private String tel;
	private int power;
	private int groupid;
	private int status;
	private String groupname;
	public String getGroupname() {
		return groupname;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public static String[] status_name = {"正常","禁用"};
	public static String[] power_name = {"管理员","组长","组员"};
	
	public String getPower_name() {
		return power_name[power];
	}
	public String getStatus_name() {
		return status_name[status];
	}
	public Operator() {
		
	}
	public Operator(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}


}	
