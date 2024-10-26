public class Personaje {
    protected String nombre;
    protected int fuerza;
    protected int velocidad;
    protected int vida_hp;
    protected String poder;
    protected String[] ataques;
    protected int vida_maxima;

    public Personaje(String nombre, int fuerza, int velocidad, int vida_hp, String poder, String[] ataques) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.velocidad = velocidad;
        this.vida_hp = vida_hp;
        this.vida_maxima = vida_hp;
        this.poder = poder;
        this.ataques = ataques.clone(); // Protección contra modificación externa
    }

    public void atacar(Personaje objetivo, int indiceAtaque) {
        if (indiceAtaque >= 0 && indiceAtaque < this.ataques.length && this.estaVivo() && objetivo.estaVivo()) {
            int daño = calcularDaño();
            objetivo.recibirDaño(daño);
            System.out.println(this.nombre + " usa " + this.ataques[indiceAtaque] + " y ataca a " +
                             objetivo.nombre + ", quitándole " + daño + " de vida.");
        }
    }

    protected int calcularDaño() {
        // Fórmula básica de daño que puede ser sobrescrita por las subclases
        return this.fuerza + (int)(this.velocidad * 0.5);
    }

    public void recibirDaño(int daño) {
        this.vida_hp = Math.max(0, this.vida_hp - daño);
        if (!this.estaVivo()) {
            System.out.println(this.nombre + " ha sido derrotado!");
        }
    }

    public boolean estaVivo() {
        return this.vida_hp > 0;
    }

    public void mostrarEstado() {
        System.out.println(vida_hp);
    }

    

    public String getNombre() {
        return nombre;
    }

    public String[] getAtaques() {
        return ataques.clone(); // Retorna una copia para proteger el array original
    }
}