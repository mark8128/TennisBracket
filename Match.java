// Mark Mahony
// April 18, 2015
// Tennis Tournamnet Planner
// Bracket tree structure

public class Match
{
    Match subL;
    Match subR;
    Match parent;
    Team t;
    
    // Constructors
    public Match()
    {
        subL = null;
        subR = null;
        parent = null;
        t = null;
    }
    public Match(Match left, Match right, Match p)
    {
        subL = left;
        subR = right;
        parent = p;
        t = null;
    }
    public Match(Match left, Match right, Match p, Team tm)
    {
        subL = left;
        subR = right;
        parent = p;
        t = tm;
    }
    public Match(Match left, Match right)
    {
        subL = left;
        subR = right;
    }
    public Match(Team tm)
    {
        subL = null;
        subR = null;
        parent = null;
        t = tm;
    }
    
    // Setters
    public void setParent(Match m)
    {
        parent = m;
    }
    public void setSubL(Match m)
    {
        subL = m;
    }
    public void setSubR(Match m)
    {
        subR = m;
    }
    
    // Getters
    
    // Printing
    public void printTree()
    {
        System.out.println(this.toString());
        
        if (subL != null)
            subL.printTree2("\t");
        if (subR != null)
            subR.printTree2("\t");
    }
    // Used to add spacing
    public void printTree2(String spacing)
    {
        System.out.println(spacing + this.toString());
        
        if (subL != null)
            subL.printTree2(spacing + "\t");
        if (subR != null)
            subR.printTree2(spacing + "\t");
    }
    
    public String toString()
    {
        if (t != null)
            return t.getNames();
        return "Determined by winner";
    }
    
    
    
}