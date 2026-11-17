package org.sart.xdat.ct0;

import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XMLDefaultProperty implements FSerializable {
   public static final Logger log = Logger.getLogger(XMLDefaultProperty.class.getName());
   @XmlAttribute
   public String name;
   @XmlAttribute
   public String extend;
   @XmlAttribute
   public int alwaysOnTop;
   @XmlAttribute
   public int alwaysOnBack;
   @XmlAttribute
   public String parentName;
   @XmlAttribute
   public int virtual;
   @XmlAttribute
   public int passThrough;
   @XmlAttribute
   public int nWindowStyle;
   @XmlAttribute
   public int sized = 0;
   @XmlAttribute
   public int isAbsolute = 0;
   @XmlAttribute
   public int hasPosition = 0;
   @XmlElement(
      name = "RelativeSize"
   )
   public XMLDefaultProperty.RelativeSize releativeSize = new XMLDefaultProperty.RelativeSize();
   @XmlElement(
      name = "AbsoluteSize"
   )
   public XMLDefaultProperty.AbsoluteSize absoluteSize = new XMLDefaultProperty.AbsoluteSize();
   @XmlElement(
      name = "Position"
   )
   public XMLDefaultProperty.Position position = new XMLDefaultProperty.Position();
   @XmlElement(
      name = "Tooltip"
   )
   public XMLDefaultProperty.Tooltip tooltip = new XMLDefaultProperty.Tooltip();
   @XmlElement(
      name = "TabOrder"
   )
   public XMLDefaultProperty.TabOrder taborder = new XMLDefaultProperty.TabOrder();
   public static final int SIZE_TYPE_RELEATIVE = 0;
   public static final int SIZE_TYPE_ABSOLUTE = 1;

   public void serialize(FArchive var1) {
      var1.write(this.name);
      var1.write(this.extend);
      var1.write(this.alwaysOnTop);
      var1.write(this.alwaysOnBack);
      var1.write(this.parentName);
      this.taborder.serialize(var1);
      var1.write(this.position.anchored);
      var1.write(this.sized);
      if (this.sized == 1) {
         var1.write(this.isAbsolute);
         if (this.isAbsolute == 1) {
            this.absoluteSize.serialize(var1);
         } else {
            this.releativeSize.serialize(var1);
         }
      }

      var1.write(this.hasPosition);
      if (this.hasPosition == 1) {
         this.position.serialize(var1);
      }

      var1.write(this.virtual);
      var1.write(this.passThrough);
      var1.write(this.nWindowStyle);
      this.tooltip.serialize(var1);
   }

   public void unserialize(FArchive var1) {
      this.name = var1.readS();
      this.extend = var1.readS();
      this.alwaysOnTop = var1.readB();
      this.alwaysOnBack = var1.readB();
      this.parentName = var1.readS();
      this.taborder.unserialize(var1);
      this.position.anchored = var1.readB();
      this.sized = var1.readB();
      if (this.sized == 1) {
         this.isAbsolute = var1.readB();
         if (this.isAbsolute == 1) {
            this.absoluteSize.unserialize(var1);
         } else {
            this.releativeSize.unserialize(var1);
         }
      }

      this.hasPosition = var1.readB();
      if (this.hasPosition == 1) {
         this.position.unserialize(var1);
      }

      this.virtual = var1.readB();
      this.passThrough = var1.readB();
      this.nWindowStyle = var1.readI();
      this.tooltip.unserialize(var1);
   }

   public static enum Point {
      None,
      TopLeft,
      TopCenter,
      TopRight,
      CenterLeft,
      CenterCenter,
      CenterRight,
      BottomLeft,
      BottomCenter,
      BottomRight;
   }

   public static class TabOrder implements FSerializable {
      @XmlAttribute
      public String preOrder = "undefined";
      @XmlAttribute
      public String postOrder = "undefined";

      public void serialize(FArchive var1) {
         var1.write(this.preOrder);
         var1.write(this.postOrder);
      }

      public void unserialize(FArchive var1) {
         this.preOrder = var1.readS();
         this.postOrder = var1.readS();
      }
   }

   public static class Tooltip implements FSerializable {
      @XmlAttribute
      public String type = "undefined";
      @XmlAttribute
      public int text = 0;

      public void serialize(FArchive var1) {
         var1.write(this.type);
         var1.write(this.text);
      }

      public void unserialize(FArchive var1) {
         this.type = var1.readS();
         this.text = var1.readI();
      }
   }

   public static class Position implements FSerializable {
      @XmlAttribute
      public XMLDefaultProperty.Point relativePoint;
      @XmlAttribute
      public XMLDefaultProperty.Point anchorPoint;
      @XmlAttribute
      public String relativeTo;
      @XmlAttribute
      public int offsetX;
      @XmlAttribute
      public int offsetY;
      @XmlAttribute
      public int anchored;

      public Position() {
         this.relativePoint = XMLDefaultProperty.Point.TopLeft;
         this.anchorPoint = XMLDefaultProperty.Point.TopLeft;
         this.relativeTo = "";
         this.offsetX = 0;
         this.offsetY = 0;
         this.anchored = 0;
      }

      public void serialize(FArchive var1) {
         var1.write(this.relativePoint.ordinal());
         var1.write(this.anchorPoint.ordinal());
         var1.write(this.relativeTo);
         var1.write(this.offsetX);
         var1.write(this.offsetY);
      }

      public void unserialize(FArchive var1) {
         this.relativePoint = XMLDefaultProperty.Point.values()[var1.readI()];
         this.anchorPoint = XMLDefaultProperty.Point.values()[var1.readI()];
         this.relativeTo = var1.readS();
         this.offsetX = var1.readI();
         this.offsetY = var1.readI();
      }
   }

   public static class RelativeSize implements FSerializable {
      @XmlAttribute
      public String relativeTo = "";
      @XmlAttribute
      public float widthRate = 0.0F;
      @XmlAttribute
      public float heightRate = 0.0F;
      @XmlAttribute
      public int offsetWidth;
      @XmlAttribute
      public int offsetHeight;

      public void serialize(FArchive var1) {
         var1.write(this.relativeTo);
         var1.write(this.widthRate);
         var1.write(this.heightRate);
         var1.write(this.offsetWidth);
         var1.write(this.offsetHeight);
      }

      public void unserialize(FArchive var1) {
         this.relativeTo = var1.readS();
         this.widthRate = var1.readF();
         this.heightRate = var1.readF();
         this.offsetWidth = var1.readI();
         this.offsetHeight = var1.readI();
      }
   }

   public static class AbsoluteSize implements FSerializable {
      @XmlAttribute
      public int width = 0;
      @XmlAttribute
      public int height = 0;

      public void serialize(FArchive var1) {
         var1.write(this.width);
         var1.write(this.height);
      }

      public void unserialize(FArchive var1) {
         this.width = var1.readI();
         this.height = var1.readI();
      }
   }
}
