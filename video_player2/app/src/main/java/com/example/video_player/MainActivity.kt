package com.example.video_player

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.video_player.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout using ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Access the VideoView from layout
        val videoView = binding.testView

        // Create MediaController and attach it to the VideoView
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        // Specify the location of the video file in 'res/raw'
        val uri: Uri = Uri.parse("android.resource://$packageName/raw/index")

        // Set MediaController and URI, then start the video
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
    }
}
