enum TipoDisp {  // enums literales para identificar dispositivos
	bombillo=0,
	sensorHumo=1,
	sensorPuertas=2,
	camara=3,
};

struct AccionesPorTipo {
	TipoDisp type;
	List<Action> acciones;
}

struct Action {
	string name;
	parameters params[];
}

AccionesPorDispotivo config_acciones[4];

List<string> accionesToLoad = new List<string>();
accionesToLoad.add("encender", "apagar", "cambiarColor");

config_acciones[(int)TipoDisp.bombillo].type = TipoDisp.bombillo;
config_acciones[(int)TipoDisp.bombillo].acciones = accionesToLoad;


accionesToLoad.clear();
accionesToLoad.add("ajustarSensibilidad", "cambiarSonido");
config_acciones[(int)TipoDisp.sensorHumo].type = TipoDisp.sensorHumo;
config_acciones[(int)TipoDisp.sensorHumo].acciones = accionesToLoad;

PtrDispositivo nuevoDispositivo("bombillo del cuarto", TipoDisp.bombillo, "cuarto exterior");
nuevoDispositivo.acciones = config_acciones[(int)TipoDisp.bombillo].acciones;



///// funciona, pero pudo haber sido mejor si hago el arreglo de arriba
PtrDispositivo nuevoDispositivo("bombillo del cuarto", TipoDisp.bombillo, "cuarto exterior");

if (nuevoDispositivo->type==TipoDisp.bombillo) {
	nuevoDispositivo->acciones.add("enceder");
	nuevoDispositivo->acciones.add("apagar");
	nuevoDispositivo->acciones.add("cambiarColor");
}

if (nuevoDispositivo->type==TipoDisp.sensorHumo) {
	nuevoDispositivo->acciones.add("ajustarSensibilidad");
	nuevoDispositivo->acciones.add("cambiarSonido");
}


class TipoDispotivo {

	public:
		TipoDispotivo(TipoDisp pType) {
			this->type = pType;
			this->acciones = config_acciones[(int)pType];
		}
}














