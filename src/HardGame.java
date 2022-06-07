
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Rumeysa's Monster
 */
public class HardGame extends javax.swing.JPanel implements ActionListener, KeyListener {

    /**
     * Creates new form GamePanel
     */
    /*public GamePanel() {
        initComponents();
    }*/
    Timer timer = new Timer(10, this);
    private Chicken chicken = new Chicken(330, 0);
    private BufferedImage Icat, Ichicken, Iegg, Iobject, Iobject2, backGroundI, backgroundI2, backgroundI3;
    private ArrayList<EggFire> fire = new ArrayList<EggFire>();
    private ArrayList<EggFire> fireball = new ArrayList<EggFire>();

    private EggFire varT1, Left, varT2, Right;

    private TargetMovement target = new TargetMovement(300);

    private TargetMovement secondTarget = new TargetMovement(700, 1);

    private int score = 0;
    private int level = 1;
    private int targetN = 8;
    private int shoot = 0, shoot_s = 0;

    Random rand = new Random();
    Random rand1 = new Random();
    private int total = 0;
    private Enemy enemyCat = new Enemy(490, 380);

    private Enemy secondEnemy = new Enemy(280, 250);

    private boolean controlPoint = false;
    private Enemy enemyL = new Enemy(-800, -800);

    public boolean collisionC() {
        for (EggFire f : fire) {
            if (new Rectangle(f.getX(), f.getY(), 42, 41).intersects(new Rectangle(target.getX(), target.getY(), 51, 45))) {
                varT1 = f;
                return true;

            }
        }
        return false;
    }

    public boolean collisionC_sec() {
        for (EggFire f : fireball) {
            if (new Rectangle(f.getX(), f.getY(), 42, 41).intersects(new Rectangle(secondTarget.getX(), secondTarget.getY(), 51, 45))) {
                varT2 = f;
                return true;
            }
        }
        return false;
    }

    public boolean enemyCollision(Enemy enemy) {
        return new Rectangle(chicken.get1(), chicken.get2(), 40, 80).intersects(new Rectangle(enemy.getX(), enemy.getY(), 46, 60));
    }

    public boolean doubleCollision() {
        for (EggFire f : fire) {
            if (new Rectangle(f.getX(), f.getY(), 42, 41).intersects(new Rectangle(target.getX(), target.getY(), 80, 74))) {
                Left = f;
                return true;
            }
        }
        return false;
    }

    public boolean doubleCollisionC() {
        for (EggFire f : fireball) {
            if (new Rectangle(f.getX(), f.getY(), 42, 41).intersects(new Rectangle(secondTarget.getX(), secondTarget.getY(), 80, 74))) {
                Right = f;
                return true;
            }
        }
        return false;
    }

    public HardGame() {
        try {
            backGroundI = ImageIO.read(new FileImageInputStream(new File("C:\\Users\\Rumeysa\\Desktop\\desk\\ChickenGame\\src\\farmBackground.jpg")));
            backgroundI2 = ImageIO.read(new FileImageInputStream(new File("C:\\Users\\Rumeysa\\Desktop\\desk\\ChickenGame\\src\\sky.png")));
            backgroundI3 = ImageIO.read(new FileImageInputStream(new File("C:\\Users\\Rumeysa\\Desktop\\desk\\ChickenGame\\src\\volcano.jpg")));
            Icat = ImageIO.read(new FileImageInputStream(new File("C:\\Users\\Rumeysa\\Desktop\\desk\\ChickenGame\\src\\catEnemy.png")));
            Iegg = ImageIO.read(new FileImageInputStream(new File("C:\\Users\\Rumeysa\\Desktop\\desk\\ChickenGame\\src\\fire.jpeg")));
            Iobject = ImageIO.read(new FileImageInputStream(new File("C:\\Users\\Rumeysa\\Desktop\\desk\\ChickenGame\\src\\shoot.png")));
            Iobject2 = ImageIO.read(new FileImageInputStream(new File("C:\\Users\\Rumeysa\\Desktop\\desk\\ChickenGame\\src\\shoot2.png")));
            Ichicken = ImageIO.read(new FileImageInputStream(new File("C:\\Users\\Rumeysa\\Desktop\\desk\\ChickenGame\\src\\chicken.jpg")));
        } catch (IOException e) {
            
             String message = "IMAGES NOT FOUND PLS BE SURE THE IMAGES IN YOUR COMPUTER";
            JOptionPane.showMessageDialog(this, message);
            System.exit(0);

        }
        setBackground(Color.black);
        timer.start();
    }

