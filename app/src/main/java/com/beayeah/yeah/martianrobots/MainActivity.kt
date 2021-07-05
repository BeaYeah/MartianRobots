package com.beayeah.yeah.martianrobots

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.io.PrintWriter
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity(), MarsDelegate {

    private lateinit var martianField: MartianField
    private var printWriter: PrintWriter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        martianField = findViewById<MartianField>(R.id.martian_field)
        martianField.marsDelegate = this

    }

    override fun pieceAt(square: Square): AlienShip? = MarsGame.pieceAt(square)

    override fun movePiece(from: Square, to: Square) {
        MarsGame.movePiece(from, to)
        martianField.invalidate()

        printWriter?.let {
            val moveStr = "${from.y},${from.x},${to.y},${to.x}"
            Executors.newSingleThreadExecutor().execute {
                it.println(moveStr)
            }
        }
    }
}
