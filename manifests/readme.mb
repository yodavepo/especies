# Práctica 2: Ejecución de tareas en Tekton

## Alumno: David Velázquez Portilla

### Para el ejercicio Service Account

1. Verificamos en qué clúster nos encontramos:
   ```sh
   kubectl config current-context
   ```

2. Creamos el namespace:
   ```sh
   kubectl create ns diploe2-dvp
   ```

3. Aplicamos la configuración especificada en el archivo YAML:
   ```sh
   kubectl apply -f tekton-service-account.yaml
   ```

4. Desplegamos el Service Account y la tarea asociada:
   ```sh
   kubectl get serviceaccount -n diploe2-dvp
   ```

### Para Role

Un **Role** en Kubernetes define un conjunto de permisos dentro de un namespace específico.

1. Creamos y aplicamos el role:
   ```sh
   kubectl apply -f tekton-role.yaml
   ```

2. Desplegamos el role:
   ```sh
   kubectl get role -n diploe2-dvp
   ```

### Para Role-binding

Un **RoleBinding** vincula un Role con un usuario, grupo o ServiceAccount.

1. Aplicamos el RoleBinding:
   ```sh
   kubectl apply -f tekton-role-binding.yaml
   ```

### Para el ejercicio Hello World

1. Nos cambiamos de rama:
   ```sh
   git checkout -b feature/tekton-examples
   ```

2. Creamos la TaskRun:
   ```sh
   kubectl apply -f hello-word-taskrun.yaml
   ```

3. Verificamos su ejecución:
   ```sh
   kubectl get task -n diploe2
   ```

### Para el ejercicio Git Clone

1. Verificamos el clúster:
   ```sh
   kubectl config current-context
   ```

2. Nos cambiamos a la rama main y actualizamos:
   ```sh
   git checkout main
   git pull origin main
   ```

3. Creamos y cambiamos a una nueva rama:
   ```sh
   git checkout -b feature/git-clone-build
   ```

4. Instalamos la tarea git-clone desde Tekton Hub:
   ```sh
   tkn hub install task git-clone -n diploe2-dvp
   ```

5. Creamos la TaskRun:
   ```sh
   kubectl create -f taskrun.yaml
   ```

6. Desplegamos los pods:
   ```sh
   kubectl get pods -n diploe2-dvp
   ```

7. Subimos los cambios:
   ```sh
   git add .
   git commit -m "Commit de cambios"
   git push origin feature/git-clone-build
   ```

### Para el ejercicio Listar directorio

1. Verificamos el clúster:
   ```sh
   kubectl config current-context
   ```

2. Descargamos y aplicamos la configuración desde GitHub:
   ```sh
   kubectl apply -f https://raw.githubusercontent.com/redhat-scholars/tekton-tutorial/refs/heads/master/workspaces/list-directory-task.yaml -n diploe2-dvp
   ```

3. Enlistamos las tasks en Tekton:
   ```sh
   tkn task list -n diploe2-dvp
   ```

4. Creamos un volumen persistente:
   ```sh
   kubectl apply -f pvc-yaml -n diploe2-dvp
   ```

5. Creamos la TaskRun para compartir el volumen:
   ```sh
   kubectl apply -f taskrun.yaml -n diploe2-dvp
   ```

6. Obtenemos logs de la ejecución:
   ```sh
   tkn taskrun logs git-clone-run -f -n diploe2-dvp
   ```

7. Ejecutamos la TaskRun para listar el directorio clonado:
   ```sh
   kubectl apply -f list-directory-taskrun.yaml -n diploe2-dvp
   ```

8. Mostramos detalles de la ejecución:
   ```sh
   tkn taskrun describe list-directory-run -n diploe2-dvp
   ```

### Para el ejercicio Construye la aplicación Java

1. Verificamos la instalación de Maven:
   ```sh
   mvn -version
   ```

2. Configuramos Maven en el ConfigMap:
   ```sh
   ls /opt/maven/apache-maven-3.9.9/conf/ 
   cat maven-settings.xml >> maven-settings-configmap.yaml
   kubectl apply -f maven-settings-configmap.yaml -n diploe2-dvp
   ```

3. Creamos la TaskRun:
   ```sh
   kubectl create -f Maven-taskrun.yaml -n diploe2-dvp
   ```

4. Verificamos su ejecución:
   ```sh
   kubectl get taskrun -n diploe2-dvp
   ```

### Para el ejercicio Construye y empuja

1. Instalamos la Task de Buildah si no está disponible:
   ```sh
   kubectl get task buildah -n diploe2-dvp
   tkn hub install task buildah -n diploe2-dvp
   ```

2. Creamos la TaskRun de Buildah:
   ```sh
   kubectl get taskrun -n diploe2-dvp
   ```

3. Actualizamos el Dockerfile y la rama:
   ```sh
   git add Dockerfile
   git commit -m "Actualización de Dockerfile"
   git merge feature/git-clone-build
   git push origin feature/git-clone-build
   
