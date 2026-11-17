package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XMLInvenWeightData extends XMLUIData {
   @XmlAttribute
   public String Target;
   @XmlAttribute
   public int TextureWidth;
   @XmlAttribute
   public int TextureHeight;
   @XmlAttribute
   public String TextureStepLeft;
   @XmlAttribute
   public String TextureStepMid;
   @XmlAttribute
   public String TextureStepRight;
   @XmlAttribute
   public String TextureWarnLeft;
   @XmlAttribute
   public String TextureWarnMid;
   @XmlAttribute
   public String TextureWarnRight;
   @XmlAttribute
   public String TextureAddedLeft;
   @XmlAttribute
   public String TextureAddedMid;
   @XmlAttribute
   public String TextureAddedRight;
   @XmlAttribute
   public String TextureBackLeft;
   @XmlAttribute
   public String TextureBackMid;
   @XmlAttribute
   public String TextureBackRight;
   @XmlElement(
      name = "GaugeText"
   )
   public GaugeText gaugeText = new GaugeText();

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "Target", String.class);
      var1.serialize(this, "TextureWidth", Integer.TYPE);
      var1.serialize(this, "TextureHeight", Integer.TYPE);
      var1.serialize(this, "TextureStepLeft", String.class);
      var1.serialize(this, "TextureStepMid", String.class);
      var1.serialize(this, "TextureStepRight", String.class);
      var1.serialize(this, "TextureWarnLeft", String.class);
      var1.serialize(this, "TextureWarnMid", String.class);
      var1.serialize(this, "TextureWarnRight", String.class);
      var1.serialize(this, "TextureAddedLeft", String.class);
      var1.serialize(this, "TextureAddedMid", String.class);
      var1.serialize(this, "TextureAddedRight", String.class);
      var1.serialize(this, "TextureBackLeft", String.class);
      var1.serialize(this, "TextureBackMid", String.class);
      var1.serialize(this, "TextureBackRight", String.class);
      var1.serialize(this.gaugeText, "Texture", String.class);
      var1.serialize(this.gaugeText, "FontWidth", Integer.TYPE);
      var1.serialize(this.gaugeText, "FontHeight", Integer.TYPE);
   }
}
