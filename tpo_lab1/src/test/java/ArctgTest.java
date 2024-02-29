import org.example.tasks.Arctg;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ArctgTest {



    @DisplayName("Проверяем значения указанные в csv файле")
    @ParameterizedTest
    @CsvFileSource(resources = "test.csv", numLinesToSkip = 1)
    void csvFileTest(double input, double expected) {
        Assertions.assertEquals(expected, Arctg.calculate(input, 100), 0.1);
    }



}
