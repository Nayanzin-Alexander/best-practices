package oopdesignprinciples.solid.openclose.spraymachine;

import oopdesignprinciples.solid.openclose.specification.paint.DesertSandPaintingSprayCan;
import oopdesignprinciples.solid.openclose.specification.paint.PurplePaintingSprayCan;
import oopdesignprinciples.solid.openclose.specification.paint.RedPaintingSprayCan;
import oopdesignprinciples.solid.openclose.specification.paint.SkyBluePaintingSprayCan;

public class PaintingSprayMachineFactory implements SprayMachineFactory {

    @Override
    public SprayMachine getSprayMachine() {
        SprayMachine paintingSprayMachine = new SprayMachine();
        paintingSprayMachine.addSpecification(new DesertSandPaintingSprayCan());
        paintingSprayMachine.addSpecification(new PurplePaintingSprayCan());
        paintingSprayMachine.addSpecification(new SkyBluePaintingSprayCan());
        paintingSprayMachine.addSpecification(new RedPaintingSprayCan());
        return paintingSprayMachine;
    }
}
