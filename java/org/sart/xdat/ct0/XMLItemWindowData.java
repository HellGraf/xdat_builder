package org.sart.xdat.ct0;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XMLItemWindowData extends XMLUIData {
   @XmlAttribute
   public int col = -9999;
   @XmlAttribute
   public int row = -9999;
   @XmlAttribute
   public int maxItem = -9999;
   @XmlAttribute
   public int itemWidth = -9999;
   @XmlAttribute
   public int itemHeight = -9999;
   @XmlAttribute
   public int gapX = -9999;
   @XmlAttribute
   public int gapY = -9999;
   @XmlAttribute
   public int OffsetX = -9999;
   @XmlAttribute
   public int OffsetY = -9999;
   @XmlAttribute
   public int NoSelectItem = -1;
   @XmlAttribute
   public int NoItemDrag = -1;
   @XmlAttribute
   public int ButtonClick = -1;
   @XmlAttribute
   public int UseCoolTime = -1;
   @XmlAttribute
   public int noScroll = -1;
   @XmlElement(
      name = "BackgroundItem"
   )
   public XMLItemWindowData.ItemTexture BackgroundItem = new XMLItemWindowData.ItemTexture();
   @XmlElement(
      name = "SelectedItem"
   )
   public XMLItemWindowData.ItemTexture SelectedItem = new XMLItemWindowData.ItemTexture();
   @XmlElement(
      name = "UnselectedItem"
   )
   public XMLItemWindowData.ItemTexture UnselectedItem = new XMLItemWindowData.ItemTexture();
   @XmlElement(
      name = "ButtonItem"
   )
   public XMLItemWindowData.ButtonItem ButtonItem = new XMLItemWindowData.ButtonItem();

   public void serialize(FArchive var1) {
      super.serialize(var1);
      var1.write(this.col);
      var1.write(this.row);
      var1.write(this.maxItem);
      var1.write(this.itemWidth);
      var1.write(this.itemHeight);
      var1.write(this.gapX);
      var1.write(this.gapY);
      var1.write(this.OffsetX);
      var1.write(this.OffsetY);
      this.BackgroundItem.serialize(var1);
      this.SelectedItem.serialize(var1);
      this.UnselectedItem.serialize(var1);
      var1.write(this.NoSelectItem);
      var1.write(this.NoItemDrag);
      var1.write(this.ButtonClick);
      var1.write(this.UseCoolTime);
      var1.write(this.noScroll);
      this.ButtonItem.serialize(var1);
   }

   public void unserialize(FArchive var1) {
      super.unserialize(var1);
      this.col = var1.readI();
      this.row = var1.readI();
      this.maxItem = var1.readI();
      this.itemWidth = var1.readI();
      this.itemHeight = var1.readI();
      this.gapX = var1.readI();
      this.gapY = var1.readI();
      this.OffsetX = var1.readI();
      this.OffsetY = var1.readI();
      this.BackgroundItem.unserialize(var1);
      this.SelectedItem.unserialize(var1);
      this.UnselectedItem.unserialize(var1);
      this.NoSelectItem = var1.readB();
      this.NoItemDrag = var1.readB();
      this.ButtonClick = var1.readB();
      this.UseCoolTime = var1.readB();
      this.noScroll = var1.readB();
      this.ButtonItem.unserialize(var1);
   }

   public static class ButtonItem implements FSerializable {
      @XmlAttribute
      public String OutLineUp = "undefined";
      @XmlAttribute
      public String OutLineDown = "undefined";

      public void serialize(FArchive var1) {
         var1.write(this.OutLineUp);
         var1.write(this.OutLineDown);
      }

      public void unserialize(FArchive var1) {
         this.OutLineUp = var1.readS();
         this.OutLineDown = var1.readS();
      }
   }

   public static class ItemTexture implements FSerializable {
      @XmlAttribute
      public int width = -9999;
      @XmlAttribute
      public int height = -9999;
      @XmlAttribute
      public String texture = "undefined";

      public void serialize(FArchive var1) {
         var1.write(this.width);
         var1.write(this.height);
         var1.write(this.texture);
      }

      public void unserialize(FArchive var1) {
         this.width = var1.readI();
         this.height = var1.readI();
         this.texture = var1.readS();
      }
   }
}
