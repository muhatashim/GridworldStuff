/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bugs.dancingbug;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

/**
 *
 * @author 200467287
 */
public class Runner {

    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        DancingBug dancing = new DancingBug(new int[]{1,2,1,9,6,3});
        world.add(new Location(2,2), dancing);
        world.show();
    }
}
