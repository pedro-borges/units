package pcb.uwu.amount.derived.scalar;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.scalar.AngleUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Angle extends CompositeUnitAmount<AngleUnit> {

	// region constructors

	public Angle(Number value, AngleUnit unit) {
		super(value, unit);
	}

	public Angle(Number value, Magnitude magnitude, AngleUnit unit) {
		super(value, magnitude, unit);
	}

	public Angle(String value, AngleUnit unit) {
		super(value, unit);
	}

	public Angle(String value, Magnitude magnitude, AngleUnit unit) {
		super(value, magnitude, unit);
	}

	public Angle(BigDecimal value, AngleUnit unit) {
		super(value, unit);
	}

	public Angle(BigDecimal value, Magnitude magnitude, AngleUnit unit) {
		super(value, magnitude, unit);
	}

	public Angle(BigDecimalAmount amount, AngleUnit unit) {
		super(amount, unit);
	}

	public Angle(BigDecimalAmount amount, Magnitude magnitude, AngleUnit unit) {
		super(amount, magnitude, unit);
	}


	// endregion

	// region implement UnitAmount

	@Override
	public Angle plus(UnitAmount<AngleUnit> other, MathContext mathContext) {
		return new Angle(plusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public Angle minus(UnitAmount<AngleUnit> other, MathContext mathContext) {
		return new Angle(minusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public Angle multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Angle(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Angle dividedBy(BigDecimal other, MathContext mathContext) {
		return new Angle(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Angle in(AngleUnit unit) {
		return new Angle(getAmountIn(this, unit), unit);
	}

	// endregion

	// region composition



	// endregion
}
