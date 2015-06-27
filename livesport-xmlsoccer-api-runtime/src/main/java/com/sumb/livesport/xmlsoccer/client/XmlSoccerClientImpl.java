package com.sumb.livesport.xmlsoccer.client;

import com.sumb.livesport.xmlsoccer.converter.LeaguesConverter;
import com.sumb.livesport.xmlsoccer.converter.TeamsResponseConverter;
import com.sumb.livesport.xmlsoccer.domain.response.GetAllLeaguesResponse;
import com.sumb.livesport.xmlsoccer.domain.response.GetAllTeamsResponse;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * @author Erik Möller <mailto:erik.moller@live.com>
 * @since 1.0
 */
public class XmlSoccerClientImpl implements XmlSoccerClient {

    private static CloseableHttpClient client = HttpClientBuilder.create().build();
    private static HttpHost host = new HttpHost("www.xmlsoccer.com");
    private TeamsResponseConverter teamsResponseConverter = new TeamsResponseConverter();
    private LeaguesConverter leaguesConverter = new LeaguesConverter();


    @Override
    public GetAllTeamsResponse getAllTeams() {
        HttpGet get = new HttpGet("/FootballDataDemo.asmx/GetAllTeams?ApiKey=EDMYCWBMLOPMRVUDPWSXSHMTYRBBIXFOVBNTYKOLNEQVOELZRV");
        CloseableHttpResponse response = null;
        try {
            response = client.execute(host, get);
            return teamsResponseConverter.convert(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (JAXBException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public GetAllLeaguesResponse getAllLeagues() {
        HttpGet get = new HttpGet("/FootballDataDemo.asmx/GetAllLeagues?ApiKey=EDMYCWBMLOPMRVUDPWSXSHMTYRBBIXFOVBNTYKOLNEQVOELZRV");
        CloseableHttpResponse response = null;
        try {
            response = client.execute(host, get);
            return leaguesConverter.convert(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (JAXBException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
}
