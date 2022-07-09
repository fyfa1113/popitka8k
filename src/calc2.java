import java.util.Objects;
public class calc2 {
    public calc2(String number1, String number2, String oper)
    {
        a = number1;
        b = number2;
        operation = identifyNumOperation(oper);
    }

    private static int identifyNumOperation(String operator)
    {
        int operation = 0;
        if (Objects.equals(operator, "*")) operation = 1;
        else if (Objects.equals(operator, "/")) operation = 2;
        else if (Objects.equals(operator, "+")) operation = 3;
        else if (Objects.equals(operator, "-")) operation = 4;
        try
        {
            if (operation == 0) throw new Exception("не верный символ");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.exit(0);
        }

        return operation;
    }

    public void verifyInputValues()
    {
        try
        {

            if ((isRomanNum(a)) && (isArabNum(a)) || (isRomanNum(b) && (isArabNum(b))))
                throw new Exception(" Допускаются только значения от 1 до 10 ");
            if (isRomanNum(a) && isRomanNum(b) || isArabNum(a) && isArabNum(b))
            {}
            else throw new Exception(" Недопустимое значение или используются несовместимые символы");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.exit(0);
        }

    }

    public static boolean isRomanNum(String number)
    {
        boolean result = false;
        for (int i = 0; i < 10; i++)
        {
            if (number.toLowerCase().equals(roman[i])) {
                result = true;
                break;
            }
        }
        return result;

    }



    public static boolean isArabNum(String number)
    {
        boolean result = false;
        for (int arabic = 1; arabic <= 10; arabic++)
        {
            try
            {
                if (Integer.parseInt(number) == arabic) result = true;

            }
            catch (Exception ex)
            {
                return result;
            }

        }
        return result;

    }


    public void calculate(boolean verifyValues)
    {
        String number1;
        String number2;
        boolean isRoman;
        if (verifyValues) verifyInputValues();
        isRoman = isRomanNum(a) || isRomanNum(b);
        if (isRoman)
        {
            number1 = toArabic(a);
            number2 = toArabic(b);
        }
        else
        {
            number1 = a;
            number2 = b;
        }

        int c = 0;
        System.out.println("Ответ");

        {
            switch (operation) {
                case 1 -> c = Integer.parseInt(number1) * Integer.parseInt(number2);
                case 2 -> c = Integer.parseInt(number1) / Integer.parseInt(number2);
                case 3 -> c = Integer.parseInt(number1) + Integer.parseInt(number2);
                case 4 -> c = Integer.parseInt(number1) - Integer.parseInt(number2);
            }
        }
        if (isRoman) System.out.println(toRoman(Integer.toString(c)).toUpperCase());
        else System.out.println(c);
        System.out.println("\n");
    }


    public static String toRoman(String number)
    {
        StringBuilder result = new StringBuilder();
        String cyfral;
        for (int i = number.length(); i > 0; i--)
        {
            cyfral = number.substring(i - 1 , i);
            if (Integer.parseInt(cyfral) == 0)
                continue;
            switch (number.length() - i) {
                case 0 -> result.insert(0, roman[Integer.parseInt(cyfral) - 1]);
                case 1 -> result.insert(0, romanDecs[Integer.parseInt(cyfral) - 1]);
                case 2 -> result = new StringBuilder("c");
            }
        }
        return result.toString();

    }
    public static String toArabic(String number)
    {
        String result = "0";
        if (isRomanNum(number))
        {
            for (int i = 0; i < 10; i++)
            {
                if (number.toLowerCase().equals(roman[i]))
                {
                    result = Integer.toString(i + 1);
                    break;
                }

            }

        }
        return result;
    }

    private static String a = "";
    private static String b = "";
    private static int operation = 0;
    private static final String[] roman = { "i", "ii", "iii", "iv", "v",
            "vi", "vii", "viii", "ix", "x" };
    private static final String[] romanDecs = { "x", "xx", "xxx", "xl",
            "l", "lx", "lxx", "lxxx", "xc"};
}


