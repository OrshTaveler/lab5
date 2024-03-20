package controllers;

import commands.Command;
import utilities.Asker;
import utilities.FileManager;
import utilities.HumanBeingList;
import utilities.InputGetter;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Класс наследник ControlLoop. Получает команды из файла скрипта.
 * @author Ubica228
 */
public class ScriptLoop extends ControlLoop {
    String currentPath;
    HumanBeingList humanBeings;

    public ScriptLoop(Map<String,Command> commands, Scanner scanner, Asker asker, String scriptPath, HumanBeingList humanBeings){
        super(commands,scanner,asker,new InputGetter(scanner,true));
        this.currentPath = scriptPath;
        this.humanBeings = humanBeings;
    }
    @Override
    public boolean execute() {
        boolean work = true;
        String[] commandInput;
        String   commandName;
        while (work){
            try {
                commandInput = this.inputGetter.getInputLine();
                commandName = commandInput[0];
                if (commandName.isEmpty()) {continue;}
            }
            catch (NoSuchElementException e){
                return work;
            }
            try {
                switch (commandName) {
                    case ("exit") -> {
                        return false;
                    }
                    case ("execute_script") -> {
                        if (!commandInput[1].equals(this.currentPath)) {
                                Scanner scriptScanner =  FileManager.getFileScanner(commandInput[1]);
                                asker.changeScanner(scriptScanner);

                                ScriptLoop scriptLoop = new ScriptLoop(commands, scriptScanner,asker,commandInput[1],humanBeings);
                                work = scriptLoop.execute();

                                asker.changeScanner(scanner);
                        }
                    }
                    default -> {
                        if(!this.commands.get(commandName).execute(commandInput)) return true;
                    }
                }

            }
            catch (NullPointerException e){
                System.out.println("Не существующая команда - "+ commandName);
                return true;
            }
            catch (FileNotFoundException e){
                System.out.println("Файл скрипта не найден!");
                return true;
            }
            catch (Exception e){
                System.out.println("Ошибка "+ e +" в скрипте - "+ Arrays.toString(commandInput));
                return true;
            }
        }
        return work;
    }
}
