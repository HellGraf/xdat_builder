package org.sart.xdat.ct24;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

public class XMLChatChannelDefinition implements FSerialize {
   @XmlElement(
      name = "ChatChannel"
   )
   public List pChannelData = new LinkedList();

   public void serialize(FArchive var1) {
      var1.serialize(this, "pChannelData", XMLChatChannelData.class);
   }
}
