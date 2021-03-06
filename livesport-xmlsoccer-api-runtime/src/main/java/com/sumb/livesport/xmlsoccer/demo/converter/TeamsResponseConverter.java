package com.sumb.livesport.xmlsoccer.demo.converter;

import com.sumb.livesport.xmlsoccer.common.converter.GetAllTeamsResponseConverter;
import com.sumb.livesport.xmlsoccer.domain.response.GetAllTeamsResponse;
import com.sumb.livesport.xmlsoccer.domain.team.Team;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.xml.sax.SAXException;
import xmlsoccer.team.GetAllTeamsDemoResponse;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Erik Möller <mailto:erik.moller@live.com>
 * @since 1.0
 */
public class TeamsResponseConverter implements GetAllTeamsResponseConverter {

    private JAXBContext jaxbContext;
    private Unmarshaller teamsResponseUnmarshaller;
    private static String schemaUri = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    private static SchemaFactory schemaFactory = SchemaFactory.newInstance(schemaUri);

    public TeamsResponseConverter() {
        try {
            jaxbContext = createJAXBContext();
            teamsResponseUnmarshaller = createUnmarshaller(schemaFactory.newSchema(new StreamSource(ClassLoader.getSystemResourceAsStream("xsd/getAllTeams.xsd"))));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public GetAllTeamsResponse convert(HttpEntity httpEntity) throws IOException, JAXBException {
        GetAllTeamsResponse response = buildResponse(GetAllTeamsDemoResponse.class.cast(teamsResponseUnmarshaller.unmarshal(convertEntityToStringReaderWithoutNameSpace(httpEntity))));
        return response;
    }

    private StringReader convertEntityToStringReaderWithoutNameSpace(HttpEntity httpEntity) throws IOException {
        return new StringReader(EntityUtils.toString(httpEntity).replaceAll(" xmlns=\\\".*\\\"", ""));
    }

    private GetAllTeamsResponse buildResponse(GetAllTeamsDemoResponse demoResponse) {
        return GetAllTeamsResponse.builder()
                .withAccountInformation(demoResponse.getAccountInformation())
                .withTeams(buildTeams(demoResponse.getTeams())).build();

    }

    private List<Team> buildTeams(List<GetAllTeamsDemoResponse.DemoTeam> demoTeams) {
        List<Team> teams = new ArrayList<>();
        for (GetAllTeamsDemoResponse.DemoTeam demoTeam : demoTeams) {
            teams.add(Team.builder()
                    .withTeamId(demoTeam.getTeamId())
                    .withName(demoTeam.getName())
                    .withCountry(demoTeam.getCountry())
                    .withStadium(demoTeam.getStadium())
                    .withHomePageURL(demoTeam.getHomePageURL())
                    .withWikiLink(demoTeam.getWIKILink()).build()
            );
        }
        return teams;
    }

    private JAXBContext createJAXBContext() throws JAXBException {
        return JAXBContext.newInstance(GetAllTeamsDemoResponse.class);
    }

    private Unmarshaller createUnmarshaller(Schema schema) throws JAXBException {
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setSchema(schema);
        return unmarshaller;
    }
}
