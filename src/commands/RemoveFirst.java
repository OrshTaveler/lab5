package commands;

import initials.HumanBeing;

import java.util.ArrayList;
/**
 * Команда 'remove_first'. Удаляет первый элемент из коллекции.
 * @author Ubica228
 */
public class RemoveFirst extends Command{
    private ArrayList<HumanBeing> humanBeings;


    public RemoveFirst(ArrayList<HumanBeing> humanBeings){
        super("remove_first","Удаляет первого человека из списочка ");
        this.humanBeings = humanBeings;
    }
    /**
     * Выполняет команду
     * @return  Успешность выполнения команды
     * */
    @Override
    public boolean execute(String[] arguments) {
        try{
            humanBeings.remove(0);
        }
        catch (IndexOutOfBoundsException e){
            return false;
        }
        return true;
    }
}
