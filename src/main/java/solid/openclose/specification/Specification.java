package solid.openclose.specification;

import solid.openclose.spraycan.SprayCan;

public interface Specification {
    SprayCan produce();

    String getName();
}
