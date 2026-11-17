package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLUIPosition implements FSerialize {
   @XmlAttribute
   public EAnchorType anchorPoint;
   @XmlAttribute
   public EAnchorType relativePoint;
   @XmlAttribute
   public String relativeTo;
   @XmlAttribute
   public float offsetX;
   @XmlAttribute
   public float offsetY;

   public void serialize(FArchive var1) {
      var1.serialize(this, "anchorPoint", EAnchorType.class);
      var1.serialize(this, "relativePoint", EAnchorType.class);
      var1.serialize(this, "relativeTo", String.class);
      var1.serialize(this, "offsetX", Float.TYPE);
      var1.serialize(this, "offsetY", Float.TYPE);
   }
}
