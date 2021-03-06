package pcb.uwu.amount.base;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.MassUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.KiloGramUnit.KILOGRAM;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class KiloGrams extends Mass {

	// region constructors

	public KiloGrams(Number value) {
		super(value, KILOGRAM);
	}

	public KiloGrams(Number value, Magnitude magnitude) {
		super(value, magnitude, KILOGRAM);
	}

	public KiloGrams(String value) {
		super(value, KILOGRAM);
	}

	public KiloGrams(String value, Magnitude magnitude) {
		super(value, magnitude, KILOGRAM);
	}

	public KiloGrams(BigDecimal value) {
		super(value, KILOGRAM);
	}

	public KiloGrams(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, KILOGRAM);
	}

	public KiloGrams(BigDecimalAmount amount) {
		super(amount, KILOGRAM);
	}

	public KiloGrams(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, KILOGRAM);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public KiloGrams plus(UnitAmount<MassUnit> other, MathContext mathContext) {
		return new KiloGrams(plusAmount(this, other, mathContext));
	}

	@Override
	public KiloGrams minus(UnitAmount<MassUnit> other, MathContext mathContext) {
		return new KiloGrams(minusAmount(this, other, mathContext));
	}

	@Override
	public KiloGrams multipliedBy(BigDecimal other, MathContext mathContext) {
		return new KiloGrams(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public KiloGrams dividedBy(BigDecimal other, MathContext mathContext) {
		return new KiloGrams(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	// endregion
}
