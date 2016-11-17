package TemplateMethod;

public class MainTemplateMethod {

    public static void main(String[] args) {
        ConstructCar a = new FamilyCar();
        a.templateMethod();

        System.out.println();

        ConstructCar b = new SportCar();
        b.templateMethod();
    }
}


// Abstract Class
abstract class ConstructCar {
    void templateMethod(){
        System.out.print("Audi ");
        differ1();
        System.out.print("Black Color ");
        differ2();
    }

    abstract void differ1();
    abstract void differ2();
}

// Concrete Class 1
class FamilyCar extends ConstructCar {
    void differ1() {
        System.out.print("Engine power 2.0  " );
    }
    void differ2() {
        System.out.print("Transmission automatic ");
    }
}

// Concrete Class 2
class SportCar extends ConstructCar {
    void differ1() {
        System.out.print("Engine power 3.0 ");
    }
    void differ2() {}
}