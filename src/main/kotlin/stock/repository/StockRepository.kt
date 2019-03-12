package stock.repository

import org.springframework.data.jpa.repository.JpaRepository
import stock.model.Stock

interface StockRepository: JpaRepository<Stock, Int>