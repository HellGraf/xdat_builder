package org.sart.xdat.ct0;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

public class XMLScrollAreaData extends XMLUIData {
   @XmlAttribute
   public int areaHeight = 0;
   @XmlElements({@XmlElement(
   name = "StatusBar",
   type = XMLStatusBarData.class
), @XmlElement(
   name = "ShortcutItemWindow",
   type = XMLShortcutItemWindowData.class
), @XmlElement(
   name = "Radar",
   type = XMLRadarData.class
), @XmlElement(
   name = "RadioButton",
   type = XMLRadioButtonData.class
), @XmlElement(
   name = "SliderCtrl",
   type = XMLSliderCtrlData.class
), @XmlElement(
   name = "MultiSellNeededItem",
   type = XMLMultiSellNeededItemData.class
), @XmlElement(
   name = "MultiSellItemInfo",
   type = XMLMultiSellItemInfoData.class
), @XmlElement(
   name = "MinimapCtrl",
   type = XMLMinimapCtrlData.class
), @XmlElement(
   name = "MultiEdit",
   type = XMLMultiEditData.class
), @XmlElement(
   name = "ScrollArea",
   type = XMLScrollAreaData.class
), @XmlElement(
   name = "TreeCtrl",
   type = XMLTreeCtrlData.class
), @XmlElement(
   name = "TextListBox",
   type = XMLTextListBoxData.class
), @XmlElement(
   name = "FishViewportWindow",
   type = XMLFishViewportWindowData.class
), @XmlElement(
   name = "EffectButton",
   type = XMLEffectButtonData.class
), @XmlElement(
   name = "BarCtrl",
   type = XMLBarCtrlData.class
), @XmlElement(
   name = "NameCtrl",
   type = XMLNameCtrlData.class
), @XmlElement(
   name = "Progress",
   type = XMLProgressData.class
), @XmlElement(
   name = "InvenWeight",
   type = XMLInvenWeightData.class
), @XmlElement(
   name = "ListCtrl",
   type = XMLListData.class
), @XmlElement(
   name = "ComboBox",
   type = XMLComboBoxData.class
), @XmlElement(
   name = "ChatWindow",
   type = XMLChatWindowData.class
), @XmlElement(
   name = "CheckBox",
   type = XMLCheckBoxData.class
), @XmlElement(
   name = "EditBox",
   type = XMLEditBoxData.class
), @XmlElement(
   name = "Tab",
   type = XMLTabCtrlData.class
), @XmlElement(
   name = "HtmlCtrl",
   type = XMLHtmlCtrlData.class
), @XmlElement(
   name = "Button",
   type = XMLButtonData.class
), @XmlElement(
   name = "Window",
   type = XMLWindowData.class
), @XmlElement(
   name = "Texture",
   type = XMLTextureData.class
), @XmlElement(
   name = "ItemWindow",
   type = XMLItemWindowData.class
), @XmlElement(
   name = "TextBox",
   type = XMLTextBoxData.class
), @XmlElement(
   name = "StatusIconCtrl",
   type = XMLStatusIconCtrlData.class
)})
   public List items = new LinkedList();

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.areaHeight);
      var1.write(this.items.size());
      Iterator var2 = this.items.iterator();

      while(var2.hasNext()) {
         XMLUIData var3 = (XMLUIData)var2.next();
         XMLDocument.write(var1, var3);
      }

   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.areaHeight = var1.readI();
      int var2 = var1.readI();

      for(int var3 = 0; var3 < var2; ++var3) {
         XMLUIData var4 = XMLDocument.create(var1.readS());
         var4.unserialize(var1);
         this.items.add(var4);
      }

   }
}
