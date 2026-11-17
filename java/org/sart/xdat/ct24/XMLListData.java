package org.sart.xdat.ct24;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XMLListData extends XMLUIData {
   @XmlAttribute
   public int maxRow;
   @XmlAttribute
   public int showRow;
   @XmlAttribute
   public int useScroll;
   @XmlAttribute
   public int contentsHeight;
   @XmlAttribute
   public int headerHeight;
   @XmlElement(
      name = "ListColumn"
   )
   public List listColumn = new LinkedList();

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "maxRow", Integer.TYPE);
      var1.serialize(this, "showRow", Integer.TYPE);
      var1.serialize(this, "useScroll", Integer.TYPE);
      var1.serialize(this, "contentsHeight", Integer.TYPE);
      var1.serialize(this, "headerHeight", Integer.TYPE);
      var1.serialize(this, "listColumn", XMLListData.ListColumn.class);
   }

   public static class ListColumn implements FSerialize {
      @XmlAttribute
      public int string;
      @XmlAttribute
      public int width;
      @XmlAttribute
      public int bAscend;
      @XmlAttribute
      public int bClickEnable;
      @XmlAttribute
      public int bNumber;

      public void serialize(FArchive var1) {
         var1.serialize(this, "string", Integer.TYPE);
         var1.serialize(this, "width", Integer.TYPE);
         var1.serialize(this, "bAscend", Integer.TYPE);
         var1.serialize(this, "bClickEnable", Integer.TYPE);
         var1.serialize(this, "bNumber", Integer.TYPE);
      }
   }
}
