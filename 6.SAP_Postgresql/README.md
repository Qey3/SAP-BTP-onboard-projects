# Project with connection to SAP PostgreSQL service

## Before running the app in the Cloud Foundry environment, you need:
* Manually subscribe to `postgresql-db` service in your `BTP Coockpit`
* Go to your `postgresql-db` service and create `Service Keys`
* Use parameters from `Credentials` in your `postgresql-db` service, or
* You can obtain database information for setup db-connection from environment: `${vcap.services.<postgre-service-name>.credentials.<property-name>` 
