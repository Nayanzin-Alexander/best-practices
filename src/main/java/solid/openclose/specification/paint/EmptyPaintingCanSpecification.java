package solid.openclose.specification.paint;

import static solid.openclose.ingredient.Filler.CARBON_DIOXIDE;

import lombok.Setter;
import solid.openclose.specification.Specification;
import solid.openclose.spraycan.SprayCan;
import solid.openclose.spraycan.SprayCanFactory;
import solid.openclose.spraycan.SprayCanFactoryImpl;

@Setter
public abstract class EmptyPaintingCanSpecification implements Specification {

    private SprayCanFactory canFactory = new SprayCanFactoryImpl();

    protected SprayCan getEmptyPaintingCan() {
        SprayCan can = canFactory.getCan();
        can.addIngredient(CARBON_DIOXIDE, 25);
        return can;
    }
}
