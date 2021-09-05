package otros;

import java.util.Hashtable;

public class TestHash 
{
	private Hashtable<String, Estudiante> HashDb;
	
	public String[][] lista = {
			{"2016110702","AGUILAR MADRIZ JOSE RAFAEL"},
			{"2016167880","ALPIZAR HERRERA DANIEL ANTONIO"},
			{"2016126391","ALVAREZ ROSALES DANIEL ANDRE"},
			{"200546435","ARIAS CHACON MARIO ESTEBAN"},
			{"200312844","CAMACHO SABORIO JOSE MARTI"},
			{"2013101577","CHAVES MORA CHRISTIAN ANTONIO"},
			{"2016093887","COTO ALFARO ESTEBAN"},
			{"2016055077","ELIZONDO CORDERO YUBER EUSEBIO"},
			{"2016012024","ESPINOZA SOTO DAVID JOSE"},
			{"2016193340","FERNANDEZ MURILLO HANS"},
			{"2016139115","GALEANO GONZALEZ ANDRES EDUARDO"},
			{"200029255","GARZONA VAGLIO FERNANDO"},
			{"2016095929","GOMEZ CASASOLA JOSE DANIEL"},
			{"2015000433","GOMEZ DE LA CRUZ KEVIN STUART"},
			{"2016140286","GUTIERREZ QUIROS JASON GERARDO"},
			{"2016078675","MENDEZ VALVERDE DIEGO GERARDO"},
			{"2016089657","MONGE ROA YELSON ANDRES"},
			{"2015067158","MONTERO MORENO CARLOS ANDRES"},
			{"2016145484","MORALES JIMENEZ JURGENN MANUEL"},
			{"2015071255","PORRAS QUIROS DANIELA MELISSA"},
			{"2016136187","RODRIGUEZ ALAS DANIEL ALBERTO"},
			{"201140682","RODRIGUEZ BUSTOS KENDALL EDUARDO"},
			{"2016062840","ROJAS OBANDO NELSON ARMANDO"},
			{"2016115532","ROMAN MONTERO RANDALL LEONARDO"},
			{"2016124237","SAENZ ZUÑIGA CALET FRANCISCO"},
			{"2016077990","VALDEZ CALDERON MELINA MONSERRAT"},
			{"2016128883","VALERIO GUERRERO JESUS SEBASTIAN"},
			{"2016015616","VARGAS QUIROS ESTEBAN LEONARDO"},
			{"2016086098","XIE LI DANNY"}
			};
	
	public TestHash() 
	{
		popularDB();
	}
	
	private void popularDB() {		
		HashDb = new Hashtable<String, Estudiante>();
		HashDb.clear(); // eliminar todo el contenido de la tabla
		
		for(String[] est : lista)
		{
			Estudiante nuevo = new Estudiante( (new Integer(est[0])).intValue(), est[1] );
			HashDb.put(nuevo.getCarneStr(), nuevo);
		}
		
	}
	
	public Estudiante getEstudiante(String pLlave)
	{
		Estudiante result = null;
		result = HashDb.get(pLlave);
		return result;
	}

	public static void main(String args[])
	{
		TestHash estudiantes = new TestHash();
		// se imprimen los parametros del command program "java"
		for(int i=0; i<args.length; i++)
		{
			Estudiante result = estudiantes.getEstudiante(args[i]);
			if (result!=null)
			{
				System.out.println("Nombre: "+result.getNombre()+ ", Nota: "+ result.getNota());
			}
		}
	}
}
