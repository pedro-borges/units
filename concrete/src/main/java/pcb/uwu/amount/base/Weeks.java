package pcb.uwu.amount.base;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.base.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.WeekUnit.WEEK;

public class Weeks extends Time {

	// region constructors

	public Weeks(Number value) {
		super(value, WEEK);
	}

	public Weeks(Number value, Magnitude magnitude) {
		super(value, magnitude, WEEK);
	}

	public Weeks(String value) {
		super(value, WEEK);
	}

	public Weeks(String value, Magnitude magnitude) {
		super(value, magnitude, WEEK);
	}

	public Weeks(BigDecimal value) {
		super(value, WEEK);
	}

	public Weeks(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, WEEK);
	}

	public Weeks(BigDecimalAmount amount) {
		super(amount, WEEK);
	}

	public Weeks(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, WEEK);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Weeks plus(UnitAmount<TimeUnit> other, MathContext mathContext) {
		return new Weeks(plusAmount(other, mathContext));
	}

	@Override
	public Weeks minus(UnitAmount<TimeUnit> other, MathContext mathContext) {
		return new Weeks(minusAmount(other, mathContext));
	}

	@Override
	public Weeks multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Weeks(multipliedByScalar(other, mathContext));
	}

	@Override
	public Weeks dividedBy(BigDecimal other, MathContext mathContext) {
		return new Weeks(dividedByScalar(other, mathContext));
	}

	// endregion
}