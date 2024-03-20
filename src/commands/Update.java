package commands;

import customexceptions.IncorrectDataInScript;
import utilities.Asker;
import utilities.HumanBeingList;

import java.util.NoSuchElementException;

/**
 * Команда 'update'. Обновляет коллекцию, заменяя некоторый элемент на новый.
 * @author Ubica228
 */
public class Update extends Command{
    private HumanBeingList humanBeings;
    private Asker asker;

    public Update(HumanBeingList humanBeings, Asker asker){
        super("update","Обновляет людей в списочке");
        this.asker = asker;
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
            int index = humanBeings.getIndexById(id);
            humanBeings.remove(humanBeings.getById(id));
            humanBeings.add(index,asker.askHumanBeing(humanBeings.idPointer));
            return true;
        }
        catch (IncorrectDataInScript e){
            System.out.println("При обновлении HumanBeing произошла ошибка с комментарием - "+e.getMessage()+", проверьте скрипт");
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
        catch (NoSuchElementException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
