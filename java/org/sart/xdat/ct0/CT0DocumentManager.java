package org.sart.xdat.ct0;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import javax.xml.bind.JAXB;
import org.sart.xdat.DocumentManager;

public class CT0DocumentManager implements DocumentManager {
   public XMLDocument data = new XMLDocument();

   public void append(Path var1) {
   }

   public DirectoryStream of(Path var1) throws IOException {
      return Files.newDirectoryStream(var1);
   }

   public XMLDocument from(Path var1) {
      System.out.println("read " + var1.toString());
      return (XMLDocument)JAXB.unmarshal(var1.toFile(), XMLDocument.class);
   }

   public void compile(Path var1) {
      System.out.println("compile");

      try {
         this.of(var1.resolve("shortcut")).forEach((var1x) -> {
            this.data.shortcut.addAll(this.from(var1x).shortcut);
         });
         this.of(var1.resolve("window")).forEach((var1x) -> {
            this.data.windows.addAll(this.from(var1x).windows);
         });
         this.of(var1.resolve("position")).forEach((var1x) -> {
            this.data.defpos.addAll(this.from(var1x).defpos);
         });
         FArchive var2 = new FArchive(512000);
         this.data.serialize(var2);
         var2.flush("interface.xdat");
      } catch (IOException var3) {
         var3.printStackTrace();
      }

   }

   public void decompile(Path var1) {
      System.out.println("decompile");
      FArchive var2 = FArchive.read(var1.toAbsolutePath().toString());
      this.data.unserialize(var2);
   }

   public void saveAsXML(Path var1) throws IOException {
      if (Files.notExists(var1, new LinkOption[0])) {
         Files.createDirectory(var1);
      }

      Path var2 = var1.resolve("shortcut");
      if (Files.notExists(var2, new LinkOption[0])) {
         Files.createDirectory(var2);
      }

      Iterator var3 = this.data.shortcut.iterator();

      while(var3.hasNext()) {
         XMLShortcutData var4 = (XMLShortcutData)var3.next();
         XMLDocument var5 = new XMLDocument();
         var5.shortcut.add(var4);
         JAXB.marshal(var5, var2.resolve(var4.name + ".xml").toFile());
      }

      Path var9 = var1.resolve("window");
      if (Files.notExists(var9, new LinkOption[0])) {
         Files.createDirectory(var9);
      }

      Iterator var10 = this.data.windows.iterator();

      while(var10.hasNext()) {
         XMLWindowData var12 = (XMLWindowData)var10.next();
         XMLDocument var6 = new XMLDocument();
         var6.windows.add(var12);
         JAXB.marshal(var6, var9.resolve(var12.property.name + ".xml").toFile());
      }

      Path var11 = var1.resolve("position");
      if (Files.notExists(var11, new LinkOption[0])) {
         Files.createDirectory(var11);
      }

      int var13 = 0;
      Iterator var14 = this.data.defpos.iterator();

      while(var14.hasNext()) {
         XMLDefaultPositionData var7 = (XMLDefaultPositionData)var14.next();
         XMLDocument var8 = new XMLDocument();
         var8.defpos.add(var7);
         JAXB.marshal(var8, var11.resolve(var13++ + ".xml").toFile());
      }

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
