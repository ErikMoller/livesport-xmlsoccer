package com.sumb.livesport.xmlsoccer.common.converter;

import com.sumb.livesport.xmlsoccer.domain.response.GetAllLeaguesResponse;
import org.apache.http.HttpEntity;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * @author Erik Möller <mailto:erik.moller@live.com>
 * @since 1.0
 */
public interface GetAllLeaguesResponseConverter {

    GetAllLeaguesResponse convert(HttpEntity httpEntity) throws IOException, JAXBException;
}
