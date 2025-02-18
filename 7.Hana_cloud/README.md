# Project with connection to SAP Hana Cloud database

## Concept the same as previous PostgreSQL application, the difference in configuration database service, there is my suggestion how to set up service which helped me:
* First evolve if you have already created your `SAP HANA Cloud` from this material with plan `tools`, remove it:
[Start Using SAP HANA Cloud Free Tier in SAP BTP Cockpit](https://developers.sap.com/tutorials/hana-cloud-mission-trial-2-ft.html) - with this version you can't connect to Hana
* You should create `SAP HANA Cloud` with plan `hana` and start database 
(IMPORTANT: remember your `systempassword` which one you set up in configuration during service creation)
* Also, I had difficulties with connection, so for you, it can be necessary to `allow all IP adresses` , 
link: [Connect to Schema on Hana Database via JDBC](https://community.sap.com/t5/technology-q-a/connect-to-schema-on-hana-database-via-jdbc/qaq-p/12384743)
You can set up them in your `HANA Cloud Central`
* After that you should create `SAP HANA Schemas & HDI Containers` service (not trial version) and choose plan `hdi-shared`.
* And the last one you should create your database user and set up permission for him, link to the video:
[SAP HANA Deployment Infrastructure (HDI) Administration](https://www.youtube.com/watch?v=njVZWRGTJAI) - take password for your `DBADMIN` user from service-creation step 
