import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    /**
     * Act - do whatever the score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int score =0; 
    static public int showScore = 0;
    private int lastScore =0;
    static public int highScore =0;
    public void act()
    {
        if(Dino.alive)
        {
            score++;
            showScore = score;
        
      /*  if(lastScore!=showScore)
        {
            setImage(new GreenfootImage("Score" + showScore + 24 + Color.BLACK + Color. WHITE));
        }
        lastScore = showScore;*/
        }
    }
    public void print(String pText)
    {
        clear();
        getImage().drawImage(new GreenfootImage(pText, 20, Color.BLACK, new Color(1, 1, 1, 1)), 10,10);
    }
    public void clear()
    {
        getImage().clear();
    }
    static public void consolePrint(String message, String preMessage)
    {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println(preMessage);
            System.out.println(message);
    }
    protected void addedToWorld(World world)
    {
        setLocation(475, 30);
        setImage(new GreenfootImage("High: " +highScore + "     "+ "0", 24, Color.GRAY, Color.WHITE));
    }
}

