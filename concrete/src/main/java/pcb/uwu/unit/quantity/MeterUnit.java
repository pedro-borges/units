package pcb.uwu.unit.quantity;

import pcb.uwu.units.quantity.LengthUnit;

import java.util.function.Function;

public class MeterUnit extends LengthUnit {

	public static final MeterUnit METER = new MeterUnit();

	private MeterUnit() {
		super("m", "meter", "meters",
				Function.identity(),
				Function.identity());
	}
}
