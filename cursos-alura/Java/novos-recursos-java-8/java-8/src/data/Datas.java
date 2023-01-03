package data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalDate olimpiadasJapao = LocalDate.of(2021, Month.MAY, 15);

        int anos = olimpiadasJapao.getYear() - now.getYear();

//        System.out.println(anos);

        Period periodo = Period.between(now, olimpiadasJapao);
        System.out.println(periodo.getYears());
        System.out.println(periodo.getMonths());
        System.out.println(periodo.getDays());

        LocalDate plusYears = olimpiadasJapao.plusYears(4);
        System.out.println(plusYears);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String novaData = plusYears.format(formatador);
        System.out.println(novaData);

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        System.out.println(agora.format(formatadorComHoras));


    }
}
