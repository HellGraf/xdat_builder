package org.sart.xdat.ct24;

public enum EFrameType {
   None,
   Small,
   Big,
   undefined;

   public static EFrameType parseInt(int var0) {
      return var0 == -1 ? undefined : values()[var0];
   }

   public static int toInt(EFrameType var0) {
      return var0 == undefined ? -1 : var0.ordinal();
   }
}
