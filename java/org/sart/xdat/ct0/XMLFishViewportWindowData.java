package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLFishViewportWindowData extends XMLUIData {
   @XmlAttribute
   public String texBack = "undefined";
   @XmlAttribute
   public String texClock = "undefined";
   @XmlAttribute
   public String texFishHPBar = "undefined";
   @XmlAttribute
   public String texFishHPBarBack = "undefined";
   @XmlAttribute
   public String texFishFakeHPBarWarning = "undefined";
   @XmlAttribute
   public String texFishingEffect = "undefined";
   @XmlAttribute
   public String texIconPumping = "undefined";
   @XmlAttribute
   public String texIconReeling = "undefined";

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.texBack = var1.readS();
      this.texClock = var1.readS();
      this.texFishHPBar = var1.readS();
      this.texFishHPBarBack = var1.readS();
      this.texFishFakeHPBarWarning = var1.readS();
      this.texFishingEffect = var1.readS();
      this.texIconPumping = var1.readS();
      this.texIconReeling = var1.readS();
   }

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.texBack);
      var1.write(this.texClock);
      var1.write(this.texFishHPBar);
      var1.write(this.texFishHPBarBack);
      var1.write(this.texFishFakeHPBarWarning);
      var1.write(this.texFishingEffect);
      var1.write(this.texIconPumping);
      var1.write(this.texIconReeling);
   }
}
