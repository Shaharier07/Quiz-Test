import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPlus extends JFrame implements ActionListener {
    JLabel l;
    JRadioButton jb[]=new JRadioButton[5];
    JButton b1,b2;
    ButtonGroup bg;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];
    CPlus(String s)
    {
        super(s);
        l=new JLabel();
        add(l);
        bg=new ButtonGroup();
        for(int i=0;i<5;i++)
        {
            jb[i]=new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1=new JButton("Next");
        b2=new JButton("Skip");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);add(b2);
        set();
        l.setBounds(30,40,450,20);
        jb[0].setBounds(50,80,100,20);
        jb[1].setBounds(50,110,100,20);
        jb[2].setBounds(50,140,100,20);
        jb[3].setBounds(50,170,100,20);
        b1.setBounds(100,240,100,30);
        b2.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            if(check())
                count=count+1;
            current++;
            set();
            if(current==9)
            {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if(e.getActionCommand().equals("Skip"))
        {
            JButton bk=new JButton("Skip"+x);
            bk.setBounds(480,20+30*x,100,30);
            add(bk);
            bk.addActionListener(this);
            m[x]=current;
            x++;
            current++;
            set();
            if(current==9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for(int i=0,y=1;i<x;i++,y++)
        {
            if(e.getActionCommand().equals("Skip"+y))
            {
                if(check())
                    count=count+1;
                now=current;
                current=m[y];
                set();
                ((JButton)e.getSource()).setEnabled(false);
                current=now;
            }
        }

        if(e.getActionCommand().equals("Result"))
        {
            if(check())
                count=count+1;
            current++;
            //System.out.println("correct ans="+count);
            JOptionPane.showMessageDialog(this,"correct ans="+count);
            new OnlineTest.Fp("Choose any one");
        }
    }
    void set()
    {
        jb[4].setSelected(true);
        if(current==0)
        {
            l.setText("Que1: Which of the following gives the 4th element of the array?");
            jb[0].setText("Array[0]");jb[1].setText("Array[1]");jb[2].setText("Array[3]");jb[3].setText("Array[8]");
        }
        if(current==1)
        {
            l.setText("Que2: Which type of memory is used by an Array in C++?");
            jb[0].setText("Contiguous");jb[1].setText("None-contiguous");jb[2].setText("Both A and B");jb[3].setText("Not mentioned");
        }
        if(current==2)
        {
            l.setText("Que3: What did we call an array of the one-dimensional array?");
            jb[0].setText("Single Dimensional array");jb[1].setText("Multi-Dimensional array");jb[2].setText("2D Array");jb[3].setText("Both A and B");
        }
        if(current==3)
        {
            l.setText("Que4: Which types of arrays are always considered as linear arrays?");
            jb[0].setText("Single-dimensional");jb[1].setText("Multi-dimensional");jb[2].setText("Both A and B");jb[3].setText("None of the above");
        }
        if(current==4)
        {
            l.setText("Que5: What is size of int data type in cpp??");
            jb[0].setText("2 Bytes");jb[1].setText("1 Bytes");jb[2].setText("4 Bytes");jb[3].setText("Depends on Compiler");
        }
        if(current==5)
        {
            l.setText("Que6: Which one cannot be used with the virtual keyword?");
            jb[0].setText("Constructor");jb[1].setText("Destructor");jb[2].setText("Member function");jb[3].setText("None");
        }
        if(current==6)
        {
            l.setText("Que7: Which of the following is not a kind of inheritance? ");
            jb[0].setText("Multiple");jb[1].setText("Distributed");jb[2].setText("Multi-level");
            jb[3].setText("Hierarchal");
        }
        if(current==7)
        {
            l.setText("Que8: Which type of approach is used by the C++ language?");
            jb[0].setText("Right to left");jb[1].setText("Left to right");jb[2].setText("Top to bottom");
            jb[3].setText("Bottom-up");
        }
        if(current==8)
        {
            l.setText("Que9: Which is using a specific class object into other classes?");
            jb[0].setText("Polymorphism");jb[1].setText("Abstraction");jb[2].setText("Inheritance");jb[3].setText("Composition");
        }
        if(current==9)
        {
            l.setText("Que10: Which one of the following cannot be a friend in C++ languages?");
            jb[0].setText("A Class");jb[1].setText("A Function");jb[2].setText("An Object");
            jb[3].setText("None of the above");
        }
        l.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90;i+=30,j++)
            jb[j].setBounds(50,80+i,400,20);
    }
    boolean check()
    {
        if(current==0)
            return(jb[2].isSelected());
        if(current==1)
            return(jb[0].isSelected());
        if(current==2)
            return(jb[2].isSelected());
        if(current==3)
            return(jb[0].isSelected());
        if(current==4)
            return(jb[3].isSelected());
        if(current==5)
            return(jb[0].isSelected());
        if(current==6)
            return(jb[1].isSelected());
        if(current==7)
            return(jb[3].isSelected());
        if(current==8)
            return(jb[3].isSelected());
        if(current==9)
            return(jb[2].isSelected());
        return false;
    }
}
