package model;

public class TextDTO {
   private int rec_text_seq;
   private String rec_text;
   private String rec_fulltext;
   private String wordcloud;
   
   

   public TextDTO(int rec_text_seq, String rec_text, String rec_fulltext, String wordcloud) {
	super();
	this.rec_text_seq = rec_text_seq;
	this.rec_text = rec_text;
	this.rec_fulltext = rec_fulltext;
	this.wordcloud = wordcloud;
}


public TextDTO() {
      super();
   }


   public int getRec_text_seq() {
      return rec_text_seq;
   }

   public void setRec_text_seq(int rec_text_seq) {
      this.rec_text_seq = rec_text_seq;
   }


   public String getRec_text() {
      return rec_text;
   }

   public void setRec_text(String rec_text) {
      this.rec_text = rec_text;
   }


   public String getRec_fulltext() {
      return rec_fulltext;
   }

   public void setRec_fulltext(String rec_fulltext) {
      this.rec_fulltext = rec_fulltext;
   }




   public String getWordcloud() {
      return wordcloud;
   }




   public void setWordcloud(String wordcloud) {
      this.wordcloud = wordcloud;
   }
   
   
   
}