package com.company;

public class HighSchool {


    public Records[] group;

    public HighSchool(Records[] r)
    {
        group = r;
    }

    //Finds average SAT score from all schools
    public int getAverage()
    {
        //must create a separate total variable rather than using group.length because some schools in the file did not have SAT scores and using them would mess up the data
        int total = 0;
        int Sum = 0;
        //As earlier stated, some schools have no SAT scores (stored as "0"). This bypasses those schools
        for(int i = 0; i < group.length ; i++)
        {
            int combined = group[i].satRead + group[i].satMath + group[i].satWrit;
            if(combined > 0)
            {
                Sum += combined;
            }
            total++;
        }
        return Sum / total;
    }

    //Prints the top three schools with the highest SAT score
    public void printTop()
    {
        int high1 = 0, high2 = 0, high3 = 0;
        String first = "", second = "", third = "";
        for(int i = 0; i < group.length ; i++)
        {
            int combined = group[i].satRead + group[i].satMath + group[i].satWrit;
            //Makes sure the school does have recorded SAT score (some schools in the file are 0 (no score given).
            if (combined > 0) {



                //Places both of those scores on the same line
                if (combined == high3)
                {
                    //Places both of those scores on the same line
                    third += "\t&\t" + group[i].name + ":\t" + combined;
                }
                //Replaces 3rd place if greater than third and less than 2nd
                else if(combined> high3 && combined < high2)
                {
                    third = group[i].name + ":\t" + combined;
                    high3 = combined;
                }

                //Places both of those scores on the same line
                if (combined == high2)
                {
                    //Places both of those scores on the same line
                    second += "\t&\t" + group[i].name + ":\t" + combined;
                }
                //Replaces 2nd if greater than 2nd and less than 1st
                else if(combined > high2 && combined < high1)
                {
                    second = group[i].name + ":\t" + combined;
                    high3 = high2;

                    high2 = combined;
                }

                //Places both of those scores on the same line
                if (combined == high1)
                {
                    //Places both of those scores on the same line
                    first += "\t&\t" + group[i].name + ":\t" + combined;
                }
                //Replaces first if greater than first
                else if(combined > high1)
                {
                    first = group[i].name + ":\t" + combined;
                    high3 = high2;

                    high2 = high1;

                    high1 = combined;
                }

            }
        }
        //Prints out the top three
        System.out.println("\n\n\nTOP THREE SCHOOLS SAT SCORES:");
        System.out.println("1st-\t" + first);
        System.out.println("2nd-\t" + second);
        System.out.println("3rd-\t" + third);

    }

}
