package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLButtonData extends XMLUIData {
   @XmlAttribute
   public int buttonName;
   @XmlAttribute
   public String buttonNameText;
   @XmlAttribute
   public String normalTex;
   @XmlAttribute
   public String pushedTex;
   @XmlAttribute
   public String highlightTex;
   @XmlAttribute
   public String dropTex;
   @XmlAttribute
   public int noHighlight;
   @XmlAttribute
   public int defaultSoundOn;
   @XmlAttribute
   public int DisableTime;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "normalTex", String.class);
      var1.serialize(this, "pushedTex", String.class);
      var1.serialize(this, "highlightTex", String.class);
      var1.serialize(this, "dropTex", String.class);
      var1.serialize(this, "buttonName", Integer.TYPE);
      var1.serialize(this, "buttonNameText", String.class);
      var1.serialize(this, "noHighlight", Integer.TYPE);
      var1.serialize(this, "defaultSoundOn", Integer.TYPE);
      var1.serialize(this, "DisableTime", Integer.TYPE);
   }
}
