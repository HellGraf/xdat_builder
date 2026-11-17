package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlElement;

public abstract class XMLUIData implements FSerializable {
   @XmlElement(
      name = "DefaultProperty"
   )
   public XMLDefaultProperty property = new XMLDefaultProperty();
   public static final int I_UNDEFINED = -9999;
   public static final int B_UNDEFINED = -1;
   public static final int B_FALSE = 0;
   public static final int B_TRUE = 1;
   public static final float F_UNDEFINED = -9999.0F;
   public static final String S_UNDEFINED = "undefined";
   public static final int CONST = -2302756;

   public void serialize(FArchive var1) {
      this.property.serialize(var1);
   }

   public void unserialize(FArchive var1) {
      this.property.unserialize(var1);
   }
}
