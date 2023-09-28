package lapr.project.utils;

import lapr.project.controller.BuildTreeController;
import lapr.project.controller.ReadFilesController;
import lapr.project.model.port.Port;
import lapr.project.tree2D.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Comparator2DTreeXTest {
    ReadFilesController readFilesController;
    BuildTreeController buildTreeController;

    @BeforeEach
    void setUp() {
        readFilesController = new ReadFilesController();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void compare() {
        List<Node<Port>> list = new LinkedList<>();
        Node<Port> n1 = new Node<>(new Port("Europe", "Cyprus", 10136, "Larnaca", 34.91666667, 33.65), 34.91666667, 33.65);
        Node<Port> n2 = new Node<>(new Port("Europe", "Malta", 10138, "Marsaxlokk", 35.84194, 14.54306), 35.84194, 14.54306);
        Node<Port> n3 = new Node<>(new Port("Europe", "Denmark", 10358, "Aarhus", 56.15, 10.21666667), 56.15, 10.21666667);
        Node<Port> n4 = new Node<>(new Port("Europe", "Denmark", 10563, "Copenhagen", 55.7, 12.61666667), 55.7, 12.61666667);
        Node<Port> n5 = new Node<>(new Port("America", "Peru", 10860, "Matarani", -17, -72.1), -17, -72.1);
        Node<Port> n6 = new Node<>(new Port("Europe", "Italy", 11174, "Genoa", 44.4, 8.933333333), 44.4, 8.933333333);

        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.add(n4);
        list.add(n5);
        list.add(n6);

        List<Node<Port>> list1 = new LinkedList<>();
        list1.add(n5);
        list1.add(n1);
        list1.add(n2);
        list1.add(n6);
        list1.add(n4);
        list1.add(n3);
        list.sort(new Comparator2DTreeX<>());
        assertEquals(list1,list);
    }
}