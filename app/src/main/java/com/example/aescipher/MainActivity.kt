package com.example.aescipher

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.aescipher.AES.AES

class MainActivity : AppCompatActivity() {

    val secretKey = "ssshhhhhhhhhhh!!!!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edittext = findViewById<EditText>(R.id.inputtedUnencryptedText)
        val encrypt = findViewById<Button>(R.id.encryptButton)
        val editEncrypt = findViewById<EditText>(R.id.encryptedText)
        val decrypt = findViewById<Button>(R.id.decryptButton)
        val editDecrypt = findViewById<EditText>(R.id.decryptedText)
        val clearButton = findViewById<Button>(R.id.clearButton)

        encrypt.setOnClickListener{
            val message =  edittext.text.toString()
            val encryptText: String? = AES().encrypt(message, secretKey)
            editEncrypt.setText(encryptText)
        }
        decrypt.setOnClickListener{
            val message = editEncrypt.text.toString()
            val decryptText:String? = AES().decrypt(message,secretKey)
            editDecrypt.setText(decryptText)
        }

        clearButton.setOnClickListener{
            edittext.setText("")
            editEncrypt.setText("")
            editDecrypt.setText("")
        }
    }
}