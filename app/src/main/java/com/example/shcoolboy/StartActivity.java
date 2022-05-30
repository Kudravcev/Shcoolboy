package com.example.shcoolboy;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Queue;

public class StartActivity<story,answer> extends AppCompatActivity {
    Character charact;
    Story story;
    private EditText editTextName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        charact = new Character(editTextName,100,100,100);
        Situation startSituation = new Situation("Открой глаза! Ты проснулся?", "Время 7:00, пора вставать!"
                + "Тебе нужно почистить зубы!" +
                "Пойти почистить зубы?" +
                "\n 1 - Да" + "\n 2 - Нет", 2, 0, 0, 0);
//1 ситуация Ванная комната
        startSituation.directions[0] = new Situation("Ты пришёл в ванную комнату", "Ты начал рассматривать ванную комнату. " +
                "Она не большая: перед вами стоит ванная, стоит раковина, на стене картина!" +
                " Ты подошёл к раковине и увидел 4 зубные щётки: щётка мамы, щётка папы, щётка твоей младшей сестры. " +
                "Ты взял свою щётку и намазал зубную пасту  \n Далее ", 2, 100, 100, 100);
        startSituation.directions[0].directions[0] = new Situation("...", "Ты почистил свои зубы. Пора собираться в школу ", 1, 100, 0, 0);
        startSituation.directions[0].directions[0].directions[0] = new Situation("Вы вернулись в комнату", "Вы заметили, что постель не убранна!" +
                " Нужно убрать постель, потому что мама ругается за неубранную постель. Пока вы убирали вашу постель прошло время." +
                " На часах 7:30 и вам пора собираться в школу!Но сначала вам нужно позавтракать!!! \n 1-пойти на кухню \n 2-одеваться в школу", 2, 100, 0, 0);
//2 ситуация Кухня
        startSituation.directions[0].directions[0].directions[0].directions[0] = new Situation("Ты пришёл на кухню", "Ты захотел позавтракать что нибудь вкусное... " +
                "Нужно что нибудь перекусить но ты не знаете что... Ты не придумал ничего интересного, чем сделать бутерброды с чаем... " +
                "Ты покушал и пошёл собираться в вашу комнату ", 1, 100, 0, 0);
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0] = new Situation("Ты вернулся в комнату", "Нужно поторопиться! Начал одевать штаны," +
                " следом начал одевать рубашку, кофту. Но ты кое-что забыл! Ты забыл собрать свой рюкзак с вечера! Взять ваш дневник для того, чтобы узнать, какие предметы тебе нужно приготовить?" +
                " \n 1- Взять \n 2-вспоминать, какие предметы у тебя сегодня есть", 2, 100, 0, 0);


//3 ситуация ты взял дневник
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[0] = new Situation("Ты взял свой дневник", "Начал искать нужный тебе день... Ты увидел одну 2, поставленную вашим учителем по математике..." +
                " пролестнул страницу и увидел нужный день... У тебя сегодня 5 уроков: Русский, история, 2 математики и урок физкультуры... Положить учебники в рюкзак? \n 1- Положить", 1, 100, 0, 0);
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0] = new Situation("Ты начал складывать в портфель твои учебники: взял математику, положил учебник истории," +
                " обернулся и увидел учебник русского языка","Поторапись, время 7:45 - быстрее!",1,1,1,1);
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0] = new Situation("Ты одел куртку, одел обувь...","У тебя чувство, что ты что-то забыл," +
                " но времени не было вспоминать \n Ты вышел, закрыл дверь, начал спускаться и ВСПОМНИЛ!!!!...\n Ты забыл форму на физкультуру!",1,1,1,1);



        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0] = new Situation("Ты одел куртку, одел обувь...","У тебя чувство, что ты что-то забыл," +
                " но времени не было вспоминать \n Ты вышел, закрыл дверь, начал спускаться и ВСПОМНИЛ!!!!...\n Ты забыл форму на физкультуру!",1,1,1,1);

// 4 ситуация   ты перебежал через дорогу№№№№№№№№№№№№№№№№№№№№
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0]=new Situation("Ты нарушил правило дорожного движения!!!","Нельзя перебегать через дорогу на красный," +
                " так как это может повлечь за собой аварию!",1,1,1,1);
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0] = new Situation("Ты подождал, пока загориться зелёный и вот..." +
                " Загорелся зелёный свет светофора и ты побежал в школу","",1,1,1,1);
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0] = new Situation("Ты дошёл до школы, обернулся..." +
                " время 8:01 и оставшееся количество учеников, тоже как и ты опаздали в школу", "Ты поднялся по леснице, открыл дверь и зашёл в школу",1,1,1,1);
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0] = new Situation("Зайдя в школу ты заметил непривычную тишину..." +
                "Увидел сторожа ты решил с ним поздароваться, но он разговаривает по телефону", "Поздароваешься со сторожем? \n Нужно поздароваться  \n Не буду отвлекать сторожа за телефонным разговором",2,1,1,1);


