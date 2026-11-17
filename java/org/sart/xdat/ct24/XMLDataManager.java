package org.sart.xdat.ct24;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.sart.xdat.ct0.XMLStyleData;

@XmlRootElement(
   name = "L2UI"
)
public class XMLDataManager implements FSerialize {
   @XmlElement(
      name = "Shortcut"
   )
   public List pShortcutData = new LinkedList();
   @XmlElement(
      name = "Window"
   )
   public List pWindowData = new LinkedList();
   @XmlElement(
      name = "DefaultPosition"
   )
   public List pDefaultPositionData = new LinkedList();
   @XmlElement(
      name = "FontDefinition"
   )
   public XMLFontDefinition pFontDefinitation;
   @XmlElement(
      name = "Style"
   )
   public List pStyleData = new LinkedList();
   @XmlElement(
      name = "ChatChannelDefinition"
   )
   public XMLChatChannelDefinition pChatChannelData;
   @XmlElement(
      name = "tail"
   )
   public XMLDataManager.Tail tail;
   @XmlTransient
   public boolean hasFontDefintion = false;

   public void serialize(FArchive var1) {
      var1.serialize(this, "pShortcutData", XMLShortcutData.class);
      var1.serialize(this, "pWindowData", XMLWindowData.class);
      var1.serialize(this, "pDefaultPositionData", XMLDefaultPositionData.class);
      if (var1.isReadMode) {
         var1.serialize(this, "hasFontDefintion", Boolean.TYPE);
         if (this.hasFontDefintion) {
            this.pFontDefinitation = new XMLFontDefinition();
            this.pFontDefinitation.serialize(var1);
         }
      } else if (this.pFontDefinitation != null) {
         this.hasFontDefintion = true;
         var1.serialize(this, "hasFontDefintion", Boolean.TYPE);
         this.pFontDefinitation.serialize(var1);
      } else {
         this.hasFontDefintion = false;
         var1.serialize(this, "hasFontDefintion", Boolean.TYPE);
      }

      var1.serialize(this, "pStyleData", XMLStyleData.class);
      if (var1.isReadMode) {
         this.pChatChannelData = new XMLChatChannelDefinition();
         this.pChatChannelData.serialize(var1);
      } else if (this.pChatChannelData != null) {
         this.pChatChannelData.serialize(var1);
      }

      if (var1.isReadMode) {
         this.tail = new XMLDataManager.Tail();
         this.tail.serialize(var1);
      } else {
         if (this.tail == null) {
            throw new RuntimeException("not found tail node");
         }

         this.tail.serialize(var1);
      }

   }

