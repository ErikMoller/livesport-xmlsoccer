package com.sumb.livesport.xmlsoccer.domain.response;

import com.sumb.livesport.xmlsoccer.domain.team.Team;

import java.util.List;

/**
 * @author Erik Möller <mailto:erik.moller@live.com>
 * @since 1.0
 */
public class GetAllTeamsResponse {

    private List<Team> teams;
    private String accountInformation;

    private GetAllTeamsResponse() {
    }

    private GetAllTeamsResponse(Builder builder) {
        this.teams = builder.teams;
        this.accountInformation = builder.accountInformation;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public String getAccountInformation() {
        return accountInformation;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<Team> teams;
        private String accountInformation;

        private Builder() {

        }

        public Builder withTeams(List<Team> teams) {
            this.teams = teams;
            return this;
        }

        public Builder withAccountInformation(String accountInformation) {
            this.accountInformation = accountInformation;
            return this;
        }

        public GetAllTeamsResponse build() {
            return new GetAllTeamsResponse(this);
        }
    }
}
