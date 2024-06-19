package com.ghimiremilan.riderbeacon.ui.bluetoothChatPage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.ghimiremilan.riderbeacon.ui.theme.RiderBeaconTheme

class BluetoothChatPageActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RiderBeaconTheme {
                Scaffold {
                    Column (modifier = Modifier.padding(it)) {
                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "Turn on Bluetooth")
                        }
                        // ToDo Turn on BLE
                        // ToDO Scan BLE
                        // ToDo LIST out BLE
                        // ToDo Show connect Bottomsheet / alert and connect
                    }
                }
            }
        }
    }
}