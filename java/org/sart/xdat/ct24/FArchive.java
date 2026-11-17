package org.sart.xdat.ct24;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.List;

public class FArchive {
   public ByteBuffer buffer;
   public boolean isReadMode;

   public FArchive(int var1) {
      this.buffer = ByteBuffer.allocate(32767).order(ByteOrder.LITTLE_ENDIAN);
      this.isReadMode = true;
      this.buffer = ByteBuffer.allocate(var1).order(ByteOrder.LITTLE_ENDIAN);
      this.buffer.clear();
   }

   public FArchive(String var1) {
      this.buffer = ByteBuffer.allocate(32767).order(ByteOrder.LITTLE_ENDIAN);
      this.isReadMode = true;

      try {
         SeekableByteChannel var2 = Files.newByteChannel(Paths.get(var1));
         Throwable var3 = null;

         try {
            this.buffer = ByteBuffer.allocate((int)var2.size()).order(ByteOrder.LITTLE_ENDIAN);
            this.buffer.clear();
            var2.read(this.buffer);
            this.buffer.flip();
         } catch (Throwable var13) {
            var3 = var13;
            throw var13;
         } finally {
            if (var2 != null) {
               if (var3 != null) {
                  try {
                     var2.close();
                  } catch (Throwable var12) {
                     var3.addSuppressed(var12);
                  }
               } else {
                  var2.close();
               }
            }

         }

      } catch (Throwable var15) {
         throw new RuntimeException("FArchive probmlem: " + var15);
      }
   }

   public void write(String var1) {
      int var2 = var1.length();
      if (var2 == 0) {
         this.test(1);
         this.buffer.put((byte)0);
      } else {
         int var3;
         if (this.isUnicode(var1)) {
            this.test(var2 * 2 + 5);
            this.compact(-(var2 + 1));

            for(var3 = 0; var3 < var1.length(); ++var3) {
               this.buffer.putChar(var1.charAt(var3));
            }

            this.buffer.putShort((short)0);
         } else {
            this.test(var2 + 5);
            this.compact(var2 + 1);

            for(var3 = 0; var3 < var1.length(); ++var3) {
               this.buffer.put((byte)var1.charAt(var3));
            }

            this.buffer.put((byte)0);
         }

      }
   }

   public void write(int var1) {
      this.test(4);
      this.buffer.putInt(var1);
   }

   public void write(float var1) {
      this.test(4);
      this.buffer.putFloat(var1);
   }

   public void write(boolean var1) {
      this.test(4);
      this.buffer.putInt(var1 ? 1 : 0);
   }

   public void compact(int var1) {
      this.test(5);
      boolean var2 = (var1 & Integer.MIN_VALUE) != 0;
      var1 = Math.abs(var1);
      byte var3 = (byte)(var1 & 63 | (var2 ? 128 : 0));
      int var4 = var1 >>> 6;
      if (var4 > 0) {
         this.buffer.put((byte)(var3 | 64));
         var3 = (byte)(var4 & 127);
         var4 >>>= 7;
         if (var4 > 0) {
            this.buffer.put((byte)(var3 | -128));
            var3 = (byte)(var4 & 127);
            var4 >>>= 7;
            if (var4 > 0) {
               this.buffer.put((byte)(var3 | -128));
               var3 = (byte)(var4 & 127);
               var4 >>>= 7;
               if (var4 > 0) {
                  this.buffer.put((byte)(var3 | -128));
                  this.buffer.put((byte)(var4 & 15));
               } else {
                  this.buffer.put(var3);
               }
            } else {
               this.buffer.put(var3);
            }
         } else {
            this.buffer.put(var3);
         }
      } else {
         this.buffer.put(var3);
      }

   }

   public void flip() {
      this.buffer.flip();
   }

   public int readC() {
      this.test(5);
      byte var1 = this.buffer.get();
      int var2 = var1 & 63;
      boolean var3 = (var1 & -128) != 0;
      if ((var1 & 64) != 0) {
         byte var4 = this.buffer.get();
         var2 |= (var4 & 127) << 6;
         if ((var4 & -128) != 0) {
            byte var5 = this.buffer.get();
            var2 |= (var5 & 127) << 13;
            if ((var5 & -128) != 0) {
               byte var6 = this.buffer.get();
               var2 |= (var6 & 127) << 20;
               if ((var6 & -128) != 0) {
                  var2 |= (this.buffer.get() & 15) << 27;
               }
            }
         }
      }

      return var3 ? -var2 : var2;
   }

   public void test(int var1) {
      if (this.buffer.capacity() - this.buffer.position() < var1) {
         ByteBuffer var2 = ByteBuffer.allocate(this.buffer.capacity() * 2).order(ByteOrder.LITTLE_ENDIAN);
         this.buffer.flip();
         this.buffer = var2.put(this.buffer);
         this.test(var1);
      }

   }

