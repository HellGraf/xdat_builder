package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLUIRelativeSize implements FSerialize {
   @XmlAttribute
   public String relativeTo;
   @XmlAttribute
   public float widthRate;
   @XmlAttribute
   public float heightRate;
   @XmlAttribute
   public int offsetWidth;
   @XmlAttribute
   public int offsetHeight;

   public void serialize(FArchive var1) {
      var1.serialize(this, "relativeTo", String.class);
      var1.serialize(this, "widthRate", Float.TYPE);
      var1.serialize(this, "heightRate", Float.TYPE);
      var1.serialize(this, "offsetWidth", Integer.TYPE);
      var1.serialize(this, "offsetHeight", Integer.TYPE);
   }
}
