#!/bin/bash

# Variables
SERVICE_DIR=./servicio
TOMCAT_SERVICES_DIR=~/software/apache-tomcat-9.0.87/webapps/axis2/WEB-INF/services
AAR_NAME=ETSIINFLibrary.aar

echo "Compilando el servicio con Ant..."
cd "$SERVICE_DIR" || { echo "No se pudo cambiar al directorio $SERVICE_DIR"; exit 1; }
ant clean
ant || { echo "Error en la compilación con ant"; exit 1; }

echo "Copiando el archivo .aar al directorio de servicios de Tomcat..."
cp "build/lib/$AAR_NAME" "$TOMCAT_SERVICES_DIR" || { echo "Error copiando el archivo .aar"; exit 1; }

echo "Reinicio de Tomcat..."
# Cambia la ruta si tu script de arranque está en otro sitio
~/software/apache-tomcat-9.0.87/bin/shutdown.sh
sleep 5
~/software/apache-tomcat-9.0.87/bin/startup.sh

echo "Proceso completado correctamente."

exit
