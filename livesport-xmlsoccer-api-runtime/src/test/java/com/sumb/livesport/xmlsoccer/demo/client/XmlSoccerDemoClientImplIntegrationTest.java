package com.sumb.livesport.xmlsoccer.demo.client;

import com.sumb.livesport.xmlsoccer.client.XmlSoccerClient;
import com.sumb.livesport.xmlsoccer.domain.response.GetAllTeamsResponse;
import com.sumb.livesport.xmlsoccer.domain.team.Team;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Erik Möller <mailto:erik.moller@live.com>
 * @since 1.0
 */
public class XmlSoccerDemoClientImplIntegrationTest {

    private final XmlSoccerClient client = new XmlSoccerDemoClient("www.xmlsoccer.com", "EDMYCWBMLOPMRVUDPWSXSHMTYRBBIXFOVBNTYKOLNEQVOELZRV");

    @Test
    @Ignore
    public void testGetAllTeams() {
        GetAllTeamsResponse teamsResponse = client.getAllTeams();

        for (Team team : teamsResponse.getTeams()) {
            System.out.println(team.getName());
        }
    }

    @Test
    public void testGetAllTeamsByLeagueAndSeason() {
        GetAllTeamsResponse allTeamsResponse = client.getAllTeamsByLeagueAndSeason("Scottish Premier League", "1415");

        for (Team team : allTeamsResponse.getTeams()) {
            System.out.println(team.getName());
        }
    }
}
