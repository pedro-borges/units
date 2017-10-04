package pcb.units.concrete.time;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.time.Time;
import pcb.units.dimensions.time.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Minutes
		extends AbstractUnitAmount<BigDecimalAmount, TimeUnit>
		implements Time {

	// region constructors

	public Minutes(Number value) {
		this(value.toString());
	}

	public Minutes(String value) {
		this(new BigDecimal(value));
	}

	public Minutes(BigDecimal value) {
		this(new BigDecimalAmount(value));
	}

	public Minutes(BigDecimalAmount amount) {
		super(amount, MinuteUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Minutes plus(UnitAmount<BigDecimalAmount, TimeUnit> other, MathContext mathContext) {
		Minutes meters = new Minutes(other.getAmountIn(getUnit()));
		return new Minutes(getAmount().plus(meters.getAmount(), mathContext));
	}

	@Override
	public Minutes minus(UnitAmount<BigDecimalAmount, TimeUnit> other, MathContext mathContext) {
		Minutes meters = new Minutes(other.getAmountIn(getUnit()));
		return new Minutes(getAmount().minus(meters.getAmount(), mathContext));
	}

	@Override
	public Minutes multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Minutes(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Minutes dividedBy(BigDecimal other, MathContext mathContext) {
		return new Minutes(getAmount().dividedBy(other, mathContext));
	}

	// endregion
}