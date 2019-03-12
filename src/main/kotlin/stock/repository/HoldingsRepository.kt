package stock.repository

import org.springframework.data.jpa.repository.JpaRepository
import stock.model.StockHolding

interface HoldingsRepository: JpaRepository<StockHolding, Int>