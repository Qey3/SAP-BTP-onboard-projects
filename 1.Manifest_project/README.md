## This project has been made step-by-stem from this tutorial:
- [Create an Application with SAP Java Buildpack](https://developers.sap.com/tutorials/btp-cf-buildpacks-java-create.html)

### If you encounter issues with role creation, don’t worry! You can resolve this by modifying your xs-security.json file:
Add your own `role-collections`, ensuring they include `role-template-references` that reference your role.
Once updated, the role collection with linked roles will be automatically created and assigned to your `Subaccount`.
Additionally, you should go to your role collection `Security -> Role Collections -> <your role collection name> -> edit` ,
and add your e-mail in 'User' list.

### Commands that have been used in this project:
 - cf create-service xsuaa application javauaa -c xs-security.json [create security service]
 - cf update-service javauaa -c xs-security.json [update security service]
 - npm init [init approuter]
 - npm install @sap/approuter --save
 - cf push

### [Using Postman for API Testing with XSUAA](https://community.sap.com/t5/technology-blogs-by-sap/using-postman-for-api-testing-with-xsuaa/ba-p/13442516)
 - When run your application insert [VCAP_SERVICES in the IntelliJ Idea](https://leverxeu.atlassian.net/wiki/spaces/JAVA/pages/4908711958/How+to+find+VCAP_SERVICES+of+deployed+application#VCAP_SERVICES-in-the-IntelliJ-Idea)
 - Another example how to [Run Node.js Applications with Authentication Locally - SAP BTP Security](https://community.sap.com/t5/technology-blogs-by-sap/run-node-js-applications-with-authentication-locally-sap-btp-security/ba-p/13540122)