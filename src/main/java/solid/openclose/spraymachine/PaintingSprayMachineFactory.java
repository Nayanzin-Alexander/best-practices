package solid.openclose.spraymachine;

import solid.openclose.specification.paint.DesertSandPaintingSprayCan;
import solid.openclose.specification.paint.PurplePaintingSprayCan;
import solid.openclose.specification.paint.SkyBluePaintingSprayCan;

public class PaintingSprayMachineFactory implements SprayMachineFactory {

    @Override
    public SprayMachine getSprayMachine() {
        SprayMachine paintingSprayMachine = new SprayMachine();
        paintingSprayMachine.addSpecification(new DesertSandPaintingSprayCan());
        paintingSprayMachine.addSpecification(new PurplePaintingSprayCan());
        paintingSprayMachine.addSpecification(new SkyBluePaintingSprayCan());
        return paintingSprayMachine;
    }
}
