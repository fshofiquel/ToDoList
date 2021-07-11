/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Fazlur Shofiquel
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;

import java.time.format.DateTimeFormatter;

public class ToDoListController
{
	// Input variables
	@FXML
	private DatePicker inputDate;
	@FXML
	private TextField taskDesc;
	@FXML
	private TextField toDoListName;

	// Table elements
	@FXML
	private TableView<createTodoList> listTable;
	@FXML
	private TableColumn<createTodoList, CheckBox> statusList;
	@FXML
	private TableColumn<createTodoList, String> taskList;
	@FXML
	private TableColumn<createTodoList, String> dateList;
	@FXML
	private TableColumn<createTodoList, String> descList;

	ObservableList<createTodoList> bufferList = FXCollections.observableArrayList();
	private int index = -1;

	@FXML
	public void addToDoClick(ActionEvent actionEvent)
	{
		// This will obtain the text found in the textfield from toDoListName and tranfer it to toDoList
		// The list will be updated to match that change

		// Check if the string in toDoListName is empty or not. If empty, skip it.
		// Otherwise add content of toDoListName to the buffer and appply that to toDoList
		if (!(toDoListName.getText().trim().isEmpty()) &&
				inputDate.getConverter().fromString(inputDate.getEditor().getText()) != null &&
				!(taskDesc.getText().trim().isEmpty()))
		{
			// Fill Buffer List
			populateBuffer();
			// Created function to remove clutting of addToDoClick
			setTheCells();
			// applies bufferList to listTable
			listTable.setItems(bufferList);
		}

		// Clears all three inputs.
		inputDate.getEditor().clear();
		taskDesc.clear();
		toDoListName.clear();
	}

	// Sets the cell value factory and enables editing of the date and desc cells of the tasks.
	// Moved here because it was getting cluttered.
	@FXML
	public void setTheCells()
	{
		listTable.setEditable(true);

		statusList.setCellValueFactory(new PropertyValueFactory<>("box"));
		taskList.setCellValueFactory(new PropertyValueFactory<>("name"));
		dateList.setCellValueFactory(new PropertyValueFactory<>("date"));
		dateList.setCellFactory(TextFieldTableCell.forTableColumn());
		descList.setCellValueFactory(new PropertyValueFactory<>("desc"));
		descList.setCellFactory(TextFieldTableCell.forTableColumn());
	}

	// Everytime the required data is added they are applied to the bufferList.
	@FXML
	public void populateBuffer()
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		CheckBox ch = new CheckBox();
		bufferList.add(new createTodoList(ch, toDoListName.getText(),
				inputDate.getValue().format(formatter),
				taskDesc.getText()));
	}

	// Update the index value of the current index of the listview
	@FXML
	public void toDoListSelectClick(MouseEvent mouseEvent)
	{
		index = listTable.getSelectionModel().getSelectedIndex();
	}

	// remove the selected toDolist
	@FXML
	public void removeTodoClick(ActionEvent actionEvent)
	{
		if (index != -1)
		{
			listTable.getItems().remove(index);
		}

	}

	// Remove entire list
	@FXML
	public void removalAllClick(ActionEvent actionEvent)
	{
		listTable.getItems().clear();
	}

	@FXML
	public void exportAllClick(ActionEvent actionEvent)
	{
		// This will export ALL todoLists into a txt file or a csv. (not sure which one to do just yet)
	}
}
