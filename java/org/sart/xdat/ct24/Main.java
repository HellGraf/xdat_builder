package org.sart.xdat.ct24;

import java.util.LinkedList;
import java.util.List;

public class Main {
   public List list = new LinkedList();

   public static void main(String... var0) {
      FArchive var1 = FArchive.read("epilogue/Interface.xdat");
      var1.setReadMode(true);
      XMLDataManager var2 = new XMLDataManager();
      var2.serialize(var1);
   }
}
