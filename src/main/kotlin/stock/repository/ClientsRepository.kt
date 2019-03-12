package stock.repository

import org.springframework.data.jpa.repository.JpaRepository
import stock.model.Client

interface ClientsRepository: JpaRepository<Client, Int>