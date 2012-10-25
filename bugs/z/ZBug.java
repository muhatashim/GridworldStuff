/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bugs.z;

import info.gridworld.actor.Bug;

/**
 *
 * @author 200467287
 */
public class ZBug extends Bug {

    private float z;

    public ZBug(int z) {
        this.z = z;
        this.turn();
        this.turn();
    }
    private int steps = 0;

    @Override
    public void act() {
        System.out.println(steps);
        if (steps / z == 1 || steps / z == 2) {
            if (steps / z == 1) {
                this.turn();
                this.turn();
                this.turn();
                this.move();
            } else {
                this.turn();
                this.turn();
                this.turn();
                this.turn();
                this.turn();
            }
        } else if (steps / z <= 3) {
            this.move();
        }
        steps++;
    }
}
