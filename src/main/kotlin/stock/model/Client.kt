package stock.model

import java.util.*
import javax.persistence.*

@Entity
data class Client(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int = 0,

        val fullName: String,
        val address: String,
        val city: String,
        val phoneNumber: String,
        val birthDate: Date,
        val riskLevel: Int,
        val photoUrl: String
)