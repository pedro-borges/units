package pcb.uwu.amount.derived.electromagnetism;

import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.MagneticFieldUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;
import static pcb.uwu.unit.derived.electromagnetism.TeslaUnit.TESLA;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;

public class Teslas extends MagneticField {

	// region constructors

	public Teslas(Number value) {
		super(value, TESLA);
	}

	public Teslas(Number value, Magnitude magnitude) {
		super(value, magnitude, TESLA);
	}

	public Teslas(String value) {
		super(value, TESLA);
	}

	public Teslas(String value, Magnitude magnitude) {
		super(value, magnitude, TESLA);
	}

	public Teslas(BigDecimal value) {
		super(value, TESLA);
	}

	public Teslas(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, TESLA);
	}

	public Teslas(BigDecimalAmount amount) {
		super(amount, TESLA);
	}

	public Teslas(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, TESLA);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Teslas plus(UnitAmount<MagneticFieldUnit> other, MathContext mathContext) {
		return new Teslas(plusAmount(other, mathContext));
	}

	@Override
	public Teslas minus(UnitAmount<MagneticFieldUnit> other, MathContext mathContext) {
		return new Teslas(minusAmount(other, mathContext));
	}

	@Override
	public Teslas multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Teslas(multipliedByScalar(other, mathContext));
	}

	@Override
	public Teslas dividedBy(BigDecimal other, MathContext mathContext) {
		return new Teslas(dividedByScalar(other, mathContext));
	}

	@Override
	public Teslas in(MagneticFieldUnit unit) {
		return new Teslas(getAmountIn(this, unit));
	}

	// endregion

	// region composition

	public Webbers multipliedBy(Area area, MathContext mathContext) {
		return new Webbers(getAmount().multipliedBy(getAmountIn(area, SQUARE_METER), mathContext));
	}
	
	// endregion
}
