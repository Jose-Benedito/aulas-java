/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreak;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author bene
 */
public class GamePlay extends JPanel implements KeyListener, ActionListener{
    private boolean play = false;
    private int score = 0;
    private int totalBricks = 21;
    private Timer timer;
    private int delay = 0;
    private int playerx = 310;
    private int ballposx = 120;
    private int ballposy = 350;
    private int ballxDir = -1;
    private int ballyDir = -2;
    
    private MapGerador map;
    //Construtor
    public GamePlay(){
        map = new MapGerador(3,7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
        
    }
    public void paint(Graphics g){
        //Fundo
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);
        // desenha map
        map.desenha((Graphics2D)g);
        //bordas
        g.setColor(Color.yellow);
        g.fillRect(0,0,3, 592);
        g.fillRect(0,0,692, 3);
        g.fillRect(691,0,3, 592);
        //scores
        g.setColor(Color. white);
        g.setFont(new Font("serif",Font.BOLD, 25));
        g.drawString(""+score, 590, 30);
        //the paddle
        g.setColor(Color.GREEN);
        g.fillRect(playerx, 550,100, 8);
        
        // A bola
        g.setColor(Color.YELLOW);
        g.fillOval(ballposx,ballposy,20, 20);
        
        if(totalBricks <= 0){
             play = false;
            ballxDir = 0;
            ballyDir = 0;
            
            g.setColor(Color.red);
            g.setFont(new Font("serif",Font.BOLD, 30));
            g.drawString("You win!:", 260, 300);
            
            g.setFont(new Font("serif",Font.BOLD, 30));
            g.drawString("Press Enter to Restart ", 230, 350);
            
            
        }
        
        if(ballposy > 570){
            play = false;
            ballxDir = 0;
            ballyDir = 0;
            
            g.setColor(Color.red);
            g.setFont(new Font("serif",Font.BOLD, 30));
            g.drawString("Game Over, Scores: ", 190, 300);
            
            g.setFont(new Font("serif",Font.BOLD, 30));
            g.drawString("Press Enter to Restart ", 230, 350);
            
        }
        g.dispose();
        
    } 
    @Override
    public void actionPerformed(ActionEvent ae) {
        timer.start();
        if(play){
            if(new Rectangle(ballposx, ballposy,20, 20).intersects(new Rectangle(playerx, 550,100,8))){
            ballyDir = -ballyDir;
        }
        A: for(int i = 0; i<map.map.length; i++){
            for(int j = 0; j<map.map[0].length; j++){
                if(map.map[i][j] > 0){
                    int brickx = j * map.brickWidth + 80;
                    int bricky = i * map.brickHeight + 50;
                    int brickWidth = map.brickWidth;
                    int brichHeight = map.brickHeight;
                    
                    Rectangle rect = new Rectangle(brickx,bricky);
                    Rectangle ballrect = new Rectangle(ballposx, ballposy, 20, 20);
                    Rectangle brickRect = rect;
                    
                    if(ballrect.intersects(brickRect)){
                        map.setBrickValue(0, i, j);
                        totalBricks --;
                        score += 5;
                        
                    if(ballposx + 19 <= brickRect.x || ballposx + 1 >= brickRect.x + brickRect.width){
                        ballxDir = - ballxDir;
                     
                    }else{
                        ballyDir = - ballyDir;
                    } 
                     break A;
                    }
                }
                
            }
        }    
            ballposx = ballposx+ballxDir;
            ballposy = ballposy+ ballyDir;
            if(ballposx <0){
                ballxDir = -ballxDir;
            }
            if(ballposy <0){
                ballyDir = -ballyDir;
        }
            if(ballposx >670){
                ballxDir = -ballxDir;
             
        }
           
         
     }
        repaint();
    }
    @Override
    public void keyTyped(KeyEvent ke) {
    } 
    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode()== KeyEvent.VK_RIGHT){
            if(playerx >=598){
                playerx = 580;
            }else {
                moveRight();
            }
            
        }
        if(ke.getKeyCode()==KeyEvent.VK_LEFT){
             if(playerx <=0){
                playerx =10;
            }else {
                moveLeft();
            }
        }
        if(ke.getKeyCode() == KeyEvent.VK_ENTER){
            if(!play){
                play = true;
                ballposx = 120;
                ballposy = 350;
                ballxDir = -1;
                ballyDir = -2;
                playerx = 310;
                score = 0;
                totalBricks = 21;
                map = new MapGerador(3,7);
                
                repaint();
            }
        }
    }
    public void moveRight(){
        play = true;
        playerx += 20;
    }
    public void moveLeft(){
        play = true;
        playerx -= 20;
    }

   

   
}
