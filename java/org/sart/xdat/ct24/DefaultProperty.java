package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class DefaultProperty implements FSerialize {
   @XmlAttribute
   public String Name;
   @XmlAttribute
   public String Extends;
   @XmlAttribute
   public String ParentName;
   @XmlAttribute
   public int AlwaysOnTop;
   @XmlAttribute
   public int AlwaysOnBack;
   @XmlAttribute
   public int Anchored;
   @XmlAttribute
   public int SuperChild;
   @XmlAttribute
   public int Virtual;
   @XmlAttribute
   public int NWindowStyle;
   @XmlElement(
      name = "Position"
   )
   public XMLUIPosition position = new XMLUIPosition();
   @XmlElement(
      name = "AbsoluteSize"
   )
   public XMLUIAbsoluteSize absoluteSize = new XMLUIAbsoluteSize();
   @XmlElement(
      name = "RelativeSize"
   )
   public XMLUIRelativeSize relativeSize = new XMLUIRelativeSize();
   @XmlElement(
      name = "Tooltip"
   )
   public DefaultProperty.Tooltip tooltip = new DefaultProperty.Tooltip();
   @XmlElement(
      name = "UseFont"
   )
   public DefaultProperty.UseFont usefont = new DefaultProperty.UseFont();
   @XmlElement(
      name = "TabOrder"
   )
   public DefaultProperty.TabOrder taborder = new DefaultProperty.TabOrder();
   @XmlElement(
      name = "ScrollBarOffset"
   )
   public DefaultProperty.ScrollBarOffset scrollBarOffset = new DefaultProperty.ScrollBarOffset();
   @XmlAttribute
   public boolean hasFont = false;
   @XmlAttribute
   public boolean hasSize = false;
   @XmlAttribute
   public boolean isAbsolute = false;
   @XmlAttribute
   public boolean hasPosition = false;

   public void serialize(FArchive var1) {
      var1.serialize(this, "Name", String.class);
      var1.serialize(this, "Extends", String.class);
      var1.serialize(this, "AlwaysOnTop", Integer.TYPE);
      var1.serialize(this, "AlwaysOnBack", Integer.TYPE);
      var1.serialize(this, "ParentName", String.class);
      var1.serialize(this.taborder, "preOrder", String.class);
      var1.serialize(this.taborder, "postOrder", String.class);
      var1.serialize(this, "Anchored", Integer.TYPE);
      var1.serialize(this, "SuperChild", Integer.TYPE);
      var1.serialize(this, "hasSize", Boolean.TYPE);
      if (this.hasSize) {
         var1.serialize(this, "isAbsolute", Boolean.TYPE);
         if (this.isAbsolute) {
            this.absoluteSize.serialize(var1);
         } else {
            this.relativeSize.serialize(var1);
         }
      }

      var1.serialize(this, "hasPosition", Boolean.TYPE);
      if (this.hasPosition) {
         this.position.serialize(var1);
      }

      var1.serialize(this, "hasFont", Boolean.TYPE);
      if (this.hasFont) {
         var1.serialize(this.usefont, "styleName", String.class);
         var1.serialize(this.usefont, "fontName", String.class);
         var1.serialize(this.usefont, "color", Integer.TYPE);
         var1.serialize(this.usefont, "line", Integer.TYPE);
      }

      var1.serialize(this, "Virtual", Integer.TYPE);
      var1.serialize(this, "NWindowStyle", Integer.TYPE);
      var1.serialize(this.tooltip, "type", String.class);
      var1.serialize(this.tooltip, "text", Integer.TYPE);
      var1.serialize(this.scrollBarOffset, "x", Integer.TYPE);
      var1.serialize(this.scrollBarOffset, "y", Integer.TYPE);
      var1.serialize(this.scrollBarOffset, "heightOffset", Integer.TYPE);
   }

   public static class ScrollBarOffset {
      @XmlAttribute
      public int x;
      @XmlAttribute
      public int y;
      @XmlAttribute
      public int heightOffset;
   }

   public static class Tooltip {
      @XmlAttribute
      public String type;
      @XmlAttribute
      public int text;
   }

   public static class UseFont {
      @XmlAttribute
      public String styleName;
      @XmlAttribute
      public String fontName;
      @XmlAttribute
      public int color;
      @XmlAttribute
      public int line;
   }

   public static class TabOrder {
      @XmlAttribute
      public String preOrder;
      @XmlAttribute
      public String postOrder;
   }
}
