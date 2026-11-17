package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XMLTextureCtrlData extends XMLUIData {
   @XmlAttribute
   public String file;
   @XmlAttribute
   public String AlphaMask;
   @XmlAttribute
   public ETextureCtrlType type;
   @XmlAttribute
   public ETextureLayer layer;
   @XmlAttribute
   public int alpha;
   @XmlAttribute
   public int isAnimTex;
   @XmlAttribute
   public String AutoRotate;
   @XmlAttribute
   public float MaskLayer;
   @XmlElement(
      name = "TextureCoords"
   )
   public XMLTextureCtrlData.TextureCoords textureCoords = new XMLTextureCtrlData.TextureCoords();
   @XmlAttribute
   public int ColorModify;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "file", String.class);
      var1.serialize(this, "AlphaMask", String.class);
      var1.serialize(this, "type", ETextureCtrlType.class);
      var1.serialize(this, "layer", ETextureLayer.class);
      var1.serialize(this.textureCoords, "u", Float.TYPE);
      var1.serialize(this.textureCoords, "v", Float.TYPE);
      var1.serialize(this.textureCoords, "usize", Float.TYPE);
      var1.serialize(this.textureCoords, "vsize", Float.TYPE);
      var1.serialize(this, "alpha", Integer.TYPE);
      var1.serialize(this, "isAnimTex", Integer.TYPE);
      var1.serialize(this, "AutoRotate", String.class);
      var1.serialize(this, "MaskLayer", Float.TYPE);
      var1.serialize(this, "ColorModify", Integer.TYPE);
   }

   public static class TextureCoords {
      @XmlAttribute
      public float u;
      @XmlAttribute
      public float v;
      @XmlAttribute
      public float usize;
      @XmlAttribute
      public float vsize;
   }
}
