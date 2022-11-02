package lotto.domain;


import java.util.List;

@FunctionalInterface
public interface LottoPublisher {
    List<LottoNumber> get();
}
