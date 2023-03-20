package com.project.todolist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project.todolist.task.TaskRepository;

import org.assertj.core.api.Assertions;

@DataJpaTest
public class TaskRepositoryTests {
    
	@Autowired
	private TaskRepository taskRepository;

	@AfterEach
	void tearDown(){
		taskRepository.deleteAll();
	}

    @Test
	void exampleTest() {
		//	given
		boolean expected;
		
		// 	when
		expected = true;

		//	then
		Assertions.assertThat(expected).isTrue();
	}
}
