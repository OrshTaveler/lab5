package commands;

import initials.HumanBeing;
import utilities.FileManager;
import utilities.XML;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
/**
 * Команда 'save'. Сохраняет коллекцию в файл.
 * @author Ubica228
 */
public class Save extends Command{
    ArrayList<HumanBeing> humanBeings;
    public Save(ArrayList<HumanBeing> humanBeings){
        super("save","Сохраняет людей");
        this.humanBeings = humanBeings;
    }
    /**
     * Выполняет команду
     * @return  Успешность выполнения команды
     * */
    @Override
    public boolean execute(String[] arguments) {
        try{
         FileManager.save(XML.toXML(humanBeings));
         return true;
        }
        catch (IOException e){
            System.out.println("Ошибка с записью в файл!");
            return false;
        }
    }
}
