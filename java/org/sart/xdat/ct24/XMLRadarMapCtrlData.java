package org.sart.xdat.ct24;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XMLRadarMapCtrlData extends XMLUIData {
   @XmlAttribute
   public String MapTextureName;
   @XmlAttribute
   public float Layer;
   @XmlElement(
      name = "RadarMapCtrlObjectType"
   )
   public List items = new LinkedList();

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "MapTextureName", String.class);
      var1.serialize(this, "Layer", Float.TYPE);
      var1.serialize(this, "items", XMLRadarMapCtrlData.RadarMapCtrlObjectType.class);
   }

   public static class RadarMapCtrlObjectType implements FSerialize {
      @XmlAttribute
      public String TypeName;
      @XmlAttribute
      public String NormalTexName;
      @XmlAttribute
      public String PushedTexName;
      @XmlAttribute
      public String OverTexName;
      @XmlAttribute
      public int Width;
      @XmlAttribute
      public int Height;
      @XmlAttribute
      public int Top;

      public void serialize(FArchive var1) {
         var1.serialize(this, "TypeName", String.class);
         var1.serialize(this, "NormalTexName", String.class);
         var1.serialize(this, "PushedTexName", String.class);
         var1.serialize(this, "OverTexName", String.class);
         var1.serialize(this, "Width", Integer.TYPE);
         var1.serialize(this, "Height", Integer.TYPE);
         var1.serialize(this, "Top", Integer.TYPE);
      }
   }
}
