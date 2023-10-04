package planner;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

//https://mvnrepository.com/artifact/javax.json/javax.json-api/1.1.4

public class ScheduleParser {
	private JsonArray jsontasks;
	
	public ScheduleParser() {
		loadJson();
	}

	public ArrayList<Task> getTasks() {
		ArrayList<Task> result = new ArrayList<Task>();
		
        for (JsonValue taskjson : jsontasks) {
            JsonObject taskobject = (JsonObject) taskjson;
            
            System.out.println(taskobject.getString("task"));
            
            Task task = new Task(taskobject.getString("time"), taskobject.getString("task"));
            result.add(task);
        }
        
        return result;
	}	
	
	private void loadJson() {
		String pathtofile = "C:\\dev\\cursostec\\poo\\1. SemestreII2023\\programas\\java\\onedayincr\\src\\planner\\schedule.json";
        FileReader fileReader = null;
		try {
			fileReader = new FileReader(pathtofile);
			JsonReader reader = Json.createReader(fileReader);
            JsonObject jsonparser = reader.readObject();
            
            jsontasks = jsonparser.getJsonArray("tareas");
            
            System.out.println("Loaded JSON: " + jsonparser);            
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
			if (fileReader!=null) {
				try {
					fileReader.close();
				} catch (IOException ex) {
					
				}
			}
		}
	}
}
