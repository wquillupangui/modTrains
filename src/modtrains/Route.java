/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modtrains;

import java.util.Objects;

/**
 *
 * @author Washington
 */
public class Route {

    private Town origin;
    private Town destination;
    private int distance;
    private Route next;

    public Route(Town origin, Town destination, int distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }

    public Route getNext() {
        return next;
    }

    public void setNext(Route next) {
        this.next = next;
    }   
    
    public Town getOrigin() {
        return origin;
    }

    public void setOrigin(Town origin) {
        this.origin = origin;
    }

    public Town getDestination() {
        return destination;
    }

    public void setDestination(Town destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.origin);
        hash = 41 * hash + Objects.hashCode(this.destination);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Route other = (Route) obj;
        if (!Objects.equals(this.origin, other.origin)) {
            return false;
        }
        if (!Objects.equals(this.destination, other.destination)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Route{" + "origin=" + origin + ", destination=" + destination + ", distance=" + distance + '}';
    }
    
    
}
