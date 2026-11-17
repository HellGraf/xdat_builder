package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLStatusBarData extends XMLUIData {
   @XmlAttribute
   public String Title = "undefined";
   @XmlAttribute
   public int TextureWidth = -9999;
   @XmlAttribute
   public int TextureHeight = -9999;
   @XmlAttribute
   public String ForeTexture = "undefined";
   @XmlAttribute
   public String BackTexture = "undefined";
   @XmlAttribute
   public String WarnTexture = "undefined";
   @XmlAttribute
   public String RegenTexture = "undefined";

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.Title);
      var1.write(this.TextureWidth);
      var1.write(this.TextureHeight);
      var1.write(this.ForeTexture);
      var1.write(this.BackTexture);
      var1.write(this.WarnTexture);
      var1.write(this.RegenTexture);
   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.Title = var1.readS();
      this.TextureWidth = var1.readI();
      this.TextureHeight = var1.readI();
      this.ForeTexture = var1.readS();
      this.BackTexture = var1.readS();
      this.WarnTexture = var1.readS();
      this.RegenTexture = var1.readS();
   }
}
