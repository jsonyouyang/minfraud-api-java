package com.maxmind.minfraud.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maxmind.minfraud.MinFraudRequest;

/**
 * Shared behavior between Shipping and Billing
 */
abstract class AbstractLocation {
    @JsonProperty("first_name")
    protected String firstName;

    @JsonProperty("last_name")
    protected String lastName;

    protected String company;

    protected String address;

    @JsonProperty("address_2")
    protected String address2;

    protected String city;

    protected String region;

    protected String country;

    protected String postal;

    @JsonProperty("phone_number")
    protected String phoneNumber;

    @JsonProperty("phone_country_code")
    protected String phoneCountryCode;

    public AbstractLocation(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.company = builder.company;
        this.address = builder.address;
        this.address2 = builder.address2;
        this.city = builder.city;
        this.region = builder.region;
        this.country = builder.country;
        this.postal = builder.postal;
        this.phoneNumber = builder.phoneNumber;
        this.phoneCountryCode = builder.phoneCountryCode;
    }

    public static class Builder<T extends Builder>  {
        String firstName;
        String lastName;
        String company;
        String address;
        String address2;
        String city;
        String region;
        String country;
        String postal;
        String phoneNumber;
        String phoneCountryCode;

        public T firstName(String name) {
            this.firstName = name;
            return (T) this;
        }

        public T lastName(String name) {
            this.lastName = name;
            return (T) this;
        }

        public T company(String name) {
            this.company = name;
            return (T) this;
        }

        public T address(String address) {
            this.address = address;
            return (T) this;
        }

        public T address2(String address2) {
            this.address2 = address2;
            return (T) this;
        }

        public T city(String name) {
            this.city = name;
            return (T) this;
        }

        public T region(String code) {
            this.region = code;
            return (T) this;
        }

        public T country(String code) {
            this.country = code;
            return (T) this;
        }

        public T postal(String code) {
            this.postal = code;
            return (T) this;
        }

        public T phoneNumber(String number) {
            this.phoneNumber = number;
            return (T) this;
        }

        public T phoneCountryCode(String code) {
            this.phoneCountryCode = code;
            return (T) this;
        }
    }
}
