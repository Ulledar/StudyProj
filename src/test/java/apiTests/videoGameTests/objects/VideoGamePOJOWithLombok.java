package apiTests.videoGameTests.objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VideoGamePOJOWithLombok {
    public String category;
    public String name;
    public String rating;
    public String releaseDate;
    public int reviewScore;
}
