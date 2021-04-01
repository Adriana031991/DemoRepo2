package co.com.sofka.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.opentest4j.AssertionFailedError;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class BasicCalculatorTest {

    private final BasicCalculator basicCalculator = new BasicCalculator();

    /*@Test
    @DisplayName("Testing suma 1+1 = 2")
    public void sum() {

        //Arrange
        Long num1 =1L;
        Long num2 =1L;
        Long expectedValue =2L;

        //Act
        Long result = basicCalculator.sum(num1, num2);

        //Assert
        assertEquals(expectedValue, result);

    }*/

    //@Test
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @DisplayName("Testing several sums")
    @CsvSource({ //contiene los datos a evaluar num1 num1 resultado--coincide con los parametros de entrada. parameterizedTest
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })

    public void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    //@Test
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @DisplayName("Testing several rest")
    @CsvSource({
            "1, 1, 0",
            "5, 2, 3",
            "22, 10, 12",
            "15, 30, -15"
    })
    public void severalRest(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.rest(first, second),
                () -> first + "-" + second + "should equal" + expectedResult);
    }

    //@Test
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @DisplayName("Testing several Multiplication")
    @CsvSource({
            "1, 1, 1",
            "5, 5, 25",
            "22, 10, 220",
            "9, 9, 81"
    })
    public void severalMultip(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.multipl(first, second),
                () -> first + "*" + second + "should equal" + expectedResult);
    }

    //@Test
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @DisplayName("Testing several Division when dividend is zero")

    @CsvSource({
            "2, 0, 2",
            "100, 0, 20",
            "1, 0, 1",
            "55, 0, 0"
    })

    public void severalDivisionDividendZero(Long first, Long second) {
//excepcion que toma cuando divide por 0.. la estructura puede usarse para otras validaciones
        //cuando la division es incorrecta
        assertThrows(RuntimeException.class, () -> {
            basicCalculator.division(first, second);
        });
        //assertEquals(expectedResult, basicCalculator.division(first, second),
//                () -> first + "/" + second + "should equal" + expectedResult);
    }

    @ParameterizedTest(name = "{0} / {1} = {2}")
    @DisplayName("Testing several Division")
//cuando la division es correcta
    @CsvSource({
            "2, 1, 2",
            "100, 2, 50",
            "40, 4, 10",
            "80, 10, 8"
    })

    public void severalDivision(Long first, Long second, Long expectedResult) {

        assertEquals(expectedResult, basicCalculator.division(first, second),
                () -> first + "/" + second + "should equal" + expectedResult);
    }




}

