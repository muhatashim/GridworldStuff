/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bugs.circle;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

/**
 *
 * @author 200467287
 */
public class Runner {

    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        CircleBug circle = new CircleBug();
        world.add(new Location(3,4), circle);
        world.show();
    }
}
