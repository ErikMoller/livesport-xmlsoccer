package com.sumb.livesport.xmlsoccer.demo.client;

import com.sumb.livesport.xmlsoccer.common.client.XmlSoccerHttpGetGenerator;
import org.apache.http.client.methods.HttpGet;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author Erik Möller <mailto:erik.moller@live.com>
 * @since 1.0
 */
public class XmlSoccerDemoHttpGetGenerator implements XmlSoccerHttpGetGenerator {

    private static final String DEMO_URL_PREFIX = "/FootballDataDemo.asmx/";
    private static final String API_KEY_PREFIX = "?ApiKey=";

    private final HttpGet allTeamsHttpGet;
    private final HttpGet allLeaguesHttpGet;
    private final StringBuilder getAllTeamsByLeagueAndSeasonStringBuilder;

    public XmlSoccerDemoHttpGetGenerator(String apiKey) {
        this.allTeamsHttpGet = new HttpGet(createHttpGetUrl("GetAllTeams") + apiKey);
        this.getAllTeamsByLeagueAndSeasonStringBuilder = new StringBuilder(createHttpGetUrl("GetAllTeamsByLeagueAndSeason") + apiKey);
        this.allLeaguesHttpGet = new HttpGet(createHttpGetUrl("GetAllLeagues") + apiKey);

    }

    @Override
    public HttpGet allTeamsHttpGet() {
        return allTeamsHttpGet;
    }

    @Override
    public HttpGet allTeamsByLeagueAndSeasonHttpGet(String league, String season) {
        return new HttpGet(this.getAllTeamsByLeagueAndSeasonStringBuilder.append(replaceSpaceWithHttpEncoding("&league="+league+"&seasonDateString="+season)).toString());
    }

    @Override
    public HttpGet allLeaguesHttpGet() {
        return allLeaguesHttpGet;
    }

    private static String createHttpGetUrl(String action) {
        return DEMO_URL_PREFIX + action + API_KEY_PREFIX;
    }

    private String replaceSpaceWithHttpEncoding(String url) {
        return url.replaceAll(" ", "%20");
    }


}
