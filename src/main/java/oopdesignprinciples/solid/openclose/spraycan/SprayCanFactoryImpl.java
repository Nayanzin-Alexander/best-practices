package oopdesignprinciples.solid.openclose.spraycan;

public class SprayCanFactoryImpl implements SprayCanFactory {

    @Override
    public SprayCan getCan() {
        return new SprayCan();
    }
}
