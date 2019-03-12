package stock.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

import stock.repository.ClientsRepository

@Controller
@RequestMapping("/market/clients")
class ClientController(val repository: ClientsRepository) {
    @GetMapping("/all")
    fun clientsPage(model: MutableMap<String, Any>): String {
        model["clients"] = repository.findAll()
        return "clients"
    }
}