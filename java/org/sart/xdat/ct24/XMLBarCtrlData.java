package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLBarCtrlData extends XMLUIData {
   @XmlAttribute
   public String ForeTexture;
   @XmlAttribute
   public String ForeLeftTexture;
   @XmlAttribute
   public String ForeRightTexture;
   @XmlAttribute
   public String BackTexture;
   @XmlAttribute
   public String BackLeftTexture;
   @XmlAttribute
   public String BackRightTexture;
   @XmlAttribute
   public int USize;
   @XmlAttribute
   public int VSize;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "ForeTexture", String.class);
      var1.serialize(this, "ForeLeftTexture", String.class);
      var1.serialize(this, "ForeRightTexture", String.class);
      var1.serialize(this, "BackTexture", String.class);
      var1.serialize(this, "BackLeftTexture", String.class);
      var1.serialize(this, "BackRightTexture", String.class);
      var1.serialize(this, "USize", Integer.TYPE);
      var1.serialize(this, "VSize", Integer.TYPE);
   }
}
