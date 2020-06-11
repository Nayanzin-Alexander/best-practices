package solid.openclose.specification.paint;

import static solid.openclose.ingredient.CmykPaint.BLACK_PAINT;
import static solid.openclose.ingredient.CmykPaint.CYAN_PAINT;
import static solid.openclose.ingredient.CmykPaint.MAGENTA_PAINT;
import static solid.openclose.ingredient.CmykPaint.YELLOW_PAINT;

import solid.openclose.spraycan.SprayCan;

public class PurplePaintingSprayCan extends EmptyPaintingCanSpecification {

    @Override
    public String getName() {
        return "Purple Painting";
    }

    @Override
    public SprayCan produce() {
        SprayCan can = getEmptyPaintingCan();
        can.addIngredient(CYAN_PAINT, 29);
        can.addIngredient(MAGENTA_PAINT, 52);
        can.addIngredient(YELLOW_PAINT, 0);
        can.addIngredient(BLACK_PAINT, 34);
        return can;
    }
}
