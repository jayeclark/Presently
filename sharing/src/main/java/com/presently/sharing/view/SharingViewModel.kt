package com.presently.sharing.view

import com.airbnb.mvrx.MavericksViewModel
import com.presently.sharing.data.SharingViewDesign
import com.presently.sharing.data.SharingViewState

class SharingViewModel(initialState: SharingViewState) :
    MavericksViewModel<SharingViewState>(initialState) {

    fun selectColorScheme(newDesign: SharingViewDesign) {
        setState {
            copy(viewDesign = newDesign)
        }
    }

    fun clickFinish() {
        setState {
            copy(clicksShare = true)
        }
    }

    fun sharingComplete() {
        setState {
            copy(clicksShare = false)
        }
    }
}