package stock.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import stock.repository.*

import java.util.Date


@Controller
@RequestMapping("/market/holdings")
class HoldingController(
        val stockRepo: StockRepository,
        val clientRepo: ClientsRepository,
        val holdingRepo: HoldingsRepository
) {

    @GetMapping("/all")
    fun holdingsPage(model: MutableMap<String, Any>): String {
        val holdings = mutableListOf<HoldingView>()

        holdingRepo.findAll().forEach {
            holdings.add(HoldingView(
                    it.id,
                    clientRepo.findById(it.clientId).get().fullName,
                    stockRepo.findById(it.stockId).get().companyName,
                    it.percent,
                    it.purchaseDate
            ))
        }

        model["holdings"] = holdings
        return "holdings"
    }

    @DeleteMapping
    fun deleteHoldingByID(
            @RequestBody body: String,
            model: MutableMap<String, Any>
    ): String {
        val id: Int = body.toInt()
        holdingRepo.deleteById(id)

        return holdingsPage(model)
    }

    data class HoldingView(
            val id: Int,
            val clientName: String,
            val companyName: String,
            val percent: Int,
            val purchaseDate: Date
    )
}