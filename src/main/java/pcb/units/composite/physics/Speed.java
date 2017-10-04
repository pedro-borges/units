package pcb.units.composite.physics;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.space.Length;
import pcb.units.dimensions.time.Time;

import java.math.BigDecimal;
import java.math.MathContext;

public class Speed
		extends AbstractUnitAmount<BigDecimalAmount, SpeedUnit>
		implements UnitAmount<BigDecimalAmount, SpeedUnit> {

	// region factory

	public static Speed create(MathContext mathContext, Length length, Time time) {
		BigDecimalAmount amount = length.getAmount().dividedBy(time.getAmount().getValue(), mathContext);
		SpeedUnit unit = new SpeedUnit(length.getUnit(), time.getUnit());

		return new Speed(amount, unit);
	}

	// endregion

	// region constructors

	public Speed(Number value, SpeedUnit unit) {
		this(value.toString(), unit);
	}

	public Speed(String value, SpeedUnit unit) {
		this(new BigDecimal(value), unit);
	}

	public Speed(BigDecimal value, SpeedUnit unit) {
		this(new BigDecimalAmount(value), unit);
	}

	public Speed(BigDecimalAmount amount, SpeedUnit unit) {
		super(amount, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Speed plus(UnitAmount<BigDecimalAmount, SpeedUnit> other, MathContext mathContext) {
		return new Speed(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Speed minus(UnitAmount<BigDecimalAmount, SpeedUnit> other, MathContext mathContext) {
		return new Speed(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Speed multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Speed(multipliedByAmount(other, mathContext), getUnit());
	}

	@Override
	public Speed dividedBy(BigDecimal other, MathContext mathContext) {
		return new Speed(dividedByAmount(other, mathContext), getUnit());
	}

	// endregion
}
