package pcb.uwu.amount.derived.electromagnetism;

import pcb.uwu.amount.base.Amperes;
import pcb.uwu.amount.base.ElectricCurrent;
import pcb.uwu.amount.derived.thermodynamics.Joules;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.ElectricPotentialUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.derived.electromagnetism.CoulombUnit.COULOMB;
import static pcb.uwu.unit.derived.electromagnetism.OhmUnit.OHM;
import static pcb.uwu.unit.derived.electromagnetism.VoltUnit.VOLT;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Volts extends ElectricPotential {

	// region constructors

	public Volts(Number value) {
		super(value, VOLT);
	}

	public Volts(Number value, Magnitude magnitude) {
		super(value, magnitude, VOLT);
	}

	public Volts(String value) {
		super(value, VOLT);
	}

	public Volts(String value, Magnitude magnitude) {
		super(value, magnitude, VOLT);
	}

	public Volts(BigDecimal value) {
		super(value, VOLT);
	}

	public Volts(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, VOLT);
	}

	public Volts(BigDecimalAmount amount) {
		super(amount, VOLT);
	}

	public Volts(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, VOLT);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Volts plus(UnitAmount<ElectricPotentialUnit> other, MathContext mathContext) {
		return new Volts(plusAmount(this, other, mathContext));
	}

	@Override
	public Volts minus(UnitAmount<ElectricPotentialUnit> other, MathContext mathContext) {
		return new Volts(minusAmount(this, other, mathContext));
	}

	@Override
	public Volts multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Volts(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Volts dividedBy(BigDecimal other, MathContext mathContext) {
		return new Volts(dividedByScalar(this, other, mathContext));
	}

	@Override
	public Volts in(ElectricPotentialUnit unit) {
		return new Volts(getAmountIn(this, unit));
	}

	// endregion

	// region composition

	public Amperes dividedBy(ElectricResistance electricResistance, MathContext mathContext) {
		return new Amperes(getAmount().dividedBy(getAmountIn(electricResistance, OHM), mathContext));
	}

	public Ohms dividedBy(ElectricCurrent electricCurrent, MathContext mathContext) {
		return new Ohms(getAmount().dividedBy(getAmountIn(electricCurrent, AMPERE), mathContext));
	}

	public Joules multipliedBy(ElectricCharge electricCharge, MathContext mathContext) {
		return new Joules(getAmount().multipliedBy(getAmountIn(electricCharge, COULOMB), mathContext));
	}

	// endregion
}
