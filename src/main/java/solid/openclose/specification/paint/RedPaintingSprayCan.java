package solid.openclose.specification.paint;

import solid.openclose.ingredient.CmykPaint;
import solid.openclose.spraycan.SprayCan;

public class RedPaintingSprayCan extends EmptyPaintingCanSpecification {

    @Override
    public String getName() {
        return "Red Painting";
    }

    @Override
    public SprayCan produce() {
        SprayCan can = getEmptyPaintingCan();
        can.addIngredient(CmykPaint.CYAN_PAINT, 0);
        can.addIngredient(CmykPaint.MAGENTA_PAINT, 99);
        can.addIngredient(CmykPaint.YELLOW_PAINT, 100);
        can.addIngredient(CmykPaint.BLACK_PAINT, 0);
        return can;
    }
}
