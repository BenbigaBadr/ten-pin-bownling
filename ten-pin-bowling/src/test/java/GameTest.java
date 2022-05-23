import com.test.java.Frame;
import com.test.java.Game;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private List<Frame> frames = new ArrayList<>();

    @Before
    public void setUp() {

    }

    @Test
    public void test_perfect_score() {

        frames.add(Frame.initStrike());
        frames.add(Frame.initStrike());
        frames.add(Frame.initStrike());
        frames.add(Frame.initStrike());
        frames.add(Frame.initStrike());
        frames.add(Frame.initStrike());
        frames.add(Frame.initStrike());
        frames.add(Frame.initStrike());
        frames.add(Frame.initStrike());
        frames.add(Frame.initBonusStrike());

        Game game = new Game();
        game.setFrames(frames);
        int totalScore = game.getTotalScore();
        assertEquals(totalScore, 300);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_number_frames_exceed() {
        frames.add(Frame.initStrike());
        frames.add(Frame.initStrike());
        frames.add(Frame.initStrike());
        frames.add(Frame.initStrike());
        frames.add(Frame.initStrike());
        frames.add(Frame.initStrike());
        frames.add(Frame.initStrike());
        frames.add(Frame.initStrike());
        frames.add(Frame.initStrike());
        frames.add(Frame.initBonusStrike());

        Game game = new Game();
        frames.add(new Frame());
        game.setFrames(frames);
        game.getTotalScore();
    }

    @Test
    public void test_spare_case() {
        frames.add(Frame.initStrike());
        frames.add(Frame.initSpare());
        frames.add(Frame.initStrike());
        frames.add(Frame.initStrike());
        frames.add(Frame.initSpare());
        frames.add(Frame.initStrike());
        frames.add(Frame.initSpare());
        frames.add(Frame.initStrike());
        frames.add(Frame.initStrike());
        frames.add(Frame.initBonusSpare());

        Game game = new Game();
        game.setFrames(frames);
        int totalScore = game.getTotalScore();
        assertEquals(totalScore, 212);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_spare_case_ninth_frame_having_additional_shot() {
        frames.add(Frame.initStrike());
        frames.add(Frame.initSpare());
        frames.add(Frame.initStrike());
        frames.add(Frame.initStrike());
        frames.add(Frame.initSpare());
        frames.add(Frame.initStrike());
        frames.add(Frame.initSpare());
        frames.add(Frame.initStrike());
        frames.add(Frame.initStrike());

        Frame frame = Frame.initBonusSpare();
        frame.setFourthShot(8);
        frames.add(frame);

        Game game = new Game();
        game.setFrames(frames);
        game.getTotalScore();
    }

}
