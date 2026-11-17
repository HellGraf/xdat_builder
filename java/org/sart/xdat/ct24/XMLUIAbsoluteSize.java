package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLUIAbsoluteSize implements FSerialize {
   @XmlAttribute
   public int width;
   @XmlAttribute
   public int height;

   public void serialize(FArchive var1) {
      var1.serialize(this, "width", Integer.TYPE);
      var1.serialize(this, "height", Integer.TYPE);
   }
}
