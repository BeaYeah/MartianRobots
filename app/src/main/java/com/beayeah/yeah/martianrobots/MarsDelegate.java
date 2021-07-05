package com.beayeah.yeah.martianrobots;

import org.jetbrains.annotations.NotNull;

public interface MarsDelegate {

    AlienShip pieceAt(@NotNull Square currentSquare);

    void movePiece(@NotNull Square fromSquare, @NotNull Square toSquare);

}