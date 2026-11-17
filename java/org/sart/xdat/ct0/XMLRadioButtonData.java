package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLRadioButtonData extends XMLUIData {
   @XmlAttribute
   public int sysstr = -9999;
   @XmlAttribute
   public int radiogrpid = -9999;
   @XmlAttribute
   public int isChecked = -1;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.sysstr);
      var1.write(this.radiogrpid);
      var1.write(this.isChecked);
   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.sysstr = var1.readI();
      this.radiogrpid = var1.readI();
      this.isChecked = var1.readB();
   }
}
