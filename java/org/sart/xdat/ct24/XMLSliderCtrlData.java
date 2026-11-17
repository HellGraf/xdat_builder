package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLSliderCtrlData extends XMLUIData {
   @XmlAttribute
   public int iNumOfTick;
   @XmlAttribute
   public int iCurrTick;
   @XmlAttribute
   public int iThumbBtnWidth;
   @XmlAttribute
   public int iThumbBtnHeight;
   @XmlAttribute
   public String strBackTexture;
   @XmlAttribute
   public String strDisableBackTexture;
   @XmlAttribute
   public String strThumbBtnNormalTexture;
   @XmlAttribute
   public String strThumbBtnDownTexture;
   @XmlAttribute
   public int iPushBtnWidth;
   @XmlAttribute
   public int iPushBtnHeight;
   @XmlAttribute
   public int iPushBtnAutoHitTime;
   @XmlAttribute
   public String strDecreaseBtnNormalTexture;
   @XmlAttribute
   public String strDecreaseBtnDownTexture;
   @XmlAttribute
   public String strIncreaseBtnNormalTexture;
   @XmlAttribute
   public String strIncreaseBtnDownTexture;
   @XmlAttribute
   public String strTickTexture;
   @XmlAttribute
   public int thumbBtnInclusive;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "iNumOfTick", Integer.TYPE);
      var1.serialize(this, "iCurrTick", Integer.TYPE);
      var1.serialize(this, "iThumbBtnWidth", Integer.TYPE);
      var1.serialize(this, "iThumbBtnHeight", Integer.TYPE);
      var1.serialize(this, "strBackTexture", String.class);
      var1.serialize(this, "strDisableBackTexture", String.class);
      var1.serialize(this, "strThumbBtnNormalTexture", String.class);
      var1.serialize(this, "strThumbBtnDownTexture", String.class);
      var1.serialize(this, "iPushBtnWidth", Integer.TYPE);
      var1.serialize(this, "iPushBtnHeight", Integer.TYPE);
      var1.serialize(this, "iPushBtnAutoHitTime", Integer.TYPE);
      var1.serialize(this, "strDecreaseBtnNormalTexture", String.class);
      var1.serialize(this, "strDecreaseBtnDownTexture", String.class);
      var1.serialize(this, "strIncreaseBtnNormalTexture", String.class);
      var1.serialize(this, "strIncreaseBtnDownTexture", String.class);
      var1.serialize(this, "strTickTexture", String.class);
      var1.serialize(this, "thumbBtnInclusive", Integer.TYPE);
   }
}
