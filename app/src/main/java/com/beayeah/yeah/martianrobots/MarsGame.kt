package com.beayeah.yeah.martianrobots

object MarsGame {

    private var piecesBox = mutableSetOf<AlienShip>()

    init {
        reset()
    }

    fun clear() {
        piecesBox.clear()
    }

    fun addPiece(piece: AlienShip) {
        piecesBox.add(piece)
    }

    fun canMove(from: Square, to: Square): Boolean {
        return !(from.y == to.y && from.x == to.x)
    }

    fun movePiece(from: Square, to: Square) {
        if (canMove(from, to)) {
            movePiece(from.y, from.x, to.y, to.x)
        }
    }

    private fun movePiece(fromCol: Int, fromRow: Int, toCol: Int, toRow: Int) {
        if (fromCol == toCol && fromRow == toRow) return
        val movingPiece = pieceAt(fromCol, fromRow) ?: return

        pieceAt(toCol, toRow)?.let {
            piecesBox.remove(it)
        }

        piecesBox.remove(movingPiece)
        addPiece(AlienShip(1, toRow, toCol, R.drawable.alien_ship))
    }

    fun reset() {
        clear()

        addPiece(AlienShip(1, 0, 0, R.drawable.alien_ship))
    }

    fun pieceAt(square: Square): AlienShip? {
        return pieceAt(square.y, square.x)
    }

    private fun pieceAt(y: Int, row: Int): AlienShip? {
        for (piece in piecesBox) {
            if (y == piece.y && row == piece.x) {
                return piece
            }
        }
        return null
    }


}