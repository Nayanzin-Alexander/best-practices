package oopdesignprinciples.solid.openclose.spraymachine;

import static java.util.stream.Collectors.toSet;

import java.util.HashSet;
import java.util.Set;
import oopdesignprinciples.solid.openclose.specification.Specification;
import oopdesignprinciples.solid.openclose.spraycan.SprayCan;

public class SprayMachine {

    private Set<Specification> specifications = new HashSet<>();

    public void addSpecification(Specification can) {
        specifications.add(can);
    }

    public Set<String> getSpecifications() {
        return specifications.stream()
            .map(Specification::getName)
            .collect(toSet());
    }

    public SprayCan produce(String name) {
        return findSpecificationByName(name).produce();
    }

    private Specification findSpecificationByName(String name) {
        return specifications.stream()
            .filter(can -> name.equals(can.getName()))
            .findFirst()
            .orElseThrow(() -> new SprayMachineException("Requested can " + name + " not found."));
    }
}
