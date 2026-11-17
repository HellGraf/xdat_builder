package org.sart.xdat.ct24;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XMLComboBoxData extends XMLUIData {
   @XmlElement(
      name = "CombotItem"
   )
   public List items = new LinkedList();

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "items", XMLComboBoxData.ComboItem.class);
   }

   public static class ComboItem implements FSerialize {
      @XmlAttribute
      public int sysstring;
      @XmlAttribute
      public int systemMsg;
      @XmlAttribute
      public String text;
      @XmlAttribute
      public int reserved;

      public void serialize(FArchive var1) {
         var1.serialize(this, "sysstring", Integer.TYPE);
         var1.serialize(this, "systemMsg", Integer.TYPE);
         var1.serialize(this, "text", String.class);
         var1.serialize(this, "reserved", Integer.TYPE);
      }
   }
}
