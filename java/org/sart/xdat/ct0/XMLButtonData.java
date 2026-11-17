package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLButtonData extends XMLUIData {
   @XmlAttribute
   public int buttonName;
   @XmlAttribute
   public String normalTex = "undefined";
   @XmlAttribute
   public String pushedTex = "undefined";
   @XmlAttribute
   public String highlightTex = "undefined";
   @XmlAttribute
   public String dropTex = "undefined";
   @XmlAttribute
   public int noHighlight = -1;
   @XmlAttribute
   public int defaultSoundOn = -1;
   @XmlAttribute
   public int disableTime = -9999;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.normalTex);
      var1.write(this.pushedTex);
      var1.write(this.highlightTex);
      var1.write(this.dropTex);
      var1.write(this.buttonName);
      var1.write(this.noHighlight);
      var1.write(this.defaultSoundOn);
      var1.write(this.disableTime);
   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.normalTex = var1.readS();
      this.pushedTex = var1.readS();
      this.highlightTex = var1.readS();
      this.dropTex = var1.readS();
      this.buttonName = var1.readI();
      this.noHighlight = var1.readB();
      this.defaultSoundOn = var1.readB();
      this.disableTime = var1.readI();
   }
}
