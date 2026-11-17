package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLStatusIconCtrlData extends XMLUIData {
   @XmlAttribute
   public int NoClip = -1;
   @XmlAttribute
   public int NoTooltip = -1;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.NoClip);
      var1.write(this.NoTooltip);
   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.NoClip = var1.readB();
      this.NoTooltip = var1.readB();
   }
}
