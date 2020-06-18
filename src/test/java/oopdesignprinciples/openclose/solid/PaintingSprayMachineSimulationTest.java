package oopdesignprinciples.openclose.solid;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import oopdesignprinciples.solid.openclose.spraymachine.PaintingSprayMachineFactory;
import oopdesignprinciples.solid.openclose.spraymachine.SprayMachine;

public class PaintingSprayMachineSimulationTest {

    private final PaintingSprayMachineFactory paintingSprayMachineFactory = new PaintingSprayMachineFactory();

    private SprayMachine paintingSprayMachine;

    @Before
    public void setUp() {
        paintingSprayMachine = paintingSprayMachineFactory.getSprayMachine();
    }

    @Test
    public void shouldContainDesertSandSpecification() {
        assertThat(paintingSprayMachine.getSpecifications()).contains("Desert Sand Painting");
    }

    @Test
    public void shouldContainSkyBlueSpecification() {
        assertThat(paintingSprayMachine.getSpecifications()).contains("Sky Blue Painting");
    }

    @Test
    public void shouldContainPurpleSpecification() {
        assertThat(paintingSprayMachine.getSpecifications()).contains("Purple Painting");
    }

    @Test
    public void shouldContainRedSpecification() {
        assertThat(paintingSprayMachine.getSpecifications()).contains("Red Painting");
    }
}