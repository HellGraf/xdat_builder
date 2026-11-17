package org.sart.xdat.ct24;

public enum ETextureLayer {
   None,
   Normal,
   Background;

   public static ETextureLayer parseInt(int var0) {
      return values()[var0];
   }

   public static int toInt(ETextureLayer var0) {
      return var0.ordinal();
   }
}
