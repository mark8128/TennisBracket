// Mark Mahony
// April 18, 2015
// Tennis Tournament Planner
// Test Main Program

import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;

public class DoublesBracket
{
    public static void main(String args[])
    {
        System.out.println("");
        
        // Create a tree to test on
        Match m1 = new Match(new Team("p1", "p1"));
        Match m2 = new Match(new Team("p2", "p2"));
        Match m3 = new Match(m1, m2);
        m1.setParent(m3);
        m2.setParent(m3);
        Match m4 = new Match(new Team("p4", "p4"));
        Match m5 = new Match (m3, m4);
        m3.setParent(m5);
        m4.setParent(m5);
        Match m6 = new Match(new Team("p6", "p6"));
        m6.setParent(m4);
        m4.setSubL(m6);

        //m5.printTree();
        
        
        ArrayList<Team> enterants = new ArrayList<Team>();
        enterants.add(new Team("p1", "p1", 1));
        enterants.add(new Team("p2", "p2", 2));
        enterants.add(new Team("p3", "p3"));
        enterants.add(new Team("p4", "p4", 4));
        enterants.add(new Team("p5", "p5"));
        enterants.add(new Team("p6", "p6", 3));
        enterants.add(new Team("p7", "p7", 8));
        enterants.add(new Team("p8", "p8", 0));
        enterants.add(new Team("p9", "p9", 10));
        
        createTree(enterants);
        
        arrangeSeeds(seedTeams(enterants));
        
        System.out.println("");
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        arr.add(9);
        arr.add(10);
        arr.add(11);
        arr.add(12);
        arr.add(13);
        arr.add(14);
        arr.add(15);
        arr.add(16);
        
        System.out.println("Size of Arr before: " + arr.size());
        
        arr = split(arr);
        
        for (int i = 0; i < arr.size(); i++)
        {
            System.out.println(arr.get(i));
        }
        
        System.out.println("Size of Arr after: " + arr.size());
    }
    
    public static Match createTree(ArrayList<Team> t)
    {
        // Add dummy leaves which are byes
        // Order based on seeds
        // Add seeds not set
        // Make tree
        //      With proper seeding!!!
        // Go through byes and put teams through as winners
        
        t = seedTeams(t);
        
        return null;
    }
    
    public static ArrayList<Team> seedTeams(ArrayList<Team> t)
    {
        int seedLength = t.size();
        int bracketSize = (int)(seedLength * Math.pow(2, (Math.ceil(Math.log(seedLength)/Math.log(2)) - Math.log(seedLength)/Math.log(2))) + 0.5);
        
        ArrayList<Integer> seeds = new ArrayList<Integer>();
        
        // Get the seeds set by the user
        int temp;
        for (int i = 0; i < seedLength; i++)
        {
            temp = t.get(i).getSeed();
            if (temp != -1)
            {
                if (temp < 1 || temp > seedLength)
                {
                    t.get(i).setSeed(-1);
                }
                else
                    seeds.add(t.get(i).getSeed());
            }
        }
        
        // Sort the seeds
        int lowSeed;
        int index;
        for (int i = 0; i < seeds.size() - 1; i++)
        {
            lowSeed = seeds.get(i);
            index = i;
            for (int j = i + 1; j < seeds.size(); j++)
            {
                if (seeds.get(j) < lowSeed)
                {
                    lowSeed = seeds.get(j);
                    index = j;
                }
                
            }
            // swap
            seeds.set(index, seeds.get(i));
            seeds.set(i, lowSeed);
        }
        
        // Remove all the used seeds from a list of all possible seeds
        ArrayList<Integer> allSeeds = new ArrayList<Integer>();
        for (int i = 1; i <= seedLength; i++)
        {
            allSeeds.add(i);
        }
        for (int i = 0; i < seeds.size(); i++)
        {
            int j = 0;
            
            while(seeds.get(i) != allSeeds.get(j))
            {
                j++;
            }
            allSeeds.remove(j);
        }
        
        // Randomly Assign the remaining seeds to teams without a seed
        Random rnd = new Random();
        int selection;
        for (int i = 0; i < seedLength; i++)
        {
            if (t.get(i).getSeed() == -1)
            {
                // Randomly pick an element from allSeeds
                selection = rnd.nextInt(allSeeds.size());
                t.get(i).setSeed(allSeeds.get(selection));
                allSeeds.remove(selection);
            }
        }
        
        /*
        // Printout
        System.out.println("All available seeds");
        for (int i = 0; i < allSeeds.size(); i++)
        {
            System.out.println(allSeeds.get(i));
        }
        System.out.println("");
        
        System.out.println("All used seeds");
        for (int i = 0; i < seeds.size(); i++)
            System.out.println(seeds.get(i));
        
        
        // Add teams to act as byes
        for (int i = seedLength; i < bracketSize; i++)
        {
            t.add(new Team("bye " + (i + 1), "", i));
        }
        System.out.println("");
        
        System.out.println("Teams final seeds");
        for (int i = 0; i < t.size(); i++)
        {
            System.out.println(t.get(i));
        }*/
        
        
        return t;
    }
    
