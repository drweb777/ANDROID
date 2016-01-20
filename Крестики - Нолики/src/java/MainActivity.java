package com.viktor.lesson_3_homwork;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * Переменные
     * @param X - значек "крестики"
     * @param O - значек "нолики"
     * @param arrPlayingField - массив игровых клеток
     * @param isMuve - позволяет узнать чей сейчас ход
     * @param keyX - ключ для хода "крестики"
     * @param keyO - ключ для хода "нолики"
     * @param haveWinner - определение есть ли победитель
     * @param tvInfo - текстовое поле игры для отображения информации и игрового процесса
     */
    private final static String X = "X";
    private final static String O = "O";
    private final static int keyX = 1;     //"X"
    private final static int keyO = 2;     //"O"
    private  boolean haveWinner = false;   //false - нету победителя, true - есть победитель
    private boolean isMuve = false;        //false - ходит "крестик", true - ходит нолик
    private int[][] arrPlayingField = new int[3][3];
    private TextView tvInfo;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Получаем ссылки на кнопки
        btn1 = (Button) this.findViewById(R.id.btn1);
        btn2 = (Button) this.findViewById(R.id.btn2);
        btn3 = (Button) this.findViewById(R.id.btn3);
        btn4 = (Button) this.findViewById(R.id.btn4);
        btn5 = (Button) this.findViewById(R.id.btn5);
        btn6 = (Button) this.findViewById(R.id.btn6);
        btn7 = (Button) this.findViewById(R.id.btn7);
        btn8 = (Button) this.findViewById(R.id.btn8);
        btn9 = (Button) this.findViewById(R.id.btn9);
        //Получаем сслыку на текстовое поле
        tvInfo = (TextView) this.findViewById(R.id.tvInfo);

        this.haveWinner = true;
        Toast.makeText(MainActivity.this, "Для начала новой игры нажмите на любую кнопку!", Toast.LENGTH_LONG).show();
    }

    /**
     * Метод определения победителя
     */
    public void checkWinner(int[][] arrPlayingField)
    {
        //Перебераем выиграшные комбинации и определяем есть ли выиграшная линия
        if(this.arrPlayingField[0][0] == MainActivity.keyX &&
           this.arrPlayingField[1][1] == MainActivity.keyX &&
           this.arrPlayingField[2][2] == MainActivity.keyX)
        {
            this.tvInfo.setText("Поздравляем! Победитель игрок игравший Крестиками");
            btn1.setTextColor(Color.RED);
            btn5.setTextColor(Color.RED);
            btn9.setTextColor(Color.RED);
            this.haveWinner =  true;
            Toast.makeText(MainActivity.this, "Для начала новой игры нажмите на любую кнопку!", Toast.LENGTH_LONG).show();
        }
        else
        if(this.arrPlayingField[2][0] == MainActivity.keyX &&
                this.arrPlayingField[1][1] == MainActivity.keyX &&
                this.arrPlayingField[0][2] == MainActivity.keyX)
        {
            this.tvInfo.setText("Поздравляем! Победитель игрок игравший Крестиками");
            btn7.setTextColor(Color.RED);
            btn5.setTextColor(Color.RED);
            btn3.setTextColor(Color.RED);
            this.haveWinner =  true;
            Toast.makeText(MainActivity.this, "Для начала новой игры нажмите на любую кнопку!", Toast.LENGTH_LONG).show();
        }
        else
        if(this.arrPlayingField[0][0] == MainActivity.keyX &&
                this.arrPlayingField[0][1] == MainActivity.keyX &&
                this.arrPlayingField[0][2] == MainActivity.keyX)
        {
            this.tvInfo.setText("Поздравляем! Победитель игрок игравший Крестиками");
            btn1.setTextColor(Color.RED);
            btn2.setTextColor(Color.RED);
            btn3.setTextColor(Color.RED);
            this.haveWinner =  true;
            Toast.makeText(MainActivity.this, "Для начала новой игры нажмите на любую кнопку!", Toast.LENGTH_LONG).show();
        }
        else
        if(this.arrPlayingField[1][0] == MainActivity.keyX &&
                this.arrPlayingField[1][1] == MainActivity.keyX &&
                this.arrPlayingField[1][2] == MainActivity.keyX)
        {
            this.tvInfo.setText("Поздравляем! Победитель игрок игравший Крестиками");
            btn4.setTextColor(Color.RED);
            btn5.setTextColor(Color.RED);
            btn6.setTextColor(Color.RED);
            this.haveWinner =  true;
            Toast.makeText(MainActivity.this, "Для начала новой игры нажмите на любую кнопку!", Toast.LENGTH_LONG).show();
        }
        else
        if(this.arrPlayingField[2][0] == MainActivity.keyX &&
                this.arrPlayingField[2][1] == MainActivity.keyX &&
                this.arrPlayingField[2][2] == MainActivity.keyX)
        {
            this.tvInfo.setText("Поздравляем! Победитель игрок игравший Крестиками");
            btn7.setTextColor(Color.RED);
            btn8.setTextColor(Color.RED);
            btn9.setTextColor(Color.RED);
            this.haveWinner =  true;
            Toast.makeText(MainActivity.this, "Для начала новой игры нажмите на любую кнопку!", Toast.LENGTH_LONG).show();
        }
        else
        if(this.arrPlayingField[0][0] == MainActivity.keyX &&
                this.arrPlayingField[1][0] == MainActivity.keyX &&
                this.arrPlayingField[2][0] == MainActivity.keyX)
        {
            this.tvInfo.setText("Поздравляем! Победитель игрок игравший Крестиками");
            btn7.setTextColor(Color.RED);
            btn1.setTextColor(Color.RED);
            btn4.setTextColor(Color.RED);
            this.haveWinner =  true;
            Toast.makeText(MainActivity.this, "Для начала новой игры нажмите на любую кнопку!", Toast.LENGTH_LONG).show();
        }
        else
        if(this.arrPlayingField[0][1] == MainActivity.keyX &&
                this.arrPlayingField[1][1] == MainActivity.keyX &&
                this.arrPlayingField[2][1] == MainActivity.keyX)
        {
            this.tvInfo.setText("Поздравляем! Победитель игрок игравший Крестиками");
            btn2.setTextColor(Color.RED);
            btn5.setTextColor(Color.RED);
            btn8.setTextColor(Color.RED);
            this.haveWinner =  true;
            Toast.makeText(MainActivity.this, "Для начала новой игры нажмите на любую кнопку!", Toast.LENGTH_LONG).show();
        }
        else
        if(this.arrPlayingField[0][2] == MainActivity.keyX &&
                this.arrPlayingField[1][2] == MainActivity.keyX &&
                this.arrPlayingField[2][2] == MainActivity.keyX)
        {
            this.tvInfo.setText("Поздравляем! Победитель игрок игравший Крестиками");
            btn6.setTextColor(Color.RED);
            btn9.setTextColor(Color.RED);
            btn3.setTextColor(Color.RED);
            this.haveWinner =  true;
            Toast.makeText(MainActivity.this, "Для начала новой игры нажмите на любую кнопку!", Toast.LENGTH_LONG).show();
        }
        //---------O---------
        if(this.arrPlayingField[0][0] == MainActivity.keyO &&
                this.arrPlayingField[1][1] == MainActivity.keyO &&
                this.arrPlayingField[2][2] == MainActivity.keyO)
        {
            this.tvInfo.setText("Поздравляем! Победитель игрок игравший Ноликами");
            btn1.setTextColor(Color.RED);
            btn5.setTextColor(Color.RED);
            btn9.setTextColor(Color.RED);
            this.haveWinner =  true;
            Toast.makeText(MainActivity.this, "Для начала новой игры нажмите на любую кнопку!", Toast.LENGTH_LONG).show();
        }
        else
        if(this.arrPlayingField[2][0] == MainActivity.keyO &&
                this.arrPlayingField[1][1] == MainActivity.keyO &&
                this.arrPlayingField[0][2] == MainActivity.keyO)
        {
            this.tvInfo.setText("Поздравляем! Победитель игрок игравший Ноликами");
            btn7.setTextColor(Color.RED);
            btn5.setTextColor(Color.RED);
            btn3.setTextColor(Color.RED);
            this.haveWinner =  true;
            Toast.makeText(MainActivity.this, "Для начала новой игры нажмите на любую кнопку!", Toast.LENGTH_LONG).show();
        }
        else
        if(this.arrPlayingField[0][0] == MainActivity.keyO &&
                this.arrPlayingField[0][1] == MainActivity.keyO &&
                this.arrPlayingField[0][2] == MainActivity.keyO)
        {
            this.tvInfo.setText("Поздравляем! Победитель игрок игравший Ноликами");
            btn1.setTextColor(Color.RED);
            btn2.setTextColor(Color.RED);
            btn3.setTextColor(Color.RED);
            this.haveWinner =  true;
            Toast.makeText(MainActivity.this, "Для начала новой игры нажмите на любую кнопку!", Toast.LENGTH_LONG).show();
        }
        else
        if(this.arrPlayingField[1][0] == MainActivity.keyO &&
                this.arrPlayingField[1][1] == MainActivity.keyO &&
                this.arrPlayingField[1][2] == MainActivity.keyO)
        {
            this.tvInfo.setText("Поздравляем! Победитель игрок игравший Ноликами");
            btn4.setTextColor(Color.RED);
            btn5.setTextColor(Color.RED);
            btn6.setTextColor(Color.RED);
            this.haveWinner =  true;
            Toast.makeText(MainActivity.this, "Для начала новой игры нажмите на любую кнопку!", Toast.LENGTH_LONG).show();
        }
        else
        if(this.arrPlayingField[2][0] == MainActivity.keyO &&
                this.arrPlayingField[2][1] == MainActivity.keyO &&
                this.arrPlayingField[2][2] == MainActivity.keyO)
        {
            this.tvInfo.setText("Поздравляем! Победитель игрок игравший Ноликами");
            btn7.setTextColor(Color.RED);
            btn8.setTextColor(Color.RED);
            btn9.setTextColor(Color.RED);
            this.haveWinner =  true;
            Toast.makeText(MainActivity.this, "Для начала новой игры нажмите на любую кнопку!", Toast.LENGTH_LONG).show();
        }
        else
        if(this.arrPlayingField[0][0] == MainActivity.keyO &&
                this.arrPlayingField[1][0] == MainActivity.keyO &&
                this.arrPlayingField[2][0] == MainActivity.keyO)
        {
            this.tvInfo.setText("Поздравляем! Победитель игрок игравший Ноликами");
            btn7.setTextColor(Color.RED);
            btn1.setTextColor(Color.RED);
            btn4.setTextColor(Color.RED);
            this.haveWinner =  true;
            Toast.makeText(MainActivity.this, "Для начала новой игры нажмите на любую кнопку!", Toast.LENGTH_LONG).show();
        }
        else
        if(this.arrPlayingField[0][1] == MainActivity.keyO &&
                this.arrPlayingField[1][1] == MainActivity.keyO &&
                this.arrPlayingField[2][1] == MainActivity.keyO)
        {
            this.tvInfo.setText("Поздравляем! Победитель игрок игравший Ноликами");
            btn2.setTextColor(Color.RED);
            btn5.setTextColor(Color.RED);
            btn8.setTextColor(Color.RED);
            this.haveWinner =  true;
            Toast.makeText(MainActivity.this, "Для начала новой игры нажмите на любую кнопку!", Toast.LENGTH_LONG).show();
        }
        else
        if(this.arrPlayingField[0][2] == MainActivity.keyO &&
                this.arrPlayingField[1][2] == MainActivity.keyO &&
                this.arrPlayingField[2][2] == MainActivity.keyO)
        {
            this.tvInfo.setText("Поздравляем! Победитель игрок игравший Ноликами");
            btn6.setTextColor(Color.RED);
            btn9.setTextColor(Color.RED);
            btn3.setTextColor(Color.RED);
            this.haveWinner =  true;
            Toast.makeText(MainActivity.this, "Для начала новой игры нажмите на любую кнопку!", Toast.LENGTH_LONG).show();
        }
        else
        {
            int count = 0;
            //Перебераем двумерный массив на случай ничьи!
            for (int i = 0; i < this.arrPlayingField.length; i++)
            {
                for (int j = 0; j < this.arrPlayingField[i].length; j++)
                {
                    if(this.arrPlayingField[j][i] > 0)
                    {
                        count++;
                    }
                }
            }
            if(count == 9)
            {
                this.tvInfo.setText("Ничья!");
                this.haveWinner = true;
                Toast.makeText(MainActivity.this, "Для начала новой игры нажмите на любую кнопку!", Toast.LENGTH_LONG).show();
            }
        }
    }

    /**
     * Метод игрового процесса
     */
    public void gameProcess(View view)
    {
        //Проверяем есть ли победитель
        if(this.haveWinner == false)
        {
            //Определяем какая кнопка нажата и записываем "Х" или "О" в ячейку
            Button btnPressed = (Button) this.findViewById(view.getId());
            //Первым ходит "крестик"
//            this.tvInfo.setText("Ход: Х");
            //и делаем запись в массиве
            switch (view.getId())
            {
                case R.id.btn1:
                    //Если она пустая,то делаем ход
                    if(btnPressed.getText() == "")
                    {
                        //Узнаем чей ход
                        if(this.isMuve == false)
                        {
                            btnPressed.setText(MainActivity.X);
                            this.arrPlayingField[0][0] = MainActivity.keyX;
                            this.isMuve = true;
                            this.tvInfo.setText("Ход: O");
                            this.checkWinner(this.arrPlayingField);
                        }
                        else
                        {
                            btnPressed.setText(MainActivity.O);
                            this.arrPlayingField[0][0] = MainActivity.keyO;
                            this.isMuve = false;
                            this.tvInfo.setText("Ход: Х");
                            this.checkWinner(this.arrPlayingField);
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Невозможно выполнить ход! " +
                                "Нажмите на любую пустую ячейку", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.btn2:
                    //Если она пустая,то делаем ход
                    if(btnPressed.getText() == "")
                    {
                        //Узнаем чей ход
                        if(this.isMuve == false)
                        {
                            btnPressed.setText(MainActivity.X);
                            this.arrPlayingField[0][1] = MainActivity.keyX;
                            this.isMuve = true;
                            this.tvInfo.setText("Ход: O");
                            this.checkWinner(this.arrPlayingField);
                        }
                        else
                        {
                            btnPressed.setText(MainActivity.O);
                            this.arrPlayingField[0][1] = MainActivity.keyO;
                            this.isMuve = false;
                            this.tvInfo.setText("Ход: Х");
                            this.checkWinner(this.arrPlayingField);
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Невозможно выполнить ход! " +
                                "Нажмите на любую пустую ячейку", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.btn3:
                    //Если она пустая,то делаем ход
                    if(btnPressed.getText() == "")
                    {
                        //Узнаем чей ход
                        if(this.isMuve == false)
                        {
                            btnPressed.setText(MainActivity.X);
                            this.arrPlayingField[0][2] = MainActivity.keyX;
                            this.isMuve = true;
                            this.tvInfo.setText("Ход: O");
                            this.checkWinner(this.arrPlayingField);
                        }
                        else
                        {
                            btnPressed.setText(MainActivity.O);
                            this.arrPlayingField[0][2] = MainActivity.keyO;
                            this.isMuve = false;
                            this.tvInfo.setText("Ход: Х");
                            this.checkWinner(this.arrPlayingField);
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Невозможно выполнить ход! " +
                                "Нажмите на любую пустую ячейку", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.btn4:
                    //Если она пустая,то делаем ход
                    if(btnPressed.getText() == "")
                    {
                        //Узнаем чей ход
                        if(this.isMuve == false)
                        {
                            btnPressed.setText(MainActivity.X);
                            this.arrPlayingField[1][0] = MainActivity.keyX;
                            this.isMuve = true;
                            this.tvInfo.setText("Ход: O");
                            this.checkWinner(this.arrPlayingField);
                        }
                        else
                        {
                            btnPressed.setText(MainActivity.O);
                            this.arrPlayingField[1][0] = MainActivity.keyO;
                            this.isMuve = false;
                            this.tvInfo.setText("Ход: Х");
                            this.checkWinner(this.arrPlayingField);
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Невозможно выполнить ход! " +
                                "Нажмите на любую пустую ячейку", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.btn5:
                    //Если она пустая,то делаем ход
                    if(btnPressed.getText() == "")
                    {
                        //Узнаем чей ход
                        if(this.isMuve == false)
                        {
                            btnPressed.setText(MainActivity.X);
                            this.arrPlayingField[1][1] = MainActivity.keyX;
                            this.isMuve = true;
                            this.tvInfo.setText("Ход: O");
                            this.checkWinner(this.arrPlayingField);
                        }
                        else
                        {
                            btnPressed.setText(MainActivity.O);
                            this.arrPlayingField[1][1] = MainActivity.keyO;
                            this.isMuve = false;
                            this.tvInfo.setText("Ход: Х");
                            this.checkWinner(this.arrPlayingField);
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Невозможно выполнить ход! " +
                                "Нажмите на любую пустую ячейку", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.btn6:
                    //Если она пустая,то делаем ход
                    if(btnPressed.getText() == "")
                    {
                        //Узнаем чей ход
                        if(this.isMuve == false)
                        {
                            btnPressed.setText(MainActivity.X);
                            this.arrPlayingField[1][2] = MainActivity.keyX;
                            this.isMuve = true;
                            this.tvInfo.setText("Ход: O");
                            this.checkWinner(this.arrPlayingField);
                        }
                        else
                        {
                            btnPressed.setText(MainActivity.O);
                            this.arrPlayingField[1][2] = MainActivity.keyO;
                            this.isMuve = false;
                            this.tvInfo.setText("Ход: Х");
                            this.checkWinner(this.arrPlayingField);
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Невозможно выполнить ход! " +
                                "Нажмите на любую пустую ячейку", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.btn7:
                    //Если она пустая,то делаем ход
                    if(btnPressed.getText() == "")
                    {
                        //Узнаем чей ход
                        if(this.isMuve == false)
                        {
                            btnPressed.setText(MainActivity.X);
                            this.arrPlayingField[2][0] = MainActivity.keyX;
                            this.isMuve = true;
                            this.tvInfo.setText("Ход: O");
                            this.checkWinner(this.arrPlayingField);
                        }
                        else
                        {
                            btnPressed.setText(MainActivity.O);
                            this.arrPlayingField[2][0] = MainActivity.keyO;
                            this.isMuve = false;
                            this.tvInfo.setText("Ход: Х");
                            this.checkWinner(this.arrPlayingField);
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Невозможно выполнить ход! " +
                                "Нажмите на любую пустую ячейку", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.btn8:
                    //Если она пустая,то делаем ход
                    if(btnPressed.getText() == "")
                    {
                        //Узнаем чей ход
                        if(this.isMuve == false)
                        {
                            btnPressed.setText(MainActivity.X);
                            this.arrPlayingField[2][1] = MainActivity.keyX;
                            this.isMuve = true;
                            this.tvInfo.setText("Ход: O");
                            this.checkWinner(this.arrPlayingField);
                        }
                        else
                        {
                            btnPressed.setText(MainActivity.O);
                            this.arrPlayingField[2][1] = MainActivity.keyO;
                            this.isMuve = false;
                            this.tvInfo.setText("Ход: Х");
                            this.checkWinner(this.arrPlayingField);
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Невозможно выполнить ход! " +
                                "Нажмите на любую пустую ячейку", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.btn9:
                    //Если она пустая,то делаем ход
                    if(btnPressed.getText() == "")
                    {
                        //Узнаем чей ход
                        if(this.isMuve == false)
                        {
                            btnPressed.setText(MainActivity.X);
                            this.arrPlayingField[2][2] = MainActivity.keyX;
                            this.isMuve = true;
                            this.tvInfo.setText("Ход: O");
                            this.checkWinner(this.arrPlayingField);
                        }
                        else
                        {
                            btnPressed.setText(MainActivity.O);
                            this.arrPlayingField[2][2] = MainActivity.keyO;
                            this.isMuve = false;
                            this.tvInfo.setText("Ход: Х");
                            this.checkWinner(this.arrPlayingField);
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Невозможно выполнить ход! " +
                                "Нажмите на любую пустую ячейку", Toast.LENGTH_LONG).show();
                    }
                    break;
            }
        }
        else
        {
            btn1.setText("");
            btn1.setTextColor(Color.BLACK);
            btn2.setText("");
            btn2.setTextColor(Color.BLACK);
            btn3.setText("");
            btn3.setTextColor(Color.BLACK);
            btn4.setText("");
            btn4.setTextColor(Color.BLACK);
            btn5.setText("");
            btn5.setTextColor(Color.BLACK);
            btn6.setText("");
            btn6.setTextColor(Color.BLACK);
            btn7.setText("");
            btn7.setTextColor(Color.BLACK);
            btn8.setText("");
            btn8.setTextColor(Color.BLACK);
            btn9.setText("");
            btn9.setTextColor(Color.BLACK);
            tvInfo.setText("Ход: Х");

            this.haveWinner = false;
            this.isMuve = false;

            //Очищаем массив ходов
            for (int i = 0; i < this.arrPlayingField.length; i++)
            {
                for (int j = 0; j < this.arrPlayingField[i].length; j++)
                {
                    this.arrPlayingField[i][j] = 0;
                }
            }
            Toast.makeText(MainActivity.this, "Игра началась! Сделайте ход.", Toast.LENGTH_LONG).show();
        }
    }
}
