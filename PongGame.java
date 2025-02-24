import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PongGame extends JPanel implements MouseMotionListener{
        //Store width and height of drawing area
    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    private Ball gameBall;
    private Paddle userPaddle, pcPaddle;

    private int userScore, pcScore;

    private int userMouseY;
    private int bounceCount;

    /** 
     * Updates and draws all the graphics on the screen
    */
    public void paintComponent(Graphics g){
        
        //draw the background, set color to BLACK and fill in a rectangle
        g.setColor(Color.black);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        //draw the ball
        gameBall.paint(g);

        //draw the paddle
        userPaddle.paint(g);
        pcPaddle.paint(g);

        //update score
        g.setColor(Color.WHITE);
        //the drawstring method needs a String to print, and a location to print it
        g.drawString("Score - User [ " + userScore + " ] PC [ " + pcScore + " ]", 250, 20);
        
    }

    public PongGame(){
        gameBall = new Ball(300, 200, 3, 3, 5, Color.WHITE, 10);
        userPaddle = new Paddle(10, 200, 75, 3, Color.WHITE);
        pcPaddle = new Paddle(610, 200, 75, 3, Color.WHITE);
        userMouseY = 0;

        userScore = 0; pcScore = 0;

        //Listens for motion events on this object
        addMouseMotionListener(this);

    }

    public void reset(){

        //pause for a second
        try{
            Thread.sleep(1000);
        } catch(Exception e){
            e.printStackTrace();
        }

        //reset ball
        gameBall.setX(300);
        gameBall.setY(200);
        gameBall.setSpeed(3);
        gameBall.setCx(3);
        gameBall.setCy(3);
        bounceCount = 0;

    }

    /** 
     * Called once each frame to handle essential game operations
    */
    public void gameLogic(){

        //move the ball one frame
        gameBall.moveBall();

        //edge check/bounce
        gameBall.bounceoffEdges(0, WINDOW_HEIGHT);


        //user paddle movement
        userPaddle.moveTowards(userMouseY);

        //movement of PC paddle towards the ball y position
        pcPaddle.moveTowards(gameBall.getY());

        //Check collision and reverse direction if true
        if (userPaddle.checkCollision(gameBall) || pcPaddle.checkCollision(gameBall)){
            gameBall.reverseX();
            //increase bounceCount
            bounceCount++;
            }

        if (bounceCount == 5){
            //reset counter
            bounceCount = 0;
            //increase ball speed
            gameBall.increaseSpeed();
        }



        //check if someone lost
        if(gameBall.getX() < 0){
            //player has lost
            pcScore++;
            reset();
        }
        else if(gameBall.getX() > WINDOW_WIDTH){
            //pc has lost
            userScore++;
            reset();
        }


    }

        @Override
    public void mouseDragged(MouseEvent e){

    }

        @Override
    public void mouseMoved(MouseEvent e){

        userMouseY = e.getY();

    }

    /**
     * resets the game to start a new round
     */



}