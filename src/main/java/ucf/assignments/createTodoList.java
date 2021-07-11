/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Fazlur Shofiquel
 */
package ucf.assignments;

public class createTodoList
{
	private String status;
	private String name;
	private String date;
	private String desc;

	public createTodoList(String status, String name, String date, String desc)
	{
		this.status = status;
		this.name = name;
		this.date = date;
		this.desc = desc;
	}

	public void setStatus(String status)
	{
		this.status = status;
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

	public String getStatus()
	{
		return status;
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
