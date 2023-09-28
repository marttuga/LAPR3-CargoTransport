package lapr.project.tree2D;

import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void setObject() {
        Node<Object> node1 = new Node<>();
        Node<Object> node2 = new Node<>();
        Object obj1 = new Object();
        node1.setObject(obj1);
        node2.setObject(obj1);
        assertEquals(node1.getObject(), node2.getObject());

    }

    @Test
    void getCoords() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();
        Object obj4 = new Object();
        Object obj5 = new Object();

        Node<Object> node1 = new Node<>(obj1, 0, 0);
        Node<Object> node2 = new Node<>(obj2, 10, 10);
        Node<Object> node3 = new Node<>(obj3, 0, 10);
        Node<Object> node4 = new Node<>(obj4, 10, 0);
        Node<Object> node5 = new Node<>(obj5, 20, 20);
        assertEquals(new Point2D.Double(0, 0), node1.getCoords());
        assertEquals(new Point2D.Double(10, 10), node2.getCoords());
        assertEquals(new Point2D.Double(0, 10), node3.getCoords());
        assertEquals(new Point2D.Double(10, 0), node4.getCoords());
        assertEquals(new Point2D.Double(20, 20), node5.getCoords());

    }

    @Test
    void testEquals() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();
        Object obj4 = new Object();


        Node<Object> node1 = new Node<>(obj1, 0, 0);
        Node<Object> node2 = new Node<>(obj2, 10, 10);
        Node<Object> node3 = new Node<>(obj3, 0, 10);
        Node<Object> node4 = new Node<>(obj4, 10, 0);

        assertEquals(node1, node1);
        assertEquals(obj1, obj1);
        assertEquals(node2, node2);
        assertEquals(obj2, obj2);
        assertEquals(node3, node3);
        assertEquals(obj3, obj3);
        assertEquals(node4, node4);
        assertEquals(obj4, obj4);
        assertNotEquals(node1, node2);
        assertNotEquals(obj1, obj2);
    }

    @Test
    void testToString() {
        Object obj1 = new Object();
        Node<Object> node1 = new Node<>(obj1, 0, 0);
        assertEquals("Node{coords=Point2D.Double[0.0, 0.0], left=null, right=null}", node1.toString());
    }
}