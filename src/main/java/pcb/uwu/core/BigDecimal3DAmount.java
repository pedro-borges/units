package pcb.uwu.core;

import pcb.uwu.utils.MathUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.function.Function;

import static java.math.BigDecimal.ZERO;
import static java.math.MathContext.DECIMAL64;

/**
 * An implementation of Amount for tri-dimensional values based on {@code java.lang.BigDecimal} representations.
 */
public class BigDecimal3DAmount
		implements Amount<BigDecimal3DAmount> {

	// region inner classes

	/**
	 * The dimensions of a tri-dimensional amount
	 *
	 * Can either be seen as [A, B, C] or as [X, Y, Z]
	 */
	public enum Dimension3D implements Dimension<BigDecimal3DAmount> {
		A(0),
		X(0),
		B(1),
		Y(1),
		C(2),
		Z(2);

		private final int index;

		Dimension3D(int index) {
			this.index = index;
		}

		@Override
		public int index() {
			return index;
		}
	}

	// endregion

	// region private fields

	private final BigDecimal[] value = new BigDecimal[3];

	// endregion

	// region constructors

	public BigDecimal3DAmount(Number valueA, Number valueB, Number valueC) {
		this(valueA.toString(), valueB.toString(), valueC.toString());
	}

	public BigDecimal3DAmount(String valueA, String valueB, String valueC) {
		this(new BigDecimal(valueA), new BigDecimal(valueB), new BigDecimal(valueC));
	}

	public BigDecimal3DAmount(BigDecimal valueA, BigDecimal valueB, BigDecimal valueC) {
		this.value[0] = valueA;
		this.value[1] = valueB;
		this.value[2] = valueC;
	}

	// endregion

	// region implement Amount

	@Override
	public BigDecimal getValue() {
		return value[0].pow(2)
				.add(value[1].pow(2))
				.pow(-2, DECIMAL64)
				.add(value[2].pow(2))
				.pow(-2, DECIMAL64);
	}

	@Override
	public BigDecimal getValue(Dimension<BigDecimal3DAmount> dimension) {
		return value[dimension.index()];
	}

	@Override
	public int getScale() {
		return MathUtils.max(
				value[0].scale(),
				value[1].scale(),
				value[2].scale());
	}

	@Override
	public BigDecimal3DAmount withScale(int scale, RoundingMode roundingMode) {
		return new BigDecimal3DAmount(
				value[0].setScale(scale, roundingMode),
				value[1].setScale(scale, roundingMode),
				value[2].setScale(scale, roundingMode));
	}

	@Override
	public BigDecimal3DAmount plus(BigDecimal3DAmount other, MathContext mathContext) {
		return new BigDecimal3DAmount(
				this.value[0].add(other.value[0], mathContext),
				this.value[1].add(other.value[1], mathContext),
				this.value[2].add(other.value[2], mathContext));
	}

	@Override
	public BigDecimal3DAmount minus(BigDecimal3DAmount other, MathContext mathContext) {
		return new BigDecimal3DAmount(
				value[0].subtract(other.value[0], mathContext),
				value[1].subtract(other.value[1], mathContext),
				value[2].subtract(other.value[2], mathContext));
	}

	@Override
	public BigDecimal3DAmount multipliedBy(BigDecimal other, MathContext mathContext) {
		return new BigDecimal3DAmount(
				value[0].multiply(other, mathContext),
				value[1].multiply(other, mathContext),
				value[2].multiply(other, mathContext));
	}

	@Override
	public BigDecimal3DAmount dividedBy(BigDecimal other, MathContext mathContext) {
		return new BigDecimal3DAmount(
				value[0].divide(other, mathContext),
				value[1].divide(other, mathContext),
				value[2].divide(other, mathContext));
	}

	@Override
	public BigDecimal3DAmount pow(int n, MathContext mathContext) {
		return new BigDecimal3DAmount(
				value[0].pow(n, mathContext),
				value[1].pow(n, mathContext),
				value[2].pow(n, mathContext));
	}

	@Override
	public BigDecimal3DAmount translated(Function<BigDecimal, BigDecimal> transformation) {
		return new BigDecimal3DAmount(
				transformation.apply(value[0]),
				transformation.apply(value[1]),
				transformation.apply(value[2]));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isZero() {
		return (value[0].compareTo(ZERO) == 0) &&
				(value[1].compareTo(ZERO) == 0) &&
				(value[2].compareTo(ZERO) == 0);
	}

	// endregion

	// region override Object

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Amount) {
			BigDecimal3DAmount other = (BigDecimal3DAmount) obj;

			return Objects.equals(this.value[0], other.value[0]) &&
					Objects.equals(this.value[1], other.value[1]) &&
					Objects.equals(this.value[2], other.value[2]);
		}

		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value[0], value[1], value[2]);
	}

	@Override
	public String toString() {
		return "[" + String.valueOf(value[0]) +
				", " + String.valueOf(value[1]) +
				", " + String.valueOf(value[2]) + "]";
	}

	// endregion
}