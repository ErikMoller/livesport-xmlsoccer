package com.sumb.livesport.xmlsoccer.demo.converter;

import com.sumb.livesport.xmlsoccer.domain.response.GetAllTeamsResponse;
import com.sumb.livesport.xmlsoccer.domain.team.Team;
import org.apache.http.HttpEntity;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Erik Möller <mailto:erik.moller@live.com>
 * @since 1.0
 */
public class TeamsResponseConverterUnitTest {

    @Test
    public void testTeamsByLeague() throws IOException, JAXBException {
        TeamsResponseConverter converter = new TeamsResponseConverter();
        HttpEntity httpEntity = mock(HttpEntity.class);
        when(httpEntity.getContent()).thenReturn(ClassLoader.getSystemResourceAsStream("teamsByLeagues.xml"));
        GetAllTeamsResponse getAllTeamsResponse = converter.convert(httpEntity);
        for (Team team : getAllTeamsResponse.getTeams()) {
            System.out.println(team.getName());
        }
    }

    @Test
    public void testTeams() throws IOException, JAXBException {
        TeamsResponseConverter converter = new TeamsResponseConverter();
        HttpEntity httpEntity = mock(HttpEntity.class);
        when(httpEntity.getContent()).thenReturn(ClassLoader.getSystemResourceAsStream("teams.xml"));
        GetAllTeamsResponse getAllTeamsResponse = converter.convert(httpEntity);
        for (Team team : getAllTeamsResponse.getTeams()) {
            System.out.println(team.getName());
        }
    }
}
