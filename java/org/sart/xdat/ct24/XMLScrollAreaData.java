package org.sart.xdat.ct24;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

public class XMLScrollAreaData extends XMLUIData {
   @XmlAttribute
   public int AreaHeight;
   @XmlElements({@XmlElement(
   name = "StatusIconCtrl",
   type = XMLStatusIconCtrlData.class
), @XmlElement(
   name = "TextBox",
   type = XMLTextBoxData.class
), @XmlElement(
   name = "Texture",
   type = XMLTextureCtrlData.class
), @XmlElement(
   name = "ItemWindow",
   type = XMLItemWindowData.class
), @XmlElement(
   name = "Button",
   type = XMLButtonData.class
), @XmlElement(
   name = "ScrollArea",
   type = XMLScrollAreaData.class
), @XmlElement(
   name = "Window",
   type = XMLWindowData.class
), @XmlElement(
   name = "EffectButton",
   type = XMLEffectButtonData.class
), @XmlElement(
   name = "ListCtrl",
   type = XMLListData.class
), @XmlElement(
   name = "HtmlCtrl",
   type = XMLHtmlCtrlData.class
), @XmlElement(
   name = "Tab",
   type = XMLTabCtrlData.class
), @XmlElement(
   name = "TreeCtrl",
   type = XMLTreeCtrlData.class
), @XmlElement(
   name = "EditBox",
   type = XMLEditBoxData.class
), @XmlElement(
   name = "ComboBox",
   type = XMLComboBoxData.class
), @XmlElement(
   name = "CheckBox",
   type = XMLCheckBoxData.class
), @XmlElement(
   name = "ChatWindow",
   type = XMLChatWindowData.class
), @XmlElement(
   name = "MultiSellItemInfo",
   type = XMLMultiSellItemInfoData.class
), @XmlElement(
   name = "MultiSellNeededItem",
   type = XMLMultiSellNeededItemData.class
), @XmlElement(
   name = "NameCtrl",
   type = XMLNameCtrlData.class
), @XmlElement(
   name = "PropertyController",
   type = XMLPropertyControllerData.class
), @XmlElement(
   name = "Radar",
   type = XMLRadarData.class
), @XmlElement(
   name = "InvenWeight",
   type = XMLInvenWeightData.class
), @XmlElement(
   name = "StatusBar",
   type = XMLStatusBarCtrlData.class
), @XmlElement(
   name = "Progress",
   type = XMLProgressData.class
), @XmlElement(
   name = "BarCtrl",
   type = XMLBarCtrlData.class
), @XmlElement(
   name = "FishViewportWindow",
   type = XMLFishViewportWindowData.class
), @XmlElement(
   name = "ShortcutItemWindow",
   type = XMLShortcutItemWindowData.class
), @XmlElement(
   name = "MinimapCtrl",
   type = XMLMinimapCtrlData.class
), @XmlElement(
   name = "TextListBox",
   type = XMLTextListBoxData.class
), @XmlElement(
   name = "CharacterViewportWindow",
   type = XMLCharacterViewportWindowData.class
), @XmlElement(
   name = "MultiEdit",
   type = XMLMultiEditData.class
), @XmlElement(
   name = "MoviePlayerCtrl",
   type = XMLVideoPlayerCtrlData.class
), @XmlElement(
   name = "RadioButton",
   type = XMLRadioButtonData.class
), @XmlElement(
   name = "SliderCtrl",
   type = XMLSliderCtrlData.class
), @XmlElement(
   name = "RadarMapCtrl",
   type = XMLRadarMapCtrlData.class
), @XmlElement(
   name = "ListBox",
   type = XMLListBoxData.class
)})
   public List mChildList = new LinkedList();

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "AreaHeight", Integer.TYPE);
      if (var1.isReadMode) {
         int var2 = var1.readI();

         for(int var3 = 0; var3 < var2; ++var3) {
            XMLUIData var4 = XMLDataManager.CreateUIData(var1.readS());
            var4.serialize(var1);
            this.mChildList.add(var4);
         }
      } else {
         var1.write(this.mChildList.size());
         Iterator var5 = this.mChildList.iterator();

         while(var5.hasNext()) {
            XMLUIData var6 = (XMLUIData)var5.next();
            var1.write(XMLDataManager.TypeString(var6));
            var6.serialize(var1);
         }
      }

   }
}
