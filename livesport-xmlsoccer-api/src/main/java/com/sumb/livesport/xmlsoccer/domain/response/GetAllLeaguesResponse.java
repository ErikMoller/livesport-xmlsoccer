package com.sumb.livesport.xmlsoccer.domain.response;

import com.sumb.livesport.xmlsoccer.domain.league.League;

import java.util.List;

/**
 * @author Erik Möller <mailto:erik.moller@live.com>
 * @since 1.0
 */
public class GetAllLeaguesResponse {

    private List<League> leagues;
    private String accountInformation;

    private GetAllLeaguesResponse() {
    }

    public GetAllLeaguesResponse(Builder builder) {
        this.leagues = builder.leagues;
        this.accountInformation = builder.accountInformation;
    }

    public List<League> getLeagues() {
        return leagues;
    }

    public String getAccountInformation() {
        return accountInformation;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<League> leagues;
        private String accountInformation;

        private Builder() {

        }

        public Builder withLeagues(List<League> leagues) {
            this.leagues = leagues;
            return this;
        }

        public Builder withAccountInformation(String accountInformation) {
            this.accountInformation = accountInformation;
            return this;
        }
        public GetAllLeaguesResponse build() {
            return new GetAllLeaguesResponse(this);
        }
    }
}
