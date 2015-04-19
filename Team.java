// Mark Mahony
// April 18, 2015
// Tennis Tournament Planner
// Team for bracket tree

public class Team
{
    String player1 = "";
    String player2 = "";
    int seed;
    
    // Constructors
    public Team()
    {
        player1 = "Player 1";
        player2 = "Player 2";
        seed = -1;
    }
    public Team(String p1, String p2, int s)
    {
        player1 = p1;
        player2 = p2;
        seed = s;
    }
    public Team(String p1, String p2)
    {
        player1 = p1;
        player2 = p2;
        seed = -1;
    }
    
    // Getters
    public String getNames()
    {
        return player1 + " and " + player2;
    }
    public String getPlayer1()
    {
        return player1;
    }
    public String getPlayer2()
    {
        return player2;
    }
    public int getSeed()
    {
        return seed;
    }
    
    // Setters
    public void setPlayer1(String p1)
    {
        player1 = p1;
    }
    public void setPlayer2(String p2)
    {
        player2 = p2;
    }
    public void setSeed(int s)
    {
        seed = s;
    }
    
    public String toString()
    {
        if (player2.equals(""))
            return player1;
        
        return player1 + " and " + player2 + "\tseed: " + seed;
    }
}