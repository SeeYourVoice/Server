package model;

public class DeptDTO {

	private String dept_name;
	private int dept_seq;
	
	public DeptDTO(String dept_name, int dept_seq) {
		super();
		this.dept_name = dept_name;
		this.dept_seq = dept_seq;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public int getDept_seq() {
		return dept_seq;
	}

	public void setDept_seq(int dept_seq) {
		this.dept_seq = dept_seq;
	}
	
	
	
}
