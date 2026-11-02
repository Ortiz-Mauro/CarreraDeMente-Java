# 🧠 Motor Lógico: Carrera de Mente (Java/POO)

![Java](https://img.shields.io/badge/Java-21+-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit-5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![Arquitectura](https://img.shields.io/badge/Arquitectura-Capas-blue?style=for-the-badge)

## 🎯 Sobre el Proyecto
Desarrollo del motor lógico y modelo de dominio transaccional basado en el clásico juego de mesa argentino "Carrera de Mente"[cite: 10]. Este proyecto académico para la cátedra de Programación Orientada a Objetos de la UNDAV[cite: 11] se enfocó en construir una estructura backend robusta, priorizando el descubrimiento de objetos esenciales, la alta cohesión y el bajo acoplamiento por sobre la implementación de una Interfaz Gráfica (GUI) prematura[cite: 10].

## 🏗️ Arquitectura y Diseño (Separación de Incumbencias)
El sistema está diseñado bajo el patrón de separación en capas lógicas para garantizar la escalabilidad y el encapsulamiento[cite: 9, 11]:

*   **`model` (Capa de Dominio):** Entidades conceptuales puras (`Jugador`, `Tablero`, `Dado`, `Pregunta`). Ninguna clase conoce detalles de infraestructura ni interfaces gráficas[cite: 9, 11].
*   **`controller` (Capa de Orquestación):** Implementación del Patrón GRASP. El `ControladorJuego` coordina el flujo transaccional sin almacenar datos propios del dominio[cite: 9, 11].
*   **`app` (Capa de Aplicación):** Contiene el `Main.java` operando como *Composition Root*, responsable de instanciar los componentes e inyectar las dependencias[cite: 9, 11].
*   **`test.model` (Capa de Verificación):** Aislamiento de la suite de pruebas para no contaminar el código de producción[cite: 9].

## 🧪 Metodología y Calidad de Software
*   **Diseño Guiado por Pruebas (TDD):** El desarrollo fue validado iterativamente mediante una suite de **24 pruebas automatizadas** (unitarias y de integración) utilizando JUnit 5[cite: 11, 16].
*   **Patrón AAA (Arrange-Act-Assert):** Aplicado estrictamente en cada test, garantizando estados limpios en memoria mediante el ciclo `@BeforeEach`[cite: 11].
*   **Diseño UML Riguroso:** Sincronización 1:1 entre el código fuente Java, el Diagrama de Clases y los 5 Diagramas de Secuencia transaccionales modelados en StarUML[cite: 11].

## 👨‍💻 Organización del Equipo y Mi Rol
El proyecto fue desarrollado mediante metodologías colaborativas[cite: 10]. Mi rol principal (Ortiz Mauro) abarcó[cite: 11, 13]:
1.  **Arquitectura Base:** Diseño del `Main.java` y definición de firmas, parámetros e inyección de dependencias para asegurar la cohesión del código del equipo.
2.  **Testing Automation:** Desarrollo e implementación íntegra de la red de seguridad (*Safety Net*) de 24 tests con JUnit 5.
3.  **Documentación Dinámica:** Diseño del Diagrama de Secuencia de interacciones transaccionales y consolidación de la documentación técnica.

*Compañeros de equipo:* A. Barnas (Diseño Estructural Espacial), L. Diaz (Lógica de Entidades Dinámicas), A. Minervini (Persistencia y Casos Especiales)[cite: 11, 13].

## 🚀 Mejoras Futuras
Gracias al estricto bajo acoplamiento logrado en el orquestador (`ControladorJuego`), el motor lógico está preparado para[cite: 10]:
*   **Integración de GUI:** Acoplar interfaces visuales (JavaFX / Swing) sin modificar una sola línea del paquete `model`.
*   **Persistencia Remota:** Intercambiar el `ProveedorPreguntas` local por una conexión a base de datos o API externa mediante polimorfismo.