import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int score= 0;
    private int counter= 0;
    private int worldSpeed= 50;
    private boolean startTime = true;
    static public int difficulty = 0;
    private int rand;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public void act()
    {
        score++;
        counter++;
        if(startTime) 
        {
            difficulty =0;
            if(counter>= 100)
            {
                counter=0;
                rand=Greenfoot.getRandomNumber(15);
                startTime = true;
                addObject(new Obstacle(), 580, 300);
            }
        }
        else if(counter>=(40+rand)-(int)(1.7*(double)difficulty))
        {
            counter=0;
            rand=Greenfoot.getRandomNumber(15);
            addObject(new Obstacle(), 580, 300);
        }
        
    }
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Dino(), 300, 500);
        addObject(new Obstacle(), 50, 75);
        addObject(new Score(), 20, 35);     
    }
}

