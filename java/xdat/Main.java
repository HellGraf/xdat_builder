package xdat;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Properties;
import javax.xml.bind.JAXB;
import org.sart.xdat.ct0.FArchive;
import org.sart.xdat.ct0.XMLDefaultPositionData;
import org.sart.xdat.ct0.XMLDocument;
import org.sart.xdat.ct0.XMLShortcutData;
import org.sart.xdat.ct0.XMLWindowData;

public class Main {
   public static void main(String... var0) {
      if (var0.length == 0) {
         error("no command");
      }

      Properties var1 = new Properties();
      if (!Files.exists(Paths.get("xdat.property"), new LinkOption[0])) {
         error("not found property file");
      }

      try {
         var1.load(new FileReader("xdat.property"));
         System.out.println(var1.getProperty("xdat.original"));
      } catch (IOException var9) {
         var9.printStackTrace();
         error("IOException...");
      }

      String var2 = var0[0];
      byte var3 = -1;
      switch(var2.hashCode()) {
      case 523856530:
         if (var2.equals("decompile")) {
            var3 = 1;
         }
         break;
      case 950491699:
         if (var2.equals("compile")) {
            var3 = 0;
         }
      }

      String var4;
      FArchive var6;
      switch(var3) {
      case 0:
         var4 = var1.getProperty("xdat.src");
         System.out.println("Try compile from " + var4);
         XMLDocument var10 = new XMLDocument();
         mesure("collecting windwos's data...", () -> {
            var10.collect(collect(var4 + "/window"));
         });
         mesure("collecting shortcut's data...", () -> {
            var10.collect(collect(var4 + "/shortcut"));
         });
         mesure("collecting defpos's data...", () -> {
            var10.collect(collect(var4 + "/defpos"));
         });
         var6 = new FArchive(512000);
         mesure("Serialize data...", () -> {
            var10.serialize(var6);
         });
         String var11 = var1.getProperty("xdat.target", "interface.xdat");
         mesure("Save in to file " + var11, () -> {
            var6.flush(var11);
         });
         System.out.println("done");
         break;
      case 1:
         var4 = var1.getProperty("xdat.src");

         try {
            Files.createDirectories(Paths.get(var4, "window"));
            Files.createDirectories(Paths.get(var4, "shortcut"));
            Files.createDirectories(Paths.get(var4, "defpos"));
         } catch (IOException var8) {
            var8.printStackTrace();
            error("problem creating directory");
         }

         String var5 = var1.getProperty("xdat.original");
         if (!Files.exists(Paths.get(var5), new LinkOption[0])) {
            error("not found original data for decompile %1$s", Paths.get(var5));
         }

         var6 = FArchive.read(var5);
         XMLDocument var7 = new XMLDocument();
         mesure("Unserialize from " + Paths.get(var5).toAbsolutePath().toString(), () -> {
            var7.unserialize(var6);
         });
         mesure("XML writing: window's data... ", () -> {
            try {
               Iterator var2 = var7.windows.iterator();

               while(var2.hasNext()) {
                  XMLWindowData var3 = (XMLWindowData)var2.next();
                  XMLDocument var4x = new XMLDocument();
                  var4x.windows.add(var3);
                  JAXB.marshal(var4x, new File(var4 + "/window/" + var3.property.name + ".xml"));
               }
            } catch (Throwable var5) {
               error(var5.toString());
            }

         });
         mesure("XML writing: shortcut's data... ", () -> {
            try {
               Iterator var2 = var7.shortcut.iterator();

               while(var2.hasNext()) {
                  XMLShortcutData var3 = (XMLShortcutData)var2.next();
                  XMLDocument var4x = new XMLDocument();
                  var4x.shortcut.add(var3);
                  JAXB.marshal(var4x, new File(var4 + "/shortcut/" + var3.name + ".xml"));
               }
            } catch (Throwable var5) {
               error(var5.toString());
            }

         });
         mesure("XML writing: defpos's data... ", () -> {
            try {
               int var2 = 0;
               Iterator var3 = var7.defpos.iterator();

               while(var3.hasNext()) {
                  XMLDefaultPositionData var4x = (XMLDefaultPositionData)var3.next();
                  XMLDocument var5 = new XMLDocument();
                  var5.defpos.add(var4x);
                  JAXB.marshal(var5, new File(var4 + "/defpos/" + var2++ + ".xml"));
               }
            } catch (Throwable var6) {
               error(var6.toString());
            }

         });
         break;
      default:
         System.err.println("unknown command name " + var0[0]);
         return;
      }

   }

   private static void mesure(String var0, Runnable var1) {
      long var2 = System.currentTimeMillis();
      var1.run();
      System.out.println(var0 + " " + (double)(System.currentTimeMillis() - var2) / 1000.0D + "s");
   }

   private static void error(String var0, Object... var1) {
      System.err.println(String.format(var0, var1));
      System.exit(-1);
   }

   public static XMLDocument collect(String var0) {
      try {
         XMLDocument var1 = new XMLDocument();
         Files.newDirectoryStream(Paths.get(var0)).forEach((var1x) -> {
            var1.collect((XMLDocument)JAXB.unmarshal(var1x.toFile(), XMLDocument.class));
         });
         return var1;
      } catch (Throwable var2) {
         throw new RuntimeException(var2);
      }
   }
}
