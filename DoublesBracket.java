// Mark Mahony
// April 18, 2015
// Tennis Tournament Planner
// Test Main Program

import java.lang.Math;
import java.util.ArrayList;

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

        m5.printTree();
        
        
        ArrayList<Team> enterants = new ArrayList<Team>();
        enterants.add(new Team("p1", "p1"));
        enterants.add(new Team("p2", "p2"));
        enterants.add(new Team("p3", "p3"));
        enterants.add(new Team("p4", "p4"));
        enterants.add(new Team("p5", "p5"));
        enterants.add(new Team("p6", "p6"));
        enterants.add(new Team("p7", "p7"));
        enterants.add(new Team("p8", "p8"));
        enterants.add(new Team("p9", "p9"));
        
        createTree(enterants);
        
        System.out.println("");
    }
    
    public static Match createTree(ArrayList<Team> t)
    {
        // Add dummy leaves which are byes
        // Order based on seeds
        // Add seeds not set
        // Make tree
        //      With proper seeding!!!
        // Go through byes and put teams through as winners
        
        int x = t.size();
        
        for (int i = x; i < (int)(x * Math.pow(2, (Math.ceil(Math.log(x)/Math.log(2)) - Math.log(x)/Math.log(2))) + 0.5); i++)
        {
            t.add(new Team("p" + i, ""));
        }
        System.out.println(t.size());

        //System.out.println((int)(x * Math.pow(2, (Math.ceil(Math.log(x)/Math.log(2)) - Math.log(x)/Math.log(2))) + 0.5));
        
        return null;
    }
}



// Add null value matches seeded at the end to round out to a power of 2
// Get list 1..2^n then remove all selected seeds
// Give all remaining teams one of the left over seeds (arraylist remove)
