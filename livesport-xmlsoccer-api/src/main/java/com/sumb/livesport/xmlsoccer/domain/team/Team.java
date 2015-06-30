package com.sumb.livesport.xmlsoccer.domain.team;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Erik Möller <mailto:erik.moller@live.com>
 * @since 1.0
 */
public class Team {

    private Integer teamId;
    private String name;
    private String country;
    private String stadium;
    private String homePageURL;
    private String wikiLink;


    private Team() {
    }

    private Team(Builder builder) {
        this.teamId = builder.teamId;
        this.name = builder.name;
        this.country = builder.country;
        this.stadium = builder.stadium;
        this.homePageURL = builder.homePageURL;
        this.wikiLink = builder.wikiLink;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getStadium() {
        return stadium;
    }

    public String getHomePageURL() {
        return homePageURL;
    }

    public String getWikiLink() {
        return wikiLink;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer teamId;
        private String name;
        private String country;
        private String stadium;
        private String homePageURL;
        private String wikiLink;

        private Builder() {
        }

        public Builder withTeamId(Integer teamId) {
            this.teamId = teamId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder withStadium(String stadium) {
            this.stadium = stadium;
            return this;
        }

        public Builder withHomePageURL(String homePageURL) {
            this.homePageURL = homePageURL;
            return this;
        }

        public Builder withWikiLink(String wikiLink) {
            this.wikiLink = wikiLink;
            return this;
        }

        public Team build() {
            return new Team(this);
        }
    }
}
