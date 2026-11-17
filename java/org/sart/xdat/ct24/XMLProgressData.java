package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLProgressData extends XMLUIData {
   @XmlAttribute
   public String Type;
   @XmlAttribute
   public String backLeftTexture;
   @XmlAttribute
   public String backTexture;
   @XmlAttribute
   public String backRightTexture;
   @XmlAttribute
   public String barLeftTexture;
   @XmlAttribute
   public String barTexture;
   @XmlAttribute
   public String barRightTexture;
   @XmlAttribute
   public int USize;
   @XmlAttribute
   public int VSize;
   @XmlAttribute
   public int gap;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "Type", String.class);
      var1.serialize(this, "backLeftTexture", String.class);
      var1.serialize(this, "backTexture", String.class);
      var1.serialize(this, "backRightTexture", String.class);
      var1.serialize(this, "barLeftTexture", String.class);
      var1.serialize(this, "barTexture", String.class);
      var1.serialize(this, "barRightTexture", String.class);
      var1.serialize(this, "USize", Integer.TYPE);
      var1.serialize(this, "VSize", Integer.TYPE);
      var1.serialize(this, "gap", Integer.TYPE);
   }
}
