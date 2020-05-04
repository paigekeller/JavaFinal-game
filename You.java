//Paige Keller
//Final Game You Class 

import javax.swing.*;
import java.awt.*;
public class You
{
    protected int x, y, diameter, speedX, speedY;
    protected Color c;
    public You(Color c, int x, int y, int speedX, int speedY, int diameter)
    {
        this.c = c;
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
        this.diameter = diameter;
    }

    public void colorChange(Color c)
    {
        this.c = c;
    }
    
    public void moveDown()
    {
        y += speedY;
    }

    public void moveUp()
    {
        y -= speedY;
    }

    public void moveLeft()
    {
        x -= speedX;
    }

    public void moveRight()
    {
        x += speedX;
    }

    public void draw(Graphics circle)
    {
        circle.setColor(c);
        circle.fillOval(x,y,diameter,diameter);
    }
    
    //keeps you from going off the screen
    public void stopMove(Panel p)
    {
         if (x <= 0)
        {
            x = 0;
        }
        if ( x >= p.getWidth()-diameter)
        {
            x = p.getWidth()-diameter;
        }

        if (y <= 0)
        {
            y = 0;
        }
        if (y >= p.getHeight()-diameter)
        {
            y = p.getHeight()-diameter;
        }
    }
    
    public int getX()
    {
        return x;
    }
    
        public int getY()
    {
        return y;
    }
    
    public int getDi()
    {
        return diameter;
    }
    
}