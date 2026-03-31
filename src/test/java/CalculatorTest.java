import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculatorTest {
    @Mock
    Adder mockAdder;

    @InjectMocks
    Calculator calc;

    @Test
    void calcTest() {
        when(calc.add(anyInt(), anyInt())).thenAnswer(
                invoc -> {
                    int firstArg = invoc.getArgument(0);
                    int secondArg = invoc.getArgument(1);
                    return firstArg + secondArg;
                }
        );

        assertThat(5).isEqualTo(calc.add(2, 3));
        assertThat(-1).isEqualTo(calc.subtract(2, 3));
        assertThat(6).isEqualTo(calc.multiply(2, 3));
    }
}