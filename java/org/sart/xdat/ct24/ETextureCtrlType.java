package org.sart.xdat.ct24;

public enum ETextureCtrlType {
   Stretch,
   Normal,
   Tile,
   Draggable,
   Control,
   Mask;

   public static ETextureCtrlType parseInt(int var0) {
      return values()[var0];
   }

   public static int toInt(ETextureCtrlType var0) {
      return var0.ordinal();
   }
}
