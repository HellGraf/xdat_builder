package org.sart.xdat.ct24;

public enum EDirection {
   None,
   Left,
   Right,
   Top,
   Bottom,
   undefined;

   public static EDirection parseInt(int var0) {
      if (var0 > 5) {
         return None;
      } else {
         return var0 == -1 ? undefined : values()[var0];
      }
   }

   public static int toInt(EDirection var0) {
      return var0 == undefined ? -1 : var0.ordinal();
   }
}
