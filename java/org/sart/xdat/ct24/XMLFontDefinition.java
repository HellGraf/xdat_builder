package org.sart.xdat.ct24;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XMLFontDefinition implements FSerialize {
   @XmlAttribute
   public String defaultFontName;
   @XmlAttribute
   public int DefaultColor;
   @XmlElement(
      name = "FontData"
   )
   public List list = new LinkedList();

   public void serialize(FArchive var1) {
      var1.serialize(this, "defaultFontName", String.class);
      var1.serialize(this, "DefaultColor", Integer.TYPE);
      var1.serialize(this, "list", XMLFontData.class);
   }
}
