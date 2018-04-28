package mastermind;

public class TableroPartida implements Dibujable {
	private TableroJugador tablero1;
	private TableroJugador tablero2;
	TableroPartida(){
		tablero1=new TableroJugador();
		tablero2=new TableroJugador();
	}
	
	public void addTableros(TableroJugador tablero1,TableroJugador tablero2) {
		this.tablero1 = tablero1;
		this.tablero2 = tablero2;
	}

	@Override
	public String dibujar() {
		String dibujo="";
		int i;
		for(i=0;i<tablero1.getTablero().size();i++) {
			dibujo+=String.format("%s\t%s\n",tablero1.getTablero().get(i).dibujar(),tablero2.getTablero().get(i).dibujar() );
		}
		
		return dibujo;
	}

	public TableroJugador getTablero1() {
		return tablero1;
	}

	public TableroJugador getTablero2() {
		return tablero2;
	}
	


}
