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
# Pipelines



## pipeline-ci

Esta Pipeline realiza las siguientes tareas:

1. Clona un repositorio usando `git-clone`.

2. Compila y empaqueta la aplicación usando `maven`.

3. Construye y empuja la imagen usando `buildah`.



### Archivos generados

- `pipeline-ci.yaml`: Define la Pipeline.

- `pipelinerun-ci.yaml`: Define la PipelineRun para ejecutar la Pipeline.



### Ejecución

Para ejecutar la Pipeline, sigue estos pasos:

1. Aplica la Pipeline:

   ```bash

   kubectl apply -f pipeline-ci.yaml

kubectl create -f pipelinerun-ci.yaml




### Validando la linea de despliegue


> Verificación de mi CI/CD desde mi repositorio 'yodavepo/especies.git'
