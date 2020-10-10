package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;
    private CoffeeMachineState state;

    CoffeeMachine(int water, int milk, int coffeeBeans, int cups, int money, CoffeeMachineState state) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
        this.state = state;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550, CoffeeMachineState.ON);

        while (coffeeMachine.state != CoffeeMachineState.OFF) {

            System.out.println(coffeeMachine.state.getMessage());
            coffeeMachine.processInput(scanner.nextLine());

        }
    }

    void processInput(String input) {
        switch (state) {
            case ON:
                chooseAction(input);
                break;
            case BUY:
                chooseCoffee(input);
                break;
            case FILL_WATER:
                fillWater(input);
                break;
            case FILL_MILK:
                fillMilk(input);
                break;
            case FILL_BEANS:
                fillBeans(input);
                break;
            case FILL_CUPS:
                fillCups(input);
                break;
        }
    }

    void chooseAction(String action) {
        switch (action) {
            case "buy":
                state = CoffeeMachineState.BUY;
                break;
            case "fill":
                state = CoffeeMachineState.FILL_WATER;
                break;
            case "take":
                takeMoney();
                break;
            case "remaining":
                printMachineContent();
                break;
            case "exit":
                state = CoffeeMachineState.OFF;
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    void chooseCoffee(String choice) {
        switch (choice) {
            case "1":
                makeCoffee(CoffeeDrink.ESPRESSO);
                break;
            case "2":
                makeCoffee(CoffeeDrink.LATTE);
                break;
            case "3":
                makeCoffee(CoffeeDrink.CAPPUCCINO);
                break;
            case "back":
                state = CoffeeMachineState.ON;
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    void makeCoffee(CoffeeDrink drink) {
        if (water < drink.getWater()) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < drink.getMilk()) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeBeans < drink.getBeans()) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cups < drink.getCups()) {
            System.out.println("Sorry, not enough coffee cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= drink.getWater();
            milk -= drink.getMilk();
            coffeeBeans -= drink.getBeans();
            cups -= drink.getCups();
            money += drink.getCost();
        }

        state = CoffeeMachineState.ON;
    }

    void fillWater(String waterAmount) {
        try {
            water += Integer.parseInt(waterAmount);
            state = CoffeeMachineState.FILL_MILK;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
    }

    void fillMilk(String milkAmount) {
        try {
            milk += Integer.parseInt(milkAmount);
            state = CoffeeMachineState.FILL_BEANS;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
    }

    void fillBeans(String beansAmount) {
        try {
            coffeeBeans += Integer.parseInt(beansAmount);
            state = CoffeeMachineState.FILL_CUPS;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
    }

    void fillCups(String cupsAmount) {
        try {
            cups += Integer.parseInt(cupsAmount);
            state = CoffeeMachineState.ON;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
    }

    void takeMoney() {
        System.out.printf("I gave you $%s%n", money);
        money = 0;
    }

    void printMachineContent() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println();
    }
}


