package com.example.mentorship.features.playeractivity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mentorship.R
import com.example.mentorship.databinding.ActivityPlayerBinding
import com.example.mentorship.viewBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player.REPEAT_MODE_ONE
//TODO: Remember to format your code periodically
//      Delete unnecessary empty line 37
class PlayerActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityPlayerBinding::inflate)
    private var player: ExoPlayer? = null
    private var doublePressedToExit : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        player = ExoPlayer.Builder(this).build()
        binding.playerView.player = player
        player?.repeatMode = REPEAT_MODE_ONE

        val mediaItem = MediaItem.fromUri("https://thumbs.gfycat.com/NippyAchingAstarte-mobile.mp4")
        player?.setMediaItem(mediaItem)
        player?.prepare()
        player?.play()

        binding.backFAB.setOnClickListener{
            returnToPreviousActivity()
        }

    }

    override fun onPause() {
        if (player?.isPlaying == true) {
            player?.stop()
        }
        super.onPause()
    }

    override fun onResume() {
        player?.prepare()
        player?.play()
        super.onResume()
    }

    private fun returnToPreviousActivity(){
        finish()
    }
    //TODO: Overriding this wasn't a requirement for this exercise.
    //      You should call onBackPressed instead of finish in returnToPreviousActivity
    //      finish will kill this activity instance regardless of how you declared it in the manifest and might mess with what you expect to happen
    override fun onBackPressed(){
        if(doublePressedToExit){
            super.onBackPressed()
            return
        }
        doublePressedToExit = true
        Toast.makeText(this, R.string.player_back_navigation_toast_description,Toast.LENGTH_LONG).show()
        //TODO: Although this method needs to be removed, keep in mind for the future that magic numbers like this 2000 should be extracted
        //      This is because you want whoever reads the code in the future to know what it represents at a glance
        //      Here you'd extract it in companion object something like BACK_PRESSED_COUNTER_RESET_TIMER_MS
        Handler(Looper.getMainLooper()).postDelayed({doublePressedToExit = false},2000)
    }
}