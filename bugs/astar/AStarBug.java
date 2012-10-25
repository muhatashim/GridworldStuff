/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bugs.astar;

import bugs.dancingbug.DancingBug;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author 200467287
 */
public class AStarBug extends Bug {

    private final List<Rock> rocks;
    private final Location start;
    private final Location dest;
    private boolean newInstance = false;
    private Location[] path = null;

    public AStarBug(List<Rock> rocks, Location dest) {
        this.rocks = rocks;
        this.start = this.getLocation();
        this.dest = dest;
    }

    public List<Node> calcPath() {
//        List<Location> path = new ArrayList<Location>();
//        List<Node> done = new ArrayList<Node>();
        List<Node> closed = new ArrayList<Node>();
        List<Node> open = new ArrayList<Node>();
        Node lastBest = new Node(null, this.getLocation());
        open.addAll(Arrays.asList(getLocationsValid(getSorrounding(lastBest))));

        while (lastBest != null && !lastBest.getCurr().equals(dest)) {
            double bestCost = Double.MAX_VALUE;
            lastBest = null;
            for (Node loc : open) {
                if (!closed.contains(loc)) {
                    double cost = getF(loc) + getH(loc.getCurr());
                    if (cost < bestCost) {
                        lastBest = loc;
                        bestCost = cost;
                    }
                }
            }
            if (lastBest != null) {
                System.out.println("Add " + lastBest);
                closed.add(lastBest);
                open.addAll(Arrays.asList(getLocationsValid(getSorrounding(lastBest))));
                open.remove(lastBest);
            }
        }
        System.out.println("Calculated path!");
        System.out.println("    Closed: ");
        System.out.println(Arrays.toString(closed.toArray()));
        return closed;
    }

    public Location[] getPath(List<Node> path) {
        int indexOf = path.size() - 1;
        ArrayList<Location> locs = new ArrayList<Location>();
        if (indexOf != -1) {
            Node loc = path.get(indexOf);
            while (loc != null) {
                locs.add(loc.getCurr());
                loc = loc.getParent();
            }
        }
        Collections.reverse(locs);
        Location[] array = new Location[locs.size()];
        return locs.toArray(array);
    }
    int i = 0;

    @Override
    public void act() {
        if (path == null) {
            path = getPath(calcPath());
            System.out.println("    Path:");
            System.out.println(Arrays.toString(path));
        }
        i++;
        if (i < path.length) {
            Location l = path[i];
            if (l != null) {
                super.setDirection(super.getLocation().getDirectionToward(l));
                super.setColor(DancingBug.nextColorRandom());
                super.move();
            }
        } else if (!newInstance) {
            newInstance = true;
            Runner.main(new String[]{});
        }
    }

    public double getH(Location l) {
        return dist(l, this.start);
    }

    public double getF(Node l) {
        Node last = l;
        double c = 0;
        while (last != null) {
            if (last.getParent() != null) {
                c += dist(last.getCurr(), last.getParent().getCurr());
            }
            last = last.getParent();
        }
        return c;
    }

    public double dist(Location l, Location l2) {
        if (l != null && l2 != null) {
            return Math.hypot(l2.getRow() - l.getRow(), l2.getCol() - l.getCol());
        }
        return 0;
    }

    public Node[] getLocationsValid(Node[] l) {
        List<Node> returns = new ArrayList<Node>();
        for (Node node : l) {
            if (node != null) {
                if (isLocationValid(node.getCurr())) {
                    returns.add(node);
                }
            }
        }
        Node[] array = new Node[returns.size()];
        returns.toArray(array);
        return array;
    }

    public Location[] getLocationsValid(Location[] l) {
        List<Location> returns = new ArrayList<Location>();
        for (Location loc : l) {
            if (isLocationValid(loc)) {
                returns.add(loc);
            }
        }
        Location[] array = new Location[returns.size()];
        returns.toArray(array);
        return array;
    }

    public boolean isLocationValid(Location l) {
        if ((l == null || rocks == null) || (!super.getGrid().isValid(l))) {
            return false;
        }
        for (Rock rock : rocks) {
            if (rock.getLocation() != null) {
                if (rock.getLocation().equals(l)) {
                    return false;
                }
            }
        }
        return true;
    }

    public Node[] getSorrounding(Node node) {
        Node[] sorr = new Node[9];
        if (node != null) {
            int idx = 0;
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    Location location = new Location(node.getCurr().getRow() + x, node.getCurr().getCol() + y);
                    Node sorrNode = new Node(node, location);
                    System.out.println(idx + ", " + sorrNode);
                    sorr[idx++] = sorrNode;
                }
            }
        }
        return sorr;
    }
}
