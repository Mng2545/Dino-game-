import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Actor
{
    private boolean start = true;
    private boolean cactus = true; 
    private int counter = 0;
    
    /**
     * Act - do whatever the obstacle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
            
       if(Dino.alive||Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("shift"))
        {
            counter ++;
            if(start) {
                start = false;
                setLocation(599, 270);
                if(Greenfoot.getRandomNumber(5)==0)
                {
                    setImage("images/cactus4.png");
                    setLocation(599, 294);
                }
                else if(Greenfoot.getRandomNumber(2)==0)
                {
                    setImage("images/cactus2.png");
                }
                else if (Greenfoot.getRandomNumber(1)==0)
                {
                    setImage("images/cactus1.png");
                }
            }
             move(-6-MyWorld.difficulty);
        if(isAtEdge())
            {
                getWorld().removeObject(this);
            }
        }
        else
        {
            getWorld().addObject(new Reset(), 0,0);
        }
        }
}
