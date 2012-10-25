/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bugs.dancingbug;

import info.gridworld.actor.Bug;
import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 200467287
 */
public class DancingBug extends Bug {

    private int[] array;
    private int steps = 0;
    private int index = 0;

    public DancingBug(int[] array) {
        this.array = array;
    }

    @Override
    public void act() {
        if (index == array.length) {
            index = 0;
        }
        turn(array[index++]);
        System.out.println(index);
        this.move();
        this.setColor(nextColorRandom());
        steps++;
    }

    public void turn(int amount) {
        for (int i = 0; i < amount; i++) {
            this.turn();
        }
    }

    public static Color nextColorRandom() {
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
