package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLFishViewportWindowData extends XMLUIData {
   @XmlAttribute
   public String texBack;
   @XmlAttribute
   public String texClock;
   @XmlAttribute
   public String texFishHPBar;
   @XmlAttribute
   public String texFishHPBarBack;
   @XmlAttribute
   public String texFishFakeHPBarWarning;
   @XmlAttribute
   public String texFishingEffect;
   @XmlAttribute
   public String texIconPumping;
   @XmlAttribute
   public String texIconReeling;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "texBack", String.class);
      var1.serialize(this, "texClock", String.class);
      var1.serialize(this, "texFishHPBar", String.class);
      var1.serialize(this, "texFishHPBarBack", String.class);
      var1.serialize(this, "texFishFakeHPBarWarning", String.class);
      var1.serialize(this, "texFishingEffect", String.class);
      var1.serialize(this, "texIconPumping", String.class);
      var1.serialize(this, "texIconReeling", String.class);
   }
}
