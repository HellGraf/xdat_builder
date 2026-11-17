package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLSliderCtrlData extends XMLUIData {
   @XmlAttribute
   public int iNumOfTick = -9999;
   @XmlAttribute
   public int iCurrTick = -9999;
   @XmlAttribute
   public int iThumbBtnWidth = -9999;
   @XmlAttribute
   public int iThumbBtnHeight = -9999;
   @XmlAttribute
   public String strBackTexture = "undefined";
   @XmlAttribute
   public String strDisableBackTexture = "undefined";
   @XmlAttribute
   public String strThumbBtnNormalTexture = "undefined";
   @XmlAttribute
   public String strThumbBtnDownTexture = "undefined";
   @XmlAttribute
   public int iPushBtnWidth = -9999;
   @XmlAttribute
   public int iPushBtnHeight = -9999;
   @XmlAttribute
   public int iPushBtnAutoHitTime;
   @XmlAttribute
   public String strDecreaseBtnNormalTexture = "undefined";
   @XmlAttribute
   public String strDecreaseBtnDownTexture = "undefined";
   @XmlAttribute
   public String strIncreaseBtnNormalTexture = "undefined";
   @XmlAttribute
   public String strIncreaseBtnDownTexture = "undefined";
   @XmlAttribute
   public String strTickTexture = "undefined";

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.iNumOfTick);
      var1.write(this.iCurrTick);
      var1.write(this.iThumbBtnWidth);
      var1.write(this.iThumbBtnHeight);
      var1.write(this.strBackTexture);
      var1.write(this.strDisableBackTexture);
      var1.write(this.strThumbBtnNormalTexture);
      var1.write(this.strThumbBtnDownTexture);
      var1.write(this.iPushBtnWidth);
      var1.write(this.iPushBtnHeight);
      var1.write(this.iPushBtnAutoHitTime);
      var1.write(this.strDecreaseBtnNormalTexture);
      var1.write(this.strDecreaseBtnDownTexture);
      var1.write(this.strIncreaseBtnNormalTexture);
      var1.write(this.strIncreaseBtnDownTexture);
      var1.write(this.strTickTexture);
   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.iNumOfTick = var1.readI();
      this.iCurrTick = var1.readI();
      this.iThumbBtnWidth = var1.readI();
      this.iThumbBtnHeight = var1.readI();
      this.strBackTexture = var1.readS();
      this.strDisableBackTexture = var1.readS();
      this.strThumbBtnNormalTexture = var1.readS();
      this.strThumbBtnDownTexture = var1.readS();
      this.iPushBtnWidth = var1.readI();
      this.iPushBtnHeight = var1.readI();
      this.iPushBtnAutoHitTime = var1.readI();
      this.strDecreaseBtnNormalTexture = var1.readS();
      this.strDecreaseBtnDownTexture = var1.readS();
      this.strIncreaseBtnNormalTexture = var1.readS();
      this.strIncreaseBtnDownTexture = var1.readS();
      this.strTickTexture = var1.readS();
   }
}
