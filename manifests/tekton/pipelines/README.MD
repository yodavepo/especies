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
