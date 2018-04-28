package mastermind;

public class Ficha implements Dibujable{
	private String color;
	public Ficha() {
		
	}
	@Override
	public int hashCode() {
		int hash;
		hash= getColor().hashCode();
		return hash;
	}
	public boolean equals(Object obj) {
		boolean resultado=false;
		if(obj instanceof Ficha && getColor().equals(((Ficha) obj).getColor())) {
			resultado=true;
		}
		return resultado;
	}
	public String getColor() {
		return color;
	}
	
	public void addColor(String color) {
		this.color = color;
	}
	@Override
	public String dibujar() {
		String dibujo=String.format("%s", color);
		return dibujo;
	}


	

}
