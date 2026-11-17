package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlElement;

public class XMLUIData implements FSerialize {
   @XmlElement(
      name = "DefaultProperty"
   )
   public DefaultProperty property = new DefaultProperty();

   public void serialize(FArchive var1) {
      this.property.serialize(var1);
   }
}
