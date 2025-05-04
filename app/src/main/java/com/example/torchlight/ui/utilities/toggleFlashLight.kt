package com.example.torchlight.ui.utilities

import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.M)
fun toggleFlashlight(context: Context, enabled: Boolean) {
    val cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
    val cameraId = cameraManager.cameraIdList[0] // Assumes the back camera is at index 0

    try {
        cameraManager.setTorchMode(cameraId, enabled)
        Toast.makeText(
            context,
            if (enabled) "Flashlight is turned ON" else "Flashlight is turned OFF",
            Toast.LENGTH_SHORT
        ).show()
    } catch (e: CameraAccessException) {
        e.printStackTrace()
    }
}
