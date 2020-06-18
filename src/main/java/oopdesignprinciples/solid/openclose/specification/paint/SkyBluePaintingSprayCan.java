package oopdesignprinciples.solid.openclose.specification.paint;

import oopdesignprinciples.solid.openclose.ingredient.CmykPaint;
import oopdesignprinciples.solid.openclose.spraycan.SprayCan;

public class SkyBluePaintingSprayCan extends EmptyPaintingCanSpecification {

    @Override
    public String getName() {
        return "Sky Blue Painting";
    }

    @Override
    public SprayCan produce() {
        SprayCan can = getEmptyPaintingCan();
        can.addIngredient(CmykPaint.CYAN_PAINT, 46);
        can.addIngredient(CmykPaint.MAGENTA_PAINT, 17.6f);
        can.addIngredient(CmykPaint.YELLOW_PAINT, 0);
        can.addIngredient(CmykPaint.BLACK_PAINT, 2);
        return can;
    }
}
