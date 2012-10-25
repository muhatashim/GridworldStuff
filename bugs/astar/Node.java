/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bugs.astar;

import info.gridworld.grid.Location;

/**
 *
 * @author 200467287
 */
public class Node {

    private Node parent;
    private final Location curr;

    public Node(Node parent, Location curr) {
        this.parent = parent;
        this.curr = curr;
    }

    public Node getParent() {
        return parent;
    }

    public Location getCurr() {
        return curr;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        if (this.getParent() != null) {
            return "(" + this.curr.getRow() + ", " + this.curr.getCol() + "); " + this.getParent().toString();
        } else {
            return "(" + this.curr.getRow() + ", " + this.curr.getCol() + ")";
        }
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Node && ((Node) o).getCurr().equals(this.getCurr()));
    }
}
