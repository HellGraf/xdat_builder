package org.sart.xdat.ct24;

public enum EEffectButtonType {
   Tutorial,
   Quest,
   Mail,
   undefined;

   public static EEffectButtonType parseInt(int var0) {
      return var0 == -1 ? undefined : values()[var0];
   }

   public static int toInt(EEffectButtonType var0) {
      return var0 == undefined ? -1 : var0.ordinal();
   }
}
