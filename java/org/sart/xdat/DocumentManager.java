package org.sart.xdat;

import java.io.IOException;
import java.nio.file.Path;

public interface DocumentManager {
   void append(Path var1);

   void compile(Path var1);

   void decompile(Path var1);

   void saveAsXML(Path var1) throws IOException;
}
