import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter digits: ");
        String input = scanner.nextLine();

        if (input.contains(OperatorEnum.MULTIPLY.getValue())) {
            multiply(input);
            return;
        }

        if (input.contains(OperatorEnum.MINUS.getValue())) {
            minus(input);
            return;
        }

        if (input.contains(OperatorEnum.ADD.getValue())) {
            add(input);
            return;
        }

        if (input.contains(OperatorEnum.DIVIDE.getValue())) {
            divide(input);
            return;
        } else {
            throw new RuntimeException("Строка не является математической операцией");
        }
    }

    private static void multiply(String input) {
        String[] arr = input.split(OperatorEnum.MULTIPLY.getValue());
        arr = validateOperandAndReturn(arr);
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        System.out.println(a * b);
    }

    private static void minus(String input) {
        String[] arr = input.split(OperatorEnum.MINUS.getValue());
        validateOperandAndReturn(arr);
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        System.out.println(a - b);
    }

    private static void add(String input) {
        String[] arr = input.split(OperatorEnum.ADD.getValue());
        validateOperandAndReturn(arr);
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        System.out.println(a + b);
    }

    private static void divide(String input) {
        String[] arr = input.split(OperatorEnum.DIVIDE.getValue());
        validateOperandAndReturn(arr);
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        System.out.println(a / b);
    }

    private static String[] validateOperandAndReturn(String[] arr) {
        if (arr.length > 2) {
            throw new RuntimeException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim();
        }
        return arr;
    }

    enum OperatorEnum {
        ADD("+"),
        MINUS("-"),
        DIVIDE("/"),
        MULTIPLY("*");

        private String value;
        OperatorEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return this.getValue();
        }
    }
}
