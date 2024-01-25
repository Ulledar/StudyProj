package apiTests.videoGameTests.config;

public class TestDataProvider {

    public static final String MARIO_GAME_BODY_BY_JSON = "{\n" +
            "  \"category\": \"Platform\",\n" +
            "  \"name\": \"Mario\",\n" +
            "  \"rating\": \"Mature\",\n" +
            "  \"releaseDate\": \"2012-05-04\",\n" +
            "  \"reviewScore\": 85\n" +
            "}";

    public static final String MARIO_GAME_BODY_BY_XML = "<VideoGameRequest>\n" +
            "\t<category>Platform</category>\n" +
            "\t<name>Mario</name>\n" +
            "\t<rating>Mature</rating>\n" +
            "\t<releaseDate>2012-05-04</releaseDate>\n" +
            "\t<reviewScore>85</reviewScore>\n" +
            "</VideoGameRequest>";
}
