import java.io.Serializable;


public class Faltas implements Serializable{

	//atributos del Equipo
	private String nombreJugador;
	private int numAmarilla;
	private int numRoja;
	private int numFaltas;

	public Faltas(String nom, int numA,int numR,int numF) {
		// Inicialización
		nombreJugador=nom;
		numAmarilla=numA;
		numRoja=numR;
		numFaltas=numF;
	}
	public Faltas(){
		// Inicialización
		nombreJugador="";
		numAmarilla=0;
		numRoja=0;
		numFaltas=0;	
	}
	
	//Entrada y salida de atributos
		public void setNombre(String nom){
			nombreJugador=nom;
		}

		public String getNombre(){
			return nombreJugador;
		}

		public void setNumAmarilla(int numA){
			numAmarilla=numA;
		}

		public int getNumAmarilla(){
			return numAmarilla;
		}

		public void setNumRoja(int numR){
			numRoja=numR;
		}

		public int getNumRoja(){
			return numRoja;
		}

		public void setNumFaltas(int numF){
			numFaltas=numF;
		}

		public int getNumFaltas(){
			return numFaltas;
		}
}