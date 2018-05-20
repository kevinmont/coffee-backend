#!/bin/bash

super=postgres
echo "se elimina la base de datos coffe-ito"
echo "proporciona el password de usuario $super"
dropdb -U $super -W coffe-ito
echo "Se elimina el usuario coffe-ito"
echo "Proporciona el password del usuario $super"
dropuser -U $super -W coffe-ito
echo "creando el usuario coffe-ito solicita password 2 veces"
echo "Despues el password del usuario $super"
createuser -U $super -W -s -P coffe-ito
echo "Se creara ahora la base de datos coffe-ito"
echo "te solicitara el password del usuario coffe-ito"
createdb -U coffe-ito -W coffe-ito
echo "se procesa el schema de la base de datos"
psql -U coffe-ito -W < coffe-schema.sql
echo "se llenan las tablas"
psql -U coffe-ito -W < new-data.sql
echo "Se ha terminado el proceso"

