package pcb.uwu.amount.derived.electromagnetism;

import org.junit.Test;
import pcb.uwu.amount.derived.fundamental.Area;

import static java.math.MathContext.DECIMAL64;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;

public class TeslasTest {
	private static final Teslas teslas = new Teslas(2);

	@Test
	public void multipliedByArea() {
		assertEquals("4 Wb", teslas.multipliedBy(new Area(2, SQUARE_METER), DECIMAL64).toString());
	}

}