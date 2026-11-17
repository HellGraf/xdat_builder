package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLMultiEditData extends XMLUIData {
   @XmlAttribute
   public int maxRow = -9999;
   @XmlAttribute
   public int showRow = -9999;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.maxRow);
      var1.write(this.showRow);
   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.maxRow = var1.readI();
      this.showRow = var1.readI();
   }
}
