/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manwomandiff;

import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author mtsguest
 */
public class ManWomanDiff {

    /**
     * @param args the command line arguments
     */
        ArrayList<Speakable> people = new ArrayList<Speakable>();
        
    public static void main(String[] args) {
      
        ManWomanDiff myConversations = new ManWomanDiff();
        myConversations.createPeople();
        myConversations.processConversations();
        //this will be my second commit 
        //another commit
        
    }
    
    public void createPeople()
    {
        createMan();
        createWoman();
    }
    
    public void processConversations()
    {
        for (int i = 0; i < people.size(); i++)
        {
            people.get(i).speak();
        }
    }
    
    public void createWoman()
    {
       
        String wFileName = "womon.txt";
        String name, sport;
        Woman aWoman;
        boolean invalidFile = true;
        Scanner keyboard = new Scanner(System.in);
        Scanner inWFile = null;
        
        do 
        {
            try
            {
                File aFile = new File(wFileName);
                inWFile = new Scanner(aFile);
                invalidFile = false;
                while (inWFile.hasNext())
                {
                    name = inWFile.next();
                    sport = inWFile.nextLine();
                    aWoman = new Woman(name, sport);
                    people.add(aWoman);
                }

            }
            catch(FileNotFoundException e)
            {
                System.out.println("Invalid Woman File.  Please enter another file name:");
                wFileName = keyboard.nextLine();
                invalidFile = true;
            }
            finally
            {
                if (!invalidFile)
                    inWFile.close();
            }
            
        } while (invalidFile);
    }
    
    public void createMan()
    {
        String mFileName = "mon.txt";
       
        String name, sport;
        Man aMan;
        boolean invalidFile = true;
        Scanner keyboard = new Scanner(System.in);
        Scanner inMFile = null;
        
        do 
        {
            try
            {
                File aFile = new File(mFileName);
                inMFile = new Scanner(aFile);
                invalidFile = false;
                while (inMFile.hasNext())
                {
                    name = inMFile.next();
                    sport = inMFile.nextLine();
                    aMan = new Man(name, sport);
                    people.add(aMan);
                }

            }
            catch(FileNotFoundException e)
            {
                System.out.println("Invalid Man File.  Please enter another file name:");
                mFileName = keyboard.nextLine();
                invalidFile = true;
            }
            finally
            {
                if (!invalidFile)
                    inMFile.close();
            }
            
        } while (invalidFile);
    }
    
    
    
    
    
}
