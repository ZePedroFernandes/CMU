package com.example.cmu_room.classes

data class API_GasStationDetails(
    val resultado: Resultado
) {
    data class Resultado(
        val Id: Int,
        val Nome: String,
        val Morada: DetalhesMorada,
        val Combustiveis: List<CombustivelInfo>
    ) {
        data class DetalhesMorada(
            val Distrito: String,
            val Municipio: String,
            val Morada: String,
            val Localidade: String,
            val CodPostal: String,
            val Latitude: Double,
            val Longitude: Double
        ) {
            override fun toString(): String {
                return Distrito + ", " + Municipio + ", " + Morada + ", " + Localidade + ", " + CodPostal
            }
        }

        data class CombustivelInfo(
            val TipoCombustivel: String,
            val Preco: String,
            val DataAtualizacao: String
        )
    }
}