    public static void arrangeSeeds(ArrayList<Team> t)
    {
        // First sort the teams based on seeds
        int lowSeed;
        int index;
        Team tempTeam;
        for (int i = 0; i < t.size() - 1; i++)
        {
            lowSeed = t.get(i).getSeed();
            index = i;
            for (int j = i + 1; j < t.size(); j++)
            {
                if (t.get(j).getSeed() < lowSeed)
                {
                    lowSeed = t.get(j).getSeed();
                    index = j;
                }
                
            }
            // swap
            tempTeam = t.get(i);
            t.set(i, t.get(index));
            t.set(index, tempTeam);
        }
        
        
        
        for (int i = 0; i < t.size(); i++)
        {
            System.out.println(t.get(i));
        }
        
        // Use a set of integers to sort permute the list, then swap the teams around
    }
    
    public static ArrayList<Integer> split(ArrayList<Integer> seeds)
    {
        int l = seeds.size();
        
        // Check if the algorithm has reached the end
        if (l == 2)
            return seeds;
        
        // Split the list into the two halves
        ArrayList<Integer> set1 = new ArrayList<Integer>();
        ArrayList<Integer> set2 = new ArrayList<Integer>();
        
        for (int i = 0; i < l; i++)
        {
            if (i % 4 == 0 || i % 4 == 3)
                set1.add(seeds.get(i));
            else
                set2.add(seeds.get(i));
        }
        /*
        for (int i = 0; i < l/2.0; i++)
        {
            System.out.println(set1.get(i));
        }
        
        for (int i = 0; i < l/2.0; i++)
        {
            System.out.println(set2.get(i));
        }*/
        
        // Recursively call this function and the one with the swap
        set1 = split(set1);
        set1.addAll(splitSwitch(set2));
        return set1;
        
    }
    
    public static ArrayList<Integer> splitSwitch(ArrayList<Integer> seeds)
    {
        int l = seeds.size();
        
        // Check if the algorithm has reached the end
        if (l == 2)
            return seeds;
        
        // Split the list into the two halves
        ArrayList<Integer> set1 = new ArrayList<Integer>();
        ArrayList<Integer> set2 = new ArrayList<Integer>();
        
        for (int i = 0; i < l; i++)
        {
            if (i % 4 == 0 || i % 4 == 3)
                set1.add(seeds.get(i));
            else
                set2.add(seeds.get(i));
        }
        /*
         for (int i = 0; i < l/2.0; i++)
         {
         System.out.println(set1.get(i));
         }
         
         for (int i = 0; i < l/2.0; i++)
         {
         System.out.println(set2.get(i));
         }*/
        
        // Recursively call this function and the one with the swap
        set1 = split(set1);
        set1.addAll(split(set2));
        return set1;

    }
}



// Add null value matches seeded at the end to round out to a power of 2
// Get list 1..2^n then remove all selected seeds
// Give all remaining teams one of the left over seeds (arraylist remove)