   public static XMLUIData CreateUIData(String var0) {
      byte var2 = -1;
      switch(var0.hashCode()) {
      case -1841123444:
         if (var0.equals("MultiSellItemInfo")) {
            var2 = 16;
         }
         break;
      case -1703884784:
         if (var0.equals("Window")) {
            var2 = 6;
         }
         break;
      case -1649037106:
         if (var0.equals("FishViewportWindow")) {
            var2 = 25;
         }
         break;
      case -1195822324:
         if (var0.equals("SliderCtrl")) {
            var2 = 33;
         }
         break;
      case -1067708388:
         if (var0.equals("MoviePlayerCtrl")) {
            var2 = 31;
         }
         break;
      case -936434099:
         if (var0.equals("Progress")) {
            var2 = 23;
         }
         break;
      case -933397322:
         if (var0.equals("StatusIconCtrl")) {
            var2 = 0;
         }
         break;
      case -705564605:
         if (var0.equals("EffectButton")) {
            var2 = 7;
         }
         break;
      case -679363095:
         if (var0.equals("ShortcutItemWindow")) {
            var2 = 26;
         }
         break;
      case -547674755:
         if (var0.equals("ComboBox")) {
            var2 = 13;
         }
         break;
      case -273034026:
         if (var0.equals("HtmlCtrl")) {
            var2 = 9;
         }
         break;
      case -223347903:
         if (var0.equals("EditBox")) {
            var2 = 12;
         }
         break;
      case -196983549:
         if (var0.equals("ItemWindow")) {
            var2 = 3;
         }
         break;
      case -66259295:
         if (var0.equals("StatusBar")) {
            var2 = 22;
         }
         break;
      case 83829:
         if (var0.equals("Tab")) {
            var2 = 10;
         }
         break;
      case 78717670:
         if (var0.equals("Radar")) {
            var2 = 20;
         }
         break;
      case 246787390:
         if (var0.equals("TextBox")) {
            var2 = 1;
         }
         break;
      case 246836475:
         if (var0.equals("Texture")) {
            var2 = 2;
         }
         break;
      case 357242706:
         if (var0.equals("InvenWeight")) {
            var2 = 21;
         }
         break;
      case 437998984:
         if (var0.equals("ChatWindow")) {
            var2 = 15;
         }
         break;
      case 776382189:
         if (var0.equals("RadioButton")) {
            var2 = 32;
         }
         break;
      case 796562115:
         if (var0.equals("MultiEdit")) {
            var2 = 30;
         }
         break;
      case 1009870400:
         if (var0.equals("TextListBox")) {
            var2 = 28;
         }
         break;
      case 1136284529:
         if (var0.equals("PropertyController")) {
            var2 = 19;
         }
         break;
      case 1330120958:
         if (var0.equals("BarCtrl")) {
            var2 = 24;
         }
         break;
      case 1401115681:
         if (var0.equals("RadarMapCtrl")) {
            var2 = 34;
         }
         break;
      case 1409797193:
         if (var0.equals("ListCtrl")) {
            var2 = 8;
         }
         break;
      case 1450315593:
         if (var0.equals("TreeCtrl")) {
            var2 = 11;
         }
         break;
      case 1601505219:
         if (var0.equals("CheckBox")) {
            var2 = 14;
         }
         break;
      case 1846591533:
         if (var0.equals("ListBox")) {
            var2 = 35;
         }
         break;
      case 1896173471:
         if (var0.equals("CharacterViewportWindow")) {
            var2 = 29;
         }
         break;
      case 1904727990:
         if (var0.equals("NameCtrl")) {
            var2 = 18;
         }
         break;
      case 1960268499:
         if (var0.equals("MultiSellNeededItem")) {
            var2 = 17;
         }
         break;
      case 2001146706:
         if (var0.equals("Button")) {
            var2 = 4;
         }
         break;
      case 2059196698:
         if (var0.equals("ScrollArea")) {
            var2 = 5;
         }
         break;
      case 2105807248:
         if (var0.equals("MinimapCtrl")) {
            var2 = 27;
         }
      }

      switch(var2) {
      case 0:
         return new XMLStatusIconCtrlData();
      case 1:
         return new XMLTextBoxData();
      case 2:
         return new XMLTextureCtrlData();
      case 3:
         return new XMLItemWindowData();
      case 4:
         return new XMLButtonData();
      case 5:
         return new XMLScrollAreaData();
      case 6:
         return new XMLWindowData();
      case 7:
         return new XMLEffectButtonData();
      case 8:
         return new XMLListData();
      case 9:
         return new XMLHtmlCtrlData();
      case 10:
         return new XMLTabCtrlData();
      case 11:
         return new XMLTreeCtrlData();
      case 12:
         return new XMLEditBoxData();
      case 13:
         return new XMLComboBoxData();
      case 14:
         return new XMLCheckBoxData();
      case 15:
         return new XMLChatWindowData();
      case 16:
         return new XMLMultiSellItemInfoData();
      case 17:
         return new XMLMultiSellNeededItemData();
      case 18:
         return new XMLNameCtrlData();
      case 19:
         return new XMLPropertyControllerData();
      case 20:
         return new XMLRadarData();
      case 21:
         return new XMLInvenWeightData();
      case 22:
         return new XMLStatusBarCtrlData();
      case 23:
         return new XMLProgressData();
      case 24:
         return new XMLBarCtrlData();
      case 25:
         return new XMLFishViewportWindowData();
      case 26:
         return new XMLShortcutItemWindowData();
      case 27:
         return new XMLMinimapCtrlData();
      case 28:
         return new XMLTextListBoxData();
      case 29:
         return new XMLCharacterViewportWindowData();
      case 30:
         return new XMLMultiEditData();
      case 31:
         return new XMLVideoPlayerCtrlData();
      case 32:
         return new XMLRadioButtonData();
      case 33:
         return new XMLSliderCtrlData();
      case 34:
         return new XMLRadarMapCtrlData();
      case 35:
         return new XMLListBoxData();
      default:
         throw new RuntimeException("unknown ui element " + var0);
      }
   }

