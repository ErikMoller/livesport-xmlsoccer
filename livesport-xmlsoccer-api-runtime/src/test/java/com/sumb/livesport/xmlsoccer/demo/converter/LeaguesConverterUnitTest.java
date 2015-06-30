package com.sumb.livesport.xmlsoccer.demo.converter;

import com.sumb.livesport.xmlsoccer.domain.league.League;
import com.sumb.livesport.xmlsoccer.domain.response.GetAllLeaguesResponse;
import org.apache.http.HttpEntity;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Erik Möller <mailto:erik.moller@live.com>
 * @since 1.0
 */
public class LeaguesConverterUnitTest {

    @Test
    public void test() throws IOException, JAXBException {
        LeaguesConverter converter = new LeaguesConverter();
        HttpEntity httpEntity = mock(HttpEntity.class);
        when(httpEntity.getContent()).thenReturn(ClassLoader.getSystemResourceAsStream("leagues.xml"));
        GetAllLeaguesResponse getAllLeaguesResponse = converter.convert(httpEntity);
        for (League league : getAllLeaguesResponse.getLeagues()) {
            System.out.println(league.getName());
        }
    }
}
