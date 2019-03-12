package stock.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

import stock.model.Client
import stock.model.Stock
import stock.model.StockHolding
import stock.repository.*

import java.text.SimpleDateFormat

@Controller
@RequestMapping("/market/admin-page")
class AdminController(
        val stockRepo: StockRepository,
        val clientRepo: ClientsRepository,
        val holdingRepo: HoldingsRepository
) {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd")

    @GetMapping
    fun adminPage(model: MutableMap<String, Any>): String {
        model["clients"] = clientRepo.findAll()
        model["stocks"] = stockRepo.findAll()
        return "admin"
    }

    @PostMapping("/new-stock")
    fun addStock(@RequestBody body: String): String {

        val values = body.split('|')
        stockRepo.save(Stock(
                companyName = values[0],
                currentPrice = values[1].toDouble(),
                isGrowing = values[3].toBoolean(),
                rating = values[5].toInt(),
                riskLevel = values[4].toInt(),
                photoUrl = values[2]
        ))

        return "admin"
    }

    @PostMapping("new-client")
    fun addClient(@RequestBody body: String): String {

        val values = body.split('|')
        clientRepo.save(Client(
                fullName = values[0],
                address = values[1],
                city = values[2],
                phoneNumber = values[3],
                riskLevel = values[5].toInt(),
                photoUrl = values[6],
                birthDate = dateFormat.parse(values[4])
        ))

        return "admin"
    }

    @PostMapping("new-holding")
    fun  addHolding(@RequestBody body: String): String {

        val values = body.split('|')
        println(values)

        holdingRepo.save(StockHolding(
                clientId = values[0].toInt(),
                stockId = values[1].toInt(),
                percent = values[2].toInt(),
                purchaseDate = dateFormat.parse(values[3])
        ))
        
        return "admin"
    }
}