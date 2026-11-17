package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLEditBoxData extends XMLUIData {
   @XmlAttribute
   public EEditBoxType editBoxType;
   @XmlAttribute
   public int maxLength;
   @XmlAttribute
   public int bShowCursor;
   @XmlAttribute
   public int ChatMarkOn;
   @XmlAttribute
   public int OffsetX;
   @XmlAttribute
   public int bCandidateBoxShowUpPos;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "editBoxType", EEditBoxType.class);
      var1.serialize(this, "maxLength", Integer.TYPE);
      var1.serialize(this, "bShowCursor", Integer.TYPE);
      var1.serialize(this, "ChatMarkOn", Integer.TYPE);
      var1.serialize(this, "OffsetX", Integer.TYPE);
      var1.serialize(this, "bCandidateBoxShowUpPos", Integer.TYPE);
   }
}
