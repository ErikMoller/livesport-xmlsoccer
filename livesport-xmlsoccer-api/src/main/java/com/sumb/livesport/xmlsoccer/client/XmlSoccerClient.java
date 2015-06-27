package com.sumb.livesport.xmlsoccer.client;

import com.sumb.livesport.xmlsoccer.domain.response.GetAllLeaguesResponse;
import com.sumb.livesport.xmlsoccer.domain.response.GetAllTeamsResponse;

/**
 * @author Erik Möller <mailto:erik.moller@live.com>
 * @since 1.0
 */
public interface XmlSoccerClient {

    GetAllTeamsResponse getAllTeams();

    GetAllLeaguesResponse getAllLeagues();
}
