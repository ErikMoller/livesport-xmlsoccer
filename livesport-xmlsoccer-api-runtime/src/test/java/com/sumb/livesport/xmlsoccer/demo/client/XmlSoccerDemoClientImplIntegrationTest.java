package com.sumb.livesport.xmlsoccer.demo.client;

import com.sumb.livesport.xmlsoccer.client.XmlSoccerClient;
import com.sumb.livesport.xmlsoccer.demo.client.XmlSoccerDemoClient;
import com.sumb.livesport.xmlsoccer.domain.response.GetAllTeamsResponse;
import com.sumb.livesport.xmlsoccer.domain.team.Team;
import org.junit.Test;

/**
 * @author Erik Möller <mailto:erik.moller@live.com>
 * @since 1.0
 */
public class XmlSoccerDemoClientImplIntegrationTest {

    @Test
    public void testGetAllTeams() {
        XmlSoccerClient client = new XmlSoccerDemoClient("www.xmlsoccer.com", "EDMYCWBMLOPMRVUDPWSXSHMTYRBBIXFOVBNTYKOLNEQVOELZRV");

        GetAllTeamsResponse teamsResponse = client.getAllTeams();

        for (Team team : teamsResponse.getTeams()) {
            System.out.println(team.getName());
        }
    }
}
