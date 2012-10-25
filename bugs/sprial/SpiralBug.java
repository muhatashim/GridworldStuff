/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bugs.sprial;

import bugs.dancingbug.DancingBug;
import info.gridworld.actor.Bug;
import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 200467287
 */
public class SpiralBug extends Bug {

    private int side;

    public SpiralBug(int side) {
        this.side = side;
    }
    private int steps = 0;

    @Override
    public void act() {
        System.out.println(steps);
        if (steps >= side) {
            this.turn();
            this.turn();
            steps = 0;
            side++;
        } else {
            this.move();
            steps++;
        }
        this.setColor(this.nextColorRandom());
    }

    public Color nextColorRandom() {
        try {
            Random rn = new Random();
            int r = rn.nextInt(255);
            Thread.sleep(rn.nextInt(50));
            int b = rn.nextInt(255);
            Thread.sleep(rn.nextInt(50));
            int g = rn.nextInt(255);
            Color c = new Color(r, b, g);
            return c;
        } catch (InterruptedException ex) {
            Logger.getLogger(DancingBug.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
