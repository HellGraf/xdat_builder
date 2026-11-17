package org.sart.xdat.ct24;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

public class XMLWindowData extends XMLUIData {
   @XmlAttribute
   public String parent;
   @XmlAttribute
   public String backTex;
   @XmlAttribute
   public String script;
   @XmlAttribute
   public String state;
   @XmlAttribute
   public int frame;
   @XmlAttribute
   public int iconable;
   @XmlAttribute
   public int stuckable;
   @XmlAttribute
   public int hidden;
   @XmlAttribute
   public int alwaysFillAlpha;
   @XmlAttribute
   public int savePosition;
   @XmlAttribute
   public int saveSize;
   @XmlAttribute
   public int title;
   @XmlAttribute
   public int resizeFrame;
   @XmlAttribute
   public int draggable;
   @XmlAttribute
   public int hookKeyInput;
   @XmlAttribute
   public String WorkingConfiguration;
   @XmlAttribute
   public int useParentClipRect;
   @XmlElement(
      name = "AdditionalState"
   )
   public List additionalState = new LinkedList();
   @XmlElement(
      name = "Frame"
   )
   public XMLWindowData.Frame _frame = new XMLWindowData.Frame();
   @XmlElement(
      name = "ResizeFrame"
   )
   public XMLWindowData.ResizeFrame _resizeFrame = new XMLWindowData.ResizeFrame();
   @XmlElement(
      name = "ShowHideAnim"
   )
   public XMLWindowData.ShowHideAnim showHideAnim = new XMLWindowData.ShowHideAnim();
   @XmlElement(
      name = "Drawer"
   )
   public XMLWindowData.Drawer drawer = new XMLWindowData.Drawer();
   @XmlElement(
      name = "Iconable"
   )
   public XMLWindowData.Iconable _iconable = new XMLWindowData.Iconable();
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
      var1.serialize(this, "parent", String.class);
      var1.serialize(this, "backTex", String.class);
      var1.serialize(this, "script", String.class);
      var1.serialize(this, "state", String.class);
      var1.serialize(this, "frame", Integer.TYPE);
      var1.serialize(this, "iconable", Integer.TYPE);
      var1.serialize(this, "stuckable", Integer.TYPE);
      var1.serialize(this, "hidden", Integer.TYPE);
      var1.serialize(this, "alwaysFillAlpha", Integer.TYPE);
      var1.serialize(this, "savePosition", Integer.TYPE);
      var1.serialize(this, "saveSize", Integer.TYPE);
      var1.serialize(this, "title", Integer.TYPE);
      var1.serialize(this, "resizeFrame", Integer.TYPE);
      var1.serialize(this._frame, "size", EFrameType.class);
      var1.serialize(this._frame, "direction", EDirection.class);
      var1.serialize(this._frame, "exitbutton", Integer.TYPE);
      var1.serialize(this, "draggable", Integer.TYPE);
      var1.serialize(this._resizeFrame, "direction", EDirection.class);
      var1.serialize(this._resizeFrame, "x", Float.TYPE);
      var1.serialize(this._resizeFrame, "y", Float.TYPE);
      var1.serialize(this._resizeFrame, "width", Float.TYPE);
      var1.serialize(this._resizeFrame, "height", Float.TYPE);
      var1.serialize(this._resizeFrame, "maxIncrease", Integer.TYPE);
      var1.serialize(this.drawer, "direction", EDirection.class);
      var1.serialize(this.drawer, "offsetX", Integer.TYPE);
      var1.serialize(this.drawer, "offsetY", Integer.TYPE);
      var1.serialize(this.drawer, "directionFixed", Integer.TYPE);
      var1.serialize(this.drawer, "ownerWindow", String.class);
      var1.serialize(this.showHideAnim.show, "type", EShowHideAnim.class);
      var1.serialize(this.showHideAnim.hide, "type", EShowHideAnim.class);
      var1.serialize(this.showHideAnim.show, "direction", EDirection.class);
      var1.serialize(this.showHideAnim.show, "seconds", Float.TYPE);
      var1.serialize(this.showHideAnim.hide, "direction", EDirection.class);
      var1.serialize(this.showHideAnim.hide, "seconds", Float.TYPE);
      var1.serialize(this._iconable, "IconName", String.class);
      var1.serialize(this._iconable, "TooltipIdx", Integer.TYPE);
      var1.serialize(this, "hookKeyInput", Integer.TYPE);
      var1.serialize(this, "WorkingConfiguration", String.class);
      var1.serialize(this._frame, "LeftTextureName", String.class);
      var1.serialize(this._frame, "MidTextureName", String.class);
      var1.serialize(this._frame, "RightTextureName", String.class);
      var1.serialize(this._frame, "MinimizeBtnTextureNormal", String.class);
      var1.serialize(this._frame, "MinimizeBtnTexturePushed", String.class);
      var1.serialize(this._frame, "CloseBtnTextureNormal", String.class);
      var1.serialize(this._frame, "CloseBtnTexturePushed", String.class);
      var1.serialize(this._frame, "LeftBackTextureWidth", Integer.TYPE);
      var1.serialize(this._frame, "MidBackTextureWidth", Integer.TYPE);
      int var2;
      int var3;
      Iterator var5;
      if (var1.isReadMode) {
         var2 = var1.readC();

         for(var3 = 0; var3 < var2; ++var3) {
            XMLWindowData.AdditionalState var4 = new XMLWindowData.AdditionalState();
            var4.serialize(var1);
            this.additionalState.add(var4);
         }
      } else {
         var1.compact(this.additionalState.size());
         var5 = this.additionalState.iterator();

         while(var5.hasNext()) {
            XMLWindowData.AdditionalState var6 = (XMLWindowData.AdditionalState)var5.next();
            var6.serialize(var1);
         }
      }

