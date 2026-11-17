package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLEffectButtonData extends XMLUIData {
   @XmlAttribute
   public XMLEffectButtonData.EffectButtonType type;
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

   public XMLEffectButtonData() {
      this.type = XMLEffectButtonData.EffectButtonType.Undefined;
      this.NormalTex = "undefined";
      this.PushedTex = "undefined";
      this.HighlightTex = "undefined";
      this.EffectTex1 = "undefined";
      this.EffectTex2 = "undefined";
   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.type = XMLEffectButtonData.EffectButtonType.values()[var1.readI() + 1];
      this.NormalTex = var1.readS();
      this.PushedTex = var1.readS();
      this.HighlightTex = var1.readS();
      this.EffectTex1 = var1.readS();
      this.EffectTex2 = var1.readS();
   }

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.type.ordinal() - 1);
      var1.write(this.NormalTex);
      var1.write(this.PushedTex);
      var1.write(this.HighlightTex);
      var1.write(this.EffectTex1);
      var1.write(this.EffectTex2);
   }

   public static enum EffectButtonType {
      Undefined,
      Tutorial,
      Quest,
      Mail;
   }
}
