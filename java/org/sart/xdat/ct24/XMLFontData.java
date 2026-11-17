package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XMLFontData implements FSerialize {
   @XmlAttribute
   public String name;
   @XmlAttribute
   public String fileName;
   @XmlAttribute
   public String type;
   @XmlAttribute
   public int size;
   @XmlAttribute
   public int index;
   @XmlAttribute
   public int lineGap;
   @XmlAttribute
   public int hasIndex;
   @XmlAttribute
   public int hasStroke;
   @XmlElement(
      name = "Stroke"
   )
   public XMLFontData.Stroke stroke = new XMLFontData.Stroke();
   @XmlAttribute
   public int hasShadow;
   @XmlElement(
      name = "Shadow"
   )
   public XMLFontData.Shadow shadow = new XMLFontData.Shadow();
   @XmlAttribute
   public int underlineOffset;

   public void serialize(FArchive var1) {
      var1.serialize(this, "name", String.class);
      var1.serialize(this, "fileName", String.class);
      var1.serialize(this, "type", String.class);
      var1.serialize(this, "size", Integer.TYPE);
      var1.serialize(this, "index", Integer.TYPE);
      var1.serialize(this, "hasIndex", Integer.TYPE);
      var1.serialize(this, "hasShadow", Integer.TYPE);
      var1.serialize(this.shadow, "offsetX", Integer.TYPE);
      var1.serialize(this.shadow, "offsetY", Integer.TYPE);
      var1.serialize(this, "hasStroke", Integer.TYPE);
      var1.serialize(this.stroke, "volume", XMLFontData.EVolume.class);
      var1.serialize(this, "lineGap", Integer.TYPE);
      var1.serialize(this, "underlineOffset", Integer.TYPE);
   }

   public static enum EVolume {
      thin,
      thick;

      public static XMLFontData.EVolume parseInt(int var0) {
         return var0 != 1 && var0 != 0 ? thin : values()[var0];
      }

      public static int toInt(XMLFontData.EVolume var0) {
         return var0.ordinal();
      }
   }

   public static class Shadow {
      @XmlAttribute
      public int offsetX;
      @XmlAttribute
      public int offsetY;
   }

   public static class Stroke {
      @XmlAttribute
      public XMLFontData.EVolume volume;
   }
}
