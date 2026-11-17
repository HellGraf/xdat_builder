package org.sart.xdat.ct24;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Iterator;
import javax.xml.bind.JAXB;
import org.sart.xdat.DocumentManager;
import org.sart.xdat.ct0.XMLStyleData;

public class CT24DocumentManager implements DocumentManager {
   private final XMLDataManager data = new XMLDataManager();

   public void append(Path var1) {
   }

   public DirectoryStream of(Path var1) throws IOException {
      return Files.newDirectoryStream(var1);
   }

   public XMLDataManager from(Path var1) {
      System.out.println("read " + var1.toString());
      return (XMLDataManager)JAXB.unmarshal(var1.toFile(), XMLDataManager.class);
   }

   public void compile(Path var1) {
      try {
         this.of(var1.resolve("shortcut")).forEach((var1x) -> {
            this.data.pShortcutData.addAll(this.from(var1x).pShortcutData);
         });
         this.of(var1.resolve("window")).forEach((var1x) -> {
            this.data.pWindowData.addAll(this.from(var1x).pWindowData);
         });
         this.of(var1.resolve("position")).forEach((var1x) -> {
            this.data.pDefaultPositionData.addAll(this.from(var1x).pDefaultPositionData);
         });
         this.of(var1.resolve("style")).forEach((var1x) -> {
            this.data.pStyleData.addAll(this.from(var1x).pStyleData);
         });
         this.data.pFontDefinitation = this.from(var1.resolve("FontDefinition.xml")).pFontDefinitation;
         this.data.pChatChannelData = this.from(var1.resolve("ChatChannelDefinition.xml")).pChatChannelData;
         this.data.tail = this.from(var1.resolve("tail.xml")).tail;
         FArchive var2 = new FArchive(512000);
         var2.setReadMode(false);
         this.data.serialize(var2);
         var2.flush("interface.xdat");
      } catch (IOException var3) {
         var3.printStackTrace();
      }

   }

   public void decompile(Path var1) {
      FArchive var2 = FArchive.read(var1.toAbsolutePath().toString());
      var2.setReadMode(true);
      this.data.serialize(var2);
   }

   public void saveAsXML(Path var1) throws IOException {
      if (Files.notExists(var1, new LinkOption[0])) {
         Files.createDirectory(var1);
      }

      Path var2 = var1.resolve("shortcut");
      if (Files.notExists(var2, new LinkOption[0])) {
         Files.createDirectory(var2);
      }

      Iterator var3 = this.data.pShortcutData.iterator();

      while(var3.hasNext()) {
         XMLShortcutData var4 = (XMLShortcutData)var3.next();
         XMLDataManager var5 = new XMLDataManager();
         var5.pShortcutData.add(var4);
         JAXB.marshal(var5, var2.resolve(var4.name + ".xml").toFile());
      }

      Path var10 = var1.resolve("window");
      if (Files.notExists(var10, new LinkOption[0])) {
         Files.createDirectory(var10);
      }

      Iterator var11 = this.data.pWindowData.iterator();

      while(var11.hasNext()) {
         XMLWindowData var13 = (XMLWindowData)var11.next();
         XMLDataManager var6 = new XMLDataManager();
         var6.pWindowData.add(var13);
         JAXB.marshal(var6, var10.resolve(var13.property.Name + ".xml").toFile());
      }

      Path var12 = var1.resolve("position");
      if (Files.notExists(var12, new LinkOption[0])) {
         Files.createDirectory(var12);
      }

      int var14 = 0;
      Iterator var15 = this.data.pDefaultPositionData.iterator();

      while(var15.hasNext()) {
         XMLDefaultPositionData var7 = (XMLDefaultPositionData)var15.next();
         XMLDataManager var8 = new XMLDataManager();
         var8.pDefaultPositionData.add(var7);
         JAXB.marshal(var8, var12.resolve(var14++ + ".xml").toFile());
      }

      Path var16 = var1.resolve("style");
      if (Files.notExists(var16, new LinkOption[0])) {
         Files.createDirectory(var16);
      }

      Iterator var17 = this.data.pStyleData.iterator();

      while(var17.hasNext()) {
         XMLStyleData var19 = (XMLStyleData)var17.next();
         XMLDataManager var9 = new XMLDataManager();
         var9.pStyleData.add(var19);
         JAXB.marshal(var9, var12.resolve(var19.Name + ".xml").toFile());
      }

      XMLDataManager var18 = new XMLDataManager();
      var18.pFontDefinitation = this.data.pFontDefinitation;
      JAXB.marshal(var18, var1.resolve("FontDefinition.xml").toFile());
      var18 = new XMLDataManager();
      var18.pChatChannelData = this.data.pChatChannelData;
      JAXB.marshal(var18, var1.resolve("ChatChannelDefinition.xml").toFile());
      var18 = new XMLDataManager();
      var18.tail = this.data.tail;
      JAXB.marshal(var18, var1.resolve("tail.xml").toFile());
   }
}
