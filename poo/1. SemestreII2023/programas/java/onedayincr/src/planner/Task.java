package planner;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
	private Date tasktime;
	private String taskname;
	private boolean procesada;
	
	public Task(String pTasktime, String pTaskName) {
		this.procesada = false;
		
		this.taskname = pTaskName;
		
		String dateString = "2023-08-29 "+pTasktime+":00";
        String pattern = "yyyy-MM-dd HH:mm:ss";
        
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            tasktime = dateFormat.parse(dateString);		
        } catch (Exception ex) {
        	System.out.println(ex.getMessage());
        }
	}
	
	public Date getTasktime() {
		return tasktime;
	}
	
	public String getTaskname() {
		return taskname;
	}

	public boolean isProcesada() {
		return procesada;
	}

	public void setProcesada(boolean procesada) {
		this.procesada = procesada;
	}
}
