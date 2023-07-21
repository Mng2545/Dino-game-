import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Actor
{
    /**
     * Act - do whatever the start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       setLocation(600, 200);
    
    }
    public void start()
    {
        {
        setImage("images/Startscreen.png");
        }
    }
    /*private void click() {
        if(Greenfoot.mouseClicked(this)) {
          Greenfoot.setWorld(new MyWorld());
        }
    }
    
   /* public Start() {
        setLocation(600, 200);
        setImage("images/Startscreen.png");
        GreenfootImage start = new GreenfootImage
    }*/
   public Start(int width, int height) {
       GreenfootImage start = getImage();
       start.scale(width, height);
       setImage(start);
   }
}
