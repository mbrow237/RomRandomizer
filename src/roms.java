import java.util.*;
import java.lang.*; 
import java.io.*;
public class roms
   {
      public void romExecute(File file)throws IOException{ 
            if (! file.exists()) {
            throw new IllegalArgumentException("The file " + file.toURL() + " does not exist");
               }
               
            Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+file.toURL());
        }
 }           