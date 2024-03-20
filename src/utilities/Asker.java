package utilities;

import customexceptions.IncorrectDataInScript;
import initials.Car;
import initials.Coordinates;
import initials.HumanBeing;
import initials.WeaponType;

import java.util.Scanner;
/**
 * Класс, создающий объекты некоторых классов, получая необходимые для этого данные из указаного потока.
 * @author Ubica228
 */
public class Asker {
    public boolean fromScript;
    InputGetter inputGetter;
    public Asker(boolean fromScript, Scanner scanner){
        this.fromScript = fromScript;
        this.inputGetter = new InputGetter(scanner,fromScript);
    }
    public Asker(Scanner scanner){
        this.fromScript = false;
        this.inputGetter = new InputGetter(scanner,fromScript);
    }
    public void changeMode(){
        this.fromScript = !this.fromScript;
    }
    public void changeScanner(Scanner scanner){
        this.inputGetter = new InputGetter(scanner,fromScript);
    }

    public Car askCar(){
        if(!fromScript) System.out.print("Название машины:");
        String name = inputGetter.getString();
        return new Car(name);
    }
    public Coordinates askCoordinates() throws IncorrectDataInScript {

         if(!fromScript) System.out.print("X:");
         double x = inputGetter.getDouble(Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
         if(!fromScript) System.out.print("Y:");
         long y   = inputGetter.getLong(-660.0,Double.POSITIVE_INFINITY);
         return new Coordinates(x,y);
    }
    public HumanBeing askHumanBeing(int idPointer) throws IncorrectDataInScript{
        HumanBeing humanBeing;

        if(!fromScript) System.out.print("Имя:");
        String name = inputGetter.getString();


        if(!fromScript) System.out.print("Настоящий герой?:");
        boolean realHero = inputGetter.getBoolean();

        if(!fromScript) System.out.print("Есть зубачистка?:");
        boolean hasToothpick = inputGetter.getBoolean();

        if(!fromScript) System.out.print("impactSpeed:");
        float impactSpeed = inputGetter.getFloat(Double.NEGATIVE_INFINITY,411.0);

        if(!fromScript) System.out.print("саундтрек:");
        String soundtrackName = inputGetter.getString();

        if(!fromScript) System.out.print("minutesOfWaiting:");
        long minutesOfWaiting = inputGetter.getLong(Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);

        if(!fromScript) System.out.print("Оружие:");
        WeaponType weaponType = inputGetter.getWeaponType();

        Coordinates coordinates = askCoordinates();
        Car car = askCar();
        humanBeing = new HumanBeing(idPointer+1,name,coordinates,realHero,hasToothpick,impactSpeed,soundtrackName,minutesOfWaiting,weaponType,car);
        return humanBeing;
    }


}
