package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XMLTextureData extends XMLUIData {
   @XmlAttribute
   public String file = "undefined";
   @XmlAttribute
   public XMLTextureData.Type type;
   @XmlAttribute
   public XMLTextureData.Layer layer;
   @XmlAttribute
   public int alpha;
   @XmlAttribute
   public int isAnimTex;
   @XmlElement(
      name = "TextureCoords"
   )
   public XMLTextureData.TextureCoords coords;

   public XMLTextureData() {
      this.type = XMLTextureData.Type.Stretch;
      this.layer = XMLTextureData.Layer.Normal;
      this.alpha = -9999;
      this.isAnimTex = -1;
      this.coords = new XMLTextureData.TextureCoords();
   }

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.file);
      var1.write(this.type.ordinal());
      var1.write(this.layer.ordinal());
      this.coords.serialize(var1);
      var1.write(this.alpha);
      var1.write(this.isAnimTex);
   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.file = var1.readS();
      this.type = XMLTextureData.Type.values()[var1.readI()];
      this.layer = XMLTextureData.Layer.values()[var1.readI()];
      this.coords.unserialize(var1);
      this.alpha = var1.readI();
      this.isAnimTex = var1.readB();
   }

   public static enum Layer {
      None,
      Normal,
      Background;
   }

   public static enum Type {
      Stretch,
      Normal,
      Tile,
      Draggable,
      Control;
   }

   public static class TextureCoords implements FSerializable {
      @XmlAttribute
      public int usize;
      @XmlAttribute
      public int vsize;
      @XmlAttribute
      public float u;
      @XmlAttribute
      public float v;

      public void serialize(FArchive var1) {
         var1.write(this.usize);
         var1.write(this.vsize);
         var1.write(this.u);
         var1.write(this.v);
      }

      public void unserialize(FArchive var1) {
         this.usize = var1.readI();
         this.vsize = var1.readI();
         this.u = var1.readF();
         this.v = var1.readF();
      }
   }
}
