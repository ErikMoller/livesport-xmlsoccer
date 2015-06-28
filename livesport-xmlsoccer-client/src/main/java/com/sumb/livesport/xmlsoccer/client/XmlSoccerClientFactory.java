package com.sumb.livesport.xmlsoccer.client;

import com.sumb.livesport.xmlsoccer.demo.client.XmlSoccerDemoClientFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author Erik Möller <mailto:erik.moller@live.com>
 * @since 1.0
 */
public class XmlSoccerClientFactory {

    public XmlSoccerClientFactory() {
    }

    public static XmlSoccerClient createProductionClient() {
        throw new NotImplementedException();
    }

    public static XmlSoccerClient createDemoClient(String host, String apiKey) {
        return XmlSoccerDemoClientFactory.createDemoClient(host, apiKey);
    }

}
