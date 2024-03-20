import commands.*;
import controllers.MainLoop;
import utilities.Asker;
import utilities.FileManager;
import utilities.HumanBeingList;
import utilities.XML;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Map<String, Command> commands  = new LinkedHashMap<>();
        HumanBeingList humanBeings =  XML.XMLToHuman(FileManager.readCollection().toArray(new String[0]));
        Scanner scanner = new Scanner(System.in);
        Asker asker = new Asker(scanner);

        commands.put("add",new Add(humanBeings,asker));
        commands.put("show",new Show(humanBeings));
        commands.put("save",new Save(humanBeings));
        commands.put("clear",new Clear(humanBeings));
        commands.put("update",new Update(humanBeings,asker));
        commands.put("remove_by_id",new RemoveById(humanBeings));
        commands.put("insert_at",new InsertAt(humanBeings,asker));
        commands.put("remove_at",new RemoveAt(humanBeings));
        commands.put("remove_first",new RemoveFirst(humanBeings));
        commands.put("remove_any_by_weapon_type",new RemoveAnyByWeaponType(humanBeings));
        commands.put("filter_starts_with_name",new FilterStartsWithName(humanBeings));
        commands.put("help",new Help(commands));
        commands.put("exit",new Exit());

        MainLoop controlLoop = new MainLoop(commands,scanner,asker,humanBeings);
        controlLoop.execute();


    }
}