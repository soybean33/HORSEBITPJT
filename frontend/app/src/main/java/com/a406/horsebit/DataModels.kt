package com.a406.horsebit

import java.util.Date

// 미체결 내역 조회
data class NotConcludedResponseBodyOrderModel(
    val orderNo: Int,  //주문번호
    val userNo: Int,  //유저번호
    val tokenNo: Int,  //토큰번호
    val tokenCode: String, //토큰코드명
    val price: Int,  //가격
    val quantity: Double,  //주문수량
    val remainQuantity: Double,  //잔여수량
    val orderTime: Date,  //주문일자
    val sellOrBuy: String, //매수 매도 여부
)

// 체결 내역 조회
data class concludedResponseBodyOrderModel(
    val executionNo: Int, //거래번호
    val tokenNo: Int,  //토큰번호
    val tokenCode: String, //토큰코드명
    val price: Int,  //가격
    val quantity: Double,  //주문수량
    val timestamp: Date,  //체결시간
    val sellOrBuy: String //매수 매도 여부
)

// 체결 혹은 미체결
data class TransactionShow(
    val completeOrNot: Boolean, // 체결 or 미체결
    val sellORBuy: String,    // 매수 or 매도
    val time: Date,  // 주문시간 or 채결시간
    val tokenCode: String, //토큰 코드
    val price: Int,  //가격
    val quantity: Double,  //수량
    val remainQuantityOrPrice: Double,  //미체결량
)

data class AssetItem(
    val graph: Int,
    val assetName: String,
    val assetTicker: String,
    val new: Boolean,
    val currentPrice: Double,
    val yesterdayPrice: Double,
    val transactionPrice: Double,
)

data class Order(
    val price: Long,
    val volume: Long,
    val trend: Double,
)

// ExchangeData.kt

data class ExchangeData(
    val orderTime: String,
    val coinName: String,
    val type: String,
    val seep: String,
    val one: String,
    val money: String,
    val fee: String,
    val realMoney: String,
    val orderTime2: String
)

data class Exchange(
    val data1: Int,
    val data2: Int,
    val data3: Int,
)



data class CandleShow(
    val createdAt: Long,
    val open: Float,
    val close: Float,
    val shadowHigh: Float,
    val shadowLow: Float
)

data class MyAsset(
    val horseImage: Int,
    val coinTicker: String,
    val coinName: String,
    val value: String,
    val rate: String
)