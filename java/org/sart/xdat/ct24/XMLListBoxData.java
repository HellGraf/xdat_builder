package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLListBoxData extends XMLUIData {
   @XmlAttribute
   public int maxRow;
   @XmlAttribute
   public int showRow;
   @XmlAttribute
   public int showLastLine;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "maxRow", Integer.TYPE);
      var1.serialize(this, "showRow", Integer.TYPE);
      var1.serialize(this, "showLastLine", Integer.TYPE);
   }
}
