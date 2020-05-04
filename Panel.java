//Paige Keller
//Final Game Panel


//import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class Panel extends JPanel
{ 
    protected int width, height;
    private int x = 10;
    protected int sco = 0;
    private int extra = 0;
    private int once = 1;
    private You u;
    private ArrayList<Virus> coronas = new ArrayList<Virus>();
    private ArrayList<Powerups> ups = new ArrayList<Powerups>();
    JLabel label, scoreLabel, directions, directions2, lose, urScore, Uwin, pic;
    JButton start;
    private Color c;
    public boolean begin = false;
    public boolean win = false;

    
    public Panel(Color c, int wi, int hi) 
    {
        this.c = c;
        width = wi;
        height = hi;
        this.setPreferredSize(new Dimension(wi,hi));
        //this.setBackground(c);
        u = new You(Color.BLACK,300,300,8,8,10);

        for (int i = 0; i < 7; i++)
        {
            coronas.add(new Virus());
        }
        ups.add(new Powerups());
        //one powerup at a time
        
        Uwin = new JLabel("You Won!");
        lose = new JLabel("You Lost!");
        urScore = new JLabel();
        urScore.setText("");
        label = new JLabel("Corona Run");
        directions2 = new JLabel("Get 10 Powerups To Win");
        directions = new JLabel("Avoid The Green Corona Viruses & Try To Collect The Pink Powerups");
        scoreLabel = new JLabel(0 + "");
        start = new JButton("Start!");
        setFocusable(true);
        start = new JButton("Start!");
        start.addActionListener(new MyFirstInnerClass());

        pic = new JLabel("SUBJECT ");
        pic.setIcon(new ImageIcon("corona.png"));
        
        addKeyListener(new MyKeyListener());
    }

    public void paintComponent(Graphics y)
    {
        //g.setColor(Color.CYAN);
        super.paintComponent(y);
         urScore.setVisible(false);
        lose.setVisible(false);
        Uwin.setVisible(false);
       
        if (once == 1)
        {
        
       
        add(pic);
        pic.setPreferredSize(new Dimension(575,575));
        pic.setLocation(-45,-32);
        
        add(label);
        label.setLocation(220,15);
        
        add(start);
        start.setLocation(400,50);
        
        add(directions);
        directions.setLocation(50,465);
        add(directions2);
        directions2.setLocation(185,481);
    }
          // while(againNum == 0)
        // {
            System.out.println("HERE" + once);
           /// begin = true;
        if (begin == true)
        {
            pic.setVisible(false);
            u.draw(y);
            u.stopMove(this);
            add(scoreLabel);
            scoreLabel.setLocation(20,10);
            ups.get(ups.size()-1).draw(y);
            directions.setVisible(false);
            directions2.setVisible(false);
            for (int i = 0; i < coronas.size(); i++)
            {
                coronas.get(i).draw(y);
                coronas.get(i).move();
                if(coronas.get(i).check(u) == true)
                {
                    begin = false;
                    extra = 1;
                    //againNum = 1;
                }
                if (sco == 10)
                {
                    begin = false;
                    extra = 2;
                    win = true;
                    //againNum = 1;
                }
                coronas.get(i).bounce(this);
            }

            x++;
            try
            {
                Thread.sleep(10);
            } catch (Exception e)
            {

            }
            repaint();
        }
        if( extra == 1 && win == false)
        {
            //LOSE
            add(lose);
            add(urScore);
            lose.setLocation(225,250);
            urScore.setLocation(200, 270);
            urScore.setText("Your Score Was: " + sco);
            lose.setVisible(true);
            urScore.setVisible(true);
            
            scoreLabel.setLocation(20,10);
        }
        if(extra == 2 && win == true)
        {
            //WIN
            add(Uwin);
            scoreLabel.setLocation(20,10);
            Uwin.setLocation(225,250);
            Uwin.setVisible(true);
            
           }

       // }
        
    }

    //start
    public class MyFirstInnerClass implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            start.setVisible(false);
            begin = true;
            
        }
    }
    
    
    //override get methods
    public int getHeight()
    {
        return height;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    // //playAgain
      // public class MySecondClass implements ActionListener
    // {
        // public void actionPerformed(ActionEvent e)
        // {
            // sco = 0;
            // playAgain.setVisible(false);
            // scoreLabel.setText(sco + "");
            // scoreLabel.setLocation(20,10);
            // lose.setVisible(false);
            // urScore.setVisible(false);
            // begin = true;
            // playAgainPress = true;
            
        // }
    // }

    //keys
     public class MyKeyListener extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {

            if (e.getKeyCode() == 40)
            {
                u.moveDown();
                if(u.getX() >= (ups.get(0).getX())-u.getDi() && u.getX() <= (ups.get(0).getXPlus()))
                {
                    if (u.getY() <= (ups.get(0).getYPlus()) && u.getY() >= (ups.get(0).getY()-u.getDi()))
                    {
                        ups.remove(0);
                        ups.add(new Powerups());
                        sco++;
                        scoreLabel.setText(sco + " ");
                    }
                    if (sco == 10)
                    {
                                            }
                }
            }
            if (e.getKeyCode() == 38)
            {
                u.moveUp(); 
                if(u.getX() >= (ups.get(0).getX())-u.getDi() && u.getX() <= (ups.get(0).getXPlus()))
                {
                    if (u.getY() <= (ups.get(0).getYPlus()) && u.getY() >= (ups.get(0).getY()-u.getDi()))
                    {
                        ups.remove(0);
                        ups.add(new Powerups());
                        sco++;
                        scoreLabel.setText(sco + " ");
                    }
                }
            }
            if (e.getKeyCode() == 39)
            {
                u.moveRight(); 
                if(u.getX() >= (ups.get(0).getX())-u.getDi() && u.getX() <= (ups.get(0).getXPlus()))
                {
                    if (u.getY() <= (ups.get(0).getYPlus()) && u.getY() >= (ups.get(0).getY()-u.getDi()))
                    {
                        ups.remove(0);
                        ups.add(new Powerups());
                        sco++;
                        scoreLabel.setText(sco + " ");
                    }
                }
            }
            if (e.getKeyCode() == 37)
            {
                u.moveLeft(); 
                if(u.getX() >= (ups.get(0).getX())-u.getDi() && u.getX() <= (ups.get(0).getXPlus()))
                {
                    if (u.getY() <= (ups.get(0).getYPlus()) && u.getY() >= (ups.get(0).getY()-u.getDi()))
                    {
                        ups.remove(0);
                        ups.add(new Powerups());
                        sco++;
                        scoreLabel.setText(sco + " ");
                    }
                }
            }

        }
    }

}

