package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLMinimapCtrlData extends XMLUIData {
   @XmlAttribute
   public int showtime;
   @XmlAttribute
   public int showtown;
   @XmlAttribute
   public int showgrid;
   @XmlAttribute
   public int showmylocmark;
   @XmlAttribute
   public int showmyloctext;
   @XmlAttribute
   public int showssqtext;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "showtime", Integer.TYPE);
      var1.serialize(this, "showtown", Integer.TYPE);
      var1.serialize(this, "showgrid", Integer.TYPE);
      var1.serialize(this, "showmylocmark", Integer.TYPE);
      var1.serialize(this, "showmyloctext", Integer.TYPE);
      var1.serialize(this, "showssqtext", Integer.TYPE);
   }
}
