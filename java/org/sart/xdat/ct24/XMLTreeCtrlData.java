package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLTreeCtrlData extends XMLUIData {
   @XmlAttribute
   public int SaveExpandedNode;
   @XmlAttribute
   public int MultiExpand;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "SaveExpandedNode", Integer.TYPE);
      var1.serialize(this, "MultiExpand", Integer.TYPE);
   }
}
