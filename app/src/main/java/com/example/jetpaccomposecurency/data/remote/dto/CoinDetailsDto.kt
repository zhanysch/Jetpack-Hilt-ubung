package com.example.jetpaccomposecurency.data.remote.dto

import com.example.jetpaccomposecurency.domain.model.CoinDetail
import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2021 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class CoinDetailsDto (

	@SerializedName("id") val id : String,
	@SerializedName("name") val name : String,
	@SerializedName("symbol") val symbol : String,
	@SerializedName("rank") val rank : Int,
	@SerializedName("is_new") val is_new : Boolean,
	@SerializedName("is_active") val is_active : Boolean,
	@SerializedName("type") val type : String,
	@SerializedName("tags") val tags : List<Tags>,
	@SerializedName("team") val team : List<TeamMember>,
	@SerializedName("description") val description : String,
	@SerializedName("message") val message : String,
	@SerializedName("open_source") val open_source : Boolean,
	@SerializedName("started_at") val started_at : String,
	@SerializedName("development_status") val development_status : String,
	@SerializedName("hardware_wallet") val hardware_wallet : Boolean,
	@SerializedName("proof_type") val proof_type : String,
	@SerializedName("org_structure") val org_structure : String,
	@SerializedName("hash_algorithm") val hash_algorithm : String,
	@SerializedName("links") val links : Links,
	@SerializedName("links_extended") val links_extended : List<Links_extended>,
	@SerializedName("whitepaper") val whitepaper : Whitepaper,
	@SerializedName("first_data_at") val first_data_at : String,
	@SerializedName("last_data_at") val last_data_at : String
)
fun CoinDetailsDto.toCoinDetail():CoinDetail{
	return CoinDetail(
		coinId = id,
		name = name,
		description = description,
		symbol = symbol,
		rank = rank,
		isActive = is_active,
		tags = tags.map { it.name },
		team = team
	)
}