package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ToDoListController
{
	@FXML
	private DatePicker inputDate;
	@FXML
	private TextField taskDesc;
	@FXML
	private TextField toDoListName;

	@FXML
	private TableView<createTodoList> listTable;
	@FXML
	private TableColumn statusList;
	@FXML
	private TableColumn<createTodoList, String> taskList;
	@FXML
	private TableColumn<createTodoList, String> dateList;
	@FXML
	private TableColumn<createTodoList, String> descList;

	ObservableList<createTodoList> bufferList = FXCollections.observableArrayList();
	//private int index = -1;

	@FXML
	public void addToDoClick(ActionEvent actionEvent)
	{
		String buffer;
		// This will obtain the text found in the textfield from toDoListName and tranfer it to toDoList
		// The list will be updated to match that change

		// Check if the string in toDoListName is empty or not. If empty, skip it.
		// Otherwise add content of toDoListName to the buffer and appply that to toDoList
		if (!(toDoListName.getText().trim().isEmpty()) &&
				inputDate.getConverter().fromString(inputDate.getEditor().getText()) != null &&
				!(taskDesc.getText().trim().isEmpty()))
		{

			bufferList.add(new createTodoList(toDoListName.getText(),
					inputDate.getConverter().fromString(inputDate.getEditor().getText()),
					taskDesc.getText()));

			taskList.setCellValueFactory(new PropertyValueFactory<createTodoList, String>("name"));
			dateList.setCellValueFactory(new PropertyValueFactory<createTodoList, String>("date"));
			descList.setCellValueFactory(new PropertyValueFactory<createTodoList, String>("desc"));
			listTable.setItems(bufferList);
		}
	}

	/*@FXML
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

	}*/


	@FXML
	public void exportAllClick(ActionEvent actionEvent)
	{
		// This will export ALL todoLists into a txt file or a csv. (not sure which one to do just yet)
	}
}
