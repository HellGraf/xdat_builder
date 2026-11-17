package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLCheckBoxData extends XMLUIData {
   @XmlAttribute
   public int string;
   @XmlAttribute
   public String TitleText;
   @XmlAttribute
   public int checked;
   @XmlAttribute
   public int leftAlign;
   @XmlAttribute
   public int maxWidth;
   @XmlAttribute
   public String CheckTexture;
   @XmlAttribute
   public String UnCheckTexture;
   @XmlAttribute
   public String DisableTexture;
   @XmlAttribute
   public String DisableCheckTexture;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "string", Integer.TYPE);
      var1.serialize(this, "TitleText", String.class);
      var1.serialize(this, "checked", Integer.TYPE);
      var1.serialize(this, "leftAlign", Integer.TYPE);
      var1.serialize(this, "maxWidth", Integer.TYPE);
      var1.serialize(this, "CheckTexture", String.class);
      var1.serialize(this, "UnCheckTexture", String.class);
      var1.serialize(this, "DisableTexture", String.class);
      var1.serialize(this, "DisableCheckTexture", String.class);
   }
}
