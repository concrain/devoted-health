package com.devoted.health.services;

import com.devoted.health.domains.Command;
import com.devoted.health.repositorys.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CommandProcessor {

    @Autowired
    CommandRepository commandRepository;

    public void setCommandObject(String name, String value) {
        // look for existing object
        Command command = commandRepository.findObjectByName(name);

        if (command == null) {
            // create new object
            Command cmd = new Command(generateUniqueId(), name, value);
            commandRepository.insert(cmd);

        } else {
            // update existing object
            command.setName(name);
            command.setValue(value);
            commandRepository.update(command);
        }
    }

    private Long generateUniqueId() {
        long range = 1234L;
        Random r = new Random();
        return (long) (r.nextDouble() * range);
    }

    public String getCommandObject(String name) {
        return commandRepository.findByName(name);
    }

    public void deleteCommandObject(String name) {
        commandRepository.deleteByName(name);
    }

    public int countCommandObjects(String value) {
        return commandRepository.countByValue(value);
    }


}
