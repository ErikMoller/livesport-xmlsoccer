package com.sumb.livesport.xmlsoccer.demo.client;

import com.sumb.livesport.xmlsoccer.common.client.AbstractXmlSoccerClient;
import com.sumb.livesport.xmlsoccer.demo.converter.LeaguesConverter;
import com.sumb.livesport.xmlsoccer.demo.converter.TeamsResponseConverter;

/**
 * @author Erik Möller <mailto:erik.moller@live.com>
 * @since 1.0
 */
public class XmlSoccerDemoClient extends AbstractXmlSoccerClient {

    XmlSoccerDemoClient(String host, String apiKey) {
        super(host, apiKey,
                new XmlSoccerDemoHttpGetGenerator(apiKey),
                new LeaguesConverter(),
                new TeamsResponseConverter());
    }
}
