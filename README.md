## Estrategia de Ramas

Para el desarrollo de este proyecto, utilizamos la siguiente estrategia de ramas:

- **`main`**: Rama principal con el código estable.
- **`develop`**: Rama de desarrollo donde se integran las nuevas características.
- **`feature/*`**: Ramas de características específicas. Cada miembro del equipo trabaja en una rama de características diferente.

### Ejemplo de Flujo de Trabajo

1. Crear una rama `feature/unit-testing` desde `develop`.
2. Trabajar en la rama `feature/unit-testing`.
3. Hacer un merge request a `develop` cuando la característica esté lista.
4. Una vez que todas las características estén integradas en `develop`, hacer un merge a `main` para la liberación.
