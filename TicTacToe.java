/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class TicTacToe
{
    private JFrame frame=new JFrame("Tic Tac Toe");
    private JPanel[] panels=new JPanel[3];
    private JLabel message=new JLabel("First player turn...");
    private JButton[] buttons=new JButton[9];
    private JButton reset=new JButton("RESET");
    private Class cls=getClass();
    private ImageIcon icon1=new ImageIcon(cls.getResource("user1.png"));
    private ImageIcon icon2=new ImageIcon(cls.getResource("user2.png"));
    private int player=1;
    AudioClip clip1=Applet.newAudioClip(cls.getResource("s4.wav"));
    AudioClip clip2=Applet.newAudioClip(cls.getResource("intro.mid"));
    AudioClip clip3=Applet.newAudioClip(cls.getResource("s3.wav"));
    
    private int count=0;
    private boolean winnerFound=false;
    
    
    public TicTacToe()
    {
        frame.setSize(500,610);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Color color=new Color(255,0,0);
        frame.getContentPane().setBackground(new Color(128,128,0));
        //frame.getContentPane().setBackground(color);
        frame.setLayout(null);
        addPanels();
        clip2.loop();
        frame.setVisible(true);
    }
    
    private void addPanels()
    {
        for(int i=0;i<3;i++)
        {
            panels[i]=new JPanel();
            frame.add(panels[i]);
        }
        panels[0].setBounds(50,20,400,40);
        panels[1].setBounds(50,90,400,400);
        panels[2].setBounds(50,520,400,40);
        addLabels();
    }
    
    private void addLabels()
    {
        panels[0].add(message);
        message.setFont(new Font("elephant",Font.PLAIN,25));
        message.setForeground(Color.BLUE);
        panels[0].setBackground(Color.CYAN);
        addButtons();
    }
    
    private void addButtons()
    {
        panels[1].setLayout(new GridLayout(3,3));
        TicListener listener=new TicListener();
        for(int i=0;i<9;i++)
        {
            buttons[i]=new JButton();
            buttons[i].addActionListener(listener);
            panels[1].add(buttons[i]);
//            buttons[i].setBackground(new Color(249,234,241));
            buttons[i].setBackground(new Color(233,150,122));
        }
        addResetButton();
    }
    
    private void addResetButton()
    {
        panels[2].add(reset);
        panels[2].setOpaque(false);
        reset.setFont(new Font("arial",Font.PLAIN,18));
        reset.addActionListener(new ResetListener());
        reset.setEnabled(true);
    }
    
    class TicListener implements ActionListener
    {
    public void actionPerformed(ActionEvent event)
    {
        JButton bb=(JButton)event.getSource();
        if(bb.getIcon()!=null || winnerFound)
        {
        clip1.play();
            JOptionPane.showMessageDialog(frame,"Don't click");
            return;//terminates method
        }
        
        if(player==1)
        {
            bb.setIcon(icon1);
            message.setText("Second player turn...");
            player=2;
        }
        else if(player==2)
        {
            bb.setIcon(icon2);
            message.setText("First player turn...");
            player=1;
        }
        findWinner();
        count++;
        if(count==9 && !winnerFound)
        {
            gameOver();
            JOptionPane.showMessageDialog(frame,"No one is winner");
        }
           clip3.play();
        }
    }
    
//    changed
    private void findWinner()
    {
        //First row
        if(buttons[0].getIcon()==icon1 && buttons[1].getIcon()==icon1 && buttons[2].getIcon()==icon1)
        announceWinner(0,1,2);
        else if(buttons[0].getIcon()==icon2 && buttons[1].getIcon()==icon2 && buttons[2].getIcon()==icon2)
        announceWinner(0,1,2);
        //Second row
        else if(buttons[3].getIcon()==icon1 && buttons[4].getIcon()==icon1 && buttons[5].getIcon()==icon1)
        announceWinner(3,4,5);
        else if(buttons[3].getIcon()==icon2 && buttons[4].getIcon()==icon2 && buttons[5].getIcon()==icon2)
        announceWinner(3,4,5);
        //Third row
        else if(buttons[6].getIcon()==icon1 && buttons[7].getIcon()==icon1 && buttons[8].getIcon()==icon1)
        announceWinner(6,7,8);
        else if(buttons[6].getIcon()==icon2 && buttons[7].getIcon()==icon2 && buttons[8].getIcon()==icon2)
        announceWinner(6,7,8);
        //First column
        else if(buttons[0].getIcon()==icon1 && buttons[3].getIcon()==icon1 && buttons[6].getIcon()==icon1)
        announceWinner(0,3,6);
        else if(buttons[0].getIcon()==icon2 && buttons[3].getIcon()==icon2 && buttons[6].getIcon()==icon2)
        announceWinner(0,3,6);
        //Second column
        else if(buttons[1].getIcon()==icon1 && buttons[4].getIcon()==icon1 && buttons[7].getIcon()==icon1)
        announceWinner(1,4,7);
        else if(buttons[1].getIcon()==icon2 && buttons[4].getIcon()==icon2 && buttons[7].getIcon()==icon2)
        announceWinner(1,4,7);
        //Third column
        else if(buttons[2].getIcon()==icon1 && buttons[5].getIcon()==icon1 && buttons[8].getIcon()==icon1)
        announceWinner(2,5,8);
        else if(buttons[2].getIcon()==icon2 && buttons[5].getIcon()==icon2 && buttons[8].getIcon()==icon2)
        announceWinner(2,5,8);
        //first diagonal
        else if(buttons[0].getIcon()==icon1 && buttons[4].getIcon()==icon1 && buttons[8].getIcon()==icon1)
        announceWinner(0,4,8);
        else if(buttons[0].getIcon()==icon2 && buttons[4].getIcon()==icon2 && buttons[8].getIcon()==icon2)
        announceWinner(0,4,8);
        //Second diagonal
        else if(buttons[2].getIcon()==icon1 && buttons[4].getIcon()==icon1 && buttons[6].getIcon()==icon1)
        announceWinner(2,4,6);
        else if(buttons[2].getIcon()==icon2 && buttons[4].getIcon()==icon2 && buttons[6].getIcon()==icon2)
        announceWinner(2,4,6);

    }//end of findWinner
    
    private void announceWinner(int i,int j,int k)
    {
//        winnerFound=true;
//        gameOver();
//        buttons[i].setBackground(Color.green);
//        buttons[j].setBackground(Color.green);
//        buttons[k].setBackground(Color.green);
//        if(player==2)
//        JOptionPane.showMessageDialog(frame,"First player is winner");
//        else
//        JOptionPane.showMessageDialog(frame,"Second player is winner");
        
        
        winnerFound = true;
        gameOver();
            buttons[i].setBackground(new Color(255,215,0));
            buttons[j].setBackground(new Color(255,215,0));
            buttons[k].setBackground(new Color(255,215,0));
//        buttons[i].setBackground(Color.GREEN);
//        buttons[j].setBackground(Color.GREEN);
//        buttons[k].setBackground(Color.GREEN);

        // Apply winning animation (example: enlarge the icons)
        buttons[i].setIcon(resizeIcon(icon1, 64, 64));
        buttons[j].setIcon(resizeIcon(icon1, 64, 64));
        buttons[k].setIcon(resizeIcon(icon1, 64, 64));

        if (player == 2)
        {
            JOptionPane.showMessageDialog(frame, "Player 1 is the winner!");
        } 
        else
        {
            JOptionPane.showMessageDialog(frame, "Player 2 is the winner!");
        }
    }
    
    // Helper method to resize ImageIcon
    private ImageIcon resizeIcon(ImageIcon icon, int width, int height) 
    {
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
    
    private void gameOver()
    {
        message.setText("Game is over...");
        message.setForeground(Color.green);
        panels[0].setBackground(Color.red);
        reset.setEnabled(true);

    }
    
    
    class ResetListener implements ActionListener
    {
        public void actionPerformed(ActionEvent evt)
        {
            for(int i=0;i<9;i++)
            {
                buttons[i].setBackground(new Color(233,150,122));
                buttons[i].setIcon(null);
            }
            
            message.setText("First player turn...");
            message.setForeground(Color.blue);
            panels[0].setBackground(Color.cyan);
            player=1;
            count=0;
            winnerFound=false;
            reset.setEnabled(false);
        }
    }
    
    
    public static void main(String[] abc)
    {
        new TicTacToe();
    }
}
 
