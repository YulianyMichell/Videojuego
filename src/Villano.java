public class Villano extends Personaje {
    public Villano(String nombre, int fuerza, int velocidad, int vida_hp, String poder, String[] ataques) {
        super(nombre, fuerza, velocidad, vida_hp, poder, ataques);
    }

    @Override
    protected int calcularDaño() {
        // Los villanos tienen un bono de daño basado en su fuerza
        return super.calcularDaño() + (int)(this.fuerza * 0.5);
    }

    @Override
    public void mostrarEstado() {
        System.out.println(nombre);
        System.out.print("Vida: ");
        super.mostrarEstado();
        System.out.println("Poder Maligno: " + poder + " | Fuerza: " + fuerza + " | Velocidad: " + velocidad );
    }
}