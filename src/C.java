import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class C extends JFrame implements ActionListener {
    JLabel l;
    JRadioButton jb[]=new JRadioButton[5];
    JButton b1,b2;
    ButtonGroup bg;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];
    C(String s)
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
            l.setText("Que1: Who invented C Language ?");
            jb[0].setText("Babbage");jb[1].setText("Grahambel");jb[2].setText("Ritchie");jb[3].setText("Steve Jobs");
        }
        if(current==1)
        {
            l.setText("Que2: C is a which level language?");
            jb[0].setText("Low Level");jb[1].setText("High Level");jb[2].setText("Both");jb[3].setText("None");
        }
        if(current==2)
        {
            l.setText("Que3:  Low level language is a ?");
            jb[0].setText("Human readable like language");jb[1].setText("language with big program size");jb[2].setText("language with small program size");jb[3].setText("Difficult to understand and readability is questionable");
        }
        if(current==3)
        {
            l.setText("Que4: C language was invented to develop which Operating System ?");
            jb[0].setText("Android");jb[1].setText("Linux");jb[2].setText("Ubuntu");jb[3].setText("Unix");
        }
        if(current==4)
        {
            l.setText("Que5: C language is used in the development of ?");
            jb[0].setText("Databases");jb[1].setText("Graphic applications");jb[2].setText("Word Processors");jb[3].setText("All of the above");
        }
        if(current==5)
        {
            l.setText("Que6: A C program is a combination of ?");
            jb[0].setText("Statements");jb[1].setText("Functions");jb[2].setText("Variables");jb[3].setText("All of the above");
        }
        if(current==6)
        {
            l.setText("Que7: What is an Identifier in C Language.? ");
            jb[0].setText("Name of a Function or Variable");jb[1].setText("Name of a Macros");jb[2].setText("Name of Structure or Union");
            jb[3].setText("All the above.");
        }
        if(current==7)
        {
            l.setText("Que8: A C variable name can start with a ____ ?");
            jb[0].setText("Number");jb[1].setText("Plus Sign");jb[2].setText("Underscore");
            jb[3].setText("Asterisk ");
        }
        if(current==8)
        {
            l.setText("Que9: Find an integer constant?");
            jb[0].setText("3.145");jb[1].setText("34");jb[2].setText("'125'");jb[3].setText("None of the above");
        }
        if(current==9)
        {
            l.setText("Que10: Operator % in C Language is called ?");
            jb[0].setText("Percentage Operator");jb[1].setText("Quotient Operator");jb[2].setText("Modulus");
            jb[3].setText("Division");
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
            return(jb[1].isSelected());
        if(current==2)
            return(jb[3].isSelected());
        if(current==3)
            return(jb[3].isSelected());
        if(current==4)
            return(jb[3].isSelected());
        if(current==5)
            return(jb[3].isSelected());
        if(current==6)
            return(jb[3].isSelected());
        if(current==7)
            return(jb[2].isSelected());
        if(current==8)
            return(jb[1].isSelected());
        if(current==9)
            return(jb[2].isSelected());
        return false;
    }
}
