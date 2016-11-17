package Mediator;

import java.util.ArrayList;
import java.util.List;

public class MainMediator {

    public static void main(String[] args) {

//        CarMediator carMediator = new CarMediator();
//
//        CarPieces enginePiece = new CarEngine(carMediator);
//        CarPieces bodyPiece = new CarBody(carMediator);
//        CarPieces wheelsPiece = new CarWheels(carMediator);
//
//        carMediator.addPiecesToAssambly(enginePiece);
//        carMediator.addPiecesToAssambly(bodyPiece);
//        carMediator.addPiecesToAssambly(wheelsPiece);
//        carMediator.assamblyCar();
        TextChat chat = new TextChat();

        User admin = new Admin(chat);
        User user1 = new SimpleUser(chat);
        User user2 = new SimpleUser(chat);

        chat.setAdmin(admin);
        chat.addUser(user1);
        chat.addUser(user2);

        user1.sendMessage("Hello from user 1");
        admin.sendMessage("Hello from admin");
    }
}

//// Abstract Colleague
//interface CarPieces {
//    void getPiece();
//}
//// Abstract Mediator
//interface Mediator {
//    void assamblyCar();
//}
//
//// Concrete Mediator
//class CarMediator implements Mediator{
//
//    List<CarPieces> carPiecesList = new ArrayList<>();
//    public void addPiecesToAssambly(CarPieces carPieces){
//        carPiecesList.add(carPieces);
//    }
//    public void assamblyCar() {
//        for (CarPieces pieces : carPiecesList) {
//            pieces.getPiece();
//            System.out.println("Piece was assambled");
//        }
//    }
//}
//
//// Concrete colleague's
//class CarEngine implements CarPieces {
//    Mediator mediator;
//    public CarEngine(Mediator mediator) {
//        this.mediator = mediator;
//    }
//    public void getPiece() {
//        System.out.println("Car engine getting");
//    }
//}
//
//class CarWheels implements CarPieces {
//    Mediator mediator;
//    public CarWheels(Mediator mediator) {
//        this.mediator = mediator;
//    }
//    public void getPiece() {
//        System.out.println("Car wheels getting");
//    }
//}
//
//class CarBody implements CarPieces {
//    Mediator mediator;
//    public CarBody(Mediator mediator) {
//        this.mediator = mediator;
//    }
//    public void getPiece() {
//        System.out.println("Car body getting");
//    }
//}



// Client
interface User {
     void sendMessage(String message);
     void getMessage(String message);
}

// Concrete CLIENT 1
class Admin implements User {
    Chat chat;
    public Admin(Chat chat) {
        this.chat = chat;
    }

    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }
    public void getMessage(String message) {
        System.out.println("Admin get the message : " + message);
    }
}

// Concrete CLIENT 2
class SimpleUser implements User {
    Chat chat;
    public SimpleUser(Chat chat) {
        this.chat = chat;
    }

    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }
    public void getMessage(String message) {
        System.out.println("User get the message : " + message);
    }
}

// Mediator
interface Chat {
    void sendMessage(String message, User user);
}

// Concrete mediator
class TextChat implements Chat {
    User admin;
    List<User> userList = new ArrayList<>();

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void sendMessage(String message, User user) {
        for (User userClient: userList) {
            userClient.getMessage(message);
        }
        admin.getMessage(message);
    }
}