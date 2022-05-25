import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        StringBuilder string = new StringBuilder();
        string.insert(0,"Ivanof Ivan 89033234567 ivanov@mail.ru Moscow \n");
        string.append("Petrof Petr +79029874532 petrov@gmail.com Kazan \n");
        string.append("Dronof Dron +375908880033 dronov_dron@yandex.by Minsk ");

        Pattern p_phone = Pattern.compile("\s\\d{10,}\s");
        Pattern p_fio = Pattern.compile("[a-zA-Z]+");

        Matcher m_phone = p_phone.matcher(string);
        Matcher m_fio = p_fio.matcher(string);

        while (m_phone.find()) System.out.println(m_phone.group());
        while (m_fio.find()) System.out.println(m_fio.group());

    }
}
