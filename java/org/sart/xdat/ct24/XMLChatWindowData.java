package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLChatWindowData extends XMLUIData {
   @XmlAttribute
   public int lineGap;
   @XmlAttribute
   public int NextLineOffsetX;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "lineGap", Integer.TYPE);
      var1.serialize(this, "NextLineOffsetX", Integer.TYPE);
   }
}
