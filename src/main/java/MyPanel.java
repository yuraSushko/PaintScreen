import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class MyPanel extends JPanel {
    private List<PixelPoint> locations;
    private KeyListener keyListener;
    private Rectangle player;
    public static final int PLAYER_WIDTH=20;
    public static final int PLAYER_HIEGHT=20;

    public MyPanel(){
        this.setVisible(true);
        this.setBounds(0,0,800,600);
        this.locations= new ArrayList<>();
        this.player= new Rectangle(0,0,PLAYER_WIDTH,PLAYER_HIEGHT);
        this.locations.add(new PixelPoint(0,0));
        this.setFocusable(true);
        this.requestFocus();
        this.keyListener= keyListenerCreate();

        this.addKeyListener(this.keyListener);
        this.setFocusable(true);
        this.requestFocus();


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(player.x,player.y,player.width,player.height);
        for(PixelPoint loc : locations){
            g.fillRect(loc.getX(),loc.getY(),PLAYER_WIDTH,PLAYER_HIEGHT);
        }
    }





    public KeyListener keyListenerCreate(){

        return new KeyListener() {
            public void keyTyped(KeyEvent e) { }
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        player.setBounds(player.x,player.y-PLAYER_HIEGHT,PLAYER_WIDTH,PLAYER_HIEGHT);
                        locations.add(new PixelPoint( player.x,player.y));
                        //System.out.println(locations);
                        break;
                    case KeyEvent.VK_DOWN:
                        player.setBounds(player.x,player.y+PLAYER_HIEGHT,PLAYER_WIDTH,PLAYER_HIEGHT);
                        locations.add(new PixelPoint( player.x,player.y));
                       // System.out.println(locations);
                        break;

                    case KeyEvent.VK_LEFT:
                        player.setBounds(player.x-PLAYER_WIDTH,player.y,PLAYER_WIDTH,PLAYER_HIEGHT);
                        locations.add(new PixelPoint( player.x,player.y));
                       // System.out.println(locations);
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.setBounds(player.x+PLAYER_WIDTH,player.y,PLAYER_WIDTH,PLAYER_HIEGHT);
                        locations.add(new PixelPoint( player.x,player.y));
                      //  System.out.println(locations);
                        break;
                }
                repaint();
            }

            public void keyReleased(KeyEvent e) {
                System.out.println(1);
            }
        };


    }




}
