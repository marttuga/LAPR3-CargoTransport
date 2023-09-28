package lapr.project.services;

import lapr.project.model.port.Port;
import lapr.project.tree2D.KdTree;
import lapr.project.tree2D.Node;

import java.util.LinkedList;
import java.util.List;

public class Port2DTreeCreate {

    private KdTree<Port> port2dTree;
    public List<Node<Port>> nodeList;

    public Port2DTreeCreate() {
        nodeList = new LinkedList<>();
        port2dTree = new KdTree<>();
    }

    public void fillList(Port port) {
        Node<Port> node = new Node<>(port, port.getLat(), port.getLon()); //nó com um porto
        nodeList.add(node); //adição à lista
    }

    public void build2DPortTree() {
        port2dTree.buildTree(getNodeList()); //descarrega os portos da lista na kD tree
        if (port2dTree.getAll().size() != getNodeList().size()) { //compara o nº de portos da lista e da kD tree
            for (Node<Port> n : getNodeList()) { // caso não seja igual percorre a lista e verifica qual porto é que não foi adicionado
                if (!contains(n.getObject().getCode(),port2dTree.getAll())){
                    port2dTree.insertOrUpdate(n.getObject(),n.getObject().getLat(),n.getObject().getLon()); //adiciona o objeto porto
                }
            }

        }
    }

    public boolean contains(int code, List<Port> list) {
        for (Port p : list) {
            if (p.getCode() == code) {
                return true;
            }
        }
        return false;
    }

    public KdTree<Port> getPort2dTree() {
        return port2dTree;
    }

    public void reset2DPortTree() {
        port2dTree = new KdTree<>();
        nodeList = new LinkedList<>();
    }

    public List<Node<Port>> getNodeList() {
        return nodeList;
    }
}
