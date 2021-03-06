package pcb.uwu.amount.derived.optics;

import pcb.uwu.amount.base.Candelas;
import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.optics.LuminanceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;
import static pcb.uwu.unit.derived.optics.NitUnit.NIT;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Nits extends Luminance {

	// region constructors

	public Nits(Number value) {
		super(value, NIT);
	}

	public Nits(Number value, Magnitude magnitude) {
		super(value, magnitude, NIT);
	}

	public Nits(String value) {
		super(value, NIT);
	}

	public Nits(String value, Magnitude magnitude) {
		super(value, magnitude, NIT);
	}

	public Nits(BigDecimal value) {
		super(value, NIT);
	}

	public Nits(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, NIT);
	}

	public Nits(BigDecimalAmount amount) {
		super(amount, NIT);
	}

	public Nits(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, NIT);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Nits plus(UnitAmount<LuminanceUnit> other, MathContext mathContext) {
		return new Nits(plusAmount(this, other, mathContext));
	}

	@Override
	public Nits minus(UnitAmount<LuminanceUnit> other, MathContext mathContext) {
		return new Nits(minusAmount(this, other, mathContext));
	}

	@Override
	public Nits multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Nits(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Nits dividedBy(BigDecimal other, MathContext mathContext) {
		return new Nits(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	public Candelas multipliedBy(Area area, MathContext mathContext) {
		return new Candelas(getAmount().multipliedBy(getAmountIn(area, SQUARE_METER), mathContext));
	}

	// endregion
}
