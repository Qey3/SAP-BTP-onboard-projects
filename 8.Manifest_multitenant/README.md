# Multitenant project, with manual created  and `SaaS` services.

# Key steps to create a Multitenant Application
## First create services:
* `cf create-service xsuaa application xsuaa-service-tutorial -c security/xs-security.json` - xsuaa service.
* `cf create-service saas-registry application saas-registry-tutorial -c config.json` - Creates a service 
for subscribing to your application.
Note: On this step you should already have a database service (PostgreSQL or SAP HANA) set up.
## Build and deploy application:
* `mvn clean install`
* `cf push`
* manually add route for subscriber: 
`cf map-route <router-name> cfapps.us10-001.hana.ondemand.com --hostname <subscriber-subdomain>-<router-url>`
* From subscriber account subscribe to your app.

### Notices:
- The redirect URL pattern inside the `xs-security.json` has to contain the API Endpoint URL of your environment. For example:
`"oauth2-configuration": {
    "redirect-uris": [
        "https://*.cfapps.us10-001.hana.ondemand.com/**"
    ]
}`
- setup `tenant-mode` to `shared`
- With this scope set, the callbacks for tenant onboarding, offboarding and getDependencies can be called:
- scope `$XSAPPNAME.Callback` with parameter `grant-as-authority-to-apps`:
`$XSAPPNAME(application,sap-provisioning,tenant-onboarding`

### Tutorial how to add multi-tenancy support:
[https://developers.sap.com/tutorials/cp-cf-security-xsuaa-multi-tenant.html]
[https://spring.io/blog/2022/07/31/how-to-integrate-hibernates-multitenant-feature-with-spring-data-jpa-in-a-spring-boot-application]