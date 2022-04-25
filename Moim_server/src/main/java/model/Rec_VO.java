package model;

public class Rec_VO {
   private RecordDTO rec_info;
   private TextDTO textDTO;
   
   
   public Rec_VO(RecordDTO rec_info, TextDTO textDTO) {
      super();
      this.rec_info = rec_info;
      this.textDTO = textDTO;
   }


   public RecordDTO getRec_info() {
      return rec_info;
   }


   public void setRec_info(RecordDTO rec_info) {
      this.rec_info = rec_info;
   }


   public TextDTO getTextDTO() {
      return textDTO;
   }


   public void setTextDTO(TextDTO textDTO) {
      this.textDTO = textDTO;
   }
   
   
}