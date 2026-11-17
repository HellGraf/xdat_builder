package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLCheckBoxData extends XMLUIData {
   @XmlAttribute
   public int string;
   @XmlAttribute
   public int checked = -1;
   @XmlAttribute
   public int leftAligned = -1;
   @XmlAttribute
   public int maxWidth = -9999;
   @XmlAttribute
   public String CheckTexture = "undefined";
   @XmlAttribute
   public String UnCheckTexture = "undefined";
   @XmlAttribute
   public String DisableTexture = "undefined";
   @XmlAttribute
   public String DisableCheckTexture = "undefined";

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.string);
      var1.write(this.checked);
      var1.write(this.leftAligned);
      var1.write(this.maxWidth);
      var1.write(this.CheckTexture);
      var1.write(this.UnCheckTexture);
      var1.write(this.DisableTexture);
      var1.write(this.DisableCheckTexture);
   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.string = var1.readI();
      this.checked = var1.readB();
      this.leftAligned = var1.readB();
      this.maxWidth = var1.readI();
      this.CheckTexture = var1.readS();
      this.UnCheckTexture = var1.readS();
      this.DisableTexture = var1.readS();
      this.DisableCheckTexture = var1.readS();
   }
}
