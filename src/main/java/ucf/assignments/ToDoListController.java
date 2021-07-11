/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Fazlur Shofiquel
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.function.Predicate;

public class ToDoListController
{
	// Input variables
	@FXML
	private DatePicker inputDate;
	@FXML
	private TextField taskDesc;
	@FXML
	private TextField toDoListName;
	@FXML
	private TextField filePathField;

	// Table elements
	@FXML
	private TableView<createTodoList> listTable;
	@FXML
	private TableColumn<createTodoList, String> statusList;
	@FXML
	private TableColumn<createTodoList, String> taskList;
	@FXML
	private TableColumn<createTodoList, String> dateList;
	@FXML
	private TableColumn<createTodoList, String> descList;

	// Used as buffer to store strings obtained from the textfields and store them into TableView
	ObservableList<createTodoList> bufferList = FXCollections.observableArrayList();
	// Used to filter by complete and incomplete tasks
	FilteredList<createTodoList> filteredList = new FilteredList<>(bufferList);
	//Global variable used for the index of the tasks in table list and removing them.
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
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			// Fill Buffer List
			populateBuffer(toDoListName.getText(), inputDate.getValue().format(formatter), taskDesc.getText());
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

	// Sets the cell value factory and enables editing of status, date and desc cells of the tasks.
	// Moved here because it was getting cluttered.
	@FXML
	public void setTheCells()
	{
		listTable.setEditable(true);

		statusList.setCellValueFactory(new PropertyValueFactory<>("status"));
		statusList.setCellFactory(TextFieldTableCell.forTableColumn());
		statusList.setOnEditCommit(event ->
		{
			createTodoList list = event.getRowValue();
			list.setStatus(event.getNewValue());
		});

		taskList.setCellValueFactory(new PropertyValueFactory<>("name"));

		dateList.setCellValueFactory(new PropertyValueFactory<>("date"));
		dateList.setCellFactory(TextFieldTableCell.forTableColumn());
		dateList.setOnEditCommit(event ->
		{
			createTodoList list = event.getRowValue();
			list.setStatus(event.getNewValue());
		});

		descList.setCellValueFactory(new PropertyValueFactory<>("desc"));
		descList.setCellFactory(TextFieldTableCell.forTableColumn());
		descList.setOnEditCommit(event ->
		{
			createTodoList list = event.getRowValue();
			list.setStatus(event.getNewValue());
		});
	}

	// Everytime the required data is added they are applied to the bufferList.
	@FXML
	public void populateBuffer(String name, String date, String desc)
	{
		bufferList.add(new createTodoList("x",
				name,
				date,
				desc));
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

	// This will export ALL todoLists into a file format, most likely a csv.
	@FXML
	public void exportAllClick(ActionEvent actionEvent) throws IOException
	{
		Writer writer = null;

		try
		{
			File file = new File("list.csv");
			writer = new BufferedWriter(new FileWriter(file));
			for (createTodoList list : bufferList)
			{
				String text = list.getStatus() + "," + list.getName() + "," + list.getDate() + "," + list.getDesc() + "\n";

				writer.write(text);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			assert writer != null;
			writer.flush();
			writer.close();
		}

	}

	public void importClick(ActionEvent actionEvent) throws IOException
	{
		String filePath;
		BufferedReader reader = null;
		String FieldDelimiter = ",";

		try
		{
			filePath = filePathField.getText();
			File file = new File(filePath);
			reader = new BufferedReader(new FileReader(file));
			String text;
			while ((text = reader.readLine()) != null)
			{
				String[] fields = text.split(FieldDelimiter, -1);
				String name = fields[0];
				String date = fields[1];
				String desc = fields[3];

				populateBuffer(name, date, desc);
				setTheCells();
				listTable.setItems(bufferList);
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			assert reader != null;
			reader.close();
		}

	}

	// Filters out the list to only display tasks that are completed.
	@FXML
	public void filterCompletedClick(ActionEvent actionEvent)
	{
		Predicate<createTodoList> containsCompleted = i -> i.getStatus().contains("o");
		filteredList.setPredicate(containsCompleted);
		listTable.setItems(filteredList);
	}

	// Filters out the list to only display tasks that are incompleted.
	public void filterIncompletedClick(ActionEvent actionEvent)
	{
		Predicate<createTodoList> containsinCompleted = i -> i.getStatus().contains("x");
		filteredList.setPredicate(containsinCompleted);
		listTable.setItems(filteredList);
	}

	// Sets back to default
	public void filterDefaultClick(ActionEvent actionEvent)
	{
		filteredList.setPredicate(null);
		listTable.setItems(bufferList);
	}


}