// 5 ситуация        Разговор сторожа по телефону
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0]= new Situation("Ты решил поздароваться со сторожем," +
                " но он не заметил тебя и ты прошёл дальше","Ты подошёл к гардеробной, снял свою куртку. Увидев гардеробщицу ты решил поздароваться с ней, она улыбнулась и поздаровалась в ответ.\n Ты передал куртку ей, она взяла и протянула номерок №28 ", 1,1,1,1);
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0]= new Situation("Ты пошёл по коридору, дошёл до лестницы","...", 1,1,1,1);
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0]= new Situation("Дошёл до третьего этажа, пошёл прямо...","Вот нужный кабинет..." +
                "Ты не очень хочешь заходить, так как ты опоздал... Ты посмотрел на время... Ого! Ты опоздал на 15 минут!", 1,1,1,1);
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0]= new Situation("Ты постучал в дверь...","Отрыв дверь ты начал обращаться к учителю:" +
                "\n - Здравствуйте, извините за опоздание. Можно войти?" +
                "\n - А ты почему опоздал? Что у тебя такое случилось, что ты решил опоздать на мой урок? Если ты так хочешь опаздовать на мой урок, можешь вообще не приходить!" +
                "\n - Извините меня ещё раз, больше так не буду!!!", 1,1,1,1);
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0]= new Situation("Она разрешила тебе сесть на своё место, но предупредила," +
                " что если ты опоздаешь ещё раз, она тебя больше не пустит! ","", 0,1,1,1);


        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[1]= new Situation("Ты решил не здароваться со сторожем и нарушил правило этиката!" +
                "","Нужно здароваться со всеми, но не нужно кричать при приветствии с человеком! ты должен спокойно поздароваться со сторожем!Ты подошёл к гардеробной, снял свою куртку. Увидев гардеробщицу ты решил поздароваться с ней, она улыбнулась и поздаровалась в ответ.\n Ты передал куртку ей" +
                ", она взяла и протянула номерок №28", 1,1,1,1);


        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[1].directions[0]= new Situation("Дошёл до третьего этажа, пошёл прямо...","Вот нужный кабинет..." +
                "Ты не очень хочешь заходить, так как ты опоздал... Ты посмотрел на время... Ого! Ты опоздал на 15 минут!", 1,1,1,1);
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[1].directions[0].directions[0]= new Situation("Ты постучал в дверь...","Отрыв дверь ты начал обращаться к учителю:" +
                "\n - Здравствуйте, извините за опоздание. Можно войти?" +
                "\n - А ты почему опоздал? Что у тебя такое случилось, что ты решил опоздать на мой урок? Если ты так хочешь опаздывать на мой урок, можешь вообще не приходить!" +
                "\n - Извините меня ещё раз, больше так не буду!!!", 1,1,1,1);
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[1].directions[0].directions[0].directions[0]= new Situation("Она разрешила тебе сесть на своё место, но предупредила," +
                " что если ты опоздаешь ещё раз, она тебя больше не пустит! ","", 1,1,1,1);



        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[1].directions[0].directions[0].directions[0].directions[0]= new Situation("Ты, пройдя на своё место," +
                " заметил на себе взгляды своих одноклассников","Сев на место, ты осмотрел класс, увидел всё те же знакомые предметы: в переди была доска, около доски был учительский стол, где лежали стопки тетрадей, несколько книг и стоял учительский компьютер, к которому учитьница не разрешала подходит даже близко," +
                " на против доски стояли 3 ряда по 5 парт где почти были рассажены все твои одноклассники и взади стояли шкафы, набитые книгами и тетрадями других учеников. Пока ты разглядывал класс, учительница вызвала тебя к доске", 1,1,1,1);
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[1].directions[0].directions[0].directions[0].directions[0].directions[0]= new Situation("Ты начал идти к доске" +
                "","Ты не знал что у тебя спросят, сердце стучало, ладони вспотели из-за того, что ты не зделал своё домашнее задание", 1,1,1,1);
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[1].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0]= new Situation("Ты подошёл к доске," +
                " взял мел, посмотрел на доску и начал читать","... ", 0,1,1,1);