      var1.serialize(this, "useParentClipRect", Integer.TYPE);
      if (var1.isReadMode) {
         var2 = var1.readI();

         for(var3 = 0; var3 < var2; ++var3) {
            XMLUIData var7 = XMLDataManager.CreateUIData(var1.readS());
            var7.serialize(var1);
            this.mChildList.add(var7);
         }
      } else {
         var1.write(this.mChildList.size());
         var5 = this.mChildList.iterator();

         while(var5.hasNext()) {
            XMLUIData var8 = (XMLUIData)var5.next();
            var1.write(XMLDataManager.TypeString(var8));
            var8.serialize(var1);
         }
      }

   }

   public static class ResizeFrame {
      @XmlAttribute
      public float x;
      @XmlAttribute
      public float y;
      @XmlAttribute
      public float width;
      @XmlAttribute
      public float height;
      @XmlAttribute
      public EDirection direction;
      @XmlAttribute
      public int maxIncrease;
   }

   public static class Iconable {
      @XmlAttribute
      public String IconName = "";
      @XmlAttribute
      public int TooltipIdx;
   }

   public static class Frame {
      @XmlAttribute
      public EFrameType size;
      @XmlAttribute
      public EDirection direction;
      @XmlAttribute
      public int exitbutton;
      @XmlAttribute
      public String LeftTextureName;
      @XmlAttribute
      public String MidTextureName;
      @XmlAttribute
      public String RightTextureName;
      @XmlAttribute
      public String MinimizeBtnTextureNormal;
      @XmlAttribute
      public String MinimizeBtnTexturePushed;
      @XmlAttribute
      public String CloseBtnTextureNormal;
      @XmlAttribute
      public String CloseBtnTexturePushed;
      @XmlAttribute
      public int LeftBackTextureWidth;
      @XmlAttribute
      public int MidBackTextureWidth;
   }

   public static class Anim {
      @XmlAttribute
      public EShowHideAnim type;
      @XmlAttribute
      public float seconds;
      @XmlAttribute
      public EDirection direction;
   }

   public static class ShowHideAnim {
      @XmlElement(
         name = "ShowAnim"
      )
      public XMLWindowData.Anim show = new XMLWindowData.Anim();
      @XmlElement(
         name = "HideAnim"
      )
      public XMLWindowData.Anim hide = new XMLWindowData.Anim();
   }

   public static class Drawer {
      @XmlAttribute
      public String ownerWindow = "";
      @XmlAttribute
      public EDirection direction;
      @XmlAttribute
      public int offsetX;
      @XmlAttribute
      public int offsetY;
      @XmlAttribute
      public int directionFixed;
   }

   public static class AdditionalState implements FSerialize {
      @XmlAttribute
      public String stateName;

      public void serialize(FArchive var1) {
         var1.serialize(this, "stateName", String.class);
      }
   }
}
