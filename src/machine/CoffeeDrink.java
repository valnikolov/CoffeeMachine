package machine;

public enum CoffeeDrink {
    ESPRESSO(250, 0, 16, 1, 4),
    LATTE(350, 75, 20, 1, 7),
    CAPPUCCINO(200, 100, 12, 1, 6);

    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int cost;

    CoffeeDrink(int water, int milk, int coffeeBeans, int cups, int cost) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.cost = cost;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return coffeeBeans;
    }

    public int getCups() {
        return cups;
    }

    public int getCost() {
        return cost;
    }
}
