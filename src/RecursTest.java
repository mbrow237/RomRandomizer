import java.util.*;
import java.lang.*; 
import java.io.*;
public class RecursTest
   {
    directoryFind f; 
    File rom = null;
	String path;
    
    public void loadRoms(String p) throws IOException
      {
            
            path = p;
            File file = new File(path); 
            File rom = null;
            f = new directoryFind();
            f.findAllDirect(file);
            /*
            System.out.println("Loading all ROMS, please wait...");
            f.findAllDirect(file);
            System.out.println("Loading complete, Picking random rom");
            num = f.randomNum();
            romPath = f.returnFile(num);
            rom = new File(romPath);
            
            if (! rom.exists()) {
            throw new IllegalArgumentException("The file " + rom.toURL() + " does not exist");
               }
               
            roms r = new roms();
            r.romExecute(rom);
            */                   
     }
      
      public void pickRandomRom() throws IOException
      {
    	  int num = 0;
    	  String romPath;
    	  num = f.randomNum();
    	  romPath = f.returnFile(num);
    	  rom = new File(romPath);
          
    	  if (! rom.exists()) {
          throw new IllegalArgumentException("The file " + rom.toURL() + " does not exist");
             }
             
          roms r = new roms();
          r.romExecute(rom);
      }
      
      public boolean checkListIsEmpty()
      {
    	  if (f.list.isEmpty())
    	  {
    		  return true;
    	  }
    	  else
    	  {
    		  return false;
    	  }
      }
}     