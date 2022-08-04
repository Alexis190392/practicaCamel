package org.camel.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "API",
    "Description",
    "Auth",
    "HTTPS",
    "Cors",
    "Link",
    "Category"
})
@Generated("jsonschema2pojo")
public class Entry {

    @JsonProperty("API")
    private String api;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Auth")
    private String auth;
    @JsonProperty("HTTPS")
    private Boolean https;
    @JsonProperty("Cors")
    private String cors;
    @JsonProperty("Link")
    private String link;
    @JsonProperty("Category")
    private String category;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("API")
    public String getApi() {
        return api;
    }

    @JsonProperty("API")
    public void setApi(String api) {
        this.api = api;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("Auth")
    public String getAuth() {
        return auth;
    }

    @JsonProperty("Auth")
    public void setAuth(String auth) {
        this.auth = auth;
    }

    @JsonProperty("HTTPS")
    public Boolean getHttps() {
        return https;
    }

    @JsonProperty("HTTPS")
    public void setHttps(Boolean https) {
        this.https = https;
    }

    @JsonProperty("Cors")
    public String getCors() {
        return cors;
    }

    @JsonProperty("Cors")
    public void setCors(String cors) {
        this.cors = cors;
    }

    @JsonProperty("Link")
    public String getLink() {
        return link;
    }

    @JsonProperty("Link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("Category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("Category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
