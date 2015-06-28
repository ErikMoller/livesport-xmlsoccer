package com.sumb.livesport.xmlsoccer.common.client;

import com.sumb.livesport.xmlsoccer.client.XmlSoccerClient;
import com.sumb.livesport.xmlsoccer.common.converter.GetAllLeaguesResponseConverter;
import com.sumb.livesport.xmlsoccer.common.converter.GetAllTeamsResponseConverter;
import com.sumb.livesport.xmlsoccer.domain.response.GetAllLeaguesResponse;
import com.sumb.livesport.xmlsoccer.domain.response.GetAllTeamsResponse;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Erik Möller <mailto:erik.moller@live.com>
 * @since 1.0
 */
public abstract class AbstractXmlSoccerClient implements XmlSoccerClient {

    protected final String apiKey;
    protected final HttpHost host;
    protected final CloseableHttpClient client;
    private final XmlSoccerHttpGetGenerator httpGetGenerator;
    private final GetAllLeaguesResponseConverter getAllLeaguesResponseConverter;
    private final GetAllTeamsResponseConverter getAllTeamsResponseConverter;

    protected AbstractXmlSoccerClient(String host, String apiKey, XmlSoccerHttpGetGenerator httpGetGenerator,
                                      GetAllLeaguesResponseConverter getAllLeaguesResponseConverter,
                                      GetAllTeamsResponseConverter getAllTeamsResponseConverter) {
        client = HttpClientBuilder.create().build();
        this.host = new HttpHost(Objects.requireNonNull(host, "host"));
        this.apiKey = Objects.requireNonNull(apiKey, "apiKey");
        this.httpGetGenerator = Objects.requireNonNull(httpGetGenerator, "httpGetGenerator");
        this.getAllLeaguesResponseConverter = Objects.requireNonNull(getAllLeaguesResponseConverter, "getAllLeaguesResponseConverter");
        this.getAllTeamsResponseConverter = Objects.requireNonNull(getAllTeamsResponseConverter, "getAllTeamsResponseConverter");
    }

    @Override
    public GetAllTeamsResponse getAllTeams() {
        CloseableHttpResponse response = null;
        try {
            response = client.execute(host, httpGetGenerator.allTeamsHttpGet());
            return getAllTeamsResponseConverter.convert(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GetAllLeaguesResponse getAllLeagues() {
        CloseableHttpResponse response = null;
        try {
            response = client.execute(host, httpGetGenerator.allLeaguesHttpGet());
            return getAllLeaguesResponseConverter.convert(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
