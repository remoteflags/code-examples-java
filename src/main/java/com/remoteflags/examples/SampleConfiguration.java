package com.remoteflags.examples;

import com.remoteflags.ApiClient;
import com.remoteflags.api.PublicApi;
import com.remoteflags.auth.ApiKeyAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleConfiguration {

    @Bean
    public ApiClient apiClient() {
        ApiClient client = com.remoteflags.Configuration.getDefaultApiClient();
        client.setBasePath("https://api.remoteflags.com");
        ApiKeyAuth RemoteFlagsAuthorizer = (ApiKeyAuth) client.getAuthentication("RemoteFlagsAuthorizer");
        RemoteFlagsAuthorizer.setApiKey("<YourAccessToken>");
        return client;
    }

    @Bean
    public PublicApi publicApi() {
        return new PublicApi(apiClient());
    }

}
