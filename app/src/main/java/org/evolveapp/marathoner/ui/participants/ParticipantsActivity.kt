package org.evolveapp.marathoner.ui.participants

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.evolveapp.marathoner.R
import org.evolveapp.marathoner.databinding.ActivityParticipantsBinding
import org.evolveapp.marathoner.ui.invite.InviteActivity
import org.evolveapp.marathoner.utils.goTo

class ParticipantsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityParticipantsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_participants)

        binding.add.setOnClickListener { goTo(InviteActivity::class.java) }
    }
}