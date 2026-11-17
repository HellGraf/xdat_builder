package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLShortcutItemData implements FSerialize {
   @XmlAttribute
   public EInputKey key;
   @XmlAttribute
   public EInputKey subkey1;
   @XmlAttribute
   public EInputKey subkey2;
   @XmlAttribute
   public String command;
   @XmlAttribute
   public int inputAction;

   public void serialize(FArchive var1) {
      var1.serialize(this, "key", EInputKey.class);
      var1.serialize(this, "subkey1", EInputKey.class);
      var1.serialize(this, "subkey2", EInputKey.class);
      var1.serialize(this, "command", String.class);
      var1.serialize(this, "inputAction", Integer.TYPE);
   }
}
