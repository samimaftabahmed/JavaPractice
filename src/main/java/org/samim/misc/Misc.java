package org.samim.misc;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Misc {

    public static void main(String[] args) throws URISyntaxException, NoSuchAlgorithmException {
        urlDescriber();
    }

    private static void urlDescriber() throws URISyntaxException {
        String myUrl = "http://localhost:8080/get_req/sjbfkjd/sddgfsdfs/sdfsdf";
        URI uri = new URI(myUrl);

        String port = "";
        if (uri.getPort() != -1) {
            port = String.valueOf(uri.getPort());
        }
        String myHost = uri.getScheme() + "://" + uri.getHost() + ":" + port;
        System.out.println(myHost);

        String[] split = myUrl.split(myHost);

        for (String string : split) {
            System.out.println(string);
        }
    }

}
