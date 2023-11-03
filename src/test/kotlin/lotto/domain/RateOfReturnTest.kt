package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.doubles.shouldBeGreaterThanOrEqual

class RateOfReturnTest : FunSpec({

    test("수익률을 계산한다.") {
        val inputPrice = 14000
        val lottos = LottoStore.buyLottos(inputPrice)
        val winningNumber = LottoStore.takeShuffleNumber(7)
        val winningLottoNumber = Lotto(winningNumber.subList(0, 6))
        val bonusBall = winningNumber.last()
        val winningLotto = WinningLotto(winningLottoNumber, bonusBall)
        val winningResult = lottos.matchLotto(winningLotto)
        val rateOfReturn = RateOfReturn(inputPrice, winningResult).calculate()
        rateOfReturn shouldBeGreaterThanOrEqual 0.0
    }
})
