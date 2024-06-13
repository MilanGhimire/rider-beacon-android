package com.ghimiremilan.riderbeacon.bluetooth

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.activity.result.ActivityResultLauncher
import androidx.core.app.ActivityCompat
import com.ghimiremilan.riderbeacon.system.exceptions.BluetoothPermissionNotGivenException

class BluetoothService {

    // Check to see if the Bluetooth classic feature is available.
    private fun hasBluetoothFeature(context: Context): Boolean {
        return context.packageManager.hasSystemFeature(PackageManager.FEATURE_BLUETOOTH)
    }

    private fun getBluetoothAdapter(context: Context): BluetoothAdapter {
        val bluetoothManager: BluetoothManager = context.getSystemService(BluetoothManager::class.java)
        return bluetoothManager.adapter
            ?: throw UnsupportedOperationException("Bluetooth is not supported by this Device.")
    }

    private fun enableBluetooth(bluetoothAdapter: BluetoothAdapter, bluetoothActivityResultLauncher: ActivityResultLauncher<Intent>) {
        if (!bluetoothAdapter.isEnabled) {
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            bluetoothActivityResultLauncher.launch(enableBtIntent)
        }
    }

    private fun getPairedDevices(context: Context, bluetoothAdapter: BluetoothAdapter): Set<BluetoothDevice>? {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.BLUETOOTH_CONNECT
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            throw BluetoothPermissionNotGivenException("getPairedDevices")
        }
        return bluetoothAdapter.bondedDevices
    }

    private fun printPairedDevices(context: Context, bluetoothAdapter: BluetoothAdapter) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.BLUETOOTH_CONNECT
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            throw BluetoothPermissionNotGivenException("getPairedDevices")
        }
        val pairedDevices = getPairedDevices(context, bluetoothAdapter)
        if (pairedDevices == null) {
            println("Paired Devices not found")
        } else {
            println("Paired Devices are:")
        }
        pairedDevices?.forEach { device ->
            val deviceName = device.name
            val deviceHardwareAddress = device.address // MAC address
            println("Device Name: $deviceName Address: $deviceHardwareAddress")
        }
    }
}