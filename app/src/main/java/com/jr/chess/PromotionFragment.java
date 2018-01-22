package com.jr.chess;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PromotionFragment extends Fragment {

    Fragment self;
    GameManagement gameManagement;

    public PromotionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        self = this;
        gameManagement = (GameManagement) getActivity();

        View view = inflater.inflate(R.layout.fragment_promotion, container, false);

        Bundle activeColor = getArguments();
        int color = activeColor.getInt("color");

        Button knightButton = view.findViewById(R.id.promotion_knight_button);
        Button bishopButton = view.findViewById(R.id.promotion_bishop_button);
        Button rookButton = view.findViewById(R.id.promotion_rook_button);
        Button queenButton = view.findViewById(R.id.promotion_queen_button);

        switch (color){
            case Const.WHITE:
                knightButton.setBackgroundResource(R.drawable.white_knight);
                bishopButton.setBackgroundResource(R.drawable.white_bishop);
                rookButton.setBackgroundResource(R.drawable.white_rook);
                queenButton.setBackgroundResource(R.drawable.white_queen);

                break;
            case Const.BLACK:
                knightButton.setBackgroundResource(R.drawable.black_knight);
                bishopButton.setBackgroundResource(R.drawable.black_bishop);
                rookButton.setBackgroundResource(R.drawable.black_rook);
                queenButton.setBackgroundResource(R.drawable.black_queen);
                break;
        }

        knightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endPromotion(Const.KNIGHT);
           }
        });
        bishopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endPromotion(Const.BISHOP);
            }
        });
        rookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endPromotion(Const.ROOK);
            }
        });
        queenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endPromotion(Const.QUEEN);
            }
        });

        return view;
    }

    void endPromotion(int pieceToAdd){
        gameManagement.getGame().promotionAddPiece(pieceToAdd);
        gameManagement.closeFragment(self);
    }

}
