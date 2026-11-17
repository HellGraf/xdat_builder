package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLVideoPlayerCtrlData extends XMLUIData {
   @XmlAttribute
   public String FileName;
   @XmlAttribute
   public int PlayTime;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "FileName", String.class);
      var1.serialize(this, "PlayTime", Integer.TYPE);
   }
}
