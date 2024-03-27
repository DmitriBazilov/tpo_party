package com.bazilovandmyts;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;

import com.bazilovandmyts.function.FunctionsSystem;
import com.bazilovandmyts.logariphmic.Ln;
import com.bazilovandmyts.logariphmic.Log;
import com.bazilovandmyts.trigonometric.Csc;
import com.bazilovandmyts.trigonometric.Sin;
import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.Mock;
import org.mockito.Mockito;

class FunctionsSystemTest {

    private static final BigDecimal DEFAULT_PRECISION = new BigDecimal("0.00000001");
    private static final int DEFAULT_SCALE = 8;

    private static Sin sin;
    private static Csc csc;
    private static Ln ln;
    private static Log log3;
    private static Log log5;

    @BeforeAll
    static void initMocks() {
        sin = Mockito.mock(Sin.class);
        csc = Mockito.mock(Csc.class);
        ln = Mockito.mock(Ln.class);
        log3 = Mockito.mock(Log.class);
        log5 = Mockito.mock(Log.class);

        try (
                FileReader sinIn = new FileReader("csv/sin.csv");
                FileReader cscIn = new FileReader("csv/cscIn");
                FileReader lnIn = new FileReader("csv/ln.csv");
                FileReader log3In = new FileReader("csv/log3.csv");
                FileReader log5In = new FileReader("csv/log5.csv")
        ) {

            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(sinIn);
            for (CSVRecord record : records) {
                Mockito.when(sin.calculate(new BigDecimal(record.get(0)), Mockito.any(BigDecimal.class)))
                        .thenReturn(new BigDecimal(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(cscIn);
            for (CSVRecord record : records) {
                Mockito.when(csc.calculate(new BigDecimal(record.get(0)), DEFAULT_PRECISION))
                        .thenReturn(new BigDecimal(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(lnIn);
            for (CSVRecord record : records) {
                Mockito.when(ln.calculate(new BigDecimal(record.get(0)), DEFAULT_PRECISION))
                        .thenReturn(new BigDecimal(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(log3In);
            for (CSVRecord record : records) {
                Mockito.when(log3.calculate(new BigDecimal(record.get(0)), DEFAULT_PRECISION))
                        .thenReturn(new BigDecimal(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(log5In);
            for (CSVRecord record : records) {
                Mockito.when(log5.calculate(new BigDecimal(record.get(0)), DEFAULT_PRECISION))
                        .thenReturn(new BigDecimal(record.get(1)));
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println("LOL");
        }

    }

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
        final FunctionsSystem system = new FunctionsSystem(sin, csc, ln, log3, log5);

    }


    private static Stream<Arguments> illegalPrecisions() {
        return Stream.of(
                Arguments.of(BigDecimal.valueOf(1)),
                Arguments.of(BigDecimal.valueOf(0)),
                Arguments.of(BigDecimal.valueOf(1.01)),
                Arguments.of(BigDecimal.valueOf(-0.01)));
    }
}
