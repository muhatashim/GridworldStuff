/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bugs.circle;

import info.gridworld.actor.Bug;

/**
 *
 * @author 200467287
 */
public class CircleBug extends Bug{
    
    @Override
    public void act(){
        this.turn();
        this.move();
    }
}
