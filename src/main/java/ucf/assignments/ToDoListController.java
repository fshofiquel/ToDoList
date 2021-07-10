package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class ToDoListController
{
	@FXML
	public TextArea listDesc;
	public DatePicker inputDate;
	@FXML
	private ListView<String> toDosList;
	@FXML
	private TextField toDoListName;

	ObservableList<String> bufferString = FXCollections.observableArrayList();
	private int index = -1;

	@FXML
	public void addToDoClick(ActionEvent actionEvent)
	{
		// This will obtain the text found in the textfield from toDoListName and tranfer it to toDoList
		// The list will be updated to match that change

		// Check if the string in toDoListName is empty or not. If empty, skip it.
		// Otherwise add content of toDoListName to the buffer and appply that to toDoList
		if (!(toDoListName.getText().trim().isEmpty()) &&
				inputDate.getConverter().fromString(inputDate.getEditor().getText()) != null)
		{
			bufferString.add(toDoListName.getText()+" "
					+String.valueOf(inputDate.getConverter().fromString(inputDate.getEditor().getText())));

			// Clears the textfield and datepicker.
			toDoListName.clear();
			inputDate.getEditor().clear();

			// Applies the content to the bufferString to toDoList
			toDosList.setItems(bufferString);
		}
	}

	@FXML
	public void toDoListSelectClick(MouseEvent mouseEvent)
	{
		// Update the index value of the current index of the listview
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
}
