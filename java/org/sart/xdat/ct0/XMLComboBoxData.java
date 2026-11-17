package org.sart.xdat.ct0;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XMLComboBoxData extends XMLUIData {
   @XmlElement(
      name = "ComboItem"
   )
   public List items = new LinkedList();

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.items.size());
      Iterator var2 = this.items.iterator();

      while(var2.hasNext()) {
         XMLComboBoxData.ComboItem var3 = (XMLComboBoxData.ComboItem)var2.next();
         var3.serialize(var1);
      }

   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      int var2 = var1.readI();

      for(int var3 = 0; var3 < var2; ++var3) {
         XMLComboBoxData.ComboItem var4 = new XMLComboBoxData.ComboItem();
         var4.unserialize(var1);
         this.items.add(var4);
      }

   }

   public static class ComboItem implements FSerializable {
      @XmlAttribute
      public int sysstring = -9999;
      @XmlAttribute
      public int systemMsg = -9999;
      @XmlAttribute
      public String text = "undefined";
      @XmlAttribute
      public int reserved = -9999;

      public void serialize(FArchive var1) {
         var1.write(this.sysstring);
         var1.write(this.systemMsg);
         var1.write(this.text);
         var1.write(this.reserved);
      }

      public void unserialize(FArchive var1) {
         this.sysstring = var1.readI();
         this.systemMsg = var1.readI();
         this.text = var1.readS();
         this.reserved = var1.readI();
      }
   }
}
