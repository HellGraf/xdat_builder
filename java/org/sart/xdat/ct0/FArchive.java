package org.sart.xdat.ct0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FArchive {
   private ByteBuffer buffer;

   public FArchive(int var1) {
      this.buffer = ByteBuffer.allocate(32767).order(ByteOrder.LITTLE_ENDIAN);
      this.buffer = ByteBuffer.allocate(var1).order(ByteOrder.LITTLE_ENDIAN);
   }

   public FArchive(String var1) {
      this.buffer = ByteBuffer.allocate(32767).order(ByteOrder.LITTLE_ENDIAN);

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
}
