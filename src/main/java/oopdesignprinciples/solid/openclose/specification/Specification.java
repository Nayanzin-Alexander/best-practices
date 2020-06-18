package oopdesignprinciples.solid.openclose.specification;

import oopdesignprinciples.solid.openclose.spraycan.SprayCan;

public interface Specification {
    SprayCan produce();

    String getName();
}
