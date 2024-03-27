package com.bazilovandmyts;

import com.bazilovandmyts.function.FunctionsSystem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;

import static java.math.BigDecimal.ZERO;
import static org.junit.jupiter.api.Assertions.*;

class FunctionsSystemTest {

    private static final BigDecimal DEFAULT_PRECISION = new BigDecimal("0.00000001");
    private static final int DEFAULT_SCALE = 8;

    @Test
    void shouldNotAcceptNullArgument() {
        final FunctionsSystem system = new FunctionsSystem();
        assertThrows(NullPointerException.class, () -> system.calculate(null, DEFAULT_PRECISION));
    }

    @Test
    void shouldNotAcceptNullPrecision() {
        final FunctionsSystem system = new FunctionsSystem();
        assertThrows(NullPointerException.class, () -> system.calculate(new BigDecimal(-2), null));
    }

    @ParameterizedTest
    @MethodSource("illegalPrecisions")
    void shouldNotAcceptIncorrectPrecisions(final BigDecimal precision) {
        final FunctionsSystem system = new FunctionsSystem();
        assertThrows(ArithmeticException.class, () -> system.calculate(new BigDecimal(-2), precision));
    }

    @Test
    void shouldNotAcceptZeroArgument() {
        final FunctionsSystem system = new FunctionsSystem();
        assertNull(system.calculate(ZERO, DEFAULT_PRECISION));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/func.csv", nullValues = {"null"})
    void testWithMocks(String value, String expected) {
        final FunctionsSystem system = new FunctionsSystem();
        assertEquals(new BigDecimal(expected), system.calculate(new BigDecimal(value), DEFAULT_PRECISION).setScale(5, RoundingMode.HALF_EVEN));
    }


    private static Stream<Arguments> illegalPrecisions() {
        return Stream.of(
                Arguments.of(BigDecimal.valueOf(1)),
                Arguments.of(BigDecimal.valueOf(0)),
                Arguments.of(BigDecimal.valueOf(1.01)),
                Arguments.of(BigDecimal.valueOf(-0.01)));
    }
}
