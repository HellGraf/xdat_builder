package org.sart.xdat.ct24;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XMLDefaultPositionData implements FSerialize {
   @XmlElement(
      name = "DefaultPositionItem"
   )
   public List pDefaultPositionItem = new LinkedList();

   public void serialize(FArchive var1) {
      var1.serialize(this, "pDefaultPositionItem", XMLDefaultPositionData.XMLDefaultPositionItemData.class);
   }

   public static class Size {
      @XmlAttribute
      public int width;
      @XmlAttribute
      public int height;
   }

   public static class Position {
      @XmlAttribute
      public EAnchorType relativePoint;
      @XmlAttribute
      public int offsetX;
      @XmlAttribute
      public int offsetY;
      @XmlAttribute
      public int anchored;
   }

   public static class XMLDefaultPositionItemData implements FSerialize {
      @XmlAttribute
      public String windowName;
      @XmlElement(
         name = "Position"
      )
      public XMLDefaultPositionData.Position position = new XMLDefaultPositionData.Position();
      @XmlElement(
         name = "Size"
      )
      public XMLDefaultPositionData.Size size = new XMLDefaultPositionData.Size();

      public void serialize(FArchive var1) {
         var1.serialize(this, "windowName", String.class);
         var1.serialize(this.position, "relativePoint", EAnchorType.class);
         var1.serialize(this.position, "offsetX", Integer.TYPE);
         var1.serialize(this.position, "offsetY", Integer.TYPE);
         var1.serialize(this.position, "anchored", Integer.TYPE);
         var1.serialize(this.size, "width", Integer.TYPE);
         var1.serialize(this.size, "height", Integer.TYPE);
      }
   }
}
