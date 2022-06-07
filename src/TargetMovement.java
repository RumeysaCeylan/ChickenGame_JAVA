/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rumeysa's Monster
 */
public class TargetMovement {
    private int x=0;
    private int y=480;
    private int move=2;
    
 
    public TargetMovement(int y) {
        this.y=y;
    }
    
    public TargetMovement(int x,int move)
    {
        this.x=x;
        this.move=move;
    }
    public TargetMovement(int x,int y,int move)
    {
        this.x=x;
        this.move=move;
        this.y=y;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }
    
     public boolean doubleT(int collision)
    {
        if(collision == 3)
            return true;
        else 
            return false;
    }
    
}