   public static String TypeString(XMLUIData var0) {
      if (var0 instanceof XMLStatusIconCtrlData) {
         return "StatusIconCtrl";
      } else if (var0 instanceof XMLTextBoxData) {
         return "TextBox";
      } else if (var0 instanceof XMLTextureCtrlData) {
         return "Texture";
      } else if (var0 instanceof XMLItemWindowData) {
         return "ItemWindow";
      } else if (var0 instanceof XMLButtonData) {
         return "Button";
      } else if (var0 instanceof XMLScrollAreaData) {
         return "ScrollArea";
      } else if (var0 instanceof XMLWindowData) {
         return "Window";
      } else if (var0 instanceof XMLEffectButtonData) {
         return "EffectButton";
      } else if (var0 instanceof XMLListData) {
         return "ListCtrl";
      } else if (var0 instanceof XMLHtmlCtrlData) {
         return "HtmlCtrl";
      } else if (var0 instanceof XMLTabCtrlData) {
         return "Tab";
      } else if (var0 instanceof XMLTreeCtrlData) {
         return "TreeCtrl";
      } else if (var0 instanceof XMLEditBoxData) {
         return "EditBox";
      } else if (var0 instanceof XMLComboBoxData) {
         return "ComboBox";
      } else if (var0 instanceof XMLCheckBoxData) {
         return "CheckBox";
      } else if (var0 instanceof XMLChatWindowData) {
         return "ChatWindow";
      } else if (var0 instanceof XMLMultiSellItemInfoData) {
         return "MultiSellItemInfo";
      } else if (var0 instanceof XMLMultiSellNeededItemData) {
         return "MultiSellNeededItem";
      } else if (var0 instanceof XMLNameCtrlData) {
         return "NameCtrl";
      } else if (var0 instanceof XMLPropertyControllerData) {
         return "PropertyController";
      } else if (var0 instanceof XMLRadarData) {
         return "Radar";
      } else if (var0 instanceof XMLInvenWeightData) {
         return "InvenWeight";
      } else if (var0 instanceof XMLStatusBarCtrlData) {
         return "StatusBar";
      } else if (var0 instanceof XMLProgressData) {
         return "Progress";
      } else if (var0 instanceof XMLBarCtrlData) {
         return "BarCtrl";
      } else if (var0 instanceof XMLFishViewportWindowData) {
         return "FishViewportWindow";
      } else if (var0 instanceof XMLShortcutItemWindowData) {
         return "ShortcutItemWindow";
      } else if (var0 instanceof XMLMinimapCtrlData) {
         return "MinimapCtrl";
      } else if (var0 instanceof XMLTextListBoxData) {
         return "TextListBox";
      } else if (var0 instanceof XMLCharacterViewportWindowData) {
         return "CharacterViewportWindow";
      } else if (var0 instanceof XMLMultiEditData) {
         return "MultiEdit";
      } else if (var0 instanceof XMLVideoPlayerCtrlData) {
         return "MoviePlayerCtrl";
      } else if (var0 instanceof XMLRadioButtonData) {
         return "RadioButton";
      } else if (var0 instanceof XMLSliderCtrlData) {
         return "SliderCtrl";
      } else if (var0 instanceof XMLRadarMapCtrlData) {
         return "RadarMapCtrl";
      } else if (var0 instanceof XMLListBoxData) {
         return "ListBox";
      } else {
         throw new RuntimeException("unknown ui element ");
      }
   }

   public static class Tail implements FSerialize {
      @XmlAttribute
      public int a;
      @XmlAttribute
      public int b;
      @XmlAttribute
      public int c;
      @XmlAttribute
      public int d;
      @XmlAttribute
      public int e;

      public void serialize(FArchive var1) {
         var1.serialize(this, "a", Integer.TYPE);
         var1.serialize(this, "b", Integer.TYPE);
         var1.serialize(this, "c", Integer.TYPE);
         var1.serialize(this, "d", Integer.TYPE);
         var1.serialize(this, "e", Integer.TYPE);
      }
   }
}
