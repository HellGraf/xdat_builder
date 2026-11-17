package org.sart.xdat.ct0;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XMLListData extends XMLUIData {
   @XmlAttribute
   public int maxRow = -9999;
   @XmlAttribute
   public int showRow = -9999;
   @XmlAttribute
   public int useScroll = -1;
   @XmlAttribute
   public int contentsHeight = -9999;
   @XmlAttribute
   public int headerHeight = -9999;
   @XmlElement
   public List childs = new LinkedList();

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.maxRow = var1.readI();
      this.showRow = var1.readI();
      this.useScroll = var1.readB();
      this.contentsHeight = var1.readI();
      this.headerHeight = var1.readI();
      int var2 = var1.readI();

      for(int var3 = 0; var3 < var2; ++var3) {
         XMLListData.ListColumn var4 = new XMLListData.ListColumn();
         var4.unserialize(var1);
         this.childs.add(var4);
      }

   }

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.maxRow);
      var1.write(this.showRow);
      var1.write(this.useScroll);
      var1.write(this.contentsHeight);
      var1.write(this.headerHeight);
      var1.write(this.childs.size());
      Iterator var2 = this.childs.iterator();

      while(var2.hasNext()) {
         XMLListData.ListColumn var3 = (XMLListData.ListColumn)var2.next();
         var3.serialize(var1);
      }

   }

   public static class ListColumn implements FSerializable {
      @XmlAttribute
      public int string = -9999;
      @XmlAttribute
      public int width = -9999;
      @XmlAttribute
      public int bNumber = -1;
      @XmlAttribute
      public int bAscend = -1;
      @XmlAttribute
      public int bClickEnable = -1;

      public void serialize(FArchive var1) {
         var1.write(this.string);
         var1.write(this.width);
         var1.write(this.bNumber);
         var1.write(this.bAscend);
         var1.write(this.bClickEnable);
      }

      public void unserialize(FArchive var1) {
         this.string = var1.readI();
         this.width = var1.readI();
         this.bNumber = var1.readB();
         this.bAscend = var1.readB();
         this.bClickEnable = var1.readB();
      }
   }
}
