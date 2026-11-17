package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

public class XMLTextListBoxData extends XMLUIData {
   @XmlAttribute
   public int maxRow;
   @XmlAttribute
   public int showRow;
   @XmlAttribute
   public int lineGap;
   @XmlTransient
   public int isShowScroll;

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.maxRow = var1.readI();
      this.showRow = var1.readI();
      this.lineGap = var1.readI();
      this.isShowScroll = var1.readB();
   }

   public void serialize(FArchive var1) {
      super.serialize(var1);
      this.maxRow = var1.readI();
      this.showRow = var1.readI();
      this.lineGap = var1.readI();
      this.isShowScroll = var1.readB();
   }
}
