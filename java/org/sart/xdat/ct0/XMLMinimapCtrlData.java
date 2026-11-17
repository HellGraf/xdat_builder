package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLMinimapCtrlData extends XMLUIData {
   @XmlAttribute
   public int showtime = -1;
   @XmlAttribute
   public int showtown = -1;
   @XmlAttribute
   public int showgrid = -1;
   @XmlAttribute
   public int showmylocmark = -1;
   @XmlAttribute
   public int showmyloctext = -1;
   @XmlAttribute
   public int showssqtext = -1;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.showtime);
      var1.write(this.showtown);
      var1.write(this.showgrid);
      var1.write(this.showmylocmark);
      var1.write(this.showmyloctext);
      var1.write(this.showssqtext);
   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.showtime = var1.readB();
      this.showtown = var1.readB();
      this.showgrid = var1.readB();
      this.showmylocmark = var1.readB();
      this.showmyloctext = var1.readB();
      this.showssqtext = var1.readB();
   }
}
