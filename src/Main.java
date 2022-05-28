import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int count_moscow = 0;
        int count_male = 0;
        StringBuilder string = new StringBuilder();
        string.insert(0,"Ivanov Ivan +79033234567 ivanov@mail.ru Moscow, Petrov Petr 89029874532 petrov@gmail.com Kazan, ");
        string.append("Kuznetsova Anna kuzanna@mail.ru Moscow, Lozhkina Maria 123 Kazan, ");
        string.append("Sidorov Sidor +375908880033 sidro@yandex.by Minsk, Shulkov Kirill +1110134 spy@pentagon.org ");

        System.out.println("Original StringBuilder: \n" + string + "\n");

        Pattern p_phone = Pattern.compile("\\+?\\d{10,}");
        Pattern p_phone8 = Pattern.compile("[8]\\d{10,}");

        Pattern p_fio = Pattern.compile("[a-zA-Z]+\\s[a-zA-Z]+\\s");
        Pattern p_email = Pattern.compile("[a-zA-Z]+[@][a-z.]+");
        Pattern p_male = Pattern.compile("ov\\s");
        Pattern p_city = Pattern.compile("Moscow");
        Pattern p_spy = Pattern.compile("\\+1.+\\.org");

        Matcher m_phone = p_phone.matcher(string);
        Matcher m_phone8 = p_phone8.matcher(string);

        Matcher m_fio = p_fio.matcher(string);
        Matcher m_email = p_email.matcher(string);
        Matcher m_city = p_city.matcher(string);
        Matcher m_male = p_male.matcher(string);
        Matcher m_spy = p_spy.matcher(string);
        System.out.println("Phone numbers >10 digits: ");
        while (m_phone.find()) System.out.println(m_phone.group());
        System.out.println();
        System.out.println("Change 8 to +7: ");
        while (m_phone8.find()) System.out.println(m_phone8.group().replaceFirst("[8]","+7"));
        System.out.println();
        System.out.println("Print all FIOs: ");
        while (m_fio.find()) System.out.println(m_fio.group());
        System.out.println();
        System.out.println("Print all E-mails:");
        while (m_email.find()) System.out.println(m_email.group());
        System.out.println();
        System.out.print("Quantity of people who lives in Moscow: ");
        while (m_city.find()) {count_moscow ++;} System.out.println(count_moscow);
        System.out.print("Quantity of men: ");
        while (m_male.find()) {count_male++;} System.out.println(count_male);
        System.out.print("Spy has been unmasked: ");
        while (m_spy.find()) System.out.print(m_spy.group());

    }
}
