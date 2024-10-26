public class SuperHero extends Personaje {
    public SuperHero(String nombre, int fuerza, int velocidad, int vida_hp, String poder, String[] ataques) {
        super(nombre, fuerza, velocidad, vida_hp, poder, ataques);
    }

    @Override
    protected int calcularDaño() {
        // Los héroes tienen un bono de daño basado en su velocidad
        return super.calcularDaño() + (int)(this.velocidad * 0.8);
    }

    @Override
    public void mostrarEstado() {
        System.out.println(nombre);
        System.out.print("Vida: ");
        super.mostrarEstado();
        System.out.println("Poder: " + poder + " | Fuerza: " + fuerza + " | Velocidad: " + velocidad);
    }
}
