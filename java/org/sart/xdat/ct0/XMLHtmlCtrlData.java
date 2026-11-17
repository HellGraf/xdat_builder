package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLHtmlCtrlData extends XMLUIData {
   @XmlAttribute
   public String ViewType = "undefined";

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.ViewType);
   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.ViewType = var1.readS();
   }
}
