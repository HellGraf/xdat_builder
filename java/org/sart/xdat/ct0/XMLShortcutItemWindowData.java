package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLShortcutItemWindowData extends XMLUIData {
   @XmlAttribute
   public int alwaysShowOutline = 0;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.alwaysShowOutline);
   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.alwaysShowOutline = var1.readI();
   }
}
