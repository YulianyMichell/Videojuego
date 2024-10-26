import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Crear héroes
        SuperHero[] heroes = {
            new SuperHero("Inferna", 100, 5, 300, "Control del fuego y el magma", 
                         new String[]{"Furia volcánica", "Ráfaga magmática", "Lluvia de cenizas"}),
            new SuperHero("Noctus", 120, 4, 250, "Control de la oscuridad",
                         new String[]{"Rugido de la noche", "Velo de sombras", "Tormento de los sueños"}),
            new SuperHero("Politaman", 90, 6, 350, "Telepatía y manipulación emocional",
                         new String[]{"Niebla de emociones", "Tormenta psíquica", "Eco de temores"}),
            new SuperHero("Pyraxis", 110, 5, 280, "Control de la electricidad",
                         new String[]{"Tormenta de chispas", "Campo Voltáico", "Torrente de relámpagos"}),
            new SuperHero("Tremor", 130, 3, 300, "Control de la tierra",
                         new String[]{"Avalancha de Rocas", "Ruptura terrestre", "Rugido terrestre"})
        };

        // Crear villano
        Villano villano = new Villano("Malevor", 150, 4, 1200, "Absorción de Almas",
                                    new String[]{"Vórtice de espectros", "Sombras devoradoras", "Cadenas de almas"});

        mostrarBanner();
        System.out.println("¡Inicio del combate!");

        // Ver estado inicial
        mostrarEstadoInicial(heroes, villano);

        // Ciclo de combate
        while (true) {
            if (!procesarTurno(scanner, heroes, villano, random)) {
                break;
            }
        }

        System.out.println("\nFin del combate.");
        scanner.close();
    }

    private static void mostrarBanner() {
        System.out.println("===============================================");
        System.out.println("   ██████╗  ██████╗ ██╗    ██╗███████╗██████╗ ");
        System.out.println("   ██╔══██╗██╔═══██╗██║    ██║██╔════╝██╔══██╗");
        System.out.println("   ██████╔╝██║   ██║██║ █╗ ██║█████╗  ██████╔╝");
        System.out.println("   ██╔═══╝ ██║   ██║██║███╗██║██╔══╝  ██╔══██╗");
        System.out.println("   ██║     ╚██████╔╝╚███╔███╔╝███████╗██║  ██║");
        System.out.println("   ╚═╝      ╚═════╝  ╚══╝╚══╝ ╚══════╝╚═╝  ╚═╝");
        System.out.println("===============================================");
        System.out.println("    ██╗  ██╗███████╗██████╗  ██████╗         ");
        System.out.println("    ██║  ██║██╔════╝██╔══██╗██╔═══██╗        ");
        System.out.println("    ███████║█████╗  ██████╔╝██║   ██║        ");
        System.out.println("    ██╔══██║██╔══╝  ██╔══██╗██║   ██║        ");
        System.out.println("    ██║  ██║███████╗██║  ██║╚██████╔╝        ");
        System.out.println("    ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝         ");
        System.out.println("===============================================");
    }

    private static void mostrarEstadoInicial(SuperHero[] heroes, Villano villano) {
        System.out.println("\nEstado inicial de los héroes:");
        for (SuperHero hero : heroes) {
            hero.mostrarEstado();
        }
        System.out.println("\nEstado inicial del villano:");
        villano.mostrarEstado();
    }

    private static boolean procesarTurno(Scanner scanner, SuperHero[] heroes, Villano villano, Random random) {
        System.out.println("\n¿Quieres atacar (a) o huir (h)?");
        String decision = scanner.nextLine().toLowerCase();

        if (decision.equals("h")) {
            System.out.println("¡Has huido del combate!");
            return false;
        } else if (!decision.equals("a")) {
            System.out.println("Decisión inválida. Por favor, elige 'a' para atacar o 'h' para huir.");
            return true;
        }

        mostrarEstadoActual(heroes, villano);
        
        // Procesar selección de héroe y ataque
        if (!procesarAtaqueHeroe(scanner, heroes, villano)) {
            return true;
        }

        if (!villano.estaVivo()) {
            System.out.println("\n¡Victoria! Has derrotado a " + villano.getNombre());
            return false;
        }

        // Contraataque del villano
        procesarAtaqueVillano(heroes, villano, random);

        if (todosHeroesDerrotados(heroes)) {
            System.out.println("\n¡Derrota! Todos los héroes han caído.");
            return false;
        }

        return true;
    }

    private static void mostrarEstadoActual(SuperHero[] heroes, Villano villano) {
        System.out.println("\nEstado actual de los héroes:");
        for (SuperHero hero : heroes) {
            if (hero.estaVivo()) {
                hero.mostrarEstado();
            }
        }
        System.out.println("\nEstado del villano:");
        villano.mostrarEstado();
    }

    private static boolean procesarAtaqueHeroe(Scanner scanner, SuperHero[] heroes, Villano villano) {
        System.out.println("\n¿Con qué héroe quieres atacar? (1-5):");
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].estaVivo()) {
                System.out.println((i + 1) + ". " + heroes[i].getNombre());
            }
        }

        try {
            int seleccion = Integer.parseInt(scanner.nextLine()) - 1;
            if (seleccion < 0 || seleccion >= heroes.length || !heroes[seleccion].estaVivo()) {
                System.out.println("Selección inválida.");
                return false;
            }

            String[] ataques = heroes[seleccion].getAtaques();
            System.out.println("\nAtaques disponibles:");
            for (int i = 0; i < ataques.length; i++) {
                System.out.println((i + 1) + ". " + ataques[i]);
            }

            int ataqueSeleccionado = Integer.parseInt(scanner.nextLine()) - 1;
            if (ataqueSeleccionado < 0 || ataqueSeleccionado >= ataques.length) {
                System.out.println("Ataque inválido.");
                return false;
            }

            heroes[seleccion].atacar(villano, ataqueSeleccionado);
            return true;

        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingresa un número válido.");
            return false;
        }
    }

    private static void procesarAtaqueVillano(SuperHero[] heroes, Villano villano, Random random) {
        for (SuperHero hero : heroes) {
            if (hero.estaVivo()) {
                villano.atacar(hero, random.nextInt(villano.getAtaques().length));
            }
        }
    }

    private static boolean todosHeroesDerrotados(SuperHero[] heroes) {
        for (SuperHero hero : heroes) {
            if (hero.estaVivo()) {
                return false;
            }
        }
        return true;
    }
}