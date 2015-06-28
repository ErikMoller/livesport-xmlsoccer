package com.sumb.livesport.xmlsoccer.demo.client;

import com.sumb.livesport.xmlsoccer.client.XmlSoccerClient;

/**
 * @author Erik Möller <mailto:erik.moller@live.com>
 * @since 1.0
 */
public class XmlSoccerDemoClientFactory {

    public static XmlSoccerClient createDemoClient(String host, String apiKey) {
        return new XmlSoccerDemoClient(host, apiKey);
    }
}
