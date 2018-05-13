package pcb.uwu.unit.finance;

import org.junit.Test;
import pcb.uwu.contract.CurrencyConversionProvider;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.exception.InvalidCurrencyException;

import java.math.BigDecimal;
import java.util.Currency;

import static java.math.BigDecimal.ONE;
import static java.math.MathContext.DECIMAL32;
import static java.math.RoundingMode.HALF_EVEN;
import static junit.framework.TestCase.assertSame;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.BigDecimalAmount.ZERO;
import static pcb.uwu.unit.finance.MoneyUnit.CANONICAL_CURRENCY;

public class MoneyUnitTest {
	private static final Currency GBP = Currency.getInstance("GBP");

	// region test constructors

	@Test
	public void testCurrencyEquals() {
		assertSame(Currency.getInstance("GBP"), GBP);
	}

	@Test(expected = InvalidCurrencyException.class)
	public void testConstructorCurrency() {
		MoneyUnit moneyUnit = new MoneyUnit(GBP);

		assertEquals("£", moneyUnit.toString());

		moneyUnit.getTranslationToCanonical().apply(ZERO);
	}

	@Test
	public void testConstructorCurrencyConverterWithConversion() {
		CurrencyConversionProvider currencyConversionProvider = (originalCurrency, destinationCurrency) ->
		{
			if (originalCurrency == GBP && destinationCurrency == CANONICAL_CURRENCY) return new BigDecimal("1.1");
			if (originalCurrency == CANONICAL_CURRENCY && destinationCurrency == GBP) return ONE.divide(new BigDecimal("1.1"), DECIMAL32);

			return null;
		};

		MoneyUnit moneyUnit = new MoneyUnit(GBP, currencyConversionProvider);

		assertEquals("£", moneyUnit.toString());

		BigDecimalAmount result;

		result = moneyUnit.getTranslationToCanonical().apply(new BigDecimalAmount("100.00"));
		assertEquals(new BigDecimalAmount("110.00"), result.withScale(2, HALF_EVEN));
		result = moneyUnit.getTranslationFromCanonical().apply(new BigDecimalAmount("110.00"));
		assertEquals(new BigDecimalAmount("100.00"), result.withScale(2, HALF_EVEN));
	}

	@Test(expected = InvalidCurrencyException.class)
	public void testConstructorCurrencyConverterWithNoConversion() {
		CurrencyConversionProvider currencyConversionProvider = (originalCurrency, destinationCurrency) -> null;

		MoneyUnit moneyUnit = new MoneyUnit(GBP, currencyConversionProvider);

		assertEquals("£", moneyUnit.toString());

		moneyUnit.getTranslationToCanonical().apply(ZERO);
	}

	// endregion
}