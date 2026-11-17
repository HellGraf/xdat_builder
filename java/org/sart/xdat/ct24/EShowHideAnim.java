package org.sart.xdat.ct24;

public enum EShowHideAnim {
   None,
   Unk1,
   Unk2,
   AlphaTransition,
   PositionTransition;

   public static EShowHideAnim parseInt(int var0) {
      return values()[var0];
   }

   public static int toInt(EShowHideAnim var0) {
      return var0.ordinal();
   }
}
