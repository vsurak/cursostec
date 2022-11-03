package robotwar.test;

import java.util.ArrayList;
import java.util.Arrays;

import robotwar.communication.SocketClient;

public class PersonasClient {

	public static void main(String[] args) {
		String temasArray[] = {"mi vida antes y después de orientación a objetos","cuántas veces he usado un hashtable y para qué", "buenas practicas de clean code", "polimorfismo", "patrones de diseño", "qué de poo usaré cuando trabaje", "qué otras cosas he hecho o podría hacer por mi paso por el tec", "qué ha sido lo más difícil de trabajar en grupos", "cuánta gente he conocido o que tanto he socializado", "cómo se me dan las lecciones remotas y las presenciales", "me estoy divirtiendo mientras estudio en el tec"};
		String pooArray[] = {"Sebastián Calvo", "David Ugalde", "Yeiner Ugalde", "Samuel Valverde", "Jose David", "José Julián", "Oscar Andrés", "Erick Kauffmann", "Federico Alfaro", "Dayana Xie", "Juan Ernesto", "Cristopher Antonio", "Sarah Quesada", "José Andrés", "Julián Madrigal"};
		
		//String temasArray[] = {"en que casos he usado un hashtable","siempre voy a necesitar listas, vectores, arrays o similares", "que ventajas me dan las estructuras de datos", "cuál estructura de datos me gusta más", "ejemplos de cosas logrables por medio de estructuras de datos", "en cuáles o cuál estructura de datos documentaría mi historia por el tec", "he conocido personas de varios lados del país", "networking en el tec", "como emprender siendo estudiante si con costo programo un avl", "los ingenieros que trabajan dominan bien las estructuras de datos", "que hago si hay que ordenar elementos, uso esos algoritmos que vimos?", "describa el curso en máximo 5 palabras", "debería irme de fiesta con tantas progras que hacer", "qué opciones hay para aprender más y ganar experiencia"};
		//String datosArray[] = {"Isaac Rojas","Steven Sequeira", "Emmanuel Matamoros","David Fernandez", "Kenneth Rojas","Diego Granados", "Sarah Quesada","Luis Gonzalez", "Cristhoper Acuña","Yeiner Ugalde", "Helberth Cubillo","Gabriel Gomez", "Dayana Xie","Jose Pablo Barquero", "Carlos Barrantes"};
		
		ArrayList<String> temas = new ArrayList<String>(Arrays.asList(temasArray));
		
		ArrayList<String> personas = new ArrayList<String>(Arrays.asList(pooArray));
		
		//ArrayList<String> personas = new ArrayList<String>(Arrays.asList(datosArray));
		
		try {
			SocketClient clienteTemas = new SocketClient("localhost", 10000);
			SocketClient clientePersonas = new SocketClient("127.0.0.1", 10000);
						
			while (temas.size()>0 && personas.size()>0) {
				int temaId = (int)Math.random()*temas.size();
				int personaId = (int)Math.random()*personas.size();

				clienteTemas.sendMsg(temas.get(temaId));
				clientePersonas.sendMsg(personas.get(personaId));
				
				temas.remove(temaId);
				personas.remove(personaId);
				
				Thread.sleep(200000);
			}
			
		} catch (Exception ex) {
				
		}
	}
}
