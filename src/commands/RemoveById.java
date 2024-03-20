package commands;

import customexceptions.IncorrectDataInScript;
import initials.HumanBeing;
import utilities.Asker;

import java.util.ArrayList;
/**
 * Команда 'remove_by_id'. Удаляет элемент из коллекции по полю id класса HumanBeing.
 * @author Ubica228
 */
public class RemoveById extends Command{
    private ArrayList<HumanBeing> humanBeings;


    public RemoveById(ArrayList<HumanBeing> humanBeings){
        super("remove_by_id","Удаляет людей по ID");
        this.humanBeings = humanBeings;
    }
    /**
     * Выполняет команду
     * @return  Успешность выполнения команды
     * */
    @Override
    public boolean execute(String[] arguments) {
        try{
            int id = Integer.parseInt(arguments[1]);
            for(int i = 0; i<humanBeings.size();i++){
                if (humanBeings.get(i).getId() == id){
                    humanBeings.remove(i);
                    return true;
                }
            }
            System.out.println("Человека с таким id нет");
            return false;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Вы не ввели ID человека");
            return false;
        }
        catch (NumberFormatException e){
            System.out.println("ID представляет собой число.");
            return false;
        }
    }
}
