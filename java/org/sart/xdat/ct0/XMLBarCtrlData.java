package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLBarCtrlData extends XMLUIData {
   @XmlAttribute
   public String foretexture = "undefined";
   @XmlAttribute
   public String backtexture = "undefined";
   @XmlAttribute
   public int usize = -9999;
   @XmlAttribute
   public int vsize = -9999;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.foretexture);
      var1.write(this.backtexture);
      var1.write(this.usize);
      var1.write(this.vsize);
   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.foretexture = var1.readS();
      this.backtexture = var1.readS();
      this.usize = var1.readI();
      this.vsize = var1.readI();
   }
}
