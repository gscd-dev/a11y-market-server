package com.multicampus.gamesungcoding.a11ymarketserver.feature.product.repository

import com.multicampus.gamesungcoding.a11ymarketserver.feature.product.entity.Categories
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoryRepository : JpaRepository<Categories, UUID> {
    fun findAllByParentCategoryIsNull(): List<Categories>
}
