package commands;

import utilities.HumanBeingList;
/**
 * Команда 'remove_first'. Удаляет первый элемент из коллекции.
 * @author Ubica228
 */
public class RemoveFirst extends Command{
    private HumanBeingList humanBeings;


    public RemoveFirst(HumanBeingList humanBeings){
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
            humanBeings.remove(humanBeings.getByIndex(0));
        }
        catch (IndexOutOfBoundsException e){
            return false;
        }
        return true;
    }
}
