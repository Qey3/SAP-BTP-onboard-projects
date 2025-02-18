## This project has been made step-by-stem from this tutorial:
- [https://developers.sap.com/tutorials/btp-cf-buildpacks-java-create.html]

### If you encounter issues with role creation, don’t worry! You can resolve this by modifying your xs-security.json file:
Add your own `role-collections`, ensuring they include `role-template-references` that reference your role.
Once updated, the role collection with linked roles will be automatically created and assigned to your `Subaccount`.
Additionally, you should go to your role collection [Security -> Role Collections -> <your role collection name> -> edit] ,
and add your e-mail in 'User' list.

### Commands that have been used in this project:
 - cf create-service xsuaa application javauaa -c xs-security.json [create security service]
 - cf update-service javauaa -c xs-security.json [update security service]
 - npm init [init approuter]
 - npm install @sap/approuter --save
 - cf push