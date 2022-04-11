package model;

public class UserDTO {

	private String user_email;
	private String user_password;
	private String first_name;
	private String last_name;
	private String profile_img;
	private String user_joindate;
	private int dept_seq;
	//===============================
	
	
	public UserDTO(String user_email, String user_password, String first_name, String last_name, String profile_img,
			String user_joindate, int dept_seq) {
		super();
		this.user_email = user_email;
		this.user_password = user_password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.profile_img = profile_img;
		this.user_joindate = user_joindate;
		this.dept_seq = dept_seq;
	}
	public UserDTO(String user_email, String user_password) {
		super();
		this.user_email = user_email;
		this.user_password = user_password;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	public String getUser_joindate() {
		return user_joindate;
	}
	public void setUser_joindate(String user_joindate) {
		this.user_joindate = user_joindate;
	}
	public int getDept_seq() {
		return dept_seq;
	}
	public void setDept_seq(int dept_seq) {
		this.dept_seq = dept_seq;
	}
	
	
}