package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLEditBoxData extends XMLUIData {
   @XmlAttribute
   public XMLEditBoxData.EditBoxType editBoxType;
   @XmlAttribute
   public int maxLength;
   @XmlAttribute
   public int bShowCursor;
   @XmlAttribute
   public int ChatMarkOn;

   public XMLEditBoxData() {
      this.editBoxType = XMLEditBoxData.EditBoxType.Default;
      this.maxLength = -9999;
      this.bShowCursor = -1;
      this.ChatMarkOn = -1;
   }

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.editBoxType.ordinal());
      var1.write(this.maxLength);
      var1.write(this.bShowCursor);
      var1.write(this.ChatMarkOn);
   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.editBoxType = XMLEditBoxData.EditBoxType.values()[var1.readI()];
      this.maxLength = var1.readI();
      this.bShowCursor = var1.readB();
      this.ChatMarkOn = var1.readB();
   }

   public static enum EditBoxType {
      Default,
      Chat,
      Password,
      Number,
      Date,
      Time,
      ID;
   }
}
