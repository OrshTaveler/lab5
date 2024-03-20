package commands;

import customexceptions.IncorrectDataInScript;
import initials.HumanBeing;
import utilities.Asker;

import java.util.ArrayList;
/**
 * Команда 'insert_at'. Добавляет элемент в коллекцию по заданому индексу.
 * @author Ubica228
 */
public class InsertAt extends Command{
    private ArrayList<HumanBeing> humanBeings;
    private Asker asker;

    public InsertAt(ArrayList<HumanBeing> humanBeings, Asker asker){
        super("insert_at","Добавляет людей в списочек по индексу");
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
            int index = Integer.parseInt(arguments[1]);
            if (index-1 > humanBeings.size()) throw new IndexOutOfBoundsException();
            int idPointer;
            if (!humanBeings.isEmpty()) {
                idPointer = humanBeings.get(humanBeings.size() - 1).getId();
            }
            else {
                idPointer = 0;
            }
            humanBeings.add(index-1,asker.askHumanBeing(idPointer));
        }
        catch (IncorrectDataInScript e){
            System.out.println("При добавлении нового HumanBeing произошла ошибка с комментарием - "+e.getMessage()+", проверьте скрипт");
            return false;
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
