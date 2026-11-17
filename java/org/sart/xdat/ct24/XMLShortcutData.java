package org.sart.xdat.ct24;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XMLShortcutData implements FSerialize {
   @XmlAttribute
   public String name;
   @XmlAttribute
   public String state;
   @XmlAttribute
   public int modifiable;
   @XmlElement(
      name = "ShortcutItem"
   )
   public List items = new LinkedList();
   @XmlElement(
      name = "ShortcutSpecialItem"
   )
   public List specialItems = new LinkedList();

   public void serialize(FArchive var1) {
      var1.serialize(this, "name", String.class);
      var1.serialize(this, "state", String.class);
      var1.serialize(this, "modifiable", Integer.TYPE);
      var1.serialize(this, "items", XMLShortcutItemData.class);
      var1.serialize(this, "specialItems", XMLShortcutItemData.class);
   }
}
