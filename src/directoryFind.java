import java.util.*;
import java.lang.*; 
import java.io.*;
public class directoryFind
{   
   ArrayList<String> list = new ArrayList<String>();
   
   /*
   public enum romType{
	   GENESIS, SNES, NINTENDOSIXTYFOUR, GAMEGEAR, NES, GB, GBC
   }
   */
   public void findAllDirect(File file)
   {
      File[] array = file.listFiles();
      for(int i = 0; i < array.length; i++)
      {
         if (array[i].isDirectory())
         {
            findAllDirect(array[i]);
         }
         else
         {
            if(extensionCheck(array[i].getAbsolutePath()))
            {
        	 list.add(array[i].getAbsolutePath());
            }
         }
      }
   }
   public int randomNum()
   {
      int num = list.size();
      Random r = new Random();
      int n = r.nextInt(num);
      return n;
   }    
   public String returnFile(int n)
   {
      return list.get(n);    
   }
   
   public boolean extensionCheck(String s)
   {
	   String[] romPath = s.split("\\.");
	   boolean romExtension = false;
	   if (romPath[(romPath.length -1)].equals("gen") 
			   || romPath[(romPath.length -1)].equals("32x") 
			   || romPath[(romPath.length -1)].equals("gba") 
			   || romPath[(romPath.length -1)].equals("mb")
			   || romPath[(romPath.length -1)].equals("gb")
			   || romPath[(romPath.length -1)].equals("gbc")
			   || romPath[(romPath.length -1)].equals("v64")
			   || romPath[(romPath.length -1)].equals("z64")
			   || romPath[(romPath.length -1)].equals("nes")
			   || romPath[(romPath.length -1)].equals("unf")
			   || romPath[(romPath.length -1)].equals("smc")
			   || romPath[(romPath.length -1)].equals("gg"))
	   {
		   romExtension = true;
	   }
	   return romExtension;
   }

}



