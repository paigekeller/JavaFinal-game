//Paige Keller
//Corona Virus Class

import java.lang.Object;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Virus
{
    protected int x, y, diameter, speedX, speedY;
    protected Color c;  
    private Color grey = new Color(211,211,211);
    
    public Virus(Color c, int x, int y, int speedX, int speedY, int diameter)
    {
        this.c = c;
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
        this.diameter = diameter;
    }

    public Virus()
    {
        x = (int)(Math.random()*400 + 2);
        y = (int)(Math.random()*400 + 2);
        diameter = (int)(Math.random()*20 + 12); 
        speedX = (int)(Math.random()*2 + 1);
        speedY = (int)(Math.random()*2 + 1);
        c = Color.GREEN;
    }

    public void move()
    {
        x += speedX;
        y += speedY;
    }

    public void draw(Graphics circle)
    {
        circle.setColor(c);
        circle.fillOval(x,y,diameter,diameter);
    }
    
    public boolean check(You u)
    {
        if (u.getX() >= x && u.getX()+u.getDi() <= x + diameter)
        {
            if (u.getY()+u.getDi() >= y && u.getY() <= y + diameter)
            {
                return true;
            }
        }
        return false;
    }

    public void bounce(Panel p)
    {
        if (x <= 0 || x >= p.getWidth()-diameter)
        {
            speedX *= -1;
        }

        if (y <= 0 || y >= p.getHeight()-diameter)
        {
            speedY *= -1;
        }
    }

    public void portal(Panel p)
    {
        if (x<= 0)
        {
            x = p.getWidth();

        }
        if (x >= p.getWidth())
        {
            x = 0;

        }
        if(y>= p.getHeight())
        {
            y = 0;
        }
        if (y<=0)
        {
            y = p.getHeight();
        }
    }
}