//3 ситуация Какие уроки на сегодня
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[1] = new Situation("Вы начали вспоминать ваши уроки на день", "Так... Сегодня... русский, история, математики и математика..." +
                " Ещё физкультура... Положить учебники в рюкзак? \n 1- Положить", 1, 100, 0, 0);
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[1].directions[0] = new Situation("Ты начал складывать в портфель твои учебники: взял математику, положил учебник истории," +
                " обернулся и увидел учебник русского языка","Поторапись, время 7:45 - быстрее!",1,1,1,1);
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[1].directions[0].directions[0] = new Situation("Ты одел куртку, одел обувь...","У тебя чувство, что ты что-то забыл," +
                " но времени не было вспоминать \n Ты вышел, закрыл дверь, начал спускаться и ВСПОМНИЛ!!!!...\n Ты забыл форму на физкультуру!",1,1,1,1);
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[1].directions[0].directions[0].directions[0] = new Situation("Ты вышел на улицу, посмотрел на небо..." +
                "\n Погода замечательная, птицы поют, дует тёплый ветер - на улице весна...Уже виднеется твоя школа", "Ты дошёл до пешеходного перекрёстка - загорелся красный свет, время 7:57, ты опаздываешь: " +
                "\n 1 - перебежать через дарогу, но ты не опоздаешь \n 2 - дождаться зеленого света,но ты опоздаешь", 1, 100, 0, 0);





//1 ситуация Ты не захотел почистить зубы!!!!ИЗМЕНИТЬ БАЛЛЫ В КОДЕ !!!
        startSituation.directions[1] = new Situation("!!!!!!!", "Ты нарушил правило! Это очень плохо, так как нужно чистить каждое утро! Это важно... " +
                "За неправильное поведение у тебя снимаются баллы! ", 2, 100, 0, 0);
        startSituation.directions[1].directions[0] = new Situation("На самом деле!", "В норме, зубы надо чистить на протяжении 2–3 минут. " +
                "Это оптимально для поддержания сохранности эмали, профилактики заболеваний зубов и полости рта", 1, 100, 0, 0);
        startSituation.directions[1].directions[0].directions[0] = new Situation("Ты пришёл в ванную комнату", "Ты начал рассматривать ванную комнату. " +
                "Она не большая: перед вами стоит ванная, стоит раковина, на стене картина!" +
                " Ты подошёл к раковине и увидел 4 зубные щётки: щётка мамы, щётка папы, щётка твоей младшей сестры и твоя. " +
                "Ты взял свою щётку и намазал зубную пасту", 1, 100, 0, 0);
        startSituation.directions[1].directions[0].directions[0] = new Situation("...", "Ты почистил свои зубы. Пора собираться в школу ", 1, 100, 0, 0);
        startSituation.directions[1].directions[0].directions[0].directions[0] = new Situation("Вы вернулись в комнату", "Вы заметили, что постель не убранна!" +
                " Нужно убрать постель, потому что мама ругается за неубранную постель. Пока вы убирали вашу постель прошло время." +
                " На часах 7:30 и вам пора собираться в школу!Но сначала вам нужно позавтракать!!! \n 1-пойти на кухню \n 2-одеваться в школу", 2, 100, 0, 0);

        startSituation.directions[1].directions[0].directions[0].directions[0].directions[0] = new Situation("Ты пришёл на кухню", "Ты захотел позавтракать что нибудь вкусное... " +
                "Нужно что нибудь перекусить но ты не знаете что... Ты не придумал ничего интересного, чем сделать бутерброды с чаем... " +
                "Ты покушал и пошёл собираться в вашу комнату ", 1, 100, 0, 0);
        startSituation.directions[1].directions[0].directions[0].directions[0].directions[0].directions[0] = new Situation("Ты вернулся в комнату", "Нужно поторопиться! Начал одевать штаны," +
                " следом начал одевать рубашку, кофту. Но ты кое-что забыл! Ты забыл собрать свой рюкзак с вечера! Взять ваш дневник для того, чтобы узнать, какие предметы тебе нужно приготовить?" +
                " \n 1- Взять \n 2-вспоминать, какие предметы у тебя сегодня есть", 2, 100, 0, 0);

