# You can easily add the logging service to your project by including your service-logger in the service list 
# within your `manifest.yaml` file.

# SAP Application Logging Service - retiring in July 2025
* SAP Discovery Center [https://discovery-center.cloud.sap/serviceCatalog/application-logging-service?region=all]
* DOCS - [https://help.sap.com/docs/application-logging-service]

# Important Notes
By default, the logging service does not capture logs produced by certain logging libraries, such as Log4j.
To enable logging for these libraries using the SAP logging service, follow the configuration guidelines below:
 - [https://github.com/SAP/cf-java-logging-support]