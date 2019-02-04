package com.devoted.health.utilities;

import com.devoted.health.services.CommandProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@EnableAutoConfiguration
public class CommandRunner {

    @Autowired
    CommandProcessor commandProcessor;

    // system prompt
    private Scanner scanner = new Scanner(System.in);
    private String nextLine = "";

    private String sample =
            "\n    SET[name][value]\n" +
                    "    GET[name]\n" +
                    "    DELETE[name]\n" +
                    "    COUNT[name]\n" +
                    "    BEGIN\n" +
                    "    ROLLBACK\n" +
                    "    COMMIT\n" +
                    "    END\n";

    public void startConsole() {

        System.out.println("\nDevoted Health Interview Application");
        runScanner();
    }

    private void runScanner() {

        // ex.. SET[myName][myValue]
        String command;
        String name;
        String value;

        while (true) {
            showInputCommands();

            if (nextLine.equals("END")) {
                break;
            }

            if (nextLine.equals("HELP")) {
                System.out.println(String.format("Requesting Format: %30s", sample));
                continue;
            }

            String[] subLine = cleanInput(nextLine);

            if (subLine[0].equals("SET")) {
                if (subLine.length == 3) {
                    command = subLine[0];
                    name = subLine[1];
                    value = subLine[2];
                    runCommands(command, name, value);
                } else {
                    invalidCommand();
                    continue;
                }
            }

            if (subLine[0].equals("GET") || subLine[0].equals("DELETE") || subLine[0].equals("COUNT")) {
                if (subLine.length == 2) {
                    command = subLine[0];
                    name = subLine[1];
                    runCommands(command, name, null);
                } else {
                    invalidCommand();
                    continue;
                }
            }

            if (subLine[0].equals("BEGIN") || subLine[0].equals("ROLLBACK") || subLine[0].equals("COMMIT")) {
                if (subLine.length == 1) {
                    command = subLine[0];
                    runCommands(command, null, null);
                } else {
                    invalidCommand();
                    continue;
                }
            }
        }

    }

    private void runCommands(String cmd, String name, String value) {

        switch (cmd) {
            case "SET":
                commandProcessor.setCommandObject(name, value);
                break;
            case "GET":
                System.out.println(commandProcessor.getCommandObject(name));
                break;
            case "DELETE":
                commandProcessor.deleteCommandObject(name);
                break;
            case "COUNT":
                System.out.println(commandProcessor.countCommandObjects(name));
                break;
            case "BEGIN":
                //commandProcessor.beginTransaction();
                break;
            case "ROLLBACK":
                //commandProcessor.rollbackTransaction();
                break;
            case "END":
                //commandProcessor.endTransaction();
                break;
            case "COMMIT":
                //commandProcessor.commitTransaction();
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void showInputCommands() {
        System.out.println("\nEnter your commands: 'END' to exit the Database: 'HELP' for commands\n");
        nextLine = scanner.next();
    }

    private String[] cleanInput(String s) {
        String temp = s.replaceAll("\\[", ",");
        temp = temp.replaceAll("\\]", "");
        return temp.split(",");
    }

    private void invalidCommand() {
        System.out.println(String.format("Invalid Command: %30s", nextLine));
        System.out.println(String.format("Requesting Format: %30s", sample));
    }
}