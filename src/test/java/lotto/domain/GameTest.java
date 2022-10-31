package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    @DisplayName("모든 게임에 당첨")
    void game_win() {
        Game game = new Game(10, () -> List.of(1, 11, 14, 15, 18, 20));
        LottoResult result = game.play(new Lotto(List.of(1, 11, 14, 15, 18, 20)), 21);

        assertThat(result.getOrZero(Prize.SIX)).isEqualTo(10);
    }

    @Test
    @DisplayName("당첨 결과 확인")
    void game() {
        Game game = new Game(7, new TestLottoPublisher(List.of(
                List.of(1, 11, 14, 15, 18, 20),
                List.of(1, 11, 14, 16, 18, 20),
                List.of(3, 4, 5, 6, 7, 8),
                List.of(3, 4, 5, 6, 7, 18),
                List.of(1, 14, 15, 16, 30, 45),
                List.of(3, 14, 18, 20, 21, 22),
                List.of(3, 7, 14, 19, 20, 33)
        )));
        LottoResult result = game.play(new Lotto(List.of(1, 11, 14, 15, 18, 20)), 21);

        assertThat(result.getOrZero(Prize.NONE)).isEqualTo(3);
        assertThat(result.getOrZero(Prize.THREE)).isEqualTo(2);
        assertThat(result.getOrZero(Prize.FIVE)).isEqualTo(1);
        assertThat(result.getOrZero(Prize.SIX)).isEqualTo(1);
    }
}
