package ucf.assignments;

import javafx.scene.control.CheckBox;

import java.time.LocalDate;

public class createTodoList
{
	private CheckBox box;
	private String name;
	private LocalDate date;
	private String desc;

	public createTodoList(CheckBox box, String name, LocalDate date, String desc)
	{
		this.box = box;
		this.name = name;
		this.date = date;
		this.desc = desc;
	}

	public void setBox(CheckBox box)
	{
		this.box = box;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setDate(LocalDate date)
	{
		this.date = date;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public CheckBox getBox()
	{
		return box;
	}

	public String getName()
	{
		return name;
	}

	public LocalDate getDate()
	{
		return date;
	}

	public String getDesc()
	{
		return desc;
	}


}
