<br/>

![alt text](https://s3.eu-west-1.amazonaws.com/www.remoteflags.com/Header.png)
# Java examples

This package contains code example on how to integrate with Remote Flags api and fetch a specific flag status.

**Please Note**: [Remote Flags](remoteflags.com) is currently in beta. The examples contained in this package are subject to change, namely the api endpoints.

---
# How to use
## Step 1 - Gather data
Visit [Remote Flags](remoteflags.com) and grab the information you need to query the api, namely:

1. Access Token - get it at [remoteflags.com/account](www.remoteflags.com/account)
2. OwnerId - get it at [remoteflags.com/account]((www.remoteflags.com/account))
3. FlagId - get it by selecting one flag at [remoteflags.com/flags]((www.remoteflags.com/flags))

## Step 2
In ```SampleConfiguration.java``` you will find the API setup code. There you have 2 beans, one for the client and one for the actual API.
Edit the client bean to include your ```<AccessToken>```. In a SpringBoot app, you can set this 1 time, you can also put in a app.properties file.

```java
    RemoteFlagsAuthorizer.setApiKey("<AccessToken>");
```

Additionally, set up the actual flag call. In the example this is inside ```SampleController.java```.

```java
    try {
        Status result = publicApi.getStatus(ownerId, flagId, segment, key);
    } catch (ApiException e) {
        System.err.println("Exception when calling PublicApi#getStatus");
        System.err.println("Status code: " + e.getCode());
    }
```

**Note**: If you don't want to include segment or key in your query  in java you can pass empty string ```""``` or ```null``` value.

## Step 3
Your all set, simply run the project and see the flag status

1. Run - ```gradle bootRun```
2. Visit - http://localhost:8080/show/me/the/money

You should see your flag status on the screen
