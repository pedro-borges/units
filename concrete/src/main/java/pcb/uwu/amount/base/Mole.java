package pcb.uwu.amount.base;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.AmountOfSubstanceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.MoleUnit.MOLE;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Mole extends AmountOfSubstance {

	// region constructors

	public Mole(Number value) {
		super(value, MOLE);
	}

	public Mole(Number value, Magnitude magnitude) {
		super(value, magnitude, MOLE);
	}

	public Mole(String value) {
		super(value, MOLE);
	}

	public Mole(String value, Magnitude magnitude) {
		super(value, magnitude, MOLE);
	}

	public Mole(BigDecimal value) {
		super(value, MOLE);
	}

	public Mole(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, MOLE);
	}

	public Mole(BigDecimalAmount amount) {
		super(amount, MOLE);
	}

	public Mole(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, MOLE);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Mole plus(UnitAmount<AmountOfSubstanceUnit> other, MathContext mathContext) {
		return new Mole(plusAmount(this, other, mathContext));
	}

	@Override
	public Mole minus(UnitAmount<AmountOfSubstanceUnit> other, MathContext mathContext) {
		return new Mole(minusAmount(this, other, mathContext));
	}

	@Override
	public Mole multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Mole(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Mole dividedBy(BigDecimal other, MathContext mathContext) {
		return new Mole(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	// endregion
}
