package org.sart.xdat.ct24;

public enum EEditBoxType {
   Default,
   Chat,
   Password,
   Number,
   Unk0,
   Date,
   Time,
   ID;

   public static EEditBoxType parseInt(int var0) {
      return values()[var0];
   }

   public static int toInt(EEditBoxType var0) {
      return var0.ordinal();
   }
}
