import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dinoo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dino extends Actor
{
    private int score  = 0;
    private int jumpCounter = 0;
    private boolean isOnGround = true;
    private boolean leftFoot = true;
    private boolean pressingJump = false;
    private boolean start = true;
    private boolean pressed;
    private boolean down;
    static public boolean alive = true;
    private int jumpSpeed;
    private boolean jumpButton =true; 
    private int counter =0;
    private int shotTimer =0;

   // private boolean pressed = false;
    //private greenfoot img1;
   // private greenfoot img2;
   // private Dino myDino;
    
    /**
     * rock moves to destory cactus and disappers after
     * rock moves to the right of the screen then disappers. If it hits cactus
     * on the way it destorys the cactus then disappers 
     */
    public void act()
    {
        if(start)
        {
            alive = true;
            start = false;
        }
        if(pressed && (Greenfoot.mouseDragEnded(null) || Greenfoot.mouseClicked(null)))
        {
            pressed = false;
        }
        if(!pressed && Greenfoot.mousePressed(null)) 
        {
            pressed = true;
        }
        if(alive || Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("s"))
        {
            if(isOnGround)
            { 
                score++;
                jumpCounter = 0;
                if(counter>=3)
                {
                    counter =0;
                    if(leftFoot)
                    {
                        leftFoot = false;
                    }
                    else
                    {
                        leftFoot = true;
                    }
                }
                if(Greenfoot.isKeyDown("down"))
                {
                    setLocation(120,308);
                    down = true;
                    if(leftFoot)
                    {
                        setImage("images/PlayerDownLeft.PNG");
                    }
                    else
                    {
                        setImage("images/PlayerDownRight.PNG");
                    }
                }
                else
                {
                    down = false;
                    setLocation(120,300);
                    if(jumpButton()&&!pressingJump)
                    {
                        setImage("images/PlayerJumping.png");
                        setLocation(120,295);
                        move(5);
                        jumpSpeed = 10;
                        isOnGround = false;
                        pressingJump = true;
                    }
                    else
                    {
                        if(!jumpButton())
                        {
                            pressingJump = false;
                        }
                        if(leftFoot)
                        {
                            setImage("images/PlayerDownLeft.PNG");
                        }
                        else 
                        {
                            setImage("images/PlayerDownRight.PNG");
                        }
                    }
                }
            }
            else 
            {
                jumpCounter++;
                if((pressingJump&&jumpButton() && jumpCounter <= 12) || jumpCounter < 8)
                {
                    move(6);
                }
                else
                {
                    jumpCounter = 10;
                    jumpSpeed--;
                    move(jumpSpeed);
                    if(getY() >= 295)
                    {
                        setLocation(120,300);
                        isOnGround = true;
                    }
                }
            }
            if(getOneIntersectingObject(Obstacle.class) != null && !Greenfoot.isKeyDown("a"))
            {
                getWorld().addObject(new Reset(), 120, 300);
                alive = false;
            }
            else 
            {
                alive = true;
            }
        }
            else 
            {
                getWorld().addObject(new Reset(), 0, 0);
            }
            if(!alive)
            {
                if(down)
                {
                    setImage("images/PlayerDownLeft.PNG");
                }
                else 
                {
                    setImage("images/PlayerDownRight.PNG");
                }
            }
        }
    
    public Dino() 
    {
        setImage("images/PlayerDownRight.PNG");
        setLocation(120, 300);
        setRotation(270);
    }
    private boolean jumpButton()
    {
        if( Greenfoot.isKeyDown("up") ||Greenfoot.isKeyDown("space") || Greenfoot.mousePressed(null))
        {
            return true;
        }
        if(pressed)
    {
        return true;
    }
    return false;
    }
    private void shooting()
    {
        if(shotTimer>0) {
            shotTimer = shotTimer -1;
        }
        else if(Greenfoot.isKeyDown("enter")) {
            getWorld().addObject(new Shot(this), getX(), getY());
            shotTimer = 200;
        }
    }
       public void shoot()
        {
         int xpos = getX() +2;
        if(xpos >= getWorld().getWidth()) {
            getWorld().removeObject(this);
        }
            else {
                setLocation(getY(), xpos); 
            }
    }
}
/*
private boolean jumpButton = true;  
private greenfoot img1;
private greenfoot img2;
private Dino myDino;
    
public boolean jumpButton()
{
    if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("space") || Greenfoot.mousePressed(null))
    {
        return true;
    }
    if(pressed)
    {
        return true;
    }
    return false;
}
public Dino() {
    img1 = new GreenfootImage("dino1. png");
    img1 = new GreenfootImage("dino2. png");
    setImage(img1);
}
public Shoot(Dino gameDino)
    {
        myDino = gameDino;
    }
 public void act()
    {
        int ypos = getY();
        if (ypos > 0){
            ypos = ypos;
            setLocation(getX(), ypos);
            Actor cactus = getOneIntersectingObject(Obstacle.class);
            if(cactus!=null) {
                hitAnCactus();
                getWorld().removeObject(cactus);
                getWorld().removeObject(myDino);
            }
        }
        if(Greenfoot.isKeyDown("space") || pressed) {
            shoot();
        }
    }
    public void shoot() {
        shoot rocks = new Shoot();
        getWorld().addObject(rock, getX(), getY());
    }
    public void hitAnCactus() {
        // when dino hits cactus
    }
}


/*
 * public void boolean jumpButton()
    {
        if(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("space") || Greenfoot.mousePressed(null))
        {
            return true;
        }
        if(pressed) {return true;
        {
        return false;
    }

    public void shoot()
    {
        if(Greenfoot.isKeyDown("right"))
            setLocation(getX() -5, getY());
            
        Actor present = getOneInterestingObject(Present.class);
        if(shoot!= null)
        {
            getWorld().started(Shoot.class);
        }
    }
   public void Shoot()
    {
        this.myDino = myDino;
    }
    
    public void act()
    {
        int ypos = getY();
        if (ypos > 0) {
            ypos = ypos;
            setLocation(getX(), ypos);
            Actor cactus = getOneIntersectingObject(obstacle.class);
            if(cactus!=null) {
                hitAnCactus();
                getWorld().removeObject(cactus);
                getWorld().removeObject(this);
            }
            else {
                getWorld().removeobject(this);
            }
        }
    }
}
*/
 
