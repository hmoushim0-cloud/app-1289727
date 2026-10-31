package sa.factory.app1289727.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import sa.factory.app1289727.data.USMarketSEOPlanRepository
import sa.factory.app1289727.model.USMarketSEOPlan
import sa.factory.app1289727.model.KeywordStrategyTier
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class USMarketSEOPlanViewModel(
    private val repository: USMarketSEOPlanRepository
) : ViewModel() {
    val catalog: StateFlow<List<KeywordStrategyTier>> = repository.getAvailableCatalog()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val activeRequest: StateFlow<USMarketSEOPlan?> = repository.getActiveRequest()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    fun submitNewOrder(request: USMarketSEOPlan) {
        viewModelScope.launch {
            repository.submitRequest(request)
        }
    }
}
