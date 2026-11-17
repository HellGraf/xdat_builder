package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;
import org.sart.xdat.ct24.FSerialize;

public class XMLStyleData implements FSerialize {
   @XmlAttribute
   public String Name;
   @XmlAttribute
   public String FontName;
   @XmlAttribute
   public String Line;
   @XmlAttribute
   public int Color;

   public void serialize(org.sart.xdat.ct24.FArchive var1) {
      var1.serialize(this, "Name", String.class);
      var1.serialize(this, "FontName", String.class);
      var1.serialize(this, "Line", String.class);
      var1.serialize(this, "Color", Integer.TYPE);
   }
}
