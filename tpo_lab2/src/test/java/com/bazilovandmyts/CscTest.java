package com.bazilovandmyts;

import com.bazilovandmyts.trigonometric.Csc;
import com.bazilovandmyts.trigonometric.Sin;
import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileReader;
import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.eq;

public class CscTest {

    private static Sin sin;
    private final static BigDecimal DEFAULT_PRECISION = new BigDecimal("0.00000001");

    @SneakyThrows
    @BeforeAll
    static void init() {
        sin = Mockito.mock(Sin.class);

        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(new FileReader("src/test/resources/sin.csv"));
        for (CSVRecord record : records) {
            Mockito.when(
                    sin.calculate(eq(BigDecimal.valueOf(Double.parseDouble(record.get(0)))), Mockito.any())
            ).thenReturn(BigDecimal.valueOf(Double.parseDouble(record.get(1))));
        }
    }

    @Test
    void shouldNotCalculateZero() {
        Csc csc = new Csc(sin);
        Assertions.assertThrows(ArithmeticException.class, () -> csc.calculate(new BigDecimal("0.0"), DEFAULT_PRECISION));
    }

    @Test
    void correctResultFor1() {
        //1.1883951057781212
        Csc csc = new Csc(sin);
        Assertions.assertEquals(new BigDecimal("1.18839511"), csc.calculate(new BigDecimal("1.0"), DEFAULT_PRECISION));
    }
}
