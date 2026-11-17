package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XMLTextBoxData extends XMLUIData {
   @XmlAttribute
   public String text = "undefined";
   @XmlAttribute
   public XMLTextBoxData.Align align;
   @XmlAttribute
   public XMLTextBoxData.FontType fontType;
   @XmlAttribute
   public String backTex;
   @XmlAttribute
   public int offsetY;
   @XmlAttribute
   public int sysstring;
   @XmlAttribute
   public int systemMsg;
   @XmlElement(
      name = "TextColor"
   )
   public XMLTextBoxData.Color TextColor;
   @XmlAttribute
   public int emoticon;
   @XmlAttribute
   public int autosize;

   public XMLTextBoxData() {
      this.align = XMLTextBoxData.Align.Left;
      this.fontType = XMLTextBoxData.FontType.Normal;
      this.backTex = "undefined";
      this.offsetY = 0;
      this.sysstring = -9999;
      this.systemMsg = -9999;
      this.TextColor = new XMLTextBoxData.Color(-2302756);
      this.emoticon = -1;
      this.autosize = -1;
   }

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.text);
      var1.write(this.align.ordinal());
      var1.write(this.fontType.ordinal());
      var1.write(this.backTex);
      var1.write(this.offsetY);
      var1.write(this.sysstring);
      var1.write(this.systemMsg);
      var1.write(this.TextColor.value);
      var1.write(this.emoticon);
      var1.write(this.autosize);
   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.text = var1.readS();
      this.align = XMLTextBoxData.Align.values()[var1.readI()];
      this.fontType = XMLTextBoxData.FontType.values()[var1.readI()];
      this.backTex = var1.readS();
      this.offsetY = var1.readI();
      this.sysstring = var1.readI();
      this.systemMsg = var1.readI();
      this.TextColor = new XMLTextBoxData.Color(var1.readI());
      this.emoticon = var1.readB();
      this.autosize = var1.readB();
   }

   public static enum FontType {
      Normal,
      Big,
      Credit,
      Unk1,
      ZoneTitle,
      Unk2,
      Broadcast1,
      Broadcast2,
      Unk3,
      SpecialDigitSmall,
      SpecialDigitLarge,
      SpecialDigitXLarge;
   }

   public static class Color {
      @XmlAttribute
      public int R;
      @XmlAttribute
      public int G;
      @XmlAttribute
      public int B;
      @XmlAttribute
      public int value;

      public Color() {
      }

      public Color(int var1) {
         this.value = var1;
      }

      public Color(int var1, int var2, int var3) {
         this.R = var1;
         this.G = var2;
         this.B = var3;
      }
   }

   public static enum Align {
      Undefined,
      Left,
      Center,
      Right,
      MacroIcon;
   }
}
