package com.remoteflags.examples;

import com.remoteflags.ApiException;
import com.remoteflags.api.PublicApi;
import com.remoteflags.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Autowired
    PublicApi publicApi;

    @GetMapping("/show/me/the/money")
    public String showMoney() {
        String ownerId = "<YourOwnerId>";
        String flagId = "<YourFlagId>";
        String segment = null;
        String key = null;
        try {
            Status result = publicApi.getStatus(ownerId, flagId, segment, key);
            System.out.println(result);
            return result.getValue();
        } catch (ApiException e) {
            System.err.println("Exception when calling PublicApi#getStatus");
            System.err.println("Status code: " + e.getCode());
        }
        return "No money...";
    }

}
