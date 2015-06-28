package com.sumb.livesport.xmlsoccer.common.client;

import org.apache.http.client.methods.HttpGet;

/**
 * @author Erik Möller <mailto:erik.moller@live.com>
 * @since 1.0
 */
public interface XmlSoccerHttpGetGenerator {

    HttpGet allTeamsHttpGet();

    HttpGet allLeaguesHttpGet();
}
