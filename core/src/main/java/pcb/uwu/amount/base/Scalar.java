package pcb.uwu.amount.base;

import pcb.uwu.amount.derived.finance.InterestRate;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.ScalarUnit;
import pcb.uwu.unit.derived.fundamental.FrequencyUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.ScalarUnit.SCALAR;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Scalar extends CompositeUnitAmount<ScalarUnit> {

	// region constructors

	public Scalar(Number value) {
		super(value, SCALAR);
	}

	public Scalar(Number value, Magnitude magnitude) {
		super(value, magnitude, SCALAR);
	}

	public Scalar(String value) {
		super(value, SCALAR);
	}

	public Scalar(String value, Magnitude magnitude) {
		super(value, magnitude, SCALAR);
	}

	public Scalar(BigDecimal value) {
		super(value, SCALAR);
	}

	public Scalar(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, SCALAR);
	}

	public Scalar(BigDecimalAmount amount) {
		super(amount, SCALAR);
	}

	public Scalar(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, SCALAR);
	}


	// endregion

	// region implement UnitAmount

	@Override
	public Scalar plus(UnitAmount<ScalarUnit> other, MathContext mathContext) {
		return new Scalar(plusAmount(this, other, mathContext));
	}

	@Override
	public Scalar minus(UnitAmount<ScalarUnit> other, MathContext mathContext) {
		return new Scalar(minusAmount(this, other, mathContext));
	}

	@Override
	public Scalar multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Scalar(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Scalar dividedBy(BigDecimal other, MathContext mathContext) {
		return new Scalar(dividedByScalar(this, other, mathContext));
	}

	@Override
	public Scalar in(ScalarUnit unit) {
		return new Scalar(getAmountIn(this, unit));
	}

	// endregion

	// region composition

	public InterestRate dividedBy(Time time, MathContext mathContext) {
		BigDecimalAmount amount = getAmount()
				.dividedBy(time.getAmount().getValue(), mathContext);
		FrequencyUnit unit = new FrequencyUnit(time.getUnit());

		return new InterestRate(amount, unit);
	}

	// endregion
}
