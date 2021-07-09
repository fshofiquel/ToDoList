package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ToDoListController
{

	@FXML
	private ListView<String> toDosList;
	@FXML
	private TextField toDoListName;
	@FXML
	private ListView tasksList;
	@FXML
	private TextField editTasks;

	ObservableList<String> bufferString = FXCollections.observableArrayList();
	private int index = -1;

	@FXML
	public void addToDoClick(ActionEvent actionEvent)
	{
		// This will obtain the text found in the textfield from toDoListName and tranfer it to toDoList
		// The list will be updated to match that change

		// Check if the string in toDoListName is empty or not. If empty, skip it.
		// Otherwise add content of toDoListName to the buffer and appply that to toDoList
		if (!(toDoListName.getText().trim().isEmpty()))
		{
			bufferString.add(toDoListName.getText());

			// Clears the textfield with an empty string.
			toDoListName.setText("");
			toDosList.setItems(bufferString);
		}
	}

	@FXML
	public void toDoListSelectClick(MouseEvent mouseEvent)
	{
		// Update the index value of thec current index of the listview
		index = toDosList.getSelectionModel().getSelectedIndex();
	}

	@FXML
	public void removeTodoClick(ActionEvent actionEvent)
	{
		// remove the selected toDolist
		if (index != -1)
		{
			toDosList.getItems().remove(index);
		}

	}


	@FXML
	public void exportAllClick(ActionEvent actionEvent)
	{
		// This will export ALL todoLists into a txt file or a csv. (not sure which one to do just yet)
	}

	@FXML
	public void exportListClick(ActionEvent actionEvent)
	{
		// this will export a singular list
	}


	@FXML
	public void addOrEditClick(ActionEvent actionEvent)
	{
		// edits, adds or removes a list (still very bareboned, will most likely be seperated into different
		// buttons to handle it more smoothly
	}

	@FXML
	public void viewClick(ActionEvent actionEvent)
	{
		// changes between lists (this might become obselete if I figure out how to change to different lists just by
		// clicking the individual todos
	}


}
