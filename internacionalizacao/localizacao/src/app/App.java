package app;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class App {
    public static void main(String[] args) throws Exception {
        Locale ptBr = new Locale("pt", "BR");

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, ptBr);
        System.out.println(dateFormat.format(new Date()));

        DateFormat timeFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, ptBr);
        System.out.println(timeFormat.format(new Date()));

        NumberFormat numberFormat = NumberFormat.getNumberInstance(ptBr); // para números
        System.out.println(numberFormat.format(13.23));

        NumberFormat moedaFormat = NumberFormat.getCurrencyInstance(ptBr); // para moedas
        System.out.println(moedaFormat.format(13.23));

        String mensagemParametrizada = "Isto foi um post sobre {0} e {1}.";
        String mensagem = MessageFormat.format(mensagemParametrizada, "i18n", "formatação");
        System.out.println(mensagem);

    }
}