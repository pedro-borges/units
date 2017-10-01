package pcb.units.concrete.imperial;

import pcb.units.amount.Amount;
import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.dimensions.fundamental.SpaceUnit;
import pcb.units.dimensions.fundamental.amounts.Space;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.function.Function;

import static java.math.MathContext.DECIMAL64;

public class Inches
		extends AbstractUnitAmount<BigDecimal, SpaceUnit, Space>
		implements Space {
	public static final SpaceUnit INCHES = new SpaceUnit() {
		@Override
		public String getSymbol() {
			return "in";
		}

		@Override
		public String getSingularName() {
			return "inch";
		}

		@Override
		public String getPluralName() {
			return "inches";
		}

		@Override
		public Function<BigDecimal, BigDecimal> translationToCanonical() {
			return value -> value.divide(METERS_PER_INCH, DECIMAL64);
		}

		@Override
		public Function<BigDecimal, BigDecimal> translationFromCanonical() {
			return value -> value.multiply(METERS_PER_INCH, DECIMAL64);
		}
	};

	private static final BigDecimal METERS_PER_INCH = new BigDecimal("0.0254");

	// region constructors

	public Inches(Number amount) {
		this(new BigDecimalAmount(amount));
	}

	public Inches(BigDecimalAmount amount) {
		super(amount, INCHES);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Inches plus(Space other, MathContext mathContext) {
		Inches inches = new Inches(other.getValueIn(INCHES));
		return new Inches(getAmount().plus(inches.getAmount(), mathContext));
	}

	@Override
	public Inches minus(Space other, MathContext mathContext) {
		Inches inches = new Inches(other.getValueIn(INCHES));
		return new Inches(getAmount().minus(inches.getAmount(), mathContext));
	}

	@Override
	public Inches multipliedBy(Amount<BigDecimal> other, MathContext mathContext) {
		return new Inches(getAmount().multipliedBy(other.getValue(), mathContext));
	}

	@Override
	public Inches dividedBy(Amount<BigDecimal> other, MathContext mathContext) {
		return new Inches(getAmount().dividedBy(other.getValue(), mathContext));
	}

	@Override
	public Amount<BigDecimal> dividedBy(Space other, MathContext mathContext) {
		Inches inches = new Inches(other.getValueIn(INCHES));
		return getAmount().dividedBy(inches.getAmount(), mathContext);
	}

	// endregion
}
