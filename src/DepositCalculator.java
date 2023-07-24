import java.util.Scanner;

public class DepositCalculator {
double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
    return roundValue(amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod), 2);
}

double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
    return roundValue(amount + amount * yearRate * depositPeriod, 2);
}

double roundValue(double value, int power) {
    double decimalScale = Math.pow(10, power);

    return Math.round(value * decimalScale) / decimalScale;
}

void callCalculator() {
    int depositPeriod;
    int action;
    double result = 0;
    Scanner userInput = new Scanner(System.in);

    System.out.println("Введите сумму вклада в рублях:");
    int amount = userInput.nextInt();

    System.out.println("Введите срок вклада в годах:");
    depositPeriod = userInput.nextInt();

    System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
    action = userInput.nextInt();


    if (action == 1) {
        result = calculateSimplePercent(amount, 0.06, depositPeriod);
    } else if (action == 2) {
        result = calculateComplexPercent(amount, 0.06, depositPeriod);
    }
    System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + result);
}

public static void main(String[] args) {
    new DepositCalculator().callCalculator();
}

}