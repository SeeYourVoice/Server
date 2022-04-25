package model;

public class PosDTO {

	private int posNum;
	private String pos;
	
	public PosDTO(int posNum, String pos) {
	
		this.posNum = posNum;
		this.pos = pos;
	}
	public int getPosNum() {
		return posNum;
	}
	public void setPosNum(int posNum) {
		this.posNum = posNum;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	
	
}
