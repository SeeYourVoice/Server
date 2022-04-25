package model;

public class RecordDTO {
	
	private String rec_seq;
	private String user_email;
	private String rec_date;
	private String rec_text_seq;
	private String position_num;
	private String rec_wordcloud;
	private String dept_seq;
	private String rec_name;
	
	
	public RecordDTO(String rec_seq, String user_email, String rec_date, String rec_text_seq, String position_num,
			String rec_wordcloud, String dept_seq, String rec_name) {
		super();
		this.rec_seq = rec_seq;
		this.user_email = user_email;
		this.rec_date = rec_date;
		this.rec_text_seq = rec_text_seq;
		this.position_num = position_num;
		this.rec_wordcloud = rec_wordcloud;
		this.dept_seq = dept_seq;
		this.rec_name = rec_name;
	}

	

	public RecordDTO(String user_email,  String position_num,  String dept_seq, String rec_name) {
		super();
		this.user_email = user_email;
	//	this.rec_text_seq = rec_text_seq;//이거랑 
		this.position_num = position_num;
		//this.rec_wordcloud = rec_wordcloud; //이거는 word_cloud 링크 갖고와야
		this.dept_seq = dept_seq;
		this.rec_name = rec_name;
	}



	public RecordDTO() {
		super();
	}


	public RecordDTO(String rec_date2, String rec_name2, String position_num) {
		// TODO Auto-generated constructor stub
		
		this.rec_date = rec_date2;
		this.rec_name = rec_name2;
		this.position_num=position_num;
		
	}


	public String getRec_seq() {
		return rec_seq;
	}


	public void setRec_seq(String rec_seq) {
		this.rec_seq = rec_seq;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getRec_date() {
		return rec_date;
	}


	public void setRec_date(String rec_date) {
		this.rec_date = rec_date;
	}


	public String getRec_text_seq() {
		return rec_text_seq;
	}


	public void setRec_text_seq(String rec_text_seq) {
		this.rec_text_seq = rec_text_seq;
	}


	public String getPosition_num() {
		return position_num;
	}


	public void setPosition_num(String position_num) {
		this.position_num = position_num;
	}


	public String getRec_wordcloud() {
		return rec_wordcloud;
	}


	public void setRec_wordcloud(String rec_wordcloud) {
		this.rec_wordcloud = rec_wordcloud;
	}


	public String getDept_seq() {
		return dept_seq;
	}


	public void setDept_seq(String dept_seq) {
		this.dept_seq = dept_seq;
	}


	public String getRec_name() {
		return rec_name;
	}


	public void setRec_name(String rec_name) {
		this.rec_name = rec_name;
	}
	
	
	
	

}
