package modelaje;

public enum ColorSemaforos 
{
	VERDE(0), AMARILLO(1), ROJO(2);
	
    private int value;
    
    private ColorSemaforos(int value)
    {
        this.value = value;
    }	
    
    public int getValue() {
        return value;
    }    
}
