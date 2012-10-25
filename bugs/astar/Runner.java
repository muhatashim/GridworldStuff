/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bugs.astar;

import bugs.dancingbug.DancingBug;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 200467287
 */
public class Runner {

    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        List<Rock> rocks = new ArrayList<Rock>();
        for (int i = 0; i < 15; i++) {
            Rock r = new Rock();
            r.setColor(DancingBug.nextColorRandom());
            rocks.add(r);
            world.add(r);
        }
        AStarBug astar = new AStarBug(rocks, new Location(0, 0));
        world.add(new Location(9, 8), astar);
        world.show();
    }
}
