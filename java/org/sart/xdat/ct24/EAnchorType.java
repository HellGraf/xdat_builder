package org.sart.xdat.ct24;

public enum EAnchorType {
   None,
   TopLeft,
   TopCenter,
   TopRight,
   CenterLeft,
   CenterCenter,
   CenterRight,
   BottomLeft,
   BottomCenter,
   BottomRight;

   public static EAnchorType parseInt(int var0) {
      return values()[var0];
   }

   public static int toInt(EAnchorType var0) {
      return var0.ordinal();
   }
}
