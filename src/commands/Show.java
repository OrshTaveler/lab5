package commands;

import utilities.HumanBeingList;
/**
 * Команда 'show'. Выводит все элементы коллекции.
 * @author Ubica228
 */
public class Show extends Command{
    HumanBeingList humanBeings;
    public Show(HumanBeingList humanBeings){
        super("show","Показывает людей");
        this.humanBeings = humanBeings;
    }
    @Override
    public boolean execute(String[] arguments) {
        System.out.println(humanBeings.toString());
        return true;
    }
}
