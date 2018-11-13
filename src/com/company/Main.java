package com.company;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        Scanner scores= new Scanner (new File("scores.txt"));
        Scanner sf;

        String lines[] = new String [100000];



        int MaxIndx = -1;
        scores.nextLine();
        scores.useDelimiter("\\t");

        //Stores every line of the txt file in the array "lines"
        while(scores.hasNext())
        {
            MaxIndx++;
            lines[MaxIndx] = scores.nextLine();
        }

        //Declares and instantiates every element of a Records array
        Records NY[] = new Records[MaxIndx + 1];
        for(int i = 0; i<=MaxIndx; i++)
        {
            NY[i] = new Records();
        }

        //Takes the fields from the txt file and places them as their correct state variable in their object in the "NY" array
        for(int i = 0; i<=MaxIndx; i++)
        {
            sf = new Scanner(lines[i]);
            sf.useDelimiter("\\t");

            if(sf.hasNext())
                sf.next();

            if(sf.hasNext())
                NY[i].name = sf.next();

            for(int j = 0; j < 16; j++)
            {
                if(sf.hasNext())
                    sf.next();
            }
            //Try/catch statement are used to make sure the next value is integer (there are format mistakes in the txt file that we are not allowed to change)
            try
            {
                if(sf.hasNext())
                    NY[i].satMath = Integer.parseInt(sf.next());
            }
            catch (NumberFormatException e)
            {
                if(sf.hasNext())
                    sf.next();
            }
            try
            {
                if(sf.hasNext())
                    NY[i].satRead = Integer.parseInt(sf.next());
            }
            catch (NumberFormatException e)
            {
                if(sf.hasNext())
                    sf.next();
            }
            try
            {
                if(sf.hasNext())
                    NY[i].satWrit = Integer.parseInt(sf.next());
            }
            catch (NumberFormatException e)
            {
                if(sf.hasNext())
                    sf.next();
            }
        }

        //Creates a new HighSchool object called "NewYork".
        //This object is used to perform tasks like get top three schools, averages, etc.
        HighSchool NewYork = new HighSchool(NY);


        //----------------------------------------SEPARATION----------------------------------------\\


        for(int i = 0; i <= MaxIndx; i++)
        {
            int combined = NY[i].satRead + NY[i].satMath + NY[i].satWrit;
            System.out.println("\nSCHOOL: " + NY[i].name + "\nAVERAGE SAT SCORES:\tMATH-" + NY[i].satMath + "\tREADING-" + NY[i].satRead + "\tWRITING-" + NY[i].satWrit+ "\tTOTAL-" + combined );
        }

        NewYork.printTop();
        System.out.println("\nNEW YORK SAT AVERAGE:\t" + NewYork.getAverage());



    }
}