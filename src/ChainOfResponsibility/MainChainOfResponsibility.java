package ChainOfResponsibility;

public class MainChainOfResponsibility {

    public static void main(String[] args) {
        CarHandler carHandler = new CarBodyHandler();
        CarHandler carHandler1 = new CarEngineHandler();
        CarHandler carHandler2 = new CarWheelsHandler();
        carHandler.nextHandler = carHandler1;
        carHandler1.nextHandler = carHandler2;

        carHandler.HandleItem(new CarEngine());

    }
}


interface CarItem {

}

class CarBody implements CarItem{

}

class CarEngine implements CarItem{

}

class CarWheels implements CarItem{

}

// Basic Handler
abstract class CarHandler {
    abstract void HandleItem(CarItem carItem);
    CarHandler nextHandler;
}

// Concrete Handler 1
class CarBodyHandler extends CarHandler{
    void HandleItem(CarItem carItem) {
        if(carItem instanceof CarBody) {
            System.out.println("Car Body found. Handling");
        }
        else
        {
            System.out.println("Car Body not found. Handling using next handler");
            nextHandler.HandleItem(carItem);
        }
    }
}

// Concrete Handler 2
class CarEngineHandler extends CarHandler{
    void HandleItem(CarItem carItem) {
        if(carItem instanceof CarEngine) {
            System.out.println("Car engine found. Handling");
        }
        else
        {
            System.out.println("Car engine not found. Handling using next handler");
            nextHandler.HandleItem(carItem);
        }
    }
}

// Concrete Handler 3
class CarWheelsHandler extends CarHandler{
    void HandleItem(CarItem carItem) {
        if(carItem instanceof CarWheels) {
            System.out.println("Car wheels found. Handling");
        }
        else
        {
            System.out.println("Car wheels not found. Handling using next handler");
            nextHandler.HandleItem(carItem);
        }
    }
}



