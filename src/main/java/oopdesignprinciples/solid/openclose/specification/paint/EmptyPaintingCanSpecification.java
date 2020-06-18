package oopdesignprinciples.solid.openclose.specification.paint;

import static oopdesignprinciples.solid.openclose.ingredient.Filler.CARBON_DIOXIDE;

import lombok.Setter;
import oopdesignprinciples.solid.openclose.specification.Specification;
import oopdesignprinciples.solid.openclose.spraycan.SprayCan;
import oopdesignprinciples.solid.openclose.spraycan.SprayCanFactory;
import oopdesignprinciples.solid.openclose.spraycan.SprayCanFactoryImpl;

@Setter
public abstract class EmptyPaintingCanSpecification implements Specification {

    private SprayCanFactory canFactory = new SprayCanFactoryImpl();

    protected SprayCan getEmptyPaintingCan() {
        SprayCan can = canFactory.getCan();
        can.addIngredient(CARBON_DIOXIDE, 25);
        return can;
    }
}
