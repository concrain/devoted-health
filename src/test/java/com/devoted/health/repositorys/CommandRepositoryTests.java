package com.devoted.health.repositorys;

import com.devoted.health.domains.Command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class CommandRepositoryTests {

    @Autowired
    private CommandRepository repository;

    @Test
    public void should_store_a_command() {
        Command cmd = new Command("Russel","Engineer");
        repository.insert(cmd);

        assertThat(cmd).hasFieldOrPropertyWithValue("Russel", "Engineer");
    }

    @Test
    public void should_delete_a_command() {
        Command cmd = new Command("Russel","Engineer");
        repository.insert(cmd);

        repository.deleteByName("Russel");

        assertThat(repository.findByName("Russel")).isEmpty();
    }

    @Test
    public void should_find_a_command_by_name() {
        Command cmd = new Command("Russel","Engineer");
        repository.insert(cmd);

        Command foundCommand = repository.findObjectByName("Russel");

        assertThat(foundCommand).isEqualTo(cmd);
    }
}
