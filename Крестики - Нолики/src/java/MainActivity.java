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
     * @param  X - значек "крестики"
     * @param O - значек "нолики"
     * @param arrPlayingField - массив игровых клеток
     * @param isMuve - позволяет узнать чей сейчас ход
     * @param keyX - ключ для хода "крестики"
     * @param keyO - ключ для хода "нолики"
     * @param haveWinner - определение есть ли победитель
     * @param tvInfo - текстовое поле игры для отображения информации и игрового процесса
     * @param isGameStarted - true - игра началась, false - игра закончилась
     */
    private final static String X = "X";
    private final static String O = "O";
    private final static int keyX = 1;     //"X"
    private final static int keyO = 2;     //"O"
    private  boolean haveWinner = false;   //false - нету победителя, true - есть победитель
    private boolean isMuve = false;        //false - ходит "крестик", true - ходит нолик
    private boolean isGameStarted = false; //true - игра началась, false - игра закончилась
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

    /**
     * Ключи для сохранения состояния в bundle
     * @param BUNDLE_KEY_HAVE_WINNER - ключ для boolean haveWinner
     * @param BUNDLE_KEY_IS_MUVE - ключ для boolean isMuve
     * @param BUNDLE_KEY_PLAYING_FIELD - ключ для int[] arrPlayingField
     */
    private final static String BUNDLE_KEY_HAVE_WINNER = "haveWinnder";
    private final static String BUNDLE_KEY_IS_MUVE = "isMuve";
    private final static String BUNDLE_KEY_PLAYING_FIELD = "arrPlayingField";
    private final static String BUNDLE_KEY_GAME_STARTED = "isGameStarted";

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

        //Восстанавливаем данные о старте игры
        if(savedInstanceState != null)
        {
            this.isGameStarted = savedInstanceState.getBoolean(MainActivity.BUNDLE_KEY_GAME_STARTED);
        }
        if(this.isGameStarted == false)
        {
            this.haveWinner = true;
            Toast.makeText(MainActivity.this, "Для начала новой игры нажмите на любую кнопку!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Метод сохранения состояния активности
     */
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        //сохраняем значения логических переменных
        outState.putBoolean(MainActivity.BUNDLE_KEY_HAVE_WINNER, this.haveWinner);
        outState.putBoolean(MainActivity.BUNDLE_KEY_IS_MUVE, this.isMuve);
        outState.putBoolean(MainActivity.BUNDLE_KEY_GAME_STARTED, this.isGameStarted);
        //сохраняем состояние кнопок (текст и цвет)
        int color1 = btn1.getCurrentTextColor();
        outState.putInt("color1", color1);
        String text1 = btn1.getText().toString();
        outState.putString("text1", text1);

        int color2 = btn2.getCurrentTextColor();
        outState.putInt("color2", color2);
        String text2 = btn2.getText().toString();
        outState.putString("text2", text2);

        int color3 = btn3.getCurrentTextColor();
        outState.putInt("color3", color3);
        String text3 = btn3.getText().toString();
        outState.putString("text3", text3);

        int color4 = btn4.getCurrentTextColor();
        outState.putInt("color4", color4);
        String text4 = btn4.getText().toString();
        outState.putString("text4", text4);

        int color5 = btn5.getCurrentTextColor();
        outState.putInt("color5", color5);
        String text5 = btn5.getText().toString();
        outState.putString("text5", text5);

        int color6 = btn6.getCurrentTextColor();
        outState.putInt("color6", color6);
        String text6 = btn6.getText().toString();
        outState.putString("text6", text6);

        int color7 = btn7.getCurrentTextColor();
        outState.putInt("color7", color7);
        String text7 = btn7.getText().toString();
        outState.putString("text7", text7);

        int color8 = btn8.getCurrentTextColor();
        outState.putInt("color8", color8);
        String text8 = btn8.getText().toString();
        outState.putString("text8", text8);

        int color9 = btn9.getCurrentTextColor();
        outState.putInt("color9", color9);
        String text9 = btn9.getText().toString();
        outState.putString("text9", text9);

        //Сохраняем содержимое "Информационного поля"
        String textInfo = this.tvInfo.getText().toString();
        outState.putString("textInfo", textInfo);

        //сохраняем массив ходов
        for (int i = 0; i < this.arrPlayingField.length; i++)
        {
            outState.putIntArray(MainActivity.BUNDLE_KEY_PLAYING_FIELD + i, this.arrPlayingField[i]);
        }
    }

    /**
     * Метод восстановления состояния активности
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        //Восстанавливаем данные из bundle
        //Если bundle !=null
        if(savedInstanceState != null)
        {
            //Восстанавливаем значения логических переменных
            this.haveWinner = savedInstanceState.getBoolean(MainActivity.BUNDLE_KEY_HAVE_WINNER);
            this.isMuve = savedInstanceState.getBoolean(MainActivity.BUNDLE_KEY_IS_MUVE);
            //Восстанавливаем состояние кнопок
            this.btn1.setText(savedInstanceState.getString("text1"));
            this.btn1.setTextColor(savedInstanceState.getInt("color1"));
            this.btn2.setText(savedInstanceState.getString("text2"));
            this.btn2.setTextColor(savedInstanceState.getInt("color2"));
            this.btn3.setText(savedInstanceState.getString("text3"));
            this.btn3.setTextColor(savedInstanceState.getInt("color3"));
            this.btn4.setText(savedInstanceState.getString("text4"));
            this.btn4.setTextColor(savedInstanceState.getInt("color4"));
            this.btn5.setText(savedInstanceState.getString("text5"));
            this.btn5.setTextColor(savedInstanceState.getInt("color5"));
            this.btn6.setText(savedInstanceState.getString("text6"));
            this.btn6.setTextColor(savedInstanceState.getInt("color6"));
            this.btn7.setText(savedInstanceState.getString("text7"));
            this.btn7.setTextColor(savedInstanceState.getInt("color7"));
            this.btn8.setText(savedInstanceState.getString("text8"));
            this.btn8.setTextColor(savedInstanceState.getInt("color8"));
            this.btn9.setText(savedInstanceState.getString("text9"));
            this.btn9.setTextColor(savedInstanceState.getInt("color9"));

            //Восстанавливаем содержимое "Информационного поля"
            this.tvInfo.setText(savedInstanceState.getString("textInfo"));

            //Восстанавливаем массив ходов
            for (int i = 0; i < this.arrPlayingField.length; i++)
            {
                this.arrPlayingField[i] = savedInstanceState.getIntArray(MainActivity.BUNDLE_KEY_PLAYING_FIELD + i);
            }
        }
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

            this.isGameStarted = true;
        }
    }
}
