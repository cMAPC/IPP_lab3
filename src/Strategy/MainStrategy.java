package Strategy;

public class MainStrategy {

    public static void main(String[] args) {
        StrategyClient strategyClient = new StrategyClient();

        strategyClient.setConstructStrategy(new ManualCarConstructStrategy());
        strategyClient.executeStrategy();

        strategyClient.setConstructStrategy(new AutomateCarConstructStrategy());
        strategyClient.executeStrategy();
    }
}

// Client Strategy
class StrategyClient {
    CarConstructStrategy carConstructStrategy;
    public void setConstructStrategy(CarConstructStrategy carConstructStrategy) {
        this.carConstructStrategy = carConstructStrategy;
    }
    public void executeStrategy() {
        carConstructStrategy.construct();
    }
}

// Strategy
interface CarConstructStrategy {
    void construct ();
}

// Concrete Strategy 1
class ManualCarConstructStrategy implements CarConstructStrategy {
    public void construct() {
        System.out.println("Car was constructed in manual mode");
    }
}

// Concrete Strategy 2
class AutomateCarConstructStrategy implements CarConstructStrategy {
    public void construct() {
        System.out.println("Car was constructed in automate mode");
    }
}