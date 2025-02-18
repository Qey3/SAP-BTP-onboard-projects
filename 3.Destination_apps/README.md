## Here are the applications than can communicate using a configured Destination.
* First, create destination in your `SAP BTP Cockpit` `Subaccount -> Connectiviy -> Destinations`.
* Set up `url` to second app, choose `BasicAuthentication` and type `login` and `password` from second app.
* You can use destination in your app with `com.sap.cloud.sdk` library, which allows you to retrieve a registered SAP Destination by name and use it for making requests.
* [BTP Destination Service Integration](https://sap.github.io/cloud-sdk/docs/java/features/connectivity/btp-destination-service)