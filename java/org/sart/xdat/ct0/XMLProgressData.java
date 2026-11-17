package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLProgressData extends XMLUIData {
   @XmlAttribute
   public String backTexture = "undefined";
   @XmlAttribute
   public String barTexture = "undefined";
   @XmlAttribute
   public int gap = 0;

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.backTexture = var1.readS();
      this.barTexture = var1.readS();
      this.gap = var1.readI();
   }

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.backTexture);
      var1.write(this.barTexture);
      var1.write(this.gap);
   }
}
