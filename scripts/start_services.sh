SCRIPTDIR=`dirname "$0"`
ACME_ROOT=${SCRIPTDIR}/..

cd $ACME_ROOT/src/cadastre && jolie server.ol &
cd $ACME_ROOT/src/camunda-session-manager && jolie session_manager.ol &
cd $ACME_ROOT/src/bank && jolie server.ol &
cd $ACME_ROOT/src/mail && node mail.js &
cd $ACME_ROOT/src/distance && node distance.js -a env MAPS_API_KEY &

cd $ACME_ROOT
