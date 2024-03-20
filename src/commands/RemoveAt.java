package commands;

import customexceptions.IncorrectDataInScript;
import initials.HumanBeing;
import utilities.Asker;

import java.util.ArrayList;
/**
 * Команда 'remove_at'. Удаляет элемент с введённым.
 * @author Ubica228
 */
public class RemoveAt extends Command{
    private ArrayList<HumanBeing> humanBeings;


    public RemoveAt(ArrayList<HumanBeing> humanBeings){
        super("remove_at","Удаляет людей из списочка по индексу");
        this.humanBeings = humanBeings;
    }
    /**
     * Выполняет команду
     * @return  Успешность выполнения команды
     * */
    @Override
    public boolean execute(String[] arguments) {
        try{
            int index = Integer.parseInt(arguments[1]);
            humanBeings.remove(index-1);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Вы не ввели индекс");
            return false;
        }
        catch (NumberFormatException e){
            System.out.println("Индекс представляет собой число");
            return false;
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Индекс выходит за пределы списка");
            return false;
        }
        return true;
    }
}
