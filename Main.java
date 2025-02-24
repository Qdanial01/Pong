import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    //declare and initialize frame
    static JFrame f = new JFrame("Pong");

    public static void main(String[] args) {

            //Program exits on close button click
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            //Size of game set to 480x640, JFrame size need to be slightly larger
        f.setSize(650,495);

            //make the new PongGame
        PongGame game = new PongGame();

        //add the game to JFrame
        f.add(game);

        //show the window
        f.setVisible(true);

        //Timer
        Timer timer = new Timer(33, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                //game logic
                game.gameLogic();
                
                //repaint the screen
                game.repaint();

            }
        });

        //Start timer once created
        timer.start();

    }

}
