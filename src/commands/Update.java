package commands;

import customexceptions.IncorrectDataInScript;
import initials.HumanBeing;
import utilities.Asker;

import java.util.ArrayList;
/**
 * Команда 'update'. Обновляет коллекцию, заменяя некоторый элемент на новый.
 * @author Ubica228
 */
public class Update extends Command{
    private ArrayList<HumanBeing> humanBeings;
    private Asker asker;

    public Update(ArrayList<HumanBeing> humanBeings, Asker asker){
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
            for(int i = 0; i<humanBeings.size();i++){
                if (humanBeings.get(i).getId() == id){
                    humanBeings.remove(i);
                    humanBeings.add(i,asker.askHumanBeing(id-1));
                    return true;
                }
            }
            System.out.println("Человека с таким id нет");
            return false;
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
    }
}
