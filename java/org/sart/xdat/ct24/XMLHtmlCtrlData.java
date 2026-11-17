package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLHtmlCtrlData extends XMLUIData {
   @XmlAttribute
   public String ViewType;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "ViewType", String.class);
   }
}
