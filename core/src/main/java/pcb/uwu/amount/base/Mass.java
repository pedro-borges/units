package pcb.uwu.amount.base;

import pcb.uwu.amount.derived.mechanics.Acceleration;
import pcb.uwu.amount.derived.mechanics.Force;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.MassUnit;
import pcb.uwu.unit.derived.mechanics.ForceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Mass extends CompositeUnitAmount<MassUnit> {

	// region constructors

	public Mass(Number value, MassUnit unit) {
		super(value, unit);
	}

	public Mass(Number value, Magnitude magnitude, MassUnit unit) {
		super(value, magnitude, unit);
	}

	public Mass(String value, MassUnit unit) {
		super(value, unit);
	}

	public Mass(String value, Magnitude magnitude, MassUnit unit) {
		super(value, magnitude, unit);
	}

	public Mass(BigDecimal value, MassUnit unit) {
		super(value, unit);
	}

	public Mass(BigDecimal value, Magnitude magnitude, MassUnit unit) {
		super(value, magnitude, unit);
	}

	public Mass(BigDecimalAmount amount, MassUnit unit) {
		super(amount, unit);
	}

	public Mass(BigDecimalAmount amount, Magnitude magnitude, MassUnit unit) {
		super(amount, magnitude, unit);
	}


	// endregion

	// region implement UnitAmount

	@Override
	public Mass plus(UnitAmount<MassUnit> other, MathContext mathContext) {
		return new Mass(plusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public Mass minus(UnitAmount<MassUnit> other, MathContext mathContext) {
		return new Mass(minusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public Mass multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Mass(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Mass dividedBy(BigDecimal other, MathContext mathContext) {
		return new Mass(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Mass in(MassUnit unit) {
		return new Mass(getAmountIn(this, unit), unit);
	}

	// endregion

	// region composition

	public Force multipliedBy(Acceleration acceleration, MathContext mathContext) {
		BigDecimalAmount amount = getAmount()
				.multipliedBy(acceleration.getAmount().getValue(), mathContext);
		ForceUnit unit = new ForceUnit(getUnit(), acceleration.getUnit());

		return new Force(amount, unit);
	}

	// endregion
}
