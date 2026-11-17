package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLEffectButtonData extends XMLUIData {
   @XmlAttribute
   public EEffectButtonType Type;
   @XmlAttribute
   public String NormalTex;
   @XmlAttribute
   public String PushedTex;
   @XmlAttribute
   public String HighlightTex;
   @XmlAttribute
   public String EffectTex1;
   @XmlAttribute
   public String EffectTex2;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "Type", EEffectButtonType.class);
      var1.serialize(this, "NormalTex", String.class);
      var1.serialize(this, "PushedTex", String.class);
      var1.serialize(this, "HighlightTex", String.class);
      var1.serialize(this, "EffectTex1", String.class);
      var1.serialize(this, "EffectTex2", String.class);
   }
}
