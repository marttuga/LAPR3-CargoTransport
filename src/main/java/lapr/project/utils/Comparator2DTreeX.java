package lapr.project.utils;

import lapr.project.tree2D.Node;

import java.util.Comparator;

public class Comparator2DTreeX<T> implements Comparator<Node<T>> {

    @Override
    public int compare(Node<T> p1, Node<T> p2) {
        return Double.compare(p1.getX(), p2.getX());
    }
}


