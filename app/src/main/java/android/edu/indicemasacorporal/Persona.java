package android.edu.indicemasacorporal;


public class Persona {
    private float peso;
    private float altura;

    public Persona(float peso, float altura) {
        this.peso = peso;
        this.altura = altura;
    }

    public Persona() { }

    public float getPeso() { return peso; }
    public float getAltura() { return altura; }

    public void setPeso(float peso) { this.peso = peso; }
    public void setAltura(float altura) { this.altura = altura; }



}
