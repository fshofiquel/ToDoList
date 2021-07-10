package ucf.assignments;

import java.time.LocalDate;

public class createTodoList
{
	private String name;
	private LocalDate date;
	private String desc;


	public createTodoList(String name, LocalDate date, String desc)
	{
		this.name = name;
		this.date = date;
		this.desc = desc;
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
