package commands;

import customexceptions.IncorrectDataInScript;
import initials.HumanBeing;
import utilities.Asker;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
/**
 * Команда 'add'. Добавляет новый элемент в коллекцию.
 * @author Ubica228
 */

public class Add extends Command{
    private ArrayList<HumanBeing> humanBeings;
    private Asker asker;

    public Add(ArrayList<HumanBeing> humanBeings, Asker asker){
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

             int idPointer;
             if (!humanBeings.isEmpty()) {
                 idPointer = humanBeings.get(humanBeings.size() - 1).getId();
             }
             else {
                 idPointer = 0;
             }
             humanBeings.add(asker.askHumanBeing(idPointer));
        }
         catch (IncorrectDataInScript e){
             System.out.println("При добавлении нового HumanBeing произошла ошибка с комментарием - "+e.getMessage()+", проверьте скрипт");
             return false;
         }
         return true;
    }
}
