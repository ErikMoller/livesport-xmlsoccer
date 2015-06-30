package com.sumb.livesport.xmlsoccer.domain.league;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author Erik Möller <mailto:erik.moller@live.com>
 * @since 1.0
 */
public class League {

    private Integer id;
    private String name;
    private String country;
    private String historicalData;
    private String fixtures;
    private String livescore;
    private short numberOfMatches;
    private XMLGregorianCalendar latestMatch;

    private League() {
    }

    private League(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.country = builder.country;
        this.historicalData = builder.historicalData;
        this.fixtures = builder.fixtures;
        this.livescore = builder.livescore;
        this.numberOfMatches = builder.numberOfMatches;
        this.latestMatch = builder.latestMatch;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getHistoricalData() {
        return historicalData;
    }

    public String getFixtures() {
        return fixtures;
    }

    public String getLivescore() {
        return livescore;
    }

    public short getNumberOfMatches() {
        return numberOfMatches;
    }

    public XMLGregorianCalendar getLatestMatch() {
        return latestMatch;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String name;
        private String country;
        private String historicalData;
        private String fixtures;
        private String livescore;
        private short numberOfMatches;
        private XMLGregorianCalendar latestMatch;


        private Builder() {

        }

        public Builder withId(Integer id) {
            this.id = id;
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

        public Builder withHistoricalData(String historicalData) {
            this.historicalData = historicalData;
            return this;
        }

        public Builder withFixtures(String fixtures) {
            this.fixtures = fixtures;
            return this;
        }

        public Builder withLivescore(String livescore) {
            this.livescore = livescore;
            return this;
        }

        public Builder withNumberOfMatches(short numberOfMatches) {
            this.numberOfMatches = numberOfMatches;
            return this;
        }

        public Builder withLatestMatch(XMLGregorianCalendar latestMatch) {
            this.latestMatch = latestMatch;
            return this;
        }

        public League build() {
            return new League(this);
        }
    }
}
