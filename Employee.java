package vantage;

public class Employee {
	private String name;
	private String age;
	private String[] hobbies;
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getAge(){
		return age;
	}
	
	public void setAge(String age){
		this.age=age;
	}
	
	public String[] getHobbies(){
		return hobbies;
	}
	
	public void setHobbies(String[] hobbies){
		this.hobbies=hobbies;
	}
	
	Employee(String name,String age,String[] hobbies){
		this.name = name;
		this.age=age;
		this.hobbies=hobbies;
}

}
