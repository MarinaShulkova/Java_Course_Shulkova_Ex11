import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        StringBuilder string = new StringBuilder();
        string.insert(0,"|Ivanov Ivan|+79033234567|ivanov@mail.ru|Moscow/");
        string.append("|Petrov Petr|89029874532|petrov@gmail.com|Kazan/");
        string.append("|Sidorov Sidor|+375908880033|sidro@yandex.by|Minsk/");

        System.out.println(string);

        Pattern p_phone = Pattern.compile("\\+?\\d{10,}");
        Pattern p_fio = Pattern.compile("[a-zA-Z]+\\s[a-zA-Z]+");
        Pattern p_email = Pattern.compile("[a-zA-Z]+[@][a-z.]+");
        Pattern p_city = Pattern.compile("[a-zA-Z]+[/]");


        Matcher m_phone = p_phone.matcher(string);
        Matcher m_fio = p_fio.matcher(string);
        Matcher m_email = p_email.matcher(string);
        Matcher m_city = p_city.matcher(string);

        while (m_phone.find()){
            if (m_phone.group().charAt(0)=="8") m_phone.group().replace(0,2,"+7");
        }
        while (m_fio.find()) System.out.println(m_fio.group());
        while (m_email.find()) System.out.println(m_email.group());
        while (m_city.find()) System.out.println(m_city.group());


    }
}