   public void flush(String var1) {
      try {
         FileChannel var2 = FileChannel.open(Paths.get(var1), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
         Throwable var3 = null;

         try {
            this.buffer.flip();
            var2.write(this.buffer);
         } catch (Throwable var13) {
            var3 = var13;
            throw var13;
         } finally {
            if (var2 != null) {
               if (var3 != null) {
                  try {
                     var2.close();
                  } catch (Throwable var12) {
                     var3.addSuppressed(var12);
                  }
               } else {
                  var2.close();
               }
            }

         }

      } catch (Throwable var15) {
         throw new RuntimeException(var15);
      }
   }

   public int readI() {
      return this.buffer.getInt();
   }

   public String readS() {
      int var1 = this.readC();
      StringBuilder var2 = new StringBuilder();
      int var3;
      if (var1 > 0) {
         for(var3 = 0; var3 < var1 - 1; ++var3) {
            var2.append((char)this.buffer.get());
         }

         if (this.buffer.get() != 0) {
            throw new RuntimeException("read string with not null terminate");
         }
      } else if (var1 < 0) {
         var1 = -var1;

         for(var3 = 0; var3 < var1 - 1; ++var3) {
            var2.append(this.buffer.getChar());
         }

         if (this.buffer.getShort() != 0) {
            throw new RuntimeException("read string with not null terminate");
         }
      }

      return var2.toString();
   }

   public float readF() {
      return this.buffer.getFloat();
   }

   public static FArchive read(String var0) {
      return new FArchive(var0);
   }

   public int readB() {
      int var1 = this.readI();
      if (var1 != -1 && var1 != 1 && var1 != 0) {
         System.err.println("undefine boolean value " + var1);
         return -1;
      } else {
         return var1;
      }
   }

   public boolean readBOOL() {
      int var1 = this.readI();
      if (var1 != 0 && var1 != 1) {
         System.err.println("incorrect bool value");
         return false;
      } else {
         return var1 == 1;
      }
   }

   public String toString() {
      return "FArchive offset: " + Integer.toHexString(this.buffer.position());
   }

   public int pos() {
      return this.buffer.position();
   }

   public boolean isUnicode(String var1) {
      for(int var2 = 0; var2 < var1.length(); ++var2) {
         if (var1.charAt(var2) > 255) {
            return true;
         }
      }

      return false;
   }

   public void setReadMode(boolean var1) {
      this.isReadMode = var1;
   }

   public FArchive serialize(Object var1, String var2, Class var3) {
      try {
         Field var4 = var1.getClass().getDeclaredField(var2);
         if (Modifier.isPublic(var4.getModifiers()) && !Modifier.isStatic(var4.getModifiers())) {
            if (var4.getType().isAssignableFrom(List.class)) {
               List var5 = (List)var4.get(var1);
               if (this.isReadMode) {
                  int var6 = this.readI();

                  for(int var7 = 0; var7 < var6; ++var7) {
                     Object var8 = var3.newInstance();
                     ((FSerialize)var8).serialize(this);
                     var5.add(var8);
                  }
               } else {
                  this.write(var5.size());
                  Iterator var11 = var5.iterator();

                  while(var11.hasNext()) {
                     Object var12 = var11.next();
                     ((FSerialize)var12).serialize(this);
                  }
               }
            } else if (var3.isEnum()) {
               if (var4.getType() != var3) {
                  throw new RuntimeException("field type problem: try read to field " + var4 + " with type " + var4.getType() + " " + var3);
               }

               Method var10;
               if (this.isReadMode) {
                  var10 = var3.getDeclaredMethod("parseInt", Integer.TYPE);
                  var4.set(var1, var10.invoke((Object)null, this.readI()));
               } else {
                  var10 = var3.getDeclaredMethod("toInt", var3);
                  this.write((Integer)var10.invoke((Object)null, var4.get(var1)));
               }
            } else {
               if (var4.getType() != var3) {
                  throw new RuntimeException("field type problem: try read to field " + var4 + " with type " + var4.getType() + " " + var3);
               }

               if (this.isReadMode) {
                  this.read(var1, var4, var3);
               } else {
                  this.write(var1, var4, var3);
               }
            }

            return this;
         } else {
            throw new RuntimeException("field modifier problem: " + var2 + " " + Modifier.toString(var4.getModifiers()));
         }
      } catch (Throwable var9) {
         var9.printStackTrace();
         throw new RuntimeException(var9 + " " + var1.getClass() + " field " + var2);
      }
   }

   public void write(Object var1, Field var2, Class var3) throws Throwable {
      if (var3.isPrimitive()) {
         if (var3 == Integer.TYPE) {
            this.write(var2.getInt(var1));
         } else if (var3 == Boolean.TYPE) {
            this.write(var2.getBoolean(var1));
         } else {
            if (var3 != Float.TYPE) {
               throw new RuntimeException("primitive type error: not allowed type " + var3 + " in field " + var2);
            }

            this.write(var2.getFloat(var1));
         }
      } else {
         if (var3 != String.class) {
            throw new RuntimeException("not allowed type for serialization " + var3);
         }

         this.write(var2.get(var1).toString());
      }

   }

   private void read(Object var1, Field var2, Class var3) throws Throwable {
      if (var3.isPrimitive()) {
         if (var3 == Integer.TYPE) {
            var2.setInt(var1, this.readI());
         } else if (var3 == Boolean.TYPE) {
            var2.setBoolean(var1, this.readBOOL());
         } else {
            if (var3 != Float.TYPE) {
               throw new RuntimeException("primitive type error: not allowed type " + var3 + " in field " + var2);
            }

            var2.setFloat(var1, this.readF());
         }
      } else {
         if (var3 != String.class) {
            throw new RuntimeException("not allowed type for serialization " + var3);
         }

         var2.set(var1, this.readS());
      }

   }
}