    @Override
    public void paint(Graphics graph) {
        super.paint(graph);
        if (level == 1) {
            graph.drawImage(backGroundI, 0, -140, backGroundI.getWidth(), 2 * backGroundI.getHeight(), this);
        }
        //graph.setColor(Color.BLACK);
        if (level == 2) {
            graph.drawImage(backgroundI2, 0, 0, this);
        }
        if (level == 3) {
            graph.drawImage(backgroundI3, 0, 0, this);
        }
        graph.drawString("SCORE: " + score, 10, 15);
        graph.drawString("LEVEL: " + level, 10, 30);
        graph.drawString("TIME: " + timer.getDelay(), 10, 45);
        if (shoot == 3) {
            graph.drawString("COMBO X3 LEFT", 200, 15);
        }
        if (shoot_s == 3) {
            graph.drawString("COMBO X3 RIGHT", 300, 15);
        }

        fire.stream().map(f -> {
            if (f.getX() < 0) {
                fire.remove(f);
            }
            return f;
        }).filter(_item -> (chicken.get2() >= 590)).forEachOrdered(_item -> {
            fire.forEach(ff -> {
                fire.remove(ff);
            });
        });
        fireball.stream().map(f -> {
            if (f.getX() > 800) {
                fireball.remove(f);
            }
            return f;
        }).filter(_item -> (chicken.get2() >= 590)).forEachOrdered(_item -> {
            fireball.forEach(ff -> {
                fireball.remove(ff);
            });
        });
        graph.drawImage(Ichicken, chicken.get1(), chicken.get2(), 2 * Ichicken.getWidth() / 3, 2 * Ichicken.getHeight() / 3, this);
        if (shoot == 3) {
            graph.drawImage(Iobject, target.getX(), target.getY(), Iobject.getWidth() / 4, Iobject.getHeight() / 4, this);

        } else {
            graph.drawImage(Iobject, target.getX(), target.getY(), Iobject.getWidth() / 2, Iobject.getHeight() / 2, this);
        }
        if (shoot_s == 3) {
            graph.drawImage(Iobject2, secondTarget.getX(), secondTarget.getY(), Iobject2.getWidth() / 4, Iobject2.getHeight() / 4, this);

        } else {
            graph.drawImage(Iobject2, secondTarget.getX(), secondTarget.getY(), Iobject2.getWidth() / 3, Iobject2.getHeight() / 3, this);
        }

        for (EggFire f : fire) {
            graph.drawImage(Iegg, f.getX(), f.getY(), Iegg.getWidth() / 5, Iegg.getHeight() / 5, this);
        }
        for (EggFire f : fireball) {
            graph.drawImage(Iegg, f.getX(), f.getY(), Iegg.getWidth() / 5, Iegg.getHeight() / 5, this);
        }
        graph.drawImage(Icat, enemyCat.getX(), enemyCat.getY(), Icat.getWidth() / 11, Icat.getHeight() / 11, this);
        graph.drawImage(Icat, secondEnemy.getX(), secondEnemy.getY(), Icat.getWidth() / -8, Icat.getHeight() / 8, this);

        if (controlPoint) {
            graph.drawImage(Icat, enemyL.getX(), enemyL.getY(), Icat.getWidth() / 10, Icat.getHeight() / 10, this);
        }
        if (level == 1 && score >= 500) {
            timer.stop();
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(this, "First level completed\nScore: " + score );
            
            total += score;
            score = 0;
            shoot = 0;
            shoot_s = 0;
            level++;
            targetN = 9;
            chicken.set1(600);
            chicken.move2 = 4;
            chicken.move1 = 8;

            timer.start();
        }
        if (level == 2 && score >= 800) {
            timer.stop();
            String message = "Second level completed\nScore: " + score ;
            total += score;
            score = 0;
            shoot = 0;
            shoot_s = 0;
            JOptionPane.showMessageDialog(this, message);

            targetN = 10;
            level++;
            chicken.set2(600);
            EggFire.ActionX = 8;
            chicken.move2 = 3;
            controlPoint = true;

            timer.start();

        }
        if (level == 3 && score >= 1000) {
            timer.stop();
            total += score;
            String message = "Third level completed\nScore: " + score + "\nTotal score is " + total;
            JOptionPane.showMessageDialog(this, message);
            controlPoint = false;
            System.exit(0);

        }
        if (enemyCollision(enemyCat) || enemyCollision(enemyL) || enemyCollision(secondEnemy)) {
            timer.stop();
            score = 0;
            shoot = 0;
            shoot_s = 0;
            switch (level) {
                case 1:
                    targetN = 5;
                    break;
                case 2:
                    targetN = 5;
                    break;
                case 3:
                    targetN = 8;
                    break;
                default:
                    break;
            }
            String message = "LOSE\nTO TRY AGAIN PRESS SPACE";
            JOptionPane.showMessageDialog(this, message);
            chicken.set2(600);
            timer.start();
        }

        if (doubleCollision() && target.doubleT(shoot)) {
            targetN -= 2;
            score += 200;
            fire.remove(Left);
            target.setY(-100);
            if (level == 3) {
                shoot = 0;
            }

        } else {
            if (collisionC()) {
                targetN--;
                score += 100;
                fire.remove(varT1);
                target.setY(-100);
                shoot++;

            }
        }
        if (doubleCollisionC() && secondTarget.doubleT(shoot_s)) {
            targetN -= 2;
            score += 200;
            fireball.remove(Right);
            secondTarget.setY(-100);
            if (level == 3) {
                shoot_s = 0;
            }
        } else {
            if (collisionC_sec()) {
                targetN -= 2;
                score += 100;
                fireball.remove(varT2);
                secondTarget.setY(-100);
                shoot_s++;
            }
        }

    }

 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

public void repaint() {
        super.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int temp = e.getKeyCode();
          if (temp == KeyEvent.VK_A) {
            if (chicken.get1() <= 50) {
                chicken.set1(50);
            } else {
                chicken.set1(chicken.get1() - chicken.move1);
            }
        } else if (temp == KeyEvent.VK_D) {
            if (chicken.get1() >= 650) {
                chicken.set1(650);
            } else {
                chicken.set1(chicken.get1() + chicken.move1);
            }

        } else if (temp == KeyEvent.VK_SPACE) {
            fire.add(new EggFire(chicken.get1() + 30, chicken.get2()));
            fireball.add(new EggFire(chicken.get1() + 30, chicken.get2()));

        } else if (temp == KeyEvent.VK_RIGHT) {
            fireball.add(new EggFire(chicken.get1() + 30, chicken.get2()));
        } else if (temp == KeyEvent.VK_LEFT) {
            fire.add(new EggFire(chicken.get1() + 30, chicken.get2()));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (EggFire f : fire) {
            f.setX(f.getX() - f.ActionX);
        }
        for (EggFire f : fireball) {
            f.setX(f.getX() + f.ActionX);

        }
        if (target.getY() < 20 && target.getY() != -100) {
            target.setY(650);
        }
        if (secondTarget.getY() < 20 && secondTarget.getY() != -100) {
            secondTarget.setY(650);
        }
        chicken.set2(chicken.get2() + chicken.move2);
        if (chicken.get2() >= 600) {
            chicken.set2(0);

            target.setY(18 + rand.nextInt(510));
            secondTarget.setY(18 + rand.nextInt(510));
            enemyCat.setX((400 + rand1.nextInt(210)));
            enemyCat.setY((120 + rand1.nextInt(480)));
            secondEnemy.setX((60 + rand1.nextInt(340)));
            secondEnemy.setY((120 + rand1.nextInt(480)));
            if (controlPoint) {
                enemyL.setX(250 + rand1.nextInt(230));
                enemyL.setY(200 + rand1.nextInt(340));
            }

        }

        repaint();

    }

    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
