package org.sart.xdat.ct24;

public enum EFontType {
   SpecialDigitSmall,
   SpecialDigitLarge,
   SpecialDigitXLarge,
   undefined;

   public static EFontType parseInt(int var0) {
      return var0 == -1 ? undefined : values()[var0];
   }

   public static int toInt(EFontType var0) {
      return var0 == undefined ? -1 : var0.ordinal();
   }
}
