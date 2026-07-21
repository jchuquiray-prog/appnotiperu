package com.example.audio

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Locale

data class AudioState(
    val isPlaying: Boolean = false,
    val currentArticleId: String? = null,
    val currentTitle: String = "",
    val currentText: String = "",
    val isInitialized: Boolean = false,
    val speechRate: Float = 1.0f
)

class AudioNarrator(context: Context) : TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = TextToSpeech(context.applicationContext, this)

    private val _audioState = MutableStateFlow(AudioState())
    val audioState: StateFlow<AudioState> = _audioState

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts?.setLanguage(Locale("es", "PE"))
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                tts?.setLanguage(Locale("es", "ES"))
            }

            tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                override fun onStart(utteranceId: String?) {
                    _audioState.value = _audioState.value.copy(isPlaying = true)
                }

                override fun onDone(utteranceId: String?) {
                    _audioState.value = _audioState.value.copy(isPlaying = false)
                }

                @Deprecated("Deprecated in Java")
                override fun onError(utteranceId: String?) {
                    _audioState.value = _audioState.value.copy(isPlaying = false)
                }
            })

            _audioState.value = _audioState.value.copy(isInitialized = true)
        }
    }

    fun speak(articleId: String, title: String, textToSpeak: String) {
        val current = _audioState.value
        if (current.currentArticleId == articleId && current.isPlaying) {
            pause()
            return
        }

        val fullText = "$title. $textToSpeak"
        _audioState.value = _audioState.value.copy(
            currentArticleId = articleId,
            currentTitle = title,
            currentText = fullText,
            isPlaying = true
        )

        tts?.setSpeechRate(_audioState.value.speechRate)
        tts?.speak(fullText, TextToSpeech.QUEUE_FLUSH, null, articleId)
    }

    fun pause() {
        tts?.stop()
        _audioState.value = _audioState.value.copy(isPlaying = false)
    }

    fun resume() {
        val current = _audioState.value
        if (current.currentArticleId != null && current.currentText.isNotEmpty()) {
            tts?.setSpeechRate(current.speechRate)
            tts?.speak(current.currentText, TextToSpeech.QUEUE_FLUSH, null, current.currentArticleId)
            _audioState.value = current.copy(isPlaying = true)
        }
    }

    fun setSpeed(rate: Float) {
        _audioState.value = _audioState.value.copy(speechRate = rate)
        if (_audioState.value.isPlaying) {
            resume()
        }
    }

    fun stopAndClose() {
        tts?.stop()
        _audioState.value = AudioState()
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
        tts = null
    }
}
