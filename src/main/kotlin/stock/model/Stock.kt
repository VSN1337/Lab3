package stock.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Stock(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int = 0,

        val companyName: String,
        val currentPrice: Double,
        val isGrowing: Boolean,
        val rating: Int,
        val riskLevel: Int,
        val photoUrl: String
)