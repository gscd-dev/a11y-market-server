package com.multicampus.gamesungcoding.a11ymarketserver.feature.user.dto

import jakarta.validation.constraints.*

data class UserA11yProfileReq(
    @field:NotBlank(message = "프로필 이름은 필수 입력 값입니다.")
    @field:Size(max = 50)
    val profileName: String,

    @field:Size(max = 200)
    val description: String,

    @field:Min(0)
    @field:Max(3)
    val contrastLevel: Int,

    @field:Min(0)
    @field:Max(2)
    val textSizeLevel: Int,

    @field:Min(0)
    @field:Max(2)
    val textSpacingLevel: Int,

    @field:Min(0)
    @field:Max(2)
    val lineHeightLevel: Int,

    @field:Pattern(
        regexp = "^(left|center|right)$",
        message = "텍스트 정렬은 left, center, right 중 하나여야 합니다."
    )
    val textAlign: String,

    val screenReader: Boolean,

    val smartContrast: Boolean,

    val highlightLinks: Boolean,

    val cursorHighlight: Boolean
)
