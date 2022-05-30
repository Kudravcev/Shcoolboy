package com.example.shcoolboy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBSituations {
//    private static final String DATABASE_NAME = "shcoolboy";
//    private static final int DATABASE_VERSION = 13;
//    private static final String TABLE_NAME = "situations";
//    private static final String TABLE_ANSWER = "answers";
//
//    private static final String COLUMN_ID = "id";
//    private static final String COLUMN_TEXT = "text";
//    private static final String COLUMN_SUBJECT = "subject";
//    private static final String COLUMN_DP = "dp";
//    private static final String COLUMN_DT = "dt";
//    private static final String COLUMN_DR = "dr";
//
//    private static final int NUM_COLUMN_ID = 0;
//    private static final int NUM_COLUMN_TEXT = 1;
//    private static final int NUM_COLUMN_SUBJECT = 2;
//    private static final int NUM_COLUMN_DP = 3;
//    private static final int NUM_COLUMN_DT = 4;
//    private static final int NUM_COLUMN_DR = 5;
//
//
//    private static final String COLUMN_ID_ANSWER = "idanswer";
//    private static final String COLUMN_TEXT_ANSWER = "textanswer";
//    private static final String COLUMN_ID_NEXT = "idnext";
//    private static final String COLUMN_ID_LAST = "idlast";
//
//    private static final int NUM_COLUMN_ID_ANSWER = 0;
//    private static final int NUM_COLUMN_TEXT_ANSWER = 1;
//    private static final int NUM_COLUMN_ID_NEXT = 2;
//    private static final int NUM_COLUMN_ID_LAST = 3;
//
//    private SQLiteDatabase mDataBase;
//
//    public DBSituations(Context context) {
//        OpenHelper mOpenHelper = new OpenHelper(context);
//        mDataBase = mOpenHelper.getWritableDatabase();
//    }
//
//    public long insert(String text, String subject, int dP, int dT, int dR) {
//        ContentValues cv = new ContentValues();
//        cv.put(COLUMN_TEXT, text);
//        cv.put(COLUMN_SUBJECT, subject);
//        cv.put(COLUMN_DP, dP);
//        cv.put(COLUMN_DT, dT);
//        cv.put(COLUMN_DR, dR);
//        return mDataBase.insert(TABLE_NAME, null, cv);
//    }
//    public long answerinsert(String textanswer, int idnext, int idlast) {
//        ContentValues cv = new ContentValues();
//        cv.put(COLUMN_TEXT_ANSWER, textanswer);
//        cv.put(COLUMN_ID_NEXT, idnext);
//        cv.put(COLUMN_ID_LAST, idlast);
//        return mDataBase.insert(TABLE_ANSWER, null, cv);
//    }
//
//    public long insert(Situation startSituation) {
//        long id = this.insert(
//                startSituation.getText(),
//                startSituation.getSubject(),
//                startSituation.getdP(),
//                startSituation.getdT(),
//                startSituation.getdR())
////        );
////        startSituation.setId(id);
////        return id;
//    }
//    public long answerinsert(Answer answer) {
//        ContentValues cv = new ContentValues();
//        cv.put(COLUMN_TEXT_ANSWER, answer.getTextanswer());
//        cv.put(COLUMN_ID_NEXT, answer.getIdnext());
//        cv.put(COLUMN_ID_LAST, answer.getIdlast());
//        return mDataBase.insert(TABLE_ANSWER, null, cv);
//    }
//
//    public int update(Situation md) {
//        ContentValues cv = new ContentValues();
//        cv.put(String.valueOf(NUM_COLUMN_ID), md.getId());
//        cv.put(COLUMN_TEXT, md.getText());
//        cv.put(COLUMN_SUBJECT, md.getSubject());
//        cv.put(COLUMN_DP, md.getdP());
//        cv.put(COLUMN_DT, md.getdT());
//        cv.put(COLUMN_DR, md.getdR());
//        return mDataBase.update(TABLE_NAME, cv, COLUMN_ID + " = ?", new String[]{String.valueOf(md.getId())});
//    }
//
//    public void deleteAll() {
//        mDataBase.delete(TABLE_NAME, null, null);
//    }
//
//    public void delete(long id) {
//        mDataBase.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
//    }
//
//    public Situation select(long id) {
//        Cursor mCursor = mDataBase.query(TABLE_NAME, null, COLUMN_ID + " = ?",
//                new String[]{String.valueOf(id)}, null, null, null);
//
//        mCursor.moveToFirst();
//        id = mCursor.getLong(NUM_COLUMN_ID);
//        String Text = mCursor.getString(NUM_COLUMN_TEXT);
//        String Subjact = mCursor.getString(NUM_COLUMN_SUBJECT);
//        int dR = mCursor.getInt(NUM_COLUMN_DR);
//        int dT = mCursor.getInt(NUM_COLUMN_DT);
//        int dP = mCursor.getInt(NUM_COLUMN_DR);
//        return new Situation(id, Text, Subjact, dP, dT, dR);
//    }
//
//    public ArrayList<Situation> selectAll() {
//        Cursor mCursor = mDataBase.query(TABLE_NAME,
//                null, null, null, null, null, null);
//        ArrayList<Situation> arr = new ArrayList<Situation>();
//        mCursor.moveToFirst();
//        if (!mCursor.isAfterLast()) {
//            do {
//                long id = mCursor.getLong(NUM_COLUMN_ID);
//                String Text = mCursor.getString(NUM_COLUMN_TEXT);
//                String Subjact = mCursor.getString(NUM_COLUMN_SUBJECT);
//                int dP = mCursor.getInt(NUM_COLUMN_DP);
//                int dT = mCursor.getInt(NUM_COLUMN_DT);
//                int dR = mCursor.getInt(NUM_COLUMN_DR);
//                arr.add(new Situation(id, Text, Subjact, dP, dT, dR));
//            } while (mCursor.moveToNext());
//        }
//        return arr;
//    }
//    public ArrayList<Answer> selectAllAnswer(Long s1) {
//        Cursor mCursor = mDataBase.query(TABLE_ANSWER,
//                null, "idlast =" + s1, null, null, null, null);
//        ArrayList<Answer> arr = new ArrayList<Answer>();
//        mCursor.moveToFirst();
//        if (!mCursor.isAfterLast()) {
//            do {
//                long idanswer = mCursor.getLong(NUM_COLUMN_ID_ANSWER);
//                String textanswer = mCursor.getString(NUM_COLUMN_TEXT_ANSWER);
//                long idnext = mCursor.getLong(NUM_COLUMN_ID_NEXT);
//                long idlast = mCursor.getLong(NUM_COLUMN_ID_LAST);
//                arr.add(new Answer(idanswer, textanswer, idnext, idlast));
//            } while (mCursor.moveToNext());
//        }
//        return arr;
//    }
//
//    private class OpenHelper extends SQLiteOpenHelper {
//
//        OpenHelper(Context context) {
//            super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        }
//
//        @Override
//        public void onCreate(SQLiteDatabase db) {
//            String query = "CREATE TABLE " + TABLE_NAME + " (" +
//                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                    COLUMN_TEXT + " TEXT, " +
//                    COLUMN_SUBJECT + " TEXT," +
//                    COLUMN_DP + " INTEGER," +
//                    COLUMN_DT + " INTEGER," +
//                    COLUMN_DR + " INTEGER" +
//                    ")";
//            db.execSQL(query);
//
//            query = "CREATE TABLE " + TABLE_ANSWER + " (" +
//                    COLUMN_ID_ANSWER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                    COLUMN_TEXT_ANSWER + " TEXT, " +
//                    COLUMN_ID_NEXT + " INTEGER," +
//                    COLUMN_ID_LAST + " INTEGER" +
//                    ")";
//            db.execSQL(query);
//
//            initData(db);
//        }
//
//        private void initData(SQLiteDatabase db) {
//            mDataBase = db;
//            Situation sit1 = new Situation(0, "Открой глаза! Ты проснулся?", "Время 7:00, пора вставать!" +
//                    "\nТебе нужно почистить зубы!" +
//                    "\nПойти почистить зубы?", 2, 0, 0, 0);
//
//            Situation sit2 = new Situation(0, "Ты пришёл в ванную комнату!\nТы начал рассматривать ванную комнату...",
//                    "Она не большая: перед вами стоит ванная, стоит раковина, на стене .........  картина! " +
//                            "\n Ты подошёл к раковине и увидел 4 зубные щётки: щётка мамы, щётка папы, щётка твоей младшей сестры и твоя." +
//                            "\n Ты взял свою щётку и намазал зубную пасту", 1, 0, 0, 0);
//
//            Situation sit11 = new Situation(0, "Ты нарушил правило!",
//                    "\n Это очень плохо, так как нужно чистить каждое утро! Это важно... " +
//                    "\n \n За нарушение у тебя снимаются баллы! ",1, 0, 0, 0);
////*************************************************************************
//            Situation sit3 = new Situation(0, "...", "Ты почистил свои зубы. Пора собираться в школу ",
//                    1, 0, 0, 0);
//
//            Situation sit4 = new Situation(0, "Ты вернулся в комнату", "Ты заметил, что постель не убранна!" +
//                    "\n Нужно убрать постель, потому что мама ругается за неубранную постель. Пока ты убирал свою постель, прошло время." +
//                    "\n На часах 7:30 и тебе пора собираться в школу!" +
//                    "\n Но сначала тебе нужно позавтракать!!!", 1, 0, 0, 0);
//
//            Situation sit5 = new Situation(0, "Ты пришёл на кухню", "Ты захотел позавтракать что нибудь вкусное... " +
//                    "Нужно что нибудь перекусить но ты не знаете что... Ты не придумал ничего интересного, чем сделать бутерброды с чаем... " +
//                    "Ты покушал и пошёл собираться в вашу комнату ", 1, 0, 0, 0);
//
//            Situation sit6 = new Situation(0, "Ты вернулся в комнату", "Нужно поторопиться! Начал надевать штаны," +
//                    "\n следом начал надевать рубашку, кофту. Но ты кое-что забыл! Ты забыл собрать свой рюкзак с вечера!" +
//                    "\n Взять ваш дневник для того, чтобы узнать, какие предметы тебе нужно приготовить?", 2, 0, 0, 0);
//
//            Situation sit7 = new Situation(0, "Ты взял свой дневник", "Начал искать нужный тебе день..." +
//                    "\n Ты увидел одну 2, поставленную вашим учителем по математике..." +
//                    "\n пролестнул страницу и увидел нужный день... " +
//                    "\n У тебя сегодня 5 уроков: Русский, история, 2 математики и урок физкультуры... " +
//                    "\n Положить всё в рюкзак? ", 1, 0, 0, 0);
//
//            Situation sit12 = new Situation(0, "Ты решил не доставать свой дневник", "Вы начали вспоминать ваши уроки на день!" +
//                    "\n Так... Сегодня... русский, история, математики и математика..." +
//                    "\n Ещё физкультура... " +
//                    "\n Положить учебники в рюкзак?", 1, 0, 0, 0);
//
//            Situation sit8 = new Situation(0, "Ты начал складывать в портфель твои учебники: взял математику, положил учебник истории," +
//                    "\n обернулся и увидел учебник русского языка","Поторапись, время 7:45 - быстрее!", 1, 0, 0, 0);
//
//            Situation sit9 = new Situation(0, "Ты одел куртку, надел обувь...",
//                    "У тебя чувство, что ты что-то забыл, но времени не было вспоминать " +
//                    "\n Ты вышел, закрыл дверь, начал спускаться и ВСПОМНИЛ!!!!..." +
//                    "\n Ты забыл форму на физкультуру!", 1, 0, 0, 0);
//
//            Situation sit10 = new Situation(0, "Ты вышел на улицу, посмотрел на небо..." +
//                    "\n Погода замечательная, птицы поют, дует тёплый ветер - на улице весна...Уже виднеется твоя школа",
//                    "Ты дошёл до пешеходного перекрёстка - загорелся красный свет, время 7:57, ты опаздываешь!!!" +
//                            "Перебежать или дожаться зелёного света?",1, 0, 0, 0);
//
//            Situation sit13 = new Situation(0, "Ты подождал, пока загориться зелёный и вот..." +
//                    "\n Загорелся зелёный свет светофора ","Подожав зелёный ты быстро побежал в школу",  1, 0, 0, 0);
//
//            Situation sit14 = new Situation(0, "Ты нарушил правило дорожного движения!!!",
//                    "Нельзя перебегать через дорогу на красный, так как это может повлечь за собой аварию!", 1, 0, 0, 0);
//
//            Situation sit15 = new Situation(0, "Ты дошёл до школы, обернулся..." +
//                    "\n Время 8:01 и оставшееся количество учеников, тоже как и ты опаздали в школу",
//                    "Ты поднялся по леснице, открыл дверь и зашёл в школу", 1, 0, 0, 0);
//
//            Situation sit16 = new Situation(0, "Зайдя в школу ты заметил непривычную тишину...",
//                    "Увидев сторожа, ты решил с ним поздароваться, но он разговаривает по телефону" +
//                            "\n Поздароваешься со сторожем? ", 1, 0, 0, 0);
//
//            Situation sit17 = new Situation(0, "Ты решил поздароваться со сторожем",
//                    "Oн не заметил тебя и ты прошёл дальше", 1, 0, 0, 0);
//
//            Situation sit18 = new Situation(0, "Ты решил не здароваться со сторожем и нарушил правило этиката!",
//                    "Нужно здароваться со всеми, но не нужно кричать при приветствии с человеком!", 1, 0, 0, 0);
//
//            Situation sit19 = new Situation(0,"Ты подошёл к гардеробной и снял свою куртку","Увидев гардеробщицу ты решил поздароваться с ней," +
//                    " она улыбнулась и поздаровалась в ответ." +
//                    "\n Ты передал ей куртку, она взяла её и протянула номерок №28",1,0,0,0);
//
//            Situation sit20 = new Situation(0,"Дошёл до третьего этажа, пошёл прямо...","Вот нужный кабинет..." +
//                    "Ты не очень хочешь заходить, так как ты опоздал... Ты посмотрел на время... Ого! Ты опоздал на 15 минут!", 1,0,0,0);
//
//            Situation sit21 = new Situation(0,"Ты постучал в дверь...","Отрыв дверь ты начал обращаться к учителю:\n" +
//                    "\n - Здравствуйте, извините за опоздание. Можно войти?" +
//                    "\n - А ты почему опоздал? Что у тебя такое случилось, что ты решил опоздать на мой урок?" +
//                    " Если ты так хочешь опаздывать на мой урок, можешь вообще не приходить!" +
//                    "\n - Извините меня ещё раз, больше так не буду!!!", 1,0,0,0);
//
//            Situation sit22 = new Situation(0,"Она разрешила тебе сесть на своё место, но предупредила," +
//                    " что если ты опоздаешь ещё раз, она тебя больше не пустит!","Ты извинился ещё раз!", 1,0,0,0);
//
//            Situation sit23 = new Situation(0,"Ты, пройдя на своё место," +
//                    " заметил на себе взгляды своих одноклассников","Сев на место, ты осмотрел класс, увидел всё те же знакомые предметы:" +
//                    "в переди была доска, около доски был учительский стол, где лежали стопки тетрадей, несколько книг и стоял учительский компьютер," +
//                    " к которому учитьница не разрешала подходит даже близко," +
//                    " на против доски стояли 3 ряда по 5 парт где почти везде были рассажены все твои одноклассники и взади стояли шкафы," +
//                    " набитые книгами и тетрадями других учеников. Пока ты разглядывал класс, учительница вызвала тебя к доске", 1,0,0,0);
//
//            Situation sit24 = new Situation(0,"Ты начал идти к доске",
//                    "Ты не знал что у тебя спросят, сердце стучало," +
//                            " ладони вспотели из-за того, что ты не зделал своё домашнее задание", 1,0,0,0);
//
//            Situation sit25 = new Situation(0,"Ты подошёл к доске," +
//                    " взял мел, посмотрел на доску и начал читать","Нужно найти Имя Существительное в предложении", 1,0,0,0);
//
//            Situation sit26 = new Situation(0,"*** ЗАДАНИЕ 1 ***" +
//                    "\n Найдите в предложении Имя Существительное(Отвечает на вопрос: Кто?, Что?):",
//                    "\n Я гулял один по парку \n",1,0,0,0);
//            Situation sit27 = new Situation(0,"Это частично правильно!","Это Местоимение, и оно," +
//                    " как и Имя Существительное отвечает на вопросы:кто? что? (я, он, мы)",1,0,0,0);
//            Situation sit28 = new Situation(0,"Не правильно!","Это Глагол",1,0,0,0);
//            Situation sit29 = new Situation(0,"Не правильно!","Это Имя Числительное",1,0,0,0);
//            Situation sit30 = new Situation(0,"Молодец!","Ты нашёл Имя Существительное!",1,0,0,0);
//
//            Situation sit31 = new Situation(0,"*** ЗАДАНИЕ 2 ***" +
//                    "\n Найдите в предложении Имя Прилагательное(Отвечает на вопрос: Какой?, Какая?, Какие? и др.):",
//                    "\n Девочка испачкалась сладким вареньем \n",1,0,0,0);
//            Situation sit32 = new Situation(0,"Не правильно!","Это Имя Существительное",1,0,0,0);
//            Situation sit33 = new Situation(0,"Не правильно!","Это Глагол",1,0,0,0);
//            Situation sit34 = new Situation(0,"Молодец!","Ты нашёл Имя Прилагательное!",1,0,0,0);
//            Situation sit35 = new Situation(0,"Не правильно!","Это Имя Существительное",1,0,0,0);
//
//            Situation sit36 = new Situation(0,"Ты выполнил все задания от учителя","Ты повернулся к ней" +
//                    "\n Она тебя похвалила и сказала что ты можешь сесть на своё место",1,0,0,0);
//
//            Situation sit37 = new Situation(0,"Ты был очень счастлив своей работой",
//                    "Она поставила тебе 5 и начала распрашивать других!",1,0,0,0);
//
//            Situation sit38 = new Situation(0,"Прозвенел звонок и все начали собирать учебники в свои сумки," +
//                    " но учитель строго посмотрела на всех...",
//                    "Она сказала,что звонок с урока для учителя и только она знает, когда и кого отпускать, все сели на место..." +
//                            "\n вскоре она всех отпустила, но была очень не давольна!",1,0,0,0);
//
//            Situation sit39 = new Situation(0,"Выйдя из класса, ты подошёл к своему другу из класса",
//                    "Это был мальчик невысокого роста, спортсмен и отличник класса, Максим!",1,0,0,0);
//
//            Situation sit40 = new Situation(0,"Подойдя к своему другу, ты начал разговор:",
//                    "- Привет, Макс!" +
//                            "\n - Привет!" +
//                            "\n - А какой у нас следующий урок?" +
//                            "\n - Исория, вроде бы..." +
//                            "\n - Хорошо, тогда пошли на историю" +
//                            "\n - Пошли",1,0,0,0);
//
//            Situation sit41 = new Situation(0,"Вы шли по шумному коридуру","Вы дошли до кабинета и встретили учителя истории" +
//                    "\n Поздароваетесь с ним?",1,0,0,0);
//
//            Situation sit42 = new Situation(0,"Вы поздаровались с учителем","Он заметил вас и поздаровался с вами",1,0,0,0);
//
//            Situation sit43 = new Situation(0,"Вы не поздаровались с учителем и это не правильно",
//                    "Нужно сдароваться с учителями!",1,0,0,0);
//
//            Situation sit44 = new Situation(0,"Вы вошли в класс, начали осматривать и заметили карты," +
//                    " лежащие на шкафу, исорические таблицы, весящие на стенах и" +
//                    " учебники лежащие на последней парте и в шкафу, а в остальном, этот класс был похож на класс русского языка",
//                    "Ты подошёл к своему месту, повесил рюкзак на крючок и начал доставать учебник истории, пенал и дневник",1,0,0,0);
//
//            Situation sit45 = new Situation(0,"Прозвенел звонок и одноклассники начали приходить в класс","Все встали и зашёл учитель истории" +
//                    "\n Он обладает плотным телосложением, суровый мужчина лет 50, с тёмными волосами и очками. " +
//                    "Учитель истории всё время ходит со своим коженным портфелем и очень редко без него.",1,0,0,0);
//
//            Situation sit46 = new Situation(0,"Он начал урок с приветствия, дальше начал отмечать отсутствующих",
//                    "Он, как и всегда, начал с распроса домашнего задания. Ответить на домашнее задание?",1,0,0,0);
//
//            Situation sit47 = new Situation(0,"Ты решил ответить учителю","Он начал расспрашивать по теме ``Крещение Руси``:" +
//                    "Когда было Крещение Руси?" +
//                    "\n а) 1941" +
//                    "\n б) 988",1,0,0,0);
//            Situation sit48 = new Situation(0,"Не правильно!","Крещение Руси было в 988",1,0,0,0);
//            Situation sit49 = new Situation(0,"Правильно","Крещение Руси было в 988",1,0,0,0);
//
//            Situation sit50 = new Situation(0,"Он решил спросить другой вопрос","Кто был правителем в 988 году?" +
//                    "\n а)князь Владимир Святославич" +
//                    "\n б)Пётр 1",1,0,0,0);
//            Situation sit51 = new Situation(0,"Не правильно!","Правителем в 988 году был князь Владимир Святославич",1,0,0,0);
//            Situation sit52 = new Situation(0,"Правильно","Правителем в 988 году был князь Владимир Святославич",1,0,0,0);
//
//            Situation sit53 = new Situation(0,"Учитель истории поставил тебе 5 за то, что ты сам вызвался отвечать",
//                    "Ты сел на место...",1,0,0,0);
//
//            Situation sit54 = new Situation(0,"Урок истории прошёл быстро, учитель спросил двух ребят и мы начали новую тему",
//                    "Весь урок тебе было скучно и прозвенел долгожданный звонок на перемену ",1,0,0,0);
//
//            Situation sit55 = new Situation(0,"Ты с Максимом, после истории, пошли на Математику",
//                    "Ты любишь математику и хотешь, чтобы её было больше",1,0,0,0);
//
//            Situation sit56 = new Situation(0,"Начался урок математики","...",1,0,0,0);
//
//            Situation sit57 = new Situation(0,"Учительница подошла к доске и начала обьяснять нам новую тему",
//                    "Тебе было интересно и ты очень сильно увлёкся, что и не заметил как быстро пролетели 2 урока",1,0,0,0);
//
//            Situation sit58 = new Situation(0,"Учительница задала домашнее задание и оставалось минуты 2 до конца урока",
//                    "Она закончила урок и все одноклассники быстро выбежали из класса",1,0,0,0);
//
//            Situation sit59 = new Situation(0,"Ты собрал учебники и тетради, вышел из класса и вспомнил, что у тебя физкультура",
//                    "Тебе нужно поторопиться, чтобы успеть одеться!",1,0,0,0);
//
//            Situation sit60 = new Situation(0,"Зайдя в раздевалку, ты заметил играющих однокласников на скамейках, разбросанные вещи и рюкзаки",
//                    "Ты не стал трогать чужие вещи, так как тебе не хочется трогать чужое",1,0,0,0);
//
//            Situation sit61 = new Situation(0,"Ты переоделся и вышел в спортзал",
//                    "Прозвенел звонок и учитель построил вас в ширенгу",1,0,0,0);
//
//            Situation sit62 = new Situation(0,"Вы расчитались по порядку",
//                    "Он предложил вам проводить разминку и поиграть в мячь или начать играть мячь без разминки, что ты выбирешь?",1,0,0,0);
//
//            Situation sit63 = new Situation(0,"Лучше всего провести разминку, для того, чтобы разагреть мышцы и превести в порядок суставы",
//                    "Всегда нужно делать разминку, чтобы не случилось травмоопасное действие!",1,0,0,0);
//
//            Situation sit64 = new Situation(0,"Нужно проводить разминку каждый раз, перед занятием спарта",
//                    "Лучше всего провести разминку, для того, чтобы разагреть мышцы и превести в порядок суставы," +
//                            " чтобы не случилось травмоопасное действие!",1,0,0,0);
//            Situation sit65 = new Situation(0,"Ты предложил сделать разминку и все согласились",
//                    "Разминка заняла по времени 15-20 минут",1,0,0,0);
//            Situation sit66 = new Situation(0,"Учитель предложил сыграть в волейбол",
//                    "Весь класс согласился и вас разделили по камандам по 6 человек",1,0,0,0);
//            Situation sit67 = new Situation(0,"Вы поиграли со счётом 2:2 и осталось не много времени, учитель вас отпустил",
//                    "Ты был рад, что скоро пойдёшь домой ",1,0,0,0);
//            Situation sit68 = new Situation(0,"", "",1,0,0,0);
//            Situation sit69 = new Situation(0,"", "",1,0,0,0);
//            Situation sit70 = new Situation(0,"", "",1,0,0,0);
//            Situation sit71 = new Situation(0,"", "",1,0,0,0);
//            Situation sit72 = new Situation(0,"", "",1,0,0,0);
//
////************************************************************************************
//            insert(sit1);insert(sit2);insert(sit11);insert(sit3);insert(sit4);insert(sit5);
//            insert(sit6);insert(sit7);insert(sit12);insert(sit8);insert(sit9);insert(sit10);
//            insert(sit13);insert(sit14);insert(sit15);insert(sit16);insert(sit17);insert(sit18);
//            insert(sit19);insert(sit20);insert(sit21);insert(sit22);insert(sit23);insert(sit24);
//            insert(sit25);insert(sit26);insert(sit27);insert(sit28);insert(sit29);insert(sit30);
//            insert(sit31);insert(sit32);insert(sit33);insert(sit34);insert(sit35);insert(sit36);
//            insert(sit37);insert(sit38);insert(sit39);insert(sit40);insert(sit41);insert(sit42);
//            insert(sit43);insert(sit44);insert(sit45);insert(sit46);insert(sit47);insert(sit48);
//            insert(sit49);insert(sit50);insert(sit51);insert(sit52);insert(sit53);insert(sit54);
//            insert(sit55);insert(sit56);insert(sit57);insert(sit58);insert(sit59);insert(sit60);
//            insert(sit61);insert(sit62);insert(sit63);insert(sit64);insert(sit65);insert(sit66);
//            insert(sit67);insert(sit68);insert(sit69);insert(sit70);insert(sit71);insert(sit72);
//
//
//            Answer ans = new Answer(0,"Я пойду почистить зубы",sit2.getId(), sit1.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Для экономии времени я небуду чистить зубы", sit11.getId(), sit1.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Чистить зубы ",sit2.getId(), sit11.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее -> ",sit3.getId(), sit2.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Вернуться в комнату",sit4.getId(), sit3.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Позавтракать",sit5.getId(), sit4.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Вернуться в комнату",sit6.getId(), sit5.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Взять дневник", sit7.getId(), sit6.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Вспомнить по памяти", sit12.getId(), sit6.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Положить",sit8.getId(), sit7.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Положить",sit8.getId(), sit12.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Поторопиться",sit9.getId(), sit8.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее -> ",sit10.getId(), sit9.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Перебежать",sit13.getId(), sit10.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Дождаться зеленого света",sit14.getId(), sit10.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее -> ",sit15.getId(), sit13.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее -> ",sit15.getId(), sit14.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Поздароваться",sit17.getId(), sit16.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Не буду отвлекать",sit18.getId(), sit16.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее -> ",sit19.getId(), sit17.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее -> ",sit19.getId(), sit18.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Пойти дальше",sit20.getId(), sit19.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Зайти в класс",sit21.getId(), sit20.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Извиниться",sit22.getId(), sit21.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Пройти к своему месту",sit23.getId(), sit22.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Встать и пройти к доске",sit24.getId(), sit23.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее ->",sit25.getId(), sit24.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Просмотреть задание",sit26.getId(), sit25.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Я",sit27.getId(), sit26.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Искать дальше",sit26.getId(), sit27.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Гулял",sit28.getId(), sit26.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Искать дальше",sit26.getId(), sit28.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Один",sit29.getId(), sit26.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Искать дальше",sit26.getId(), sit29.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"По парку",sit30.getId(), sit26.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Приступить ко 2-му заданию",sit31.getId(), sit30.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Девочка",sit32.getId(), sit31.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Искать дальше",sit31.getId(), sit32.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Испачкалась",sit33.getId(), sit31.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Искать дальше",sit31.getId(), sit33.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Сладким",sit34.getId(), sit31.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Вареньем",sit35.getId(), sit31.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Искать дальше",sit31.getId(), sit35.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Повернуться к учителю",sit36.getId(), sit34.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Пройти на своё место",sit37.getId(), sit36.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее ->",sit38.getId(), sit37.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Выйти из класса",sit39.getId(), sit38.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Поздароваться с Максимом",sit40.getId(), sit39.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Пойти на историю",sit41.getId(), sit40.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Поздароваться с учителем",sit42.getId(), sit41.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Пройти мимо",sit43.getId(), sit41.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее ->",sit44.getId(), sit43.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее ->",sit45.getId(), sit44.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее ->",sit46.getId(), sit45.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Ответить",sit47.getId(), sit46.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Не отвечать",sit56.getId(), sit46.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"а) 1941",sit48.getId(), sit47.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"б) 988",sit49.getId(), sit47.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее ->",sit50.getId(), sit48.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее ->",sit50.getId(), sit49.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"а)князь Владимир Святославич",sit51.getId(), sit50.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"б)Пётр 1",sit52.getId(), sit50.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее ->",sit53.getId(), sit51.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее ->",sit53.getId(), sit42.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее ->",sit54.getId(), sit53.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Пойти на математику",sit55.getId(), sit54.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее ->",sit56.getId(), sit55.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее ->",sit57.getId(), sit56.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее ->",sit59.getId(), sit58.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Пойти на физкультуру",sit60.getId(), sit59.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Быстрее передеваться",sit61.getId(), sit60.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее ->",sit62.getId(), sit61.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Делать разминку",sit63.getId(), sit62.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Не делать разминку",sit64.getId(), sit62.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее ->",sit65.getId(), sit63.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее ->",sit65.getId(), sit64.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее ->",sit66.getId(), sit65.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Далее ->",sit67.getId(), sit66.getId());
//            answerinsert(ans);
//            ans = new Answer(0,"Пойти домой",sit68.getId(), sit67.getId());
//            answerinsert(ans);
//        }
//
//        @Override
//        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANSWER);
//            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//            onCreate(db);
//        }
//    }
}