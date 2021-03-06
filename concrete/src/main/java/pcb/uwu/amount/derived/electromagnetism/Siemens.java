package pcb.uwu.amount.derived.electromagnetism;

import pcb.uwu.amount.base.ElectricCurrent;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.ElectricConductanceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.derived.electromagnetism.SiemensUnit.SIEMENS;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Siemens extends ElectricConductance {

	// region constructors

	public Siemens(Number value) {
		super(value, SIEMENS);
	}

	public Siemens(Number value, Magnitude magnitude) {
		super(value, magnitude, SIEMENS);
	}

	public Siemens(String value) {
		super(value, SIEMENS);
	}

	public Siemens(String value, Magnitude magnitude) {
		super(value, magnitude, SIEMENS);
	}

	public Siemens(BigDecimal value) {
		super(value, SIEMENS);
	}

	public Siemens(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, SIEMENS);
	}

	public Siemens(BigDecimalAmount amount) {
		super(amount, SIEMENS);
	}

	public Siemens(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, SIEMENS);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Siemens plus(UnitAmount<ElectricConductanceUnit> other, MathContext mathContext) {
		return new Siemens(plusAmount(this, other, mathContext));
	}

	@Override
	public Siemens minus(UnitAmount<ElectricConductanceUnit> other, MathContext mathContext) {
		return new Siemens(minusAmount(this, other, mathContext));
	}

	@Override
	public Siemens multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Siemens(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Siemens dividedBy(BigDecimal other, MathContext mathContext) {
		return new Siemens(dividedByScalar(this, other, mathContext));
	}

	@Override
	public Siemens in(ElectricConductanceUnit unit) {
		return new Siemens(getAmountIn(this, unit));
	}

	@Override
	public Ohms invert(MathContext mathContext) {
		return new Ohms(getAmount().invert(mathContext));
	}

	// endregion

	// region composition

	public Volts multipliedBy(ElectricCurrent electricCurrent, MathContext mathContext) {
		return new Volts(getAmount().multipliedBy(getAmountIn(electricCurrent, AMPERE), mathContext));
	}

	// endregion
}
