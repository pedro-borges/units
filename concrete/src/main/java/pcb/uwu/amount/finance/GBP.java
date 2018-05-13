package pcb.uwu.amount.finance;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.finance.MoneyUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class GBP extends Money {

	public static final MoneyUnit CURRENCY = MoneyUnit.of("GBP");

	// region constructor

	public GBP(Number value) {
		super(value, CURRENCY);
	}

	public GBP(String value) {
		super(value, CURRENCY);
	}

	public GBP(BigDecimal value) {
		super(value, CURRENCY);
	}

	public GBP(BigDecimalAmount amount) {
		super(amount, CURRENCY);
	}

	// endregion

	// region implement UnitAmount

	public GBP plus(GBP other) {
		return new GBP(getAmount().plus(other.getAmount().getValue()));
	}

	public GBP minus(GBP other) {
		return new GBP(getAmount().minus(other.getAmount().getValue()));
	}

	@Override
	public GBP plus(UnitAmount<MoneyUnit> other, MathContext mathContext) {
		return new GBP(plusAmount(other, mathContext));
	}

	@Override
	public Money minus(UnitAmount<MoneyUnit> other, MathContext mathContext) {
		return new GBP(minusAmount(other, mathContext));
	}

	@Override
	public GBP multipliedBy(BigDecimal other, MathContext mathContext) {
		return new GBP(multipliedByScalar(other, mathContext));
	}

	@Override
	public GBP dividedBy(BigDecimal other, MathContext mathContext) {
		return new GBP(dividedByScalar(other, mathContext));
	}

	// endregion
}
