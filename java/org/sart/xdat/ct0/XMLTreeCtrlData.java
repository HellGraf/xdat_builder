package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLTreeCtrlData extends XMLUIData {
   @XmlAttribute
   public int SaveExpandedNode;
   @XmlAttribute
   public int MultiExpand;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.SaveExpandedNode);
      var1.write(this.MultiExpand);
   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.SaveExpandedNode = var1.readI();
      this.MultiExpand = var1.readI();
   }
}
