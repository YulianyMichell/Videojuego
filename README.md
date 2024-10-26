# Proyecto: Combate de Héroes vs Villano

Este es un juego de combate en Java donde cinco héroes se enfrentan a un poderoso villano. El usuario elige con qué héroe atacar y selecciona un ataque específico, mientras que el villano responde automáticamente. La partida termina cuando el villano o todos los héroes son derrotados.

## Clases Principales

### App
Clase principal del programa que gestiona la interacción entre el usuario y el juego. Sus funciones incluyen:

- Mostrar un banner ASCII al inicio del juego.
- Mostrar el estado inicial y actual de los personajes.
- Controlar el flujo del combate (ataque o huida).
- Permitir al usuario elegir un héroe y un ataque.
- Verificar las condiciones de victoria o derrota.

### Personaje
Clase base que representa a cualquier personaje en el juego (tanto héroes como villanos). Sus atributos y métodos incluyen:

- Atributos: nombre, fuerza, velocidad, vida_hp, poder y ataques.
- Métodos: 
  - atacar: Ejecuta un ataque contra otro personaje.
  - calcularDaño: Calcula el daño de un ataque.
  - recibirDaño: Reduce la vida del personaje al recibir daño.
  - estaVivo: Verifica si el personaje sigue vivo.
  - mostrarEstado: Muestra el estado actual del personaje.

### SuperHero
Subclase de Personaje, representa a un héroe con un bono de daño en función de la velocidad.

- calcularDaño: Aumenta el daño base con un bono de velocidad.
- mostrarEstado: Muestra la información del héroe, como su poder y estadísticas.

### Villano
Subclase de Personaje, representa al villano con ataques y habilidades específicas.

- calcularDaño: Aumenta el daño base con un bono de fuerza.
- mostrarEstado: Muestra la información del villano, como su poder maligno y estadísticas.

## Instrucciones del Juego

- Al inicio, se muestra el estado de cada héroe y el villano.
- En cada turno, el usuario puede:
  - Atacar (a)
  - Huir (h)
- Al atacar, el usuario selecciona un héroe y uno de sus ataques.
- Tras cada turno del héroe, el villano realiza un contraataque.
- El juego termina cuando el villano o todos los héroes han caído.

## Autores

-Yuliany Michell Sánchez Becerra (192372)
-Yanderson Jesús Ortiz Cova (192333)
-Euder Julian Pachecho Ascanio (192356)
-Kevin Steiman Sánchez Torres (192313)
-Santiago Castilla Coronel (192413)