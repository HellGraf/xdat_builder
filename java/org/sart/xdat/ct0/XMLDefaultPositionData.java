package org.sart.xdat.ct0;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XMLDefaultPositionData implements FSerializable {
   @XmlElement(
      name = "DefaultPosition"
   )
   public List list = new LinkedList();

   public void serialize(FArchive var1) {
      var1.write(this.list.size());
      Iterator var2 = this.list.iterator();

      while(var2.hasNext()) {
         XMLDefaultPositionData.DefaultPosition var3 = (XMLDefaultPositionData.DefaultPosition)var2.next();
         var3.serialize(var1);
      }

   }

   public void unserialize(FArchive var1) {
      int var2 = var1.readI();

      for(int var3 = 0; var3 < var2; ++var3) {
         XMLDefaultPositionData.DefaultPosition var4 = new XMLDefaultPositionData.DefaultPosition();
         var4.unserialize(var1);
         this.list.add(var4);
      }

   }

   public static class Position0 {
      @XmlAttribute
      public XMLDefaultProperty.Point relativePoint;
      @XmlAttribute
      public int offsetX;
      @XmlAttribute
      public int offsetY;
      @XmlAttribute
      public int anchored;

      public Position0() {
         this.relativePoint = XMLDefaultProperty.Point.None;
         this.offsetX = 0;
         this.offsetY = 0;
         this.anchored = 0;
      }
   }

   public static class Size0 {
      @XmlAttribute
      public int width = -9999;
      @XmlAttribute
      public int height = -9999;
   }

   public static class DefaultPosition implements FSerializable {
      @XmlAttribute
      public String windowName;
      @XmlElement(
         name = "Position0"
      )
      public XMLDefaultPositionData.Position0 position = new XMLDefaultPositionData.Position0();
      @XmlElement(
         name = "Size0"
      )
      public XMLDefaultPositionData.Size0 size = new XMLDefaultPositionData.Size0();

      public void serialize(FArchive var1) {
         var1.write(this.windowName);
         var1.write(this.position.relativePoint.ordinal());
         var1.write(this.position.offsetX);
         var1.write(this.position.offsetY);
         var1.write(this.position.anchored);
         var1.write(this.size.width);
         var1.write(this.size.height);
      }

      public void unserialize(FArchive var1) {
         this.windowName = var1.readS();
         this.position.relativePoint = XMLDefaultProperty.Point.values()[var1.readI()];
         this.position.offsetX = var1.readI();
         this.position.offsetY = var1.readI();
         this.position.anchored = var1.readB();
         this.size.width = var1.readI();
         this.size.height = var1.readI();
      }
   }
}
