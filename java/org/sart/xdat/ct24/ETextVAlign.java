package org.sart.xdat.ct24;

public enum ETextVAlign {
   None,
   Top,
   Middle,
   Bottom;

   public static ETextVAlign parseInt(int var0) {
      return values()[var0];
   }

   public static int toInt(ETextVAlign var0) {
      return var0.ordinal();
   }
}
