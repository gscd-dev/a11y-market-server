package com.multicampus.gamesungcoding.a11ymarketserver.common.config

import com.multicampus.gamesungcoding.a11ymarketserver.common.properties.S3StorageProperties
import org.springframework.context.annotation.Configuration

@Configuration
class S3Config(
    private val s3Properties: S3StorageProperties
)