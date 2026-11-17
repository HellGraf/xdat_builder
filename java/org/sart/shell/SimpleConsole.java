package org.sart.shell;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class SimpleConsole {
   public final Object object;
   private final Map<Class, Function> typeMap = new HashMap<Class, Function>();

   public SimpleConsole(Object var1) {
      this.object = var1;
      this.register(Byte.TYPE, Byte::parseByte);
      this.register(Short.TYPE, Short::parseShort);
      this.register(Integer.TYPE, Integer::parseInt);
      this.register(Long.TYPE, Long::parseLong);
      this.register(Float.TYPE, Float::parseFloat);
      this.register(Double.TYPE, Double::parseDouble);
      this.register(Boolean.TYPE, Boolean::parseBoolean);
      this.register(String.class, Objects::toString);
      this.register(Path.class, (var0) -> {
         return Paths.get(var0);
      });
   }

   public SimpleConsole register(Class var1, Function var2) {
      this.typeMap.put(var1, var2);
      return this;
   }

   public static SimpleConsole from(Class var0) throws InstantiationException, IllegalAccessException {
      return new SimpleConsole(var0.newInstance());
   }

   public void exec(String[] var1) throws Throwable {
      Class var2 = this.object.getClass();
      if (var1.length == 0) {
         throw new RuntimeException("exec withs zero arguments");
      } else {
         int var3 = var1.length - 1;
         Method[] var4 = var2.getDeclaredMethods();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            Method var7 = var4[var6];
            if (Modifier.isPublic(var7.getModifiers()) && !Modifier.isStatic(var7.getModifiers()) && var7.isAnnotationPresent(exec.class) && ((exec)var7.getAnnotation(exec.class)).value().equals(var1[0]) && var7.getParameterCount() == var3) {
               Object[] var8 = new Object[var3];
               Class[] var9 = var7.getParameterTypes();

               for(int var10 = 0; var10 < var3; ++var10) {
                  Function var11 = (Function)this.typeMap.get(var9[var10]);
                  if (var11 == null) {
                     throw new RuntimeException("not mapped type " + var9[var10] + " in method " + var7);
                  }

                  var8[var10] = var11.apply(var1[var10 + 1]);
               }

               var7.invoke(this.object, var8);
               return;
            }
         }

         throw new RuntimeException("not found command  " + var1[0] + " with agrc " + var3);
      }
   }
}
