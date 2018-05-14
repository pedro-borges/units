package pcb.uwu.amount.base;

import pcb.uwu.amount.derived.fundamental.Frequency;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.TimeUnit;
import pcb.uwu.unit.derived.fundamental.FrequencyUnit;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.Duration;

import static java.math.MathContext.UNLIMITED;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;

public class Time extends CompositeUnitAmount<TimeUnit> {

	// region constructors

	public Time(Number value, TimeUnit unit) {
		super(value, unit);
	}

	public Time(Number value, Magnitude magnitude, TimeUnit unit) {
		super(value, magnitude, unit);
	}

	public Time(String value, TimeUnit unit) {
		super(value, unit);
	}

	public Time(String value, Magnitude magnitude, TimeUnit unit) {
		super(value, magnitude, unit);
	}

	public Time(BigDecimal value, TimeUnit unit) {
		super(value, unit);
	}

	public Time(BigDecimal value, Magnitude magnitude, TimeUnit unit) {
		super(value, magnitude, unit);
	}

	public Time(BigDecimalAmount amount, TimeUnit unit) {
		super(amount, unit);
	}

	public Time(BigDecimalAmount amount, Magnitude magnitude, TimeUnit unit) {
		super(amount, magnitude, unit);
	}

	public Time(Duration duration, TimeUnit unit) {
		super(unit.getTranslationFromCanonical().apply(new BigDecimalAmount(duration.toNanos())).dividedBy(new BigDecimal(1000000000), UNLIMITED), unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Time plus(UnitAmount<TimeUnit> other, MathContext mathContext) {
		return new Time(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Time minus(UnitAmount<TimeUnit> other, MathContext mathContext) {
		return new Time(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Time multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Time(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Time dividedBy(BigDecimal other, MathContext mathContext) {
		return new Time(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Time in(TimeUnit unit) {
		return new Time(getAmountIn(this, unit), unit);
	}

	@Override
	public Frequency invert(MathContext mathContext) {
		return new Frequency(getAmount().invert(mathContext), new FrequencyUnit(getUnit()));
	}

	// endregion
}
