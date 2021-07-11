/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Fazlur Shofiquel
 */
package ucf.assignments;

import javafx.scene.control.CheckBox;

import java.time.LocalDate;

public class createTodoList
{
	private CheckBox box;
	private String name;
	private String date;
	private String desc;

	public createTodoList(CheckBox box, String name, String date, String desc)
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

	public void setDate(String date)
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

	public String getDate()
	{
		return date;
	}

	public String getDesc()
	{
		return desc;
	}


}
