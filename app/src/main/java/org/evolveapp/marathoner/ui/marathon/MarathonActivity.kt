package org.evolveapp.marathoner.ui.marathon

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import org.evolveapp.marathoner.R
import org.evolveapp.marathoner.databinding.ActivityMarathonBinding
import org.evolveapp.marathoner.databinding.LayoutBottomSheetMarNotBinding
import org.evolveapp.marathoner.ui.participants.ParticipantsActivity
import org.evolveapp.marathoner.utils.goTo
import org.michaelbel.bottomsheet.BottomSheet

class MarathonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMarathonBinding

    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        transparentStatusBar()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_marathon)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController


        binding.btnMain.setOnClickListener {
            navController.navigate(R.id.marathonDetailsFragment)
        }

        binding.more.setOnClickListener { showBottomSheet() }

        binding.details.layoutParticipants.setOnClickListener { goTo(ParticipantsActivity::class.java) }

    }

    private fun showBottomSheet() {

        val sheetBinding = DataBindingUtil.inflate<LayoutBottomSheetMarNotBinding>(
            layoutInflater,
            R.layout.layout_bottom_sheet_mar_not,
            null,
            false
        )

        val builder = BottomSheet.Builder(this).apply {
            view = sheetBinding.root
            setBackgroundColor(Color.TRANSPARENT)
        }


        val sheet = builder.create()

        sheet.show()


        sheet.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    }

    private fun transparentStatusBar() {
        window?.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }

}