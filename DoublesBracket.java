// Mark Mahony
// April 18, 2015
// Tennis Tournament Planner
// Test Main Program

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
        
        
        System.out.println("");
    }
}



// Add null value matches seeded at the end to round out to a power of 2
// Get list 1..2^n then remove all selected seeds
// Give all remaining teams one of the left over seeds (arraylist remove)
