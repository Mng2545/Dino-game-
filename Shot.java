import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shot extends Actor
{
    private Dino myGameDino;
    /**
     * Act - do whatever the shot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Shot(Dino myGameDino)
    {
        this.myGameDino = myGameDino;
    }
    
    public void act()
    {
    int ypos = getY();
    if(ypos > 0) 
    {
        ypos = ypos -5;
        setLocation(getX(), ypos);
        Actor stone = getOneIntersectingObject(Obstacle.class);
        if(stone != null) 
        {
            hitAnObstacle();
            getWorld().removeObject(stone);
            getWorld().removeObject(this);
        }
    }
    else 
    {
        getWorld().removeObject(this);
    }
}
private void hitAnObstacle()
{
        
}
}
