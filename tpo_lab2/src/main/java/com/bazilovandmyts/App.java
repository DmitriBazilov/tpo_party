package com.bazilovandmyts;

import com.bazilovandmyts.function.FunctionsSystem;
import com.bazilovandmyts.logariphmic.Ln;
import com.bazilovandmyts.logariphmic.Log;
import com.bazilovandmyts.trigonometric.Csc;
import com.bazilovandmyts.trigonometric.Sin;

import java.io.DataOutput;
import java.io.IOException;
import java.math.BigDecimal;

public class App {

    public static void main(String[] args) throws IOException {
        final Sin sin = new Sin();
        CsvWriter.write(
                "csv/sin.csv",
                sin,
                BigDecimal.valueOf(-1.1),
                new BigDecimal("1.1"),
                new BigDecimal("0.2"),
                new BigDecimal("0.0000000001"));

        final Csc csc = new Csc(sin);
        CsvWriter.write(
                "csv/csc.csv",
                csc,
                BigDecimal.valueOf(-1.1),
                BigDecimal.valueOf(1.1),
                new BigDecimal("0.2"),
                new BigDecimal("0.0000000001")
        );

        final Ln ln = new Ln();
        CsvWriter.write(
                "csv/ln.csv",
                ln,
                new BigDecimal(1),
                new BigDecimal(20),
                new BigDecimal("0.1"),
                new BigDecimal("0.0000000001"));

        final Log log3 = new Log(3);
        CsvWriter.write(
                "csv/log3.csv",
                log3,
                new BigDecimal(1),
                new BigDecimal(20),
                new BigDecimal("0.1"),
                new BigDecimal("0.00000000001"));

        final Log log5 = new Log(5);
        CsvWriter.write(
                "csv/log5.csv",
                log5,
                new BigDecimal(1),
                new BigDecimal(20),
                new BigDecimal("0.1"),
                new BigDecimal("0.00000000001"));
        final FunctionsSystem func = new FunctionsSystem();
        CsvWriter.write(
                "csv/func.csv",
                func,
                new BigDecimal(-2),
                new BigDecimal(2),
                new BigDecimal("0.1"),
                new BigDecimal("0.00000000001")
        );
    }
}
