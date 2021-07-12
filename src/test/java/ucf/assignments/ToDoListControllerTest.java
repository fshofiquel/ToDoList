package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListControllerTest
{
	@Test
	void populateBuffer()
	{
		// Create overservable list and populate
		ObservableList<createTodoList> bufferList = FXCollections.observableArrayList();
		bufferList.add(new createTodoList("x", "Faz", "1996-05-19", "This is a desc"));

		// Assert the values are correctly populated into buffer list
		assertEquals("x", bufferList.get(0).getStatus());
		assertEquals("Faz", bufferList.get(0).getName());
		assertEquals("1996-05-19", bufferList.get(0).getDate());
		assertEquals("This is a desc", bufferList.get(0).getDesc());
	}
}