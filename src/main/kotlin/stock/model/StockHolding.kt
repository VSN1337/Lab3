package stock.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class StockHolding(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int = 0,

        val clientId: Int,
        val stockId: Int,
        val percent: Int,
        val purchaseDate: Date
)