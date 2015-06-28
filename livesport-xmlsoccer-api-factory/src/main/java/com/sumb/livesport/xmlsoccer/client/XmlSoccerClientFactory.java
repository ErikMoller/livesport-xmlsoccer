package com.sumb.livesport.xmlsoccer.client;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author Erik Möller <mailto:erik.moller@live.com>
 * @since 1.0
 */
public class XmlSoccerClientFactory {

    public XmlSoccerClientFactory() {
    }

    public XmlSoccerClient createProductionClient() {
        throw new NotImplementedException();
    }

    public XmlSoccerClient createDemoClient() {
        return new XmlSoccerDemoClient();
    }

}
