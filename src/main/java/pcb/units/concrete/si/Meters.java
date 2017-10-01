package pcb.units.concrete.si;

import pcb.units.amount.Amount;
import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.dimensions.fundamental.SpaceUnit;
import pcb.units.dimensions.fundamental.amounts.Space;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.function.Function;

public class Meters
		extends AbstractUnitAmount<BigDecimal, SpaceUnit, Space>
		implements Space {
	public static final SpaceUnit METERS = new SpaceUnit() {
		@Override
		public String getSymbol() {
			return "m";
		}

		@Override
		public String getSingularName() {
			return "meter";
		}

		@Override
		public String getPluralName() {
			return "meters";
		}

		@Override
		public Function<BigDecimal, BigDecimal> translationToCanonical() {
			return Function.identity();
		}

		@Override
		public Function<BigDecimal, BigDecimal> translationFromCanonical() {
			return Function.identity();
		}
	};

	// region constructors

	public Meters(Number amount) {
		this(new BigDecimalAmount(amount));
	}

	public Meters(BigDecimalAmount amount) {
		super(amount, METERS);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Meters plus(Space other, MathContext mathContext) {
		Meters meters = new Meters(other.getValueIn(METERS));
		return new Meters(getAmount().plus(meters.getAmount(), mathContext));
	}

	@Override
	public Meters minus(Space other, MathContext mathContext) {
		Meters meters = new Meters(other.getValueIn(METERS));
		return new Meters(getAmount().minus(meters.getAmount(), mathContext));
	}

	@Override
	public Meters multipliedBy(Amount<BigDecimal> other, MathContext mathContext) {
		return new Meters(getAmount().multipliedBy(other.getValue(), mathContext));
	}

	@Override
	public Meters dividedBy(Amount<BigDecimal> other, MathContext mathContext) {
		return new Meters(getAmount().dividedBy(other.getValue(), mathContext));
	}

	@Override
	public Amount<BigDecimal> dividedBy(Space other, MathContext mathContext) {
		Meters meters = new Meters(other.getValueIn(METERS));
		return getAmount().dividedBy(meters.getAmount(), mathContext);
	}

	// endregion
}
