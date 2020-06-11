package solid.openclose.specification.paint;

import static solid.openclose.ingredient.CmykPaint.BLACK_PAINT;
import static solid.openclose.ingredient.CmykPaint.CYAN_PAINT;
import static solid.openclose.ingredient.CmykPaint.MAGENTA_PAINT;
import static solid.openclose.ingredient.CmykPaint.YELLOW_PAINT;

import solid.openclose.spraycan.SprayCan;

public class DesertSandPaintingSprayCan extends EmptyPaintingCanSpecification {

    @Override
    public String getName() {
        return "Desert Sand Painting";
    }

    @Override
    public SprayCan produce() {
        SprayCan can = getEmptyPaintingCan();
        can.addIngredient(CYAN_PAINT, 0);
        can.addIngredient(MAGENTA_PAINT, 15.2f);
        can.addIngredient(YELLOW_PAINT, 26.2f);
        can.addIngredient(BLACK_PAINT, 7.1f);
        return can;
    }
}
