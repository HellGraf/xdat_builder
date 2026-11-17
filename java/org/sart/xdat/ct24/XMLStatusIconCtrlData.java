package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLStatusIconCtrlData extends XMLUIData {
   @XmlAttribute
   public int NoClip;
   @XmlAttribute
   public int NoTooltip;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "NoClip", Integer.TYPE);
      var1.serialize(this, "NoTooltip", Integer.TYPE);
   }
}
