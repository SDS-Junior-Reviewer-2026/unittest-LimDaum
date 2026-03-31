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
    void addTest() {
        when(mockAdder.add(anyInt(), anyInt())).thenAnswer(
                invoc -> {
                    int firstArg = invoc.getArgument(0);
                    int secondArg = invoc.getArgument(1);
                    return firstArg + secondArg;
                }
        );

        assertThat(5).isEqualTo(calc.add(2, 3));
    }

    @Test
    void subtract() {
        when(mockAdder.add(anyInt(), anyInt())).thenAnswer(
                invoc -> {
                    int firstArg = invoc.getArgument(0);
                    int secondArg = invoc.getArgument(1);
                    return firstArg - secondArg;
                }
        );

        assertThat(-1).isEqualTo(calc.add(2, 3));
    }

    @Test
    void multiply() {
        when(mockAdder.add(anyInt(), anyInt())).thenAnswer(
                invoc -> {
                    int firstArg = invoc.getArgument(0);
                    int secondArg = invoc.getArgument(1);
                    return firstArg * secondArg;
                }
        );

        assertThat(6).isEqualTo(calc.add(2, 3));
    }
}