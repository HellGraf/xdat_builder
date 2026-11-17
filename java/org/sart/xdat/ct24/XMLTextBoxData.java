package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLTextBoxData extends XMLUIData {
   @XmlAttribute
   public String text;
   @XmlAttribute
   public int sysstring;
   @XmlAttribute
   public int systemMsg;
   @XmlAttribute
   public ETextAlign align;
   @XmlAttribute
   public ETextVAlign valign;
   @XmlAttribute
   public EFontType specialFontType;
   @XmlAttribute
   public String backTex;
   @XmlAttribute
   public int emoticon;
   @XmlAttribute
   public int autosize;
   @XmlAttribute
   public int textColor;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "text", String.class);
      var1.serialize(this, "align", ETextAlign.class);
      var1.serialize(this, "valign", ETextVAlign.class);
      var1.serialize(this, "specialFontType", EFontType.class);
      var1.serialize(this, "backTex", String.class);
      var1.serialize(this, "sysstring", Integer.TYPE);
      var1.serialize(this, "systemMsg", Integer.TYPE);
      var1.serialize(this, "textColor", Integer.TYPE);
      var1.serialize(this, "emoticon", Integer.TYPE);
      var1.serialize(this, "autosize", Integer.TYPE);
   }

   public class TextColor {
      @XmlAttribute
      public int R;
      @XmlAttribute
      public int G;
      @XmlAttribute
      public int B;
   }
}
