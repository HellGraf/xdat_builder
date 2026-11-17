package org.sart.xdat;

public enum EProjectType {
   CT0(new String[]{"interlude", "int", "ct0"}),
   CT24(new String[]{"epilogue", "ct24"});

   private final String[] names;

   private EProjectType(String... var3) {
      this.names = var3;
   }

   public static EProjectType parse(String var0) {
      EProjectType[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         EProjectType var4 = var1[var3];
         String[] var5 = var4.names;
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            String var8 = var5[var7];
            if (var8.equals(var0)) {
               return var4;
            }
         }
      }

      return null;
   }
}
