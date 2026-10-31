package sa.factory.app1289727.data

import sa.factory.app1289727.model.USMarketSEOPlan
import sa.factory.app1289727.model.KeywordStrategyTier
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

interface USMarketSEOPlanRepository {
    fun getAvailableCatalog(): Flow<List<KeywordStrategyTier>>
    fun getActiveRequest(): Flow<USMarketSEOPlan?>
    suspend fun submitRequest(request: USMarketSEOPlan): Result<String>
}

class InMemoryUSMarketSEOPlanRepository : USMarketSEOPlanRepository {
    private val _catalog = MutableStateFlow<List<KeywordStrategyTier>>(listOf(
        KeywordStrategyTier("1", "خطة الاختراق الرقمي (Launch)", "فحص فني شامل للمتجر، تحسين سرعة التحميل، وبناء الروابط الخلفية الأولية لاستهداف كلمات مفتاحية طويلة الذيل", 5000L, "verified"),
        KeywordStrategyTier("2", "خطة الهيمنة (Dominate)", "استراتيجية محتوى مكثفة، تحسين صفحات المنتجات في WooCommerce، وحملات بناء سلطوية للمنافسة على الكلمات الرئيسية التنافسية", 9500L, "bolt")
    ))
    private val _active = MutableStateFlow<USMarketSEOPlan?>(null)

    override fun getAvailableCatalog(): Flow<List<KeywordStrategyTier>> = _catalog.asStateFlow()
    override fun getActiveRequest(): Flow<USMarketSEOPlan?> = _active.asStateFlow()

    override suspend fun submitRequest(request: USMarketSEOPlan): Result<String> {
        _active.value = request
        return Result.success(request.requestId)
    }
}
