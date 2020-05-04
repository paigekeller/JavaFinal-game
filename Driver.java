//Paige Keller
//Driver Class

import java.util.*;
import javax.swing.*;
import java.awt.*;
public class Driver
{
    public static void main (String[] args)
    {
        Color grey = new Color(211,211,211);
        JFrame frame1 = new JFrame();
        Panel p1 = new Panel(grey, 500,500);
        p1.setPreferredSize(new Dimension(500,500));

        frame1.setPreferredSize(new Dimension(500,500));
        frame1.add(p1);
        frame1.pack();
        frame1.setVisible(true);
    }
}