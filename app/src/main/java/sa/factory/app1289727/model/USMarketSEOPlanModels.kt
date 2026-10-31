package sa.factory.app1289727.model

import kotlinx.serialization.Serializable

@Serializable
data class KeywordStrategyTier(
    val id: String,
    val title: String,
    val description: String,
    val priceMinorUnits: Long,
    val iconVector: String = "verified"
)

@Serializable
data class USMarketSEOPlan(
    val requestId: String,
    val items: List<KeywordStrategyTier>,
    val customerPhone: String,
    val totalAmountMinorUnits: Long,
    val status: USMarketSEOPlanStatus = USMarketSEOPlanStatus.PENDING,
    val createdAtEpochMs: Long = System.currentTimeMillis()
)

enum class USMarketSEOPlanStatus {
    PENDING,
    ACCEPTED,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED
}
