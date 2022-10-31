package lotto.domain;

public class LottoProfitCalculator {

    public float calculate(int price, LottoResult result) {
        return (float) getTotalPrize(result) / price;
    }

    private static int getTotalPrize(LottoResult lottoResult) {
        int sum = 0;
        for (Prize prize: Prize.values()) {
            sum += prize.getValue() * lottoResult.getOrZero(prize);
        }
        return sum;
    }
}
