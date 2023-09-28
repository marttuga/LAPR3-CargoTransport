package lapr.project.utils;

import lapr.project.model.ship.ShipAtrib;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ChainedShipAtribComparator implements Comparator<ShipAtrib> {
    private List<Comparator<ShipAtrib>> listComparators;

    /**
     * Construtor da classe
     *
     * @param comparators - sequencia das comparacoes encadeadas a realizar
     */
    public ChainedShipAtribComparator(Comparator<ShipAtrib>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }

    @Override
    public int compare(ShipAtrib c1, ShipAtrib c2) {
        for (Comparator<ShipAtrib> comparator : listComparators) {
            int result = comparator.compare(c1, c2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
