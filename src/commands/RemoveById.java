package commands;

import utilities.HumanBeingList;

import java.util.NoSuchElementException;

/**
 * Команда 'remove_by_id'. Удаляет элемент из коллекции по полю id класса HumanBeing.
 * @author Ubica228
 */
public class RemoveById extends Command{
    private HumanBeingList humanBeings;


    public RemoveById(HumanBeingList humanBeings){
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
            humanBeings.remove(humanBeings.getById(id));
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Вы не ввели ID человека");
            return false;
        }
        catch (NumberFormatException e){
            System.out.println("ID представляет собой число.");
            return false;
        }
        catch (NoSuchElementException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
