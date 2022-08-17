import java.sql.*;
import java.util.concurrent.Callable;

public class AcolyteTest{

    public static Statement stat;
    public static ResultSet resSet;
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:My_cats.db");
            System.out.println("Connected");
            stat = connection.createStatement();
            stat.execute("CREATE TABLE if not exists 'types' ('id' INTEGER PRIMARY KEY AUTOINCREMENT , 'type' text NOT NULL);");
            stat.execute("CREATE TABLE if not exists 'cats' ('id' INTEGER PRIMARY KEY NOT NULL ,'type_id' INTEGER NOT NULL  , 'name' text NOT NULL, 'age' INTEGER , 'weight' double NOT NULL, FOREIGN KEY (type_id) REFERENCES types(id));");









            } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        get_type(2);


    }
    static String[] types = new String[]{"Абиссинская кошка",
            "Австралийский мист",
            "Американская жесткошерстная",
            "Американская короткошерстная",
            "Американский бобтейл",
            "Американский кёрл",
            "Балинезийская кошка",
            "Бенгальская кошка",
            "Бирманская кошка",
            "Бомбейская кошка",
            "Бразильская короткошёрстная",
            "Британская длинношерстная",
            "Британская короткошерстная",
            "Бурманская кошка",
            "Бурмилла кошка",
            "Гавана",
            "Гималайская кошка",
            "Девон-рекс",
            "Донской сфинкс",
            "Европейская короткошерстная",
            "Египетская мау",
            "Канадский сфинкс",
            "Кимрик",
            "Корат",
            "Корниш-рекс",
            "Курильский бобтейл",
            "Лаперм",
            "Манчкин",
            "Мейн-ку́н",
            "Меконгский бобтейл",
            "Мэнкс кошка",
            "Наполеон",
            "Немецкий рекс",
            "Нибелунг",
            "Норвежская лесная кошка",
            "Ориентальная кошка",
            "Оцикет",
            "Персидская кошка",
            "Петерболд",
            "Пиксибоб",
            "Рагамаффин",
            "Русская голубая кошка",
            "Рэгдолл",
            "Саванна",
            "Селкирк-рекс",
            "Сиамская кошка",
            "Сибирская кошка",
            "Сингапурская кошка",
            "Скоттиш-фолд",
            "Сноу-шу",
            "Сомалийская кошка",
            "Тайская кошка",
            "Тойгер",
            "Тонкинская кошка",
            "Турецкая ангорская кошка",
            "Турецкий ван",
            "Украинский левкой",
            "Чаузи",
            "Шартрез",
            "Экзотическая короткошерстная",
            "Японский бобтейл"
    };
        public static void addType(String type) throws SQLException {
          stat.execute("INSERT INTO 'types' ('type') VALUES ('"+type+"');");
        }
        public static void addAll(String[] all ) throws SQLException {
            for(int i=0;i<types.length;i++){
            stat.execute("INSERT INTO 'types'('type') VALUES ('"+types[i]+"');");}
        }
        public static void delete_type(int id) throws SQLException {stat.execute("DELETE FROM 'types' WHERE id=='"+id+"';");}
    public  static void update_type(int id ,String type) throws SQLException {stat.execute("UPDATE 'types' SET 'type'=='"+type+"' WHERE id=='"+id+"';");}
        public  static void get_type(int id) throws SQLException {
            resSet=stat.executeQuery("SELECT * FROM 'types' WHERE id=="+id+";");
             while(resSet.next()){
                 String type = resSet.getString("type");
                 System.out.print(type);

             }

        }
    public static  void get_type(String where) throws SQLException {
            resSet=stat.executeQuery("SELECT * FROM 'types'  WHERE "+where+";");
        while(resSet.next())
        {
            String type = resSet.getString("type");
                System.out.println("type : "+ type );
            }
        }
    public static void get_all_types() throws SQLException {
            resSet =stat.executeQuery("SELECT * FROM types;");
            while(resSet.next()){
                String type = resSet.getString("type");
                System.out.println("type all: "+ type);
            }
    }


}
