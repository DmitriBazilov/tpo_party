package com.krivonosovandmarkov.trigonometric;

import com.krivonosovandmarkov.function.LimitedIterationsExpandableFunction;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.String.format;
import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.ONE;

public class Csc extends LimitedIterationsExpandableFunction {

    private final Sin sin;


    public Csc(Sin sin) {
        this.sin = sin;
    }

    public Csc() {
        this.sin = new Sin();
    }

    @Override
    public BigDecimal calculate(BigDecimal x, BigDecimal precision) {

        checkValidity(x, precision);
        final BigDecimal sinValue = sin.calculate(x, precision);

        if (sinValue.compareTo(ZERO) == 0) {
            throw new ArithmeticException(format("Function value for argument %s doesn't exist", x));
        }

        final BigDecimal result = ONE.divide(sinValue, MathContext.DECIMAL128.getPrecision(), RoundingMode.HALF_EVEN);

        return result.setScale(precision.scale(), RoundingMode.HALF_EVEN);
    }
}
