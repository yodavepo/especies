# Práctica 2: Ejecución de tareas en Tekton
## Alumno: David Velázquez Portilla


## Archivos y su Explicación

### 1. Tasks

#### `hello-world-task.yaml`
- **Descripción**: Este archivo define una tarea básica en Tekton que imprime "Hello, World!" en el log.
- **Uso**: Se utiliza para entender cómo se define una tarea en Tekton y cómo se ejecuta.
- **Contenido clave**:
  - `spec.steps`: Define los pasos que se ejecutarán en la tarea.
  - `image`: Especifica la imagen de contenedor que se utilizará para ejecutar el paso.

#### `build-push-image-task.yaml`
- **Descripción**: Esta tarea construye una imagen de Docker y la sube a un registro de contenedores.
- **Uso**: Se utiliza para automatizar el proceso de construcción y despliegue de imágenes.
- **Contenido clave**:
  - `params`: Define parámetros como el nombre de la imagen y el registro.
  - `steps`: Incluye pasos para construir y subir la imagen.

### 2. Pipelines

#### `hello-world-pipeline.yaml`
- **Descripción**: Este archivo define una pipeline que ejecuta la tarea `hello-world-task`.
- **Uso**: Se utiliza para entender cómo se encadenan tareas en una pipeline.
- **Contenido clave**:
  - `tasks`: Lista las tareas que forman parte de la pipeline.

#### `build-push-pipeline.yaml`
- **Descripción**: Esta pipeline automatiza el proceso de construcción y despliegue de una imagen de Docker.
- **Uso**: Se utiliza para integrar múltiples tareas en un flujo de trabajo completo.
- **Contenido clave**:
  - `tasks`: Define el orden de ejecución de las tareas.

### 3. Resources

#### `git-resource.yaml`
- **Descripción**: Define un recurso de tipo Git que apunta a un repositorio de código fuente.
- **Uso**: Se utiliza para especificar el código fuente que se utilizará en las tareas.
- **Contenido clave**:
  - `url`: URL del repositorio Git.
  - `revision`: Rama o tag del repositorio.

#### `image-resource.yaml`
- **Descripción**: Define un recurso de tipo imagen que especifica la imagen de Docker a construir o utilizar.
- **Uso**: Se utiliza para especificar la imagen de salida en las tareas de construcción.
- **Contenido clave**:
  - `url`: URL de la imagen en el registro de contenedores.

### 4. Runs

#### `hello-world-taskrun.yaml`
- **Descripción**: Este archivo ejecuta la tarea `hello-world-task`.
- **Uso**: Se utiliza para probar la tarea de forma independiente.
- **Contenido clave**:
  - `taskRef`: Referencia a la tarea que se ejecutará.

#### `build-push-pipelinerun.yaml`
- **Descripción**: Este archivo ejecuta la pipeline `build-push-pipeline`.
- **Uso**: Se utiliza para probar la pipeline completa.
- **Contenido clave**:
  - `pipelineRef`: Referencia a la pipeline que se ejecutará.

## Ejercicios Realizados

### 1. Ejercicio Service Account

 **Verificamos en qué clúster nos encontramos**:
 -  kubectl config current-context
 Explicación: Este comando muestra el contexto actual de Kubernetes, es decir, el clúster y el namespace en el que estamos trabajando.

**Creamos el namespace:**:
- kubectl create ns diploe2-dvp
Explicación: Crea un namespace llamado diploe2-dvp en el clúster de Kubernetes.

**Aplicamos la configuración especificada en el archivo YAML:**
- kubectl apply -f tekton-service-account.yaml
Explicación: Aplica la configuración del Service Account definida en el archivo tekton-service-account.yaml.

**Desplegamos el Service Account y la tarea asociada:**
- kubectl get serviceaccount -n diploe2-dvp
Explicación: Muestra los Service Accounts existentes en el namespace diploe2-dvp.

**Para Role**
Creamos y aplicamos el role:
- kubectl apply -f tekton-role.yaml
Explicación: Aplica la configuración del Role definida en el archivo tekton-role.yaml.

Desplegamos el role:
- kubectl get role -n diploe2-dvp
Explicación: Muestra los Roles existentes en el namespace diploe2-dvp.

**Para Role-binding**
Aplicamos el RoleBinding:
kubectl apply -f tekton-role-binding.yaml
Explicación: Aplica la configuración del RoleBinding definida en el archivo tekton-role-binding.yaml.

### 2. Ejercicio Hello World

**Nos cambiamos de rama:**
- git checkout -b feature/tekton-examples
Explicación: Crea y cambia a una nueva rama llamada feature/tekton-examples.

**Creamos la TaskRun**:
- kubectl apply -f hello-word-taskrun.yaml
Explicación: Aplica la configuración de la TaskRun definida en el archivo hello-word-taskrun.yaml.

**Verificamos su ejecución**:
- kubectl get task -n diploe2
Explicación: Muestra las tareas existentes en el namespace diploe2.

### 3. Ejercicio Git Clone

**Verificamos el clúster**:
- kubectl config current-context
Explicación: Muestra el contexto actual de Kubernetes.

