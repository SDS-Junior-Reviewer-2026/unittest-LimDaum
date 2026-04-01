public class Calculator {
    private Adder adder;

    public Calculator(Adder adder) {
        this.adder = adder;
    }

    public int add(int a, int b) {
        return adder.add(a, b);
    }

    public int subtract(int a, int b) {
        return adder.add(a, -b);
    }

    public int multiply(int a, int b) {
        int result = 0;
        if (b < 0) {
            b = -b;
            a = -a;
        }
        for (int i = 0; i < b; i = adder.add(i, 1)) {
            result = adder.add(result, a);
        }
        return result;
    }

    public int divide(int a, int b) {
        int result = 0;
        boolean isMinus = a*b<0;

        a = Math.abs(a);
        b =  Math.abs(b);

        while (a>=b) {
            result++;
            a = adder.add(a, -b);
        }

        if (isMinus)
            result = -result;

        return result;
    }

    public static void main(String[] args) {

    }
}