//2 ситуация ты взял дневник
        startSituation.directions[1].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0] = new Situation("Ты взял свой дневник", "Начал искать нужный тебе день... Ты увидел одну 2, поставленную вашим учителем по математике..." +
                " пролестнул страницу и увидел нужный день... У тебя сегодня 5 уроков: Русский, история, 2 математики и урок физкультуры... Положить учебники в рюкзак? \n 1- Положить", 1, 100, 0, 0);
        startSituation.directions[1].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0] = new Situation("Ты начал складывать в портфель твои учебники: взял математику, положил учебник истории," +
                " обернулся и увидел учебник русского языка","Поторапись, время 7:45 - быстрее!",1,1,1,1);
        startSituation.directions[1].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0] = new Situation("Ты одел куртку, одел обувь...","У тебя чувство, что ты что-то забыл," +
                " но времени не было вспоминать \n Ты вышел, закрыл дверь, начал спускаться и ВСПОМНИЛ!!!!...\n Ты забыл форму на физкультуру!",1,1,1,1);
        startSituation.directions[1].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0].directions[0] = new Situation("Ты вышел на улицу, посмотрел на небо..." +
                "\n Погода замечательная, птицы поют, дует тёплый ветер - на улице весна...Уже виднеется твоя школа", "Ты дошёл до пешеходного перекрёстка - загорелся красный свет, время 7:57, ты опаздываешь: " +
                "\n перебежать через дарогу, но ты не опоздаешь \n дождаться зеленого света,но ты опоздаешь", 0, 100, 0, 0);

//3 ситуация Какие уроки на сегодня
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[1] = new Situation("Вы начали вспоминать ваши уроки на день", "Так... Сегодня... русский, история, математики и математика..." +
                " Ещё физкультура... Положить учебники в рюкзак? \n 1- Положить", 1, 100, 0, 0);
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[1].directions[0] = new Situation("Ты начал складывать в портфель твои учебники: взял математику, положил учебник истории," +
                " обернулся и увидел учебник русского языка","Поторапись, время 7:45 - быстрее!",1,1,1,1);
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[1].directions[0].directions[0] = new Situation("Ты одел куртку, одел обувь...","У тебя чувство, что ты что-то забыл," +
                " но времени не было вспоминать \n Ты вышел, закрыл дверь, начал спускаться и ВСПОМНИЛ!!!!...\n Ты забыл форму на физкультуру!",1,1,1,1);
        startSituation.directions[0].directions[0].directions[0].directions[0].directions[0].directions[1].directions[0].directions[0].directions[0] = new Situation("Ты вышел на улицу, посмотрел на небо..." +
                "\n Погода замечательная, птицы поют, дует тёплый ветер - на улице весна...Уже виднеется твоя школа", "Ты дошёл до пешеходного перекрёстка - загорелся красный свет, время 7:57, ты опаздываешь: " +
                "\n 1 - перебежать через дарогу, но ты не опоздаешь \n 2 - дождаться зеленого света,но ты опоздаешь", 0, 100, 0, 0);

        startSituation.directions[1].directions[0] = new Situation("Вы взяли ваш дневник", "Начали исать нужный вам день... Вы увидели одну 2, поставленную вашим учителем по математике... пролестнули страницу и увидели нужный день... У вас сегодня 5 уроков: Русский, история, 2 математики и урок физкультуры... Положить учебники в рюкзак? \n 1- Положить", 1, 100, 0, 0);

//
//        DBSituations db = new DBSituations(this);
//        ArrayList<Situation> situations = db.selectAll();
//        Situation startSituation = situations.get(0);

        story = new Story(startSituation);
        updateStatus();
    }
//    private Object[][] array = new String[][] {};

    private void go(int i) {
        story.go(i);
        updateStatus();
        if (story.isEnd()){
//            Toast.makeText(this, " ", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getBaseContext(), Snake.class);
            startActivity(intent);
        }
    }

    private void updateStatus() {
        charact.P += story.currentSituation.dP;
        charact.T += story.currentSituation.dT;
        charact.R += story.currentSituation.dR;
        TextView tv = findViewById(R.id.textView5);
                tv.setText("П:" + charact.P + "\nТ:" + charact.T + "\nР:" + charact.R);
        TextView tv1 = findViewById(R.id.textView2);
                tv1.setText(story.currentSituation.subject);
        TextView tv2 = findViewById(R.id.textView6);
                tv2.setText(story.currentSituation.text);
        LinearLayout linearLayout = findViewById(R.id.layout);
                linearLayout.removeAllViews();
//        DBSituations db = new DBSituations(this);
//        ArrayList<Answer> answers = db.selectAllAnswer(story.currentSituation.getId());
//        story.currentSituation.directions = answers.toArray();

        for (int i = 0; i < story.currentSituation.directions.length; i++) {
            Button b = new Button(this);
            b.setText(Integer.toString(i + 1));
            final int buttonId = i;
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    go(buttonId);
                    }
            });
            ((LinearLayout) findViewById(R.id.layout)).addView(b);
            Button b1 = new Button(this);
        }
        return;
    }
}
