package pcb.uwu.amount.derived.optics;

import pcb.uwu.amount.base.Candelas;
import pcb.uwu.amount.base.LuminousIntensity;
import pcb.uwu.amount.base.Time;
import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.amount.derived.fundamental.area.SquareMeters;
import pcb.uwu.amount.derived.scalar.SolidAngle;
import pcb.uwu.amount.derived.scalar.Steradians;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.optics.LuminousFluxUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.CandelaUnit.CANDELA;
import static pcb.uwu.unit.base.SecondUnit.SECOND;
import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;
import static pcb.uwu.unit.derived.optics.LumenUnit.LUMEN;
import static pcb.uwu.unit.derived.optics.LuxUnit.LUX;
import static pcb.uwu.unit.derived.scalar.SteradianUnit.STERADIAN;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Lumens extends LuminousFlux {

	// region constructors

	public Lumens(Number value) {
		super(value, LUMEN);
	}

	public Lumens(Number value, Magnitude magnitude) {
		super(value, magnitude, LUMEN);
	}

	public Lumens(String value) {
		super(value, LUMEN);
	}

	public Lumens(String value, Magnitude magnitude) {
		super(value, magnitude, LUMEN);
	}

	public Lumens(BigDecimal value) {
		super(value, LUMEN);
	}

	public Lumens(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, LUMEN);
	}

	public Lumens(BigDecimalAmount amount) {
		super(amount, LUMEN);
	}

	public Lumens(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, LUMEN);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Lumens plus(UnitAmount<LuminousFluxUnit> other, MathContext mathContext) {
		return new Lumens(plusAmount(this, other, mathContext));
	}

	@Override
	public Lumens minus(UnitAmount<LuminousFluxUnit> other, MathContext mathContext) {
		return new Lumens(minusAmount(this, other, mathContext));
	}

	@Override
	public Lumens multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Lumens(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Lumens dividedBy(BigDecimal other, MathContext mathContext) {
		return new Lumens(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	public Candelas dividedBy(SolidAngle solidAngle, MathContext mathContext) {
		return new Candelas(getAmount().dividedBy(getAmountIn(solidAngle, STERADIAN), mathContext));
	}

	public Steradians dividedBy(LuminousIntensity luminousIntensity, MathContext mathContext) {
		return new Steradians(getAmount().dividedBy(getAmountIn(luminousIntensity, CANDELA), mathContext));
	}

	public Talbots multipliedBy(Time time, MathContext mathContext) {
		return new Talbots(getAmount().multipliedBy(getAmountIn(time, SECOND), mathContext));
	}

	public Lux dividedBy(Area area, MathContext mathContext) {
		return new Lux(getAmount().dividedBy(getAmountIn(area, SQUARE_METER), mathContext));
	}

	public SquareMeters dividedBy(Illuminance illuminance, MathContext mathContext) {
		return new SquareMeters(getAmount().dividedBy(getAmountIn(illuminance, LUX), mathContext));
	}

	// endregion
}
