package com.sumb.livesport.xmlsoccer.converter;

import com.sumb.livesport.xmlsoccer.domain.league.League;
import com.sumb.livesport.xmlsoccer.domain.response.GetAllLeaguesResponse;
import org.apache.http.HttpEntity;
import org.xml.sax.SAXException;
import xmlsoccer.league.GetAllLeaguesDemoResponse;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Erik Möller <mailto:erik.moller@live.com>
 * @since 1.0
 */
public class LeaguesConverter {

    private JAXBContext jaxbContext;
    private Unmarshaller teamsResponseUnmarshaller;
    private static String schemaUri = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    private static SchemaFactory schemaFactory = SchemaFactory.newInstance(schemaUri);

    public LeaguesConverter() {
        try {
            jaxbContext = createJAXBContext();
            teamsResponseUnmarshaller = createUnmarshaller(schemaFactory.newSchema(new StreamSource(ClassLoader.getSystemResourceAsStream("xsd/getAllLeagues.xsd"))));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public GetAllLeaguesResponse convert(HttpEntity httpEntity) throws IOException, JAXBException {
        return buildResponse(GetAllLeaguesDemoResponse.class.cast(teamsResponseUnmarshaller.unmarshal(httpEntity.getContent())));
    }

    private GetAllLeaguesResponse buildResponse(GetAllLeaguesDemoResponse getAllLeaguesDemoResponse) {
        return GetAllLeaguesResponse.builder()
                .withAccountInformation(getAllLeaguesDemoResponse.getAccountInformation())
                .withLeagues(buildLeagues(getAllLeaguesDemoResponse.getLeagues())).build();
    }

    private List<League> buildLeagues(List<GetAllLeaguesDemoResponse.DemoLeague> demoLeagues) {
        List<League> leagues = new ArrayList<>();
        for (GetAllLeaguesDemoResponse.DemoLeague demoLeague : demoLeagues) {
            leagues.add(League.builder()
                    .withId(demoLeague.getId())
                    .withName(demoLeague.getName())
                    .withCountry(demoLeague.getCountry())
                    .withHistoricalData(demoLeague.getHistoricalData())
                    .withFixtures(demoLeague.getFixtures())
                    .withLivescore(demoLeague.getLivescore())
                    .withNumberOfMatches(demoLeague.getNumberOfMatches())
                    .withLatestMatch(demoLeague.getLatestMatch()).build()
            );
        }
        return leagues;
    }

    private JAXBContext createJAXBContext() throws JAXBException {
        return JAXBContext.newInstance(GetAllLeaguesDemoResponse.class);
    }

    private Unmarshaller createUnmarshaller(Schema schema) throws JAXBException {
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setSchema(schema);
        return unmarshaller;
    }
}
