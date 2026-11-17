package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLRadioButtonData extends XMLUIData {
   @XmlAttribute
   public int sysstring;
   @XmlAttribute
   public int radioGroupID;
   @XmlAttribute
   public int isChecked;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "sysstring", Integer.TYPE);
      var1.serialize(this, "radioGroupID", Integer.TYPE);
      var1.serialize(this, "isChecked", Integer.TYPE);
   }
}
