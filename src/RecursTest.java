import java.util.*;
import java.lang.*; 
import java.io.*;
public class RecursTest
   {
      public static void main (String [] args)throws IOException
      {
            
            String path = "C://Users//Melvin//Downloads//Roms";
            File file = new File(path); 
            File rom = null;
            String romPath;
            int num = 0;
            directoryFind f = new directoryFind();
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
 
            boolean reroll = false;
            do{
            char anwser;
            reroll = false;
            Scanner keyboard = new Scanner (System.in);
            System.out.println("Do you want to reroll? Y/N");
            anwser = keyboard.next().charAt(0);
            
            if(anwser == 'y' || anwser == 'Y')
               {
                  reroll = true;
               }   
            if (reroll == true)
               {
                  System.out.println("Reroll...");   
                  num = f.randomNum();
                  romPath = f.returnFile(num);
                  r.romExecute(rom);
               }
              else
               {
               System.exit(0);
               }    
           }while(reroll == true);
                         
     }                      
}     