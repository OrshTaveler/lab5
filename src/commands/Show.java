package commands;

import initials.HumanBeing;

import java.util.ArrayList;
/**
 * Команда 'show'. Выводит все элементы коллекции.
 * @author Ubica228
 */
public class Show extends Command{
    ArrayList<HumanBeing> humanBeings;
    public Show(ArrayList<HumanBeing> humanBeings){
        super("show","Показывает людей");
        this.humanBeings = humanBeings;
    }
    @Override
    public boolean execute(String[] arguments) {
        for(HumanBeing humanBeing: humanBeings){
            System.out.println(humanBeing.toString());
        }
        return true;
    }
}
