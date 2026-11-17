package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLChatChannelData implements FSerialize {
   @XmlAttribute
   public int Index;
   @XmlAttribute
   public int Color;

   public void serialize(FArchive var1) {
      var1.serialize(this, "Index", Integer.TYPE);
      var1.serialize(this, "Color", Integer.TYPE);
   }
}
