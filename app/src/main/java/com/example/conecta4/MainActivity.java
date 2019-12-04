package com.example.conecta4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int turno = 0;
    String[][] arr = new String[6][7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = "-";
            }
        }

        ImageView ivRojo = findViewById(R.id.turnoRojo);
        ImageView ivAmarillo = findViewById(R.id.turnoAmarillo);
        ivRojo.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.red_circle, null));
        ivAmarillo.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.yellow_circle, null));
        cambiarTurno();
    }

    public void clickColumna0(View view) {

        String ficha = turno % 2 == 0 ? "R" : "A";

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i][0].equals("-")) {
                arr[i][0] = ficha;
                dibujarFicha(null, i, 0);
                break;
            }
        }
    }

    public void clickColumna1(View view) {

        String ficha = turno % 2 == 0 ? "R" : "A";

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i][1].equals("-")) {
                arr[i][1] = ficha;
                dibujarFicha(null, i, 1);
                break;
            }
        }
    }

    public void clickColumna2(View view) {

        String ficha = turno % 2 == 0 ? "R" : "A";

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i][2].equals("-")) {
                arr[i][2] = ficha;
                dibujarFicha(null, i, 2);
                break;
            }
        }
    }

    public void clickColumna3(View view) {

        String ficha = turno % 2 == 0 ? "R" : "A";

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i][3].equals("-")) {
                arr[i][3] = ficha;
                dibujarFicha(null, i, 3);
                break;
            }
        }
    }

    public void clickColumna4(View view) {

        String ficha = turno % 2 == 0 ? "R" : "A";

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i][4].equals("-")) {
                arr[i][4] = ficha;
                dibujarFicha(null, i, 4);
                break;
            }
        }
    }

    public void clickColumna5(View view) {

        String ficha = turno % 2 == 0 ? "R" : "A";

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i][5].equals("-")) {
                arr[i][5] = ficha;
                dibujarFicha(null, i, 5);
                break;
            }
        }
    }

    public void clickColumna6(View view) {

        String ficha = turno % 2 == 0 ? "R" : "A";

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i][6].equals("-")) {
                arr[i][6] = ficha;
                dibujarFicha(null, i, 6);
                break;
            }
        }
    }

    public void dibujarFicha(View view, int fila, int columna) {

        String ivID = "iv" + columna + fila;
        int imageView = getResources().getIdentifier(ivID, "id", getPackageName());
        ImageView tv = findViewById(imageView);

        if (turno % 2 == 0) {
            tv.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.red_circle, null));
        } else {
            tv.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.yellow_circle, null));
        }
        turno++;

        checkWinnerHorizontal();
        checkWinnerVertical();
        checkWinnerDiagonalAscendente();
        checkWinnerDiagonalDescendente();
        checkTableroLleno();
        cambiarTurno();
    }

    public void checkTableroLleno() {
        if (turno >= 42) {
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
    }

    public void cambiarTurno() {
        ImageView ivRojo = findViewById(R.id.turnoRojo);
        ImageView ivAmarillo = findViewById(R.id.turnoAmarillo);
        if (turno % 2 == 0) {
            ivRojo.setVisibility(View.VISIBLE);
            ivAmarillo.setVisibility(View.INVISIBLE);
        } else {
            ivAmarillo.setVisibility(View.VISIBLE);
            ivRojo.setVisibility(View.INVISIBLE);
        }
    }

    public void checkWinnerHorizontal() {

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < arr[i].length - 3; j++) {
                if (arr[i][j].equals(arr[i][j + 1]) && arr[i][j].equals(arr[i][j + 2]) && arr[i][j].equals(arr[i][j + 3]) && !arr[i][j].equals("-")) {
                    winnerTrue(arr[i][j]);
                    break;
                }
            }
        }
    }

    public void checkWinnerVertical() {
        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].equals(arr[i + 1][j]) && arr[i][j].equals(arr[i + 2][j]) && arr[i][j].equals(arr[i + 3][j]) && !arr[i][j].equals("-")) {
                    winnerTrue(arr[i][j]);
                    break;
                }
            }
        }
    }

    public void checkWinnerDiagonalDescendente() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 3; j++) {
                if (arr[i][j].equals(arr[i + 1][j + 1]) && arr[i][j].equals(arr[i + 2][j + 2]) && arr[i][j].equals(arr[i + 3][j + 3]) && !arr[i][j].equals("-")) {
                    winnerTrue(arr[i][j]);
                    break;
                }
            }
        }
    }

    public void checkWinnerDiagonalAscendente() {
        for (int i = arr.length - 1; i >= 3; i--) {
            for (int j = 0; j <= 3; j++) {
                if (arr[i][j].equals(arr[i - 1][j + 1]) && arr[i][j].equals(arr[i - 2][j + 2]) && arr[i][j].equals(arr[i - 3][j + 3]) && !arr[i][j].equals("-")) {
                    winnerTrue(arr[i][j]);
                    break;
                }
            }
        }
    }

    public void winnerTrue(String ganador) {
        Intent intent = new Intent(this, WinnerActivity.class);
        intent.putExtra("ganador", ganador);
        startActivity(intent);
    }

}
