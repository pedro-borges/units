package pcb.uwu.core;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.CENTI;
import static pcb.uwu.core.Magnitude.DECI;
import static pcb.uwu.core.Magnitude.DEKA;
import static pcb.uwu.core.Magnitude.GIGA;
import static pcb.uwu.core.Magnitude.HECTA;
import static pcb.uwu.core.Magnitude.KILO;
import static pcb.uwu.core.Magnitude.MEGA;
import static pcb.uwu.core.Magnitude.MICRO;
import static pcb.uwu.core.Magnitude.MILLI;
import static pcb.uwu.core.Magnitude.NANO;
import static pcb.uwu.core.Magnitude.NATURAL;
import static pcb.uwu.core.Magnitude.PICO;
import static pcb.uwu.core.Magnitude.TERA;

public class MagnitudeTest {
	@Test
	public void testValues() {
		assertEquals(new BigDecimal("1000000000000"), TERA.getValue());
		assertEquals(new BigDecimal("1000000000"), GIGA.getValue());
		assertEquals(new BigDecimal("1000000"), MEGA.getValue());
		assertEquals(new BigDecimal("1000"), KILO.getValue());
		assertEquals(new BigDecimal("100"), HECTA.getValue());
		assertEquals(new BigDecimal("10"), DEKA.getValue());
		assertEquals(new BigDecimal("1"), NATURAL.getValue());
		assertEquals(new BigDecimal("0.1"), DECI.getValue());
		assertEquals(new BigDecimal("0.01"), CENTI.getValue());
		assertEquals(new BigDecimal("0.001"), MILLI.getValue());
		assertEquals(new BigDecimal("0.000001"), MICRO.getValue());
		assertEquals(new BigDecimal("0.000000001"), NANO.getValue());
		assertEquals(new BigDecimal("0.000000000001"), PICO.getValue());
	}
}
