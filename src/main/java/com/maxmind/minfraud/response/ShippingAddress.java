package com.maxmind.minfraud.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class contains minFraud response data related to the shipping address.
 */
public final class ShippingAddress extends AbstractAddress {
    private final Boolean isHighRisk;
    private final Integer distanceToBillingAddress;

    /**
     * Constructor for {@code ShippingAddress}.
     *
     * @param distanceToBillingAddress The distance in kilometers from the shipping address to the
     * billing address.
     * @param distanceToIpLocation The distance in kilometers from the shipping address to the IP
     * location.
     * @param isHighRisk This is true if the shipping address is associated with fraudulent
     * transactions.
     * @param isInIpCountry This is true if the shipping address is in the IP country.
     * @param isPostalInCity This is true if the shipping postal code is in the city for the
     * IP location.
     * @param latitude The latitude associated with the IP address.
     * @param longitude The longitude associated with the IP address.
     */
    public ShippingAddress(
        @JsonProperty("distance_to_billing_address") Integer distanceToBillingAddress,
        @JsonProperty("distance_to_ip_location") Integer distanceToIpLocation,
        @JsonProperty("is_high_risk") Boolean isHighRisk,
        @JsonProperty("is_in_ip_country") Boolean isInIpCountry,
        @JsonProperty("is_postal_in_city") Boolean isPostalInCity,
        @JsonProperty("latitude") Double latitude,
        @JsonProperty("longitude") Double longitude
    ) {
        super(distanceToIpLocation, isInIpCountry, isPostalInCity, latitude, longitude);
        this.distanceToBillingAddress = distanceToBillingAddress;
        this.isHighRisk = isHighRisk;
    }

    /**
     * Constructor for {@code ShippingAddress}.
     */
    public ShippingAddress() {
        this(null, null, null, null, null, null, null);
    }

    /**
     * @return This returns true if the shipping address is an address
     * associated with fraudulent transactions. It returns false when the
     * address is not associated with increased risk. If the address could not
     * be parsed or was not provided, null is returned.
     */
    @JsonProperty("is_high_risk")
    public Boolean isHighRisk() {
        return isHighRisk;
    }

    /**
     * @return The distance in kilometers from the shipping address to billing
     * address.
     */
    @JsonProperty("distance_to_billing_address")
    public Integer getDistanceToBillingAddress() {
        return distanceToBillingAddress;
    }
}

