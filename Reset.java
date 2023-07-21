import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Reset here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reset extends Actor
{
    /**
     * Act - do whatever the Reset wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int counter = 0;
    public void act() 
    {
        counter++;
        if(counter<20)
        {}
        else if(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("space")||Greenfoot.mouseClicked(null))
        {
            Greenfoot.setWorld(new MyWorld());
        }
    }
    public Reset()
    {
        setLocation(300, 200);
    }
    protected void addedToWorld(World world)
    {
        setLocation(300, 200);
        if(Score.showScore>Score.highScore)
        {
            Score.highScore = Score.showScore;
            //PrintWriter pWriter = new PrintWriter( new BufferedWriter(new FileWriter("score.txt")));
        }
    }
}
    

