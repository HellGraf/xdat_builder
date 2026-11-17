package org.sart.xdat.ct0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(
   name = "L2UI"
)
public class XMLDocument implements FSerializable {
   @XmlElement(
      name = "Window"
   )
   public List windows = new LinkedList();
   @XmlElement(
      name = "Shortcut"
   )
   public List shortcut = new LinkedList();
   @XmlElement(
      name = "DefaultPosition"
   )
   public List defpos = new LinkedList();
   @XmlTransient
   public HashMap info = new HashMap();
   public static final HashMap instance = new HashMap();

   public void serialize(FArchive var1) {
      var1.write(this.windows.size());
      Iterator var2 = this.windows.iterator();

      while(var2.hasNext()) {
         XMLWindowData var3 = (XMLWindowData)var2.next();
         var3.serialize(var1);
      }

      var1.write(this.shortcut.size());
      var2 = this.shortcut.iterator();

      while(var2.hasNext()) {
         XMLShortcutData var4 = (XMLShortcutData)var2.next();
         var4.serialize(var1);
      }

      var1.write(this.defpos.size());
      var2 = this.defpos.iterator();

      while(var2.hasNext()) {
         XMLDefaultPositionData var5 = (XMLDefaultPositionData)var2.next();
         var5.serialize(var1);
      }

      var1.write(0);
      var1.write(8);
      var1.write(90);
      var1.write(749860742);
      var1.write(0);
   }

   public void unserialize(FArchive var1) {
      int var2 = var1.readI();

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         XMLWindowData var4 = new XMLWindowData();
         int var5 = var1.pos();
         var4.unserialize(var1);
         this.windows.add(var4);
         this.info.put(var4.property.name, var1.pos() - var5);
      }

      var2 = var1.readI();

      for(var3 = 0; var3 < var2; ++var3) {
         XMLShortcutData var6 = new XMLShortcutData();
         var6.unserialize(var1);
         this.shortcut.add(var6);
      }

      var2 = var1.readI();

      for(var3 = 0; var3 < var2; ++var3) {
         XMLDefaultPositionData var7 = new XMLDefaultPositionData();
         var7.unserialize(var1);
         this.defpos.add(var7);
      }

   }

   public static void write(FArchive var0, XMLUIData var1) {
      Iterator var2 = instance.keySet().iterator();

      String var3;
      Class var4;
      do {
         if (!var2.hasNext()) {
            throw new RuntimeException("not found constructor for uidata " + var1);
         }

         var3 = (String)var2.next();
         var4 = (Class)instance.get(var3);
      } while(var4 != var1.getClass());

      var0.write(var3);
      var1.serialize(var0);
   }

   public static XMLUIData create(String var0) {
      try {
         return (XMLUIData)((Class)instance.get(var0)).newInstance();
      } catch (IllegalAccessException | InstantiationException var2) {
         throw new RuntimeException(var2);
      }
   }

   public void collect(XMLDocument var1) {
      this.windows.addAll(var1.windows);
      this.shortcut.addAll(var1.shortcut);
      this.defpos.addAll(var1.defpos);
   }

   static {
      instance.put("ItemWindow", XMLItemWindowData.class);
      instance.put("MultiSellNeededItem", XMLMultiSellNeededItemData.class);
      instance.put("TextBox", XMLTextBoxData.class);
      instance.put("Texture", XMLTextureData.class);
      instance.put("ListCtrl", XMLListData.class);
      instance.put("MultiSellItemInfo", XMLMultiSellItemInfoData.class);
      instance.put("ChatWindow", XMLChatWindowData.class);
      instance.put("MinimapCtrl", XMLMinimapCtrlData.class);
      instance.put("Button", XMLButtonData.class);
      instance.put("Radar", XMLRadarData.class);
      instance.put("InvenWeight", XMLInvenWeightData.class);
      instance.put("Window", XMLWindowData.class);
      instance.put("Progress", XMLProgressData.class);
      instance.put("ComboBox", XMLComboBoxData.class);
      instance.put("ScrollArea", XMLScrollAreaData.class);
      instance.put("ShortcutItemWindow", XMLShortcutItemWindowData.class);
      instance.put("StatusIconCtrl", XMLStatusIconCtrlData.class);
      instance.put("RadioButton", XMLRadioButtonData.class);
      instance.put("StatusBar", XMLStatusBarData.class);
      instance.put("EditBox", XMLEditBoxData.class);
      instance.put("HtmlCtrl", XMLHtmlCtrlData.class);
      instance.put("NameCtrl", XMLNameCtrlData.class);
      instance.put("TextListBox", XMLTextListBoxData.class);
      instance.put("EffectButton", XMLEffectButtonData.class);
      instance.put("Tab", XMLTabCtrlData.class);
      instance.put("SliderCtrl", XMLSliderCtrlData.class);
      instance.put("CheckBox", XMLCheckBoxData.class);
      instance.put("BarCtrl", XMLBarCtrlData.class);
      instance.put("MultiEdit", XMLMultiEditData.class);
      instance.put("FishViewportWindow", XMLFishViewportWindowData.class);
      instance.put("TreeCtrl", XMLTreeCtrlData.class);
   }
}
