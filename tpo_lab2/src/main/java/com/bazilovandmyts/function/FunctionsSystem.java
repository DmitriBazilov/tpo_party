package com.bazilovandmyts.function;

import static java.math.BigDecimal.ZERO;
import static java.math.MathContext.DECIMAL128;
import static java.math.RoundingMode.HALF_EVEN;
import ch.obermuhlner.math.big.BigDecimalMath;
import com.bazilovandmyts.logariphmic.Ln;
import com.bazilovandmyts.logariphmic.Log;
import com.bazilovandmyts.trigonometric.Csc;
import com.bazilovandmyts.trigonometric.Sin;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.MathContext;

@AllArgsConstructor
public class FunctionsSystem implements SeriesExpandableFunction {

    private final Sin sin;
    private final Csc csc;
    private final Ln ln;
    private final Log log3;
    private final Log log5;

    public FunctionsSystem() {
        this.csc = new Csc();
        this.sin = new Sin();
        this.ln = new Ln();
        this.log3 = new Log(3);
        this.log5 = new Log(5);
    }

    public BigDecimal calculate(final BigDecimal x, final BigDecimal precision) {
        final MathContext mc = new MathContext(DECIMAL128.getPrecision(), HALF_EVEN);
        final BigDecimal correctedX = x.remainder(BigDecimalMath.pi(mc).multiply(new BigDecimal(2)));

        if (x.compareTo(ZERO) <= 0) {
            if (x.compareTo(ZERO) == 0) {
                return null;
            }
            return sin.calculate(correctedX, precision)
                    .add(csc.calculate(correctedX, precision))
                    .setScale(precision.scale(), HALF_EVEN);

        } else {
            return log5.calculate(correctedX, precision).pow(3)
                    .multiply(log3.calculate(correctedX, precision))
                    .add(log3.calculate(correctedX, precision)
                            .multiply(log5.calculate(correctedX, precision)))
                    .subtract(ln.calculate(correctedX, precision)).pow(3)
                    .setScale(precision.scale(), HALF_EVEN);
        }
    }
}
