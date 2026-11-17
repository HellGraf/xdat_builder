package org.sart.xdat.ct24;

import javax.xml.bind.annotation.XmlAttribute;

public class XMLCharacterViewportWindowData extends XMLUIData {
   @XmlAttribute
   public int CharacterScale;
   @XmlAttribute
   public int CharacterOffsetX;
   @XmlAttribute
   public int CharacterOffsetY;
   @XmlAttribute
   public int CameraDistMax;
   @XmlAttribute
   public int CameraDistMin;
   @XmlAttribute
   public int DefaultCameraPitch;
   @XmlAttribute
   public int DefaultCameraYaw;
   @XmlAttribute
   public int ZoomRate;
   @XmlAttribute
   public int RotationRate;
   @XmlAttribute
   public String MaskTex;
   @XmlAttribute
   public int NpcID;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "CharacterScale", Integer.TYPE);
      var1.serialize(this, "CharacterOffsetX", Integer.TYPE);
      var1.serialize(this, "CharacterOffsetY", Integer.TYPE);
      var1.serialize(this, "CameraDistMax", Integer.TYPE);
      var1.serialize(this, "CameraDistMin", Integer.TYPE);
      var1.serialize(this, "DefaultCameraPitch", Integer.TYPE);
      var1.serialize(this, "DefaultCameraYaw", Integer.TYPE);
      var1.serialize(this, "ZoomRate", Integer.TYPE);
      var1.serialize(this, "RotationRate", Integer.TYPE);
      var1.serialize(this, "MaskTex", String.class);
      var1.serialize(this, "NpcID", Integer.TYPE);
   }
}
