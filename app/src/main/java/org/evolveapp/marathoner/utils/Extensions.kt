package org.evolveapp.marathoner.utils

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.facebook.shimmer.ShimmerFrameLayout
import kotlinx.coroutines.delay


fun Fragment.simulateLoadingData(
    shimmerLayout: ShimmerFrameLayout?,
    content: View?,
    loadingDuration: Long = 3_000,
    onComplete: () -> Unit = {},
) {

    viewLifecycleOwner.lifecycleScope.launchWhenCreated {

        content?.gone()
        shimmerLayout?.apply {
            show()
            showShimmer(true)
        }

        delay(loadingDuration)

        shimmerLayout?.apply {
            showShimmer(false)
            gone()
        }

        content?.show()
        onComplete()

    }
}