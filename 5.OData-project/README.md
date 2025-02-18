# This application can extract some data from special OData resource.

## First install `com.sap.cloud.sdk` and read documentation how to generate OData client:
* [Generate a Typed OData Client With the OData Generator](https://sap.github.io/cloud-sdk/docs/java/features/odata/vdm-generator)

* If you encounter issues with the V2 OData service from: [Northwind Odata V2](https://services.odata.org/northwind/northwind.svc/$metadata)
* You should use the V4 OData service instead: [Northwind Odata V4](https://services.odata.org/V4/Northwind/Northwind.svc/$metadata)

* Generate classes through the plugin -> [Plugins -> odata-v4-generator] 

### If you have troubles with generated package name, set up your own configuration in `pom.xml` and `serviceNameMappings.properties` files.