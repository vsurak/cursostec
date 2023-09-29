package caso2;

import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class ConfigLoader {
	private JsonObject jsonparser;
	private ConfigSimulador confSim;
	private MenuConfig menuConfig;
	
	public ConfigLoader() {
		loadJson();
		menuConfig = new MenuConfig();
	}
	
	
	private void loadJson() {
		String pathtofile = "C:\\dev\\cursostec\\poo\\1. SemestreII2023\\support\\conf.json";
        
		try ( JsonReader reader = Json.createReader(new FileReader(pathtofile))) {
            jsonparser = reader.readObject();
            System.out.println("Loaded JSON: " + jsonparser);            
        } catch (Exception e) {
            e.printStackTrace();
        }	
	}

	public ConfigSimulador getGeneralSettings() {
		if (confSim==null) {
			confSim = new ConfigSimulador();
			confSim.setTiempo(jsonparser.getInt("tiempoSimulacionHora"));
			confSim.setMinHora(jsonparser.getInt("minHora"));
		}
		return confSim;
	}
	
	public MenuConfig getMenu() {
		menuConfig.getComidas().clear();
		menuConfig.getPostres().clear();
		menuConfig.getRefrescos().clear();
		
		JsonObject menujson = jsonparser.getJsonObject("menu").getJsonObject("comidas");
		//menujson.entrySet().
				
		
		return menuConfig;
	}
}
