package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XMLStatusBarCtrlData extends XMLUIData {
   @XmlAttribute
   public String Title;
   @XmlAttribute
   public int TextureWidth;
   @XmlAttribute
   public int TextureHeight;
   @XmlAttribute
   public String ForeTexture;
   @XmlAttribute
   public String ForeLeftTexture;
   @XmlAttribute
   public String ForeRightTexture;
   @XmlAttribute
   public String BackTexture;
   @XmlAttribute
   public String BackLeftTexture;
   @XmlAttribute
   public String BackRightTexture;
   @XmlAttribute
   public String RegenTexture;
   @XmlAttribute
   public String RegenLeftTexture;
   @XmlAttribute
   public String RegenRightTexture;
   @XmlAttribute
   public String WarnTexture;
   @XmlAttribute
   public String WarnLeftTexture;
   @XmlAttribute
   public String WarnRightTexture;
   @XmlElement(
      name = "GaugeText"
   )
   public GaugeText gaugeText = new GaugeText();

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "Title", String.class);
      var1.serialize(this, "TextureWidth", Integer.TYPE);
      var1.serialize(this, "TextureHeight", Integer.TYPE);
      var1.serialize(this, "ForeTexture", String.class);
      var1.serialize(this, "ForeLeftTexture", String.class);
      var1.serialize(this, "ForeRightTexture", String.class);
      var1.serialize(this, "BackTexture", String.class);
      var1.serialize(this, "BackLeftTexture", String.class);
      var1.serialize(this, "BackRightTexture", String.class);
      var1.serialize(this, "RegenLeftTexture", String.class);
      var1.serialize(this, "RegenTexture", String.class);
      var1.serialize(this, "RegenRightTexture", String.class);
      var1.serialize(this, "WarnTexture", String.class);
      var1.serialize(this, "WarnLeftTexture", String.class);
      var1.serialize(this, "WarnRightTexture", String.class);
      var1.serialize(this.gaugeText, "Texture", String.class);
      var1.serialize(this.gaugeText, "FontWidth", Integer.TYPE);
      var1.serialize(this.gaugeText, "FontHeight", Integer.TYPE);
   }
}
