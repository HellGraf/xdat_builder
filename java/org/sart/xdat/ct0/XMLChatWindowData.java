package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLChatWindowData extends XMLUIData {
   @XmlAttribute
   public int lineGap = -9999;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.lineGap);
   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.lineGap = var1.readI();
   }
}
