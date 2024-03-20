package commands;

import customexceptions.IncorrectDataInScript;
import utilities.Asker;
import utilities.HumanBeingList;
/**
 * Команда 'add'. Добавляет новый элемент в коллекцию.
 * @author Ubica228
 */

public class Add extends Command{
    private HumanBeingList humanBeings;
    private Asker asker;

    public Add(HumanBeingList humanBeings, Asker asker){
        super("add","Добавляет людей в списочек");
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
            humanBeings.add(asker.askHumanBeing(humanBeings.idPointer));
        }
         catch (IncorrectDataInScript e){
             System.out.println("При добавлении нового HumanBeing произошла ошибка с комментарием - "+e.getMessage()+", проверьте скрипт");
             return false;
         }
         return true;
    }
}
