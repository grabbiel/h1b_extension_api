package h1b_extension.h1b_extension_api.bean;

public class MatchReview {
    private String name;
    private String literal;
    private int platform;
    private int country;

    public MatchReview() {
        // default constructor needed for JSON serialization
    }

    public MatchReview(String name, String literal, int platform, int country) {
        setName(name);
        setLiteral(literal);
        setPlatform(platform);
        setCountry(country);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return this.literal;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public int getPlatform() {
        return this.platform;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public int getCountry() {
        return this.country;
    }
}
