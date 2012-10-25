/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bugs.z;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

/**
 *
 * @author 200467287
 */
public class Runner {

    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        ZBug z = new ZBug(4);
        world.add(new Location(5, 1), z);
        world.show();
    }
}
