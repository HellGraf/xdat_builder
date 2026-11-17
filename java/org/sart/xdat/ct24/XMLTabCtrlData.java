package org.sart.xdat.ct24;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XMLTabCtrlData extends XMLUIData {
   @XmlElement(
      name = "TabButton"
   )
   public List pTabButtonData = new LinkedList();

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "pTabButtonData", XMLTabCtrlData.XMLTabButtonData.class);
   }

   public static class XMLTabButtonData implements FSerialize {
      @XmlAttribute
      public int buttonName;
      @XmlAttribute
      public String buttonNameText;
      @XmlAttribute
      public String target;
      @XmlAttribute
      public int width;
      @XmlAttribute
      public int height;
      @XmlAttribute
      public String normalTex;
      @XmlAttribute
      public String pushedTex;
      @XmlAttribute
      public int movable;
      @XmlAttribute
      public int gap;
      @XmlAttribute
      public int tooltip;
      @XmlAttribute
      public int noHighlight;

      public void serialize(FArchive var1) {
         var1.serialize(this, "buttonName", Integer.TYPE);
         var1.serialize(this, "buttonNameText", String.class);
         var1.serialize(this, "target", String.class);
         var1.serialize(this, "width", Integer.TYPE);
         var1.serialize(this, "height", Integer.TYPE);
         var1.serialize(this, "normalTex", String.class);
         var1.serialize(this, "pushedTex", String.class);
         var1.serialize(this, "movable", Integer.TYPE);
         var1.serialize(this, "gap", Integer.TYPE);
         var1.serialize(this, "tooltip", Integer.TYPE);
         var1.serialize(this, "noHighlight", Integer.TYPE);
      }
   }
}
