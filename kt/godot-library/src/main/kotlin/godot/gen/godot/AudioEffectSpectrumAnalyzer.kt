// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE")

package godot

import godot.`annotation`.GodotBaseType
import godot.core.TransferContext
import godot.core.VariantType.DOUBLE
import godot.core.VariantType.LONG
import godot.core.VariantType.NIL
import kotlin.Double
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit

/**
 * Audio effect that can be used for real-time audio visualizations.
 *
 * Tutorials:
 * [https://godotengine.org/article/godot-32-will-get-new-audio-features](https://godotengine.org/article/godot-32-will-get-new-audio-features)
 *
 * This audio effect does not affect sound output, but can be used for real-time audio visualizations.
 *
 * See also [godot.AudioStreamGenerator] for procedurally generating sounds.
 */
@GodotBaseType
public open class AudioEffectSpectrumAnalyzer : AudioEffect() {
  /**
   * The length of the buffer to keep (in seconds). Higher values keep data around for longer, but require more memory.
   */
  public open var bufferLength: Double
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_AUDIOEFFECTSPECTRUMANALYZER_GET_BUFFER_LENGTH, DOUBLE)
      return TransferContext.readReturnValue(DOUBLE, false) as Double
    }
    set(`value`) {
      TransferContext.writeArguments(DOUBLE to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_AUDIOEFFECTSPECTRUMANALYZER_SET_BUFFER_LENGTH, NIL)
    }

  /**
   * The size of the [godot.Fast Fourier transform](https://en.wikipedia.org/wiki/Fast_Fourier_transform) buffer. Higher values smooth out the spectrum analysis over time, but have greater latency. The effects of this higher latency are especially noticeable with sudden amplitude changes.
   */
  public open var fftSize: Long
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_AUDIOEFFECTSPECTRUMANALYZER_GET_FFT_SIZE, LONG)
      return TransferContext.readReturnValue(LONG, false) as Long
    }
    set(`value`) {
      TransferContext.writeArguments(LONG to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_AUDIOEFFECTSPECTRUMANALYZER_SET_FFT_SIZE, NIL)
    }

  /**
   *
   */
  public open var tapBackPos: Double
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_AUDIOEFFECTSPECTRUMANALYZER_GET_TAP_BACK_POS, DOUBLE)
      return TransferContext.readReturnValue(DOUBLE, false) as Double
    }
    set(`value`) {
      TransferContext.writeArguments(DOUBLE to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_AUDIOEFFECTSPECTRUMANALYZER_SET_TAP_BACK_POS, NIL)
    }

  public override fun __new(): Unit {
    callConstructor(ENGINECLASS_AUDIOEFFECTSPECTRUMANALYZER)
  }

  public enum class FFT_Size(
    id: Long
  ) {
    /**
     * Use a buffer of 256 samples for the Fast Fourier transform. Lowest latency, but least stable over time.
     */
    FFT_SIZE_256(0),
    /**
     * Use a buffer of 512 samples for the Fast Fourier transform. Low latency, but less stable over time.
     */
    FFT_SIZE_512(1),
    /**
     * Use a buffer of 1024 samples for the Fast Fourier transform. This is a compromise between latency and stability over time.
     */
    FFT_SIZE_1024(2),
    /**
     * Use a buffer of 2048 samples for the Fast Fourier transform. High latency, but stable over time.
     */
    FFT_SIZE_2048(3),
    /**
     * Use a buffer of 4096 samples for the Fast Fourier transform. Highest latency, but most stable over time.
     */
    FFT_SIZE_4096(4),
    /**
     * Represents the size of the [enum FFT_Size] enum.
     */
    FFT_SIZE_MAX(5),
    ;

    public val id: Long
    init {
      this.id = id
    }

    public companion object {
      public fun from(`value`: Long) = values().single { it.id == `value` }
    }
  }

  public companion object {
    /**
     * Use a buffer of 1024 samples for the Fast Fourier transform. This is a compromise between latency and stability over time.
     */
    public final const val FFT_SIZE_1024: Long = 2

    /**
     * Use a buffer of 2048 samples for the Fast Fourier transform. High latency, but stable over time.
     */
    public final const val FFT_SIZE_2048: Long = 3

    /**
     * Use a buffer of 256 samples for the Fast Fourier transform. Lowest latency, but least stable over time.
     */
    public final const val FFT_SIZE_256: Long = 0

    /**
     * Use a buffer of 4096 samples for the Fast Fourier transform. Highest latency, but most stable over time.
     */
    public final const val FFT_SIZE_4096: Long = 4

    /**
     * Use a buffer of 512 samples for the Fast Fourier transform. Low latency, but less stable over time.
     */
    public final const val FFT_SIZE_512: Long = 1

    /**
     * Represents the size of the [enum FFT_Size] enum.
     */
    public final const val FFT_SIZE_MAX: Long = 5
  }
}
