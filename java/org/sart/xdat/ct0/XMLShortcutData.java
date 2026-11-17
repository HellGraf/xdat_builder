package org.sart.xdat.ct0;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XMLShortcutData implements FSerializable {
   @XmlAttribute
   public String name;
   @XmlAttribute
   public String state;
   @XmlElement(
      name = "ShortcutItem"
   )
   public List list = new LinkedList();

   public void serialize(FArchive var1) {
      var1.write(this.name);
      var1.write(this.state);
      var1.write(this.list.size());
      Iterator var2 = this.list.iterator();

      while(var2.hasNext()) {
         XMLShortcutData.XMLShortcutItemData var3 = (XMLShortcutData.XMLShortcutItemData)var2.next();
         var3.serialize(var1);
      }

   }

   public void unserialize(FArchive var1) {
      this.name = var1.readS();
      this.state = var1.readS();
      int var2 = var1.readI();

      for(int var3 = 0; var3 < var2; ++var3) {
         XMLShortcutData.XMLShortcutItemData var4 = new XMLShortcutData.XMLShortcutItemData();
         var4.unserialize(var1);
         this.list.add(var4);
      }

   }

   public static class XMLShortcutItemData implements FSerializable {
      @XmlAttribute
      public int key;
      @XmlAttribute
      public int SubKey1;
      @XmlAttribute
      public int SubKey2;
      @XmlAttribute
      public String command;

      public void serialize(FArchive var1) {
         var1.write(this.key);
         var1.write(this.SubKey1);
         var1.write(this.SubKey2);
         var1.write(this.command);
      }

      public void unserialize(FArchive var1) {
         this.key = var1.readI();
         this.SubKey1 = var1.readI();
         this.SubKey2 = var1.readI();
         this.command = var1.readS();
      }
   }
}
