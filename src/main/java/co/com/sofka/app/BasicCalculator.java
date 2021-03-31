package co.com.sofka.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicCalculator {

    private static final Logger logger = LoggerFactory.getLogger(BasicCalculator.class);

    public Long sum(Long number1, Long number2) {
        logger.info( "Summing {} + {}", number1, number2 );
        return number1 + number2;
    }

    public Long rest(Long number1, Long number2) {
        logger.info( "Resting {} - {}", number1, number2 );
        return number1 - number2;
    }

    public Long multipl(Long number1, Long number2) {
        logger.info( "Resting {} * {}", number1, number2 );
        return number1 * number2;
    }

    public Long division(Long number1, Long number2) {
        /*logger.info( "Resting {} / {}", number1, number2 );
        return number1 / number2;*/
        try {
            logger.info( "Resting {} / {}", number1, number2 );
            return number1 / number2;
        }catch (ArithmeticException ae){
            //throw new RuntimeException("No se puede dividir por 0");
            logger.info("No se puede dividir por 0");
            return (long)0;
        }

    }


    //TODO: falta crear metodo de resta multiplicacion y division 4 casos de pruebas para cada uno que hacer con la division en 0
    //TODO: control de versiones config gitignore
}
