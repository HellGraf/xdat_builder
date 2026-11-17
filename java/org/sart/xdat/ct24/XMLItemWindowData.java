package org.sart.xdat.ct24;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XMLItemWindowData extends XMLUIData {
   @XmlAttribute
   public String ItemWndType = "ScrollType";
   @XmlAttribute
   public int col;
   @XmlAttribute
   public int row;
   @XmlAttribute
   public int maxItem;
   @XmlAttribute
   public int itemWidth;
   @XmlAttribute
   public int itemHeight;
   @XmlAttribute
   public int gapX;
   @XmlAttribute
   public int gapY;
   @XmlAttribute
   public int OffsetX;
   @XmlAttribute
   public int OffsetY;
   @XmlElement(
      name = "BackgroundItem"
   )
   public XMLItemWindowData.Item BackgroundItem = new XMLItemWindowData.Item();
   @XmlElement(
      name = "SelectedItem"
   )
   public XMLItemWindowData.Item SelectedItem = new XMLItemWindowData.Item();
   @XmlElement(
      name = "UnselectedItem"
   )
   public XMLItemWindowData.Item UnselectedItem = new XMLItemWindowData.Item();
   @XmlElement(
      name = "BlankItem"
   )
   public XMLItemWindowData.Item BlankItem = new XMLItemWindowData.Item();
   @XmlAttribute
   public int NoSelectItem;
   @XmlAttribute
   public int NoItemDrag;
   @XmlAttribute
   public int ButtonClick;
   @XmlAttribute
   public int UseCoolTime;
   @XmlAttribute
   public int NoScroll;
   @XmlAttribute
   public int ShowIconFrame;
   @XmlElement(
      name = "ButtonItem"
   )
   public XMLItemWindowData.ButtonItem buttonItem = new XMLItemWindowData.ButtonItem();
   @XmlElement(
      name = "ExpandItem"
   )
   public List expandItems = new LinkedList();
   @XmlAttribute
   public int ButtonTypePrevButtonPosX;
   @XmlAttribute
   public int ButtonTypePrevButtonPosY;
   @XmlAttribute
   public int ButtonTypeNextButtonPosX;
   @XmlAttribute
   public int ButtonTypeNextButtonPosY;

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.serialize(this, "ItemWndType", String.class);
      var1.serialize(this, "col", Integer.TYPE);
      var1.serialize(this, "row", Integer.TYPE);
      var1.serialize(this, "maxItem", Integer.TYPE);
      var1.serialize(this, "itemWidth", Integer.TYPE);
      var1.serialize(this, "itemHeight", Integer.TYPE);
      var1.serialize(this, "gapX", Integer.TYPE);
      var1.serialize(this, "gapY", Integer.TYPE);
      var1.serialize(this, "OffsetX", Integer.TYPE);
      var1.serialize(this, "OffsetY", Integer.TYPE);
      this.BackgroundItem.serialize(var1);
      this.SelectedItem.serialize(var1);
      this.UnselectedItem.serialize(var1);
      this.BlankItem.serialize(var1);
      var1.serialize(this, "NoSelectItem", Integer.TYPE);
      var1.serialize(this, "NoItemDrag", Integer.TYPE);
      var1.serialize(this, "ButtonClick", Integer.TYPE);
      var1.serialize(this, "UseCoolTime", Integer.TYPE);
      var1.serialize(this, "NoScroll", Integer.TYPE);
      var1.serialize(this, "ShowIconFrame", Integer.TYPE);
      var1.serialize(this.buttonItem, "OutLineUp", String.class);
      var1.serialize(this.buttonItem, "OutLineDown", String.class);
      var1.serialize(this, "ButtonTypePrevButtonPosX", Integer.TYPE);
      var1.serialize(this, "ButtonTypePrevButtonPosY", Integer.TYPE);
      var1.serialize(this, "ButtonTypeNextButtonPosX", Integer.TYPE);
      var1.serialize(this, "ButtonTypeNextButtonPosY", Integer.TYPE);
      var1.serialize(this, "expandItems", XMLItemWindowData.ExpandItem.class);
   }

   public static class ButtonItem {
      @XmlAttribute
      public String OutLineUp;
      @XmlAttribute
      public String OutLineDown;
   }

   public static class ExpandItem implements FSerialize {
      @XmlAttribute
      public int width;
      @XmlAttribute
      public int height;
      @XmlAttribute
      public int num;
      @XmlAttribute
      public String texture;

      public void serialize(FArchive var1) {
         var1.serialize(this, "width", Integer.TYPE);
         var1.serialize(this, "height", Integer.TYPE);
         var1.serialize(this, "num", Integer.TYPE);
         var1.serialize(this, "texture", String.class);
      }
   }

   public static class Item implements FSerialize {
      @XmlAttribute
      public int width;
      @XmlAttribute
      public int height;
      @XmlAttribute
      public String texture;

      public void serialize(FArchive var1) {
         var1.serialize(this, "width", Integer.TYPE);
         var1.serialize(this, "height", Integer.TYPE);
         var1.serialize(this, "texture", String.class);
      }
   }
}
