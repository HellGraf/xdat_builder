package org.sart.xdat.ct0;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

public class XMLWindowData extends XMLUIData {
   @XmlAttribute
   public String parent = "undefined";
   @XmlAttribute
   public String backTex = "undefined";
   @XmlAttribute
   public String script = "undefined";
   @XmlAttribute
   public String state = "undefined";
   @XmlAttribute
   public int frame;
   @XmlAttribute
   public int resizeframe = -1;
   @XmlAttribute
   public int iconable;
   @XmlAttribute
   public int hidden;
   @XmlAttribute
   public int alwaysFullAlpha;
   @XmlAttribute
   public int stuckable;
   @XmlAttribute
   public int title = -9999;
   @XmlAttribute
   public int savePosition = -1;
   @XmlAttribute
   public int saveSize = -1;
   @XmlAttribute
   public int draggable = -1;
   @XmlAttribute
   public int hookKeyInput = -1;
   @XmlAttribute(
      name = "WorkingConfiguration"
   )
   public String WorkingConfiguration = "";
   @XmlElement(
      name = "Drawer"
   )
   public XMLWindowData.Drawer drawer = new XMLWindowData.Drawer();
   @XmlElement(
      name = "ShowHideAnim"
   )
   public XMLWindowData.ShowHideAnim showHideAnim = new XMLWindowData.ShowHideAnim();
   @XmlElement(
      name = "Frame"
   )
   public XMLWindowData.Frame frameType = new XMLWindowData.Frame();
   @XmlElement(
      name = "Iconable"
   )
   public XMLWindowData.Iconable icon = new XMLWindowData.Iconable();
   @XmlElement(
      name = "ResizeFrame"
   )
   public XMLWindowData.ResizeFrame rframe = new XMLWindowData.ResizeFrame();
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
   public List childs = new LinkedList();

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.parent);
      var1.write(this.backTex);
      var1.write(this.script);
      var1.write(this.state);
      var1.write(this.frame);
      var1.write(this.iconable);
      var1.write(this.stuckable);
      var1.write(this.hidden);
      var1.write(this.alwaysFullAlpha);
      var1.write(this.savePosition);
      var1.write(this.saveSize);
      var1.write(this.title);
      var1.write(this.resizeframe);
      var1.write(this.frameType.size.serialize());
      var1.write(this.frameType.direction.serialize());
      var1.write(this.frameType.exitbutton);
      var1.write(this.draggable);
      var1.write(this.rframe.direction.serialize());
      var1.write(this.rframe.x);
      var1.write(this.rframe.y);
      var1.write(this.rframe.width);
      var1.write(this.rframe.height);
      var1.write(this.rframe.maxIncrease);
      var1.write(this.frameType.expandbutton);
      var1.write(this.frameType.expandOrgHeight);
      var1.write(this.frameType.expandExpHeight);
      var1.write(this.drawer.direction.serialize());
      var1.write(this.drawer.offset);
      var1.write(this.drawer.directionFixed);
      var1.write(this.drawer.ownerWindow);
      var1.write(this.showHideAnim.ShowAnim.type.serialize());
      var1.write(this.showHideAnim.HideAnim.type.serialize());
      var1.write(this.showHideAnim.ShowAnim.direction.serialize());
      var1.write(this.showHideAnim.ShowAnim.seconds);
      var1.write(this.showHideAnim.HideAnim.direction.serialize());
      var1.write(this.showHideAnim.HideAnim.seconds);
      var1.write(this.icon.IconName);
      var1.write(this.icon.TooltipIdx);
      var1.write(this.hookKeyInput);
      var1.write(this.WorkingConfiguration);
      var1.write(this.childs.size());
      Iterator var2 = this.childs.iterator();

      while(var2.hasNext()) {
         XMLUIData var3 = (XMLUIData)var2.next();
         XMLDocument.write(var1, var3);
      }

   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.parent = var1.readS();
      this.backTex = var1.readS();
      this.script = var1.readS();
      this.state = var1.readS();
      this.frame = var1.readB();
      this.iconable = var1.readB();
      this.stuckable = var1.readB();
      this.hidden = var1.readB();
      this.alwaysFullAlpha = var1.readB();
      this.savePosition = var1.readB();
      this.saveSize = var1.readB();
      this.title = var1.readI();
      this.resizeframe = var1.readB();
      this.frameType.size = XMLWindowData.Size.unserialize(var1.readI());
      this.frameType.direction = XMLWindowData.Direction.unserialize(var1.readI());
      this.frameType.exitbutton = var1.readB();
      this.draggable = var1.readB();
      this.rframe.direction = XMLWindowData.Direction.unserialize(var1.readI());
      this.rframe.x = var1.readI();
      this.rframe.y = var1.readI();
      this.rframe.width = var1.readF();
      this.rframe.height = var1.readF();
      this.rframe.maxIncrease = var1.readI();
      this.frameType.expandbutton = var1.readB();
      this.frameType.expandOrgHeight = var1.readI();
      this.frameType.expandExpHeight = var1.readI();
      this.drawer.direction = XMLWindowData.Direction.unserialize(var1.readI());
      if (this.drawer.direction != XMLWindowData.Direction.None) {
         this.drawer.offset = var1.readI();
         this.drawer.directionFixed = var1.readB();
      } else {
         this.drawer.offset = var1.readI();
         this.drawer.directionFixed = var1.readI();
      }

      this.drawer.ownerWindow = var1.readS();
      this.showHideAnim.ShowAnim.type = XMLWindowData.AnimType.unserialize(var1.readI());
      this.showHideAnim.HideAnim.type = XMLWindowData.AnimType.unserialize(var1.readI());
      if (this.showHideAnim.ShowAnim.type != XMLWindowData.AnimType.None) {
         this.showHideAnim.ShowAnim.direction = XMLWindowData.Direction.unserialize(var1.readI());
         this.showHideAnim.ShowAnim.seconds = var1.readF();
      } else {
         var1.readI();
         this.showHideAnim.ShowAnim.direction = XMLWindowData.Direction.None;
         this.showHideAnim.ShowAnim.seconds = (float)var1.readI();
      }

      if (this.showHideAnim.HideAnim.type != XMLWindowData.AnimType.None) {
         this.showHideAnim.HideAnim.direction = XMLWindowData.Direction.unserialize(var1.readI());
         this.showHideAnim.HideAnim.seconds = var1.readF();
      } else {
         var1.readI();
         var1.readI();
         this.showHideAnim.HideAnim.direction = XMLWindowData.Direction.None;
         this.showHideAnim.HideAnim.seconds = -9999.0F;
      }

      this.icon.IconName = var1.readS();
      this.icon.TooltipIdx = var1.readI();
      this.hookKeyInput = var1.readB();
      this.WorkingConfiguration = var1.readS();
      int var2 = var1.readI();

      for(int var3 = 0; var3 < var2; ++var3) {
         String var4 = var1.readS();

         try {
            XMLUIData var5 = XMLDocument.create(var4);
            var5.unserialize(var1);
            this.childs.add(var5);
         } catch (Throwable var6) {
            var6.printStackTrace();
            System.exit(0);
         }
      }

   }

   public static enum State {
      None,
      DebugState,
      LoginState,
      CharacterSelectState,
      GamingState,
      EulaMsgState,
      ChinaWarnMsgState,
      ServerListState,
      WarnMsgState,
      LoadingState,
      CharacterCreateState,
      CreditState,
      ReplaySelectState,
      ReplayStat,
      BenchMarkMenuState,
      BenchMarkPlayState,
      BenchMarkResultState,
      ThaiHtmlWordWrapState,
      OlympiadObserverState,
      BroadcastObserverState;
   }

   public static enum Direction {
      Undefined,
      None,
      Left,
      Right,
      Top,
      Bottom;

      public static XMLWindowData.Direction unserialize(int var0) {
         return values()[var0 + 1];
      }

      public int serialize() {
         return this.ordinal() - 1;
      }
   }

   public static enum AnimType {
      Undefined,
      None,
      Unk1,
      UNk2,
      AlphaTransition,
      PositionTransition;

      public static XMLWindowData.AnimType unserialize(int var0) {
         return values()[var0 + 1];
      }

      public int serialize() {
         return this.ordinal() - 1;
      }
   }

   public static class Anim {
      @XmlAttribute
      public XMLWindowData.AnimType type;
      @XmlAttribute
      public float seconds;
      @XmlAttribute
      public XMLWindowData.Direction direction;

      public Anim() {
         this.type = XMLWindowData.AnimType.None;
      }
   }

   public static class ShowHideAnim {
      @XmlElement(
         name = "ShowAnim"
      )
      public XMLWindowData.Anim ShowAnim = new XMLWindowData.Anim();
      @XmlElement(
         name = "HideAnim"
      )
      public XMLWindowData.Anim HideAnim = new XMLWindowData.Anim();
   }

   public static class Drawer {
      @XmlAttribute
      public String ownerWindow;
      @XmlAttribute
      public XMLWindowData.Direction direction;
      @XmlAttribute
      public int offset;
      @XmlAttribute
      public int directionFixed;

      public Drawer() {
         this.direction = XMLWindowData.Direction.None;
      }
   }

   public static enum Size {
      Undefined,
      None,
      Big,
      Small;

      public static XMLWindowData.Size unserialize(int var0) {
         return values()[var0 + 1];
      }

      public int serialize() {
         return this.ordinal() - 1;
      }
   }

   public static class Frame {
      @XmlAttribute
      public XMLWindowData.Size size;
      @XmlAttribute
      public XMLWindowData.Direction direction;
      @XmlAttribute
      public int exitbutton;
      @XmlAttribute
      public int expandbutton;
      @XmlAttribute
      public int expandOrgHeight;
      @XmlAttribute
      public int expandExpHeight;

      public Frame() {
         this.size = XMLWindowData.Size.Undefined;
         this.direction = XMLWindowData.Direction.None;
         this.exitbutton = -1;
         this.expandbutton = -1;
         this.expandOrgHeight = -9999;
         this.expandExpHeight = -9999;
      }
   }

   public static class Iconable {
      @XmlAttribute
      public String IconName = "undefined";
      @XmlAttribute
      public int TooltipIdx = -9999;
   }

   public static class ResizeFrame {
      @XmlAttribute
      public int x = -9999;
      @XmlAttribute
      public int y = -9999;
      @XmlAttribute
      public float width = -9999.0F;
      @XmlAttribute
      public float height = -9999.0F;
      @XmlAttribute
      public XMLWindowData.Direction direction;
      @XmlAttribute
      public int maxIncrease;

      public ResizeFrame() {
         this.direction = XMLWindowData.Direction.None;
      }
   }
}
