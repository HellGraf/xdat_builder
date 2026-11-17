package org.sart.xdat.ct24;

public enum ETextAlign {
   None,
   Left,
   Center,
   Right,
   MacroIcon,
   undefined;

   public static ETextAlign parseInt(int var0) {
      return var0 == -1 ? undefined : values()[var0];
   }

   public static int toInt(ETextAlign var0) {
      return var0 == undefined ? -1 : var0.ordinal();
   }
}
