package machine;

public enum CoffeeMachineState {
    ON("Write action (buy, fill, take, remaining, exit):"),
    BUY("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:"),
    FILL_WATER("Write how many ml of water do you want to add:"),
    FILL_MILK("Write how many ml of milk do you want to add:"),
    FILL_BEANS("Write how many grams of coffee beans do you want to add:"),
    FILL_CUPS("Write how many disposable cups of coffee do you want to add:"),
    OFF("");

    private String message;

    CoffeeMachineState(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
