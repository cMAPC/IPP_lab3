package Memento;

public class MainMemento {

    public static void main(String[] args) {
        CarGame game = new CarGame();
        game.set("Audi R8", 2);
        System.out.println(game);

        File file = new File();
        file.setSave(game.save());

        game.set("BMW M3", 1);
        System.out.println(game);
        game.load(file.getSave());
        file.setSave(game.save());
        System.out.println(game);
    }
}




// Originator
class CarGame {
    private String carName;
    private int mission;
    public void set(String carName, int mission) {
        this.carName = carName;
        this.mission = mission;
    }

    public void load(GameState save){
        carName = save.getCarName();
        mission = save.getMission();
    }

    public GameState save(){
        return new GameState(carName, mission);
    }

    public String toString() {
        return "Game{" +
                "Car model ='" + carName + '\'' +
                ", Mission =" + mission +
                '}';
    }
}

// Memento
class GameState {
    private final String carName;
    private final int mission;

    public GameState(String carName, int mission) {
        this.carName = carName;
        this.mission = mission;
    }

    public String getCarName() {
        return carName;
    }
    public int getMission() {
        return mission;
    }
}

// Caretaker
class File {
    GameState save;
    public GameState getSave() {
        return save;
    }
    public void setSave(GameState save) {
        this.save = save;
    }
}