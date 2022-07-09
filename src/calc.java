import java.util.Scanner;

public class calc {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String expression;
        String operation = "";
        int operationPos = 0;

        System.out.println("введите выражение");
        expression = in.nextLine();
        expression = expression.toLowerCase().trim();

        if (expression.indexOf("*") > 0)
        {
            operationPos = expression.indexOf("*");
            operation = "*";
        }
        else if (expression.indexOf("/") > 0)
        {
            operationPos = expression.indexOf("/");
            operation = "/";
        }
        else if (expression.indexOf("+") > 0)
        {
            operationPos = expression.indexOf("+");
            operation = "+";
        }
        else if (expression.indexOf("-") > 0)
        {
            operationPos = expression.indexOf("-");
            operation = "-";
        }

        calc2 calc = new calc2(expression.substring(0, operationPos),
                expression.substring(operationPos + 1), operation);

        calc.verifyInputValues();
        calc.calculate(false);

    }

}



