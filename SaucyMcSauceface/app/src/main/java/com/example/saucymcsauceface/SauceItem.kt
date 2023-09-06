package com.example.saucymcsauceface

import java.util.UUID

class SauceItem (
    var id: UUID = UUID.randomUUID(),
    var name: String,
    var code: Int,
    var source: String,
    var group: String?,
    var authors: List<String>,
    var tags: List<String>,
    var complete: Boolean)
    {

}