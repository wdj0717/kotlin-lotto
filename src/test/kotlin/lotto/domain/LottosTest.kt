package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto.Companion.LOTTO_NUMBER_SIZE
import lotto.domain.LottoStore.takeShuffleNumber

class LottosTest : FunSpec({
    test("구매한 로또 갯수를 확인할 수 있다.") {
        val lottoList = List(3) { Lotto(takeShuffleNumber(LOTTO_NUMBER_SIZE)) }
        val lottos = Lottos(lottoList)
        lottos.getLottoCount() shouldBe lottoList.size
    }

//    test("당첨번호와 로또번호를 비교하여 당첨 결과를 확인할 수 있다.") {
//        val lottoList = List(3) { Lotto(takeShuffleNumber(LOTTO_NUMBER_SIZE)) }
//        val lottos = Lottos(lottoList)
//        val winningLotto = Lotto(takeShuffleNumber(LOTTO_NUMBER_SIZE))
//        val winningResult = lottos.matchLotto(winningLotto)
//        winningResult.forEach(
//            fun(winningRank: WinningRank) {
//                (WinningRank.FIRST.name..WinningRank.MISS.name).contains(winningRank.name) shouldBe true
//            }
//        )
//    }
})
