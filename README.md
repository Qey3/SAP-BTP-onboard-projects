# This is series of projects that allow you to get familiar with SAP environment and tools step-by-step.
Each project assumes that you have completed the previous one, studied the information and know how to use 
the technologies you have studied from previous one.

# Project list:
- `1.Manifest_project` – Demonstrates how to build a simple application using manifest.yaml 
with XSUAA and App Router services and deploy it to SAP BTP.
- `2.Manifest_log_project` – Shows how to configure and manage logging for your application.
- `3.Destination_apps` – Provides an example of using SAP Cloud SDK to establish connectivity with external services.
- `4.Mta_app` – Illustrates how to centralize all configurations into a single MTA (multi-target application) file.
- `5.OData-project` – Introduces OData APIs and demonstrates how to use SAP Cloud SDK for OData-based communication.
- `6.SAP_Postgresql` – Explains how to connect an application to an SAP BTP PostgreSQL database.
- `7.Hana_cloud` – Guides you through connecting an application to an SAP HANA Cloud database.
- `8.Manifest_multitenant` – Demonstrates how to build and register a SaaS application with multitenancy 
using a manifest.yaml approach.
- `9.MTA_Multitenant` – Similar to the previous project but applies MTA concepts to configure the application in a single file.

# If you get stuck at any point, don't hesitate to check the project's README file or folder structure. 
I've included additional problem-solving descriptions in each project based on challenges I encountered along the way.

## Useful links:
### Remote debugging on SAP BTP Cloud Foundry
- [Debugging Java Web Applications on SAP Business Technology Platform](https://help.sap.com/docs/btp/sap-business-technology-platform/debug-java-web-application-running-on-sapmachine?locale=en-US)
- https://blogs.sap.com/2019/07/24/remote-debugging-on-cloud-foundry/
- [SSH Services in Cloud Foundry](https://docs.cloudfoundry.org/devguide/deploy-apps/ssh-services.html)

### MTA Documentation:
- [Deploying a Multi-Target Application on SAP Business Technology Platform](https://developers.sap.com/tutorials/btp-cf-deploy-mta.html)
- [Creating a Multi-Target Application Descriptor (MTAD)](https://help.sap.com/docs/SAP_HANA_PLATFORM/4505d0bdaf4948449b7f7379d24d0f0d/4050fee4c469498ebc31b10f2ae15ff2.html)
- [Multi-Target Applications in the Cloud Foundry Environment](https://help.sap.com/docs/btp/sap-business-technology-platform/multitarget-applications-in-cloud-foundry-environment)
- [Example of mta file](https://github.com/SAP-samples/cloud-cap-multitenancy/blob/main/mta.yaml)
- [Example of mta file](https://github.com/SAP-samples/btp-build-resilient-apps/blob/main/mta.yaml)

### Helpful Resources
- [Secure Your Multi-Target Application on BTP](https://github.com/SAP-archive/teched2019-cloud-cf-product-list/blob/teched2019/docs/09_secure/README.md)
- [Sample Application - teched2019-cloud-cf-product-list](https://github.com/SAP-archive/teched2019-cloud-cf-product-list/tree/teched2019)
- [SSH Services in Cloud Foundry](https://docs.cloudfoundry.org/devguide/deploy-apps/ssh-services.html)
- [Deep Dive: Tenant-Aware Persistency with SAP S/4HANA Cloud SDK](https://blogs.sap.com/2017/12/20/deep-dive-6-with-sap-s4hana-cloud-sdk-extend-your-cloud-foundry-application-with-tenant-aware-persistency/)
- [Tutorial: Multi-Tenancy Setup with XSUAA in SAP Business Technology Platform](https://developers.sap.com/tutorials/cp-cf-security-xsuaa-multi-tenant.html)
- [Debugging Java Web Applications on SAP Business Technology Platform](https://help.sap.com/docs/btp/sap-business-technology-platform/debug-java-web-application-running-on-sapmachine?locale=en-US)
- [Remote Debugging on Cloud Foundry](https://blogs.sap.com/2019/07/24/remote-debugging-on-cloud-foundry/)