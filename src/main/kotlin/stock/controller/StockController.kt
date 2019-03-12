package stock.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

import stock.repository.StockRepository

@Controller
@RequestMapping("/market/stock")
class StockController(val repository: StockRepository) {
    @GetMapping("/all")
    fun stocksPage(model: MutableMap<String, Any>): String {
        model["stocks"] = repository.findAll()
        return "stocks"
    }
}