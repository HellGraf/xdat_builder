package org.sart.xdat.ct0;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XMLTabCtrlData extends XMLUIData {
   @XmlElement(
      name = "TabButton"
   )
   public List childs = new LinkedList();

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.childs.size());
      Iterator var2 = this.childs.iterator();

      while(var2.hasNext()) {
         XMLTabCtrlData.XMLTabButtonData var3 = (XMLTabCtrlData.XMLTabButtonData)var2.next();
         var3.serialize(var1);
      }

   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      int var2 = var1.readI();

      for(int var3 = 0; var3 < var2; ++var3) {
         XMLTabCtrlData.XMLTabButtonData var4 = new XMLTabCtrlData.XMLTabButtonData();
         var4.unserialize(var1);
         this.childs.add(var4);
      }

   }

   public static class XMLTabButtonData implements FSerializable {
      @XmlAttribute
      public int buttonName = -9999;
      @XmlAttribute
      public String target = "undefined";
      @XmlAttribute
      public int width = -9999;
      @XmlAttribute
      public int height = -9999;
      @XmlAttribute
      public String normalTex = "undefined";
      @XmlAttribute
      public String pushedTex = "undefined";
      @XmlAttribute
      public int movable = -1;
      @XmlAttribute
      public int gap = -9999;
      @XmlAttribute
      public int tooltip = -9999;
      @XmlAttribute
      public int noHighlight = -1;

      public void serialize(FArchive var1) {
         var1.write(this.buttonName);
         var1.write(this.target);
         var1.write(this.width);
         var1.write(this.height);
         var1.write(this.normalTex);
         var1.write(this.pushedTex);
         var1.write(this.movable);
         var1.write(this.gap);
         var1.write(this.tooltip);
         var1.write(this.noHighlight);
      }

      public void unserialize(FArchive var1) {
         this.buttonName = var1.readI();
         this.target = var1.readS();
         this.width = var1.readI();
         this.height = var1.readI();
         this.normalTex = var1.readS();
         this.pushedTex = var1.readS();
         this.movable = var1.readB();
         this.gap = var1.readI();
         this.tooltip = var1.readI();
         this.noHighlight = var1.readB();
      }
   }
}