**Nos cambiamos a la rama main y actualizamos**:
- git checkout main
- git pull origin main
Explicación: Cambia a la rama main y actualiza el repositorio local con los últimos cambios del repositorio remoto.

**Creamos y cambiamos a una nueva rama**:
- git checkout -b feature/git-clone-build
Explicación: Crea y cambia a una nueva rama llamada feature/git-clone-build.

**Instalamos la tarea git-clone desde Tekton Hub:**
- tkn hub install task git-clone -n diploe2-dvp
Explicación: Instala la tarea git-clone desde Tekton Hub en el namespace diploe2-dvp.

**Creamos la TaskRun**:
- kubectl create -f taskrun.yaml
Explicación: Crea una TaskRun a partir del archivo taskrun.yaml.

**Desplegamos los pods**:
- kubectl get pods -n diploe2-dvp
Explicación: Muestra los Pods existentes en el namespace diploe2-dvp.

**Subimos los cambios**:
- git add .
- git commit -m "Commit de cambios"
- git push origin feature/git-clone-build
Explicación: Sube los cambios locales a la rama feature/git-clone-build en el repositorio remoto.

### 4. Ejercicio Listar directorio

**Verificamos el clúster:**
- kubectl config current-context
Explicación: Muestra el contexto actual de Kubernetes.

**Descargamos y aplicamos la configuración desde GitHub**:
-kubectl apply -f https://raw.githubusercontent.com/redhat-scholars/tekton-tutorial/refs/heads/master/workspaces/list-directory-task.yaml -n diploe2-dvp
Explicación: Aplica la configuración de la tarea list-directory-task desde un archivo YAML alojado en GitHub.

**Enlistamos las tasks en Tekton**:
- tkn task list -n diploe2-dvp
Explicación: Muestra las tareas existentes en el namespace diploe2-dvp.

**Creamos un volumen persistente:**
- kubectl apply -f pvc-yaml -n diploe2-dvp
Explicación: Aplica la configuración de un Persistent Volume Claim (PVC) definido en el archivo pvc-yaml.

**Creamos la TaskRun para compartir el volumen**:
- kubectl apply -f taskrun.yaml -n diploe2-dvp
Explicación: Crea una TaskRun que utiliza el PVC para compartir datos entre tareas.

**Obtenemos logs de la ejecución**:
- tkn taskrun logs git-clone-run -f -n diploe2-dvp
Explicación: Muestra los logs de la TaskRun git-clone-run en tiempo real.

**Ejecutamos la TaskRun para listar el directorio clonado**:
- kubectl apply -f list-directory-taskrun.yaml -n diploe2-dvp
Explicación: Crea una TaskRun para listar el contenido del directorio clonado.

**Mostramos detalles de la ejecución**:
- tkn taskrun describe list-directory-run -n diploe2-dvp
Explicación: Muestra detalles de la TaskRun list-directory-run.

### 5. Ejercicio Construye la aplicación Java

**Verificamos la instalación de Maven:**
- mvn -version
Explicación: Muestra la versión de Maven instalada en el sistema.

**Configuramos Maven en el ConfigMap**:
- ls /opt/maven/apache-maven-3.9.9/conf/ 
- cat maven-settings.xml >> maven-settings-configmap.yaml
- kubectl apply -f maven-settings-configmap.yaml -n diploe2-dvp
Explicación: Crea un ConfigMap con la configuración de Maven y lo aplica en el namespace diploe2-dvp.

**Creamos la TaskRun**:
- kubectl create -f Maven-taskrun.yaml -n diploe2-dvp
Explicación: Crea una TaskRun para construir la aplicación Java utilizando Maven.

**Verificamos su ejecución**:
- kubectl get taskrun -n diploe2-dvp
Explicación: Muestra las TaskRuns existentes en el namespace diploe2-dvp.

### 6. Ejercicio Construye y empuja

**Instalamos la Task de Buildah si no está disponible**:
- kubectl get task buildah -n diploe2-dvp
- tkn hub install task buildah -n diploe2-dvp
Explicación: Verifica si la tarea buildah está instalada y, si no, la instala desde Tekton Hub.

**Creamos la TaskRun de Buildah**:
- kubectl get taskrun -n diploe2-dvp
Explicación: Muestra las TaskRuns existentes en el namespace diploe2-dvp.

**Actualizamos el Dockerfile y la rama**:
- git add Dockerfile
- git commit -m "Actualización de Dockerfile"
- git merge feature/git-clone-build
- git push origin feature/git-clone-build
Explicación: Actualiza el Dockerfile, fusiona la rama feature/git-clone-build y sube los cambios al repositorio remoto.


### Conclusión
Estos ejercicios te han permitido familiarizarte con los conceptos básicos de Tekton, incluyendo la definición de tareas, pipelines, recursos y su ejecución. Los manifiestos definidos en la carpeta tekton te muestran cómo se estructuran y funcionan estos componentes en un flujo de trabajo de CI/CD. Puedes utilizar estos archivos como base para construir flujos de trabajo más complejos en tus proyectos.


   
