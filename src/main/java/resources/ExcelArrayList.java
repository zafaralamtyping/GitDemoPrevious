package resources;

public class ExcelArrayList {
	private String userName;
	private String password;
	private String comment;
	
	public ExcelArrayList(String userName, String password, String comment) {
		super();
		this.userName = userName;
		this.password = password;
		this.comment = comment;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	

}
