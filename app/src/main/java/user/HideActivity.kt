package user

import `interface`.StoreState
import actions.Actions
import models.Store

class HideStore(private val stores: List<Store>):
    StoreState {
    override fun consumeAction(action: Actions): StoreState {
        return when (action) {
            is Actions.StoreTypeSelected -> NameStore(stores, action.type)
            is Actions.PredefinedStoreSelected -> StoreList(stores + action.store)
            else -> throw IllegalStateException("Invalid action $action passed to state $this")
        }
    }
}