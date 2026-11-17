package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLShortcutItemWindowData extends XMLUIData {
   @XmlAttribute
   public int alwaysShowOutline;
   @XmlAttribute
   public int useReservedShortcut;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "alwaysShowOutline", Integer.TYPE);
      var1.serialize(this, "useReservedShortcut", Integer.TYPE);
   }
}
