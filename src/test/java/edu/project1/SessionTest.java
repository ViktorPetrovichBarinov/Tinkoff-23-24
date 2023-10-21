package edu.project1;

import edu.hw1.EvenArrayUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SessionTest {

    @Test
    @DisplayName("стандартный алфавит")
    void test1() {
        Session session = new Session("word");

        String ans = "a b c d e f g h i j k l m n o p q r s t u v w x y z";

        assertThat(ans).isEqualTo(session.availableLetters());
    }

    @Test
    @DisplayName("алфавит без первых 7 букв")
    void test2() {
        Session session = new Session("wxyz");
        session.tryLetter('a');
        session.tryLetter('b');
        session.tryLetter('c');
        session.tryLetter('d');
        session.tryLetter('e');
        session.tryLetter('f');
        session.tryLetter('g');

        String ans = "h i j k l m n o p q r s t u v w x y z";

        assertThat(ans).isEqualTo(session.availableLetters());
    }

    @Test
    @DisplayName("алфавит без последних 7 букв")
    void test3() {
        Session session = new Session("abcd");
        session.tryLetter('z');
        session.tryLetter('y');
        session.tryLetter('w');
        session.tryLetter('x');
        session.tryLetter('v');
        session.tryLetter('u');
        session.tryLetter('t');

        String ans = "a b c d e f g h i j k l m n o p q r s";

        assertThat(ans).isEqualTo(session.availableLetters());
    }

    @Test
    @DisplayName("ни одной буквы не угадано")
    void test4() {
        Session session = new Session("abcd");
        session.tryLetter('z');
        session.tryLetter('y');
        session.tryLetter('w');
        session.tryLetter('x');
        session.tryLetter('v');
        session.tryLetter('u');
        session.tryLetter('t');

        String ans = "****";

        assertThat(ans).isEqualTo(session.currentUserWord());
    }

    @Test
    @DisplayName("все буквы угаданы")
    void test5() {
        Session session = new Session("xvut");
        session.tryLetter('z');
        session.tryLetter('y');
        session.tryLetter('w');
        session.tryLetter('x');
        session.tryLetter('v');
        session.tryLetter('u');
        session.tryLetter('t');

        String ans = "xvut";

        assertThat(ans).isEqualTo(session.currentUserWord());
    }

    @Test
    @DisplayName("корректный ввод")
    void test6() {
        Session session = new Session("xvut");
        boolean ans = true;
        for (char tmp = 'a'; tmp <= 'z'; tmp ++) {
            assertThat(ans).isEqualTo(session.correctInput(Character.toString(tmp)));
        }
    }

    @Test
    @DisplayName("Некорректный ввод")
    void test7() {
        Session session = new Session("xvut");
        boolean ans = false;
        for (char tmp = 'a'; tmp <= 'z'; tmp ++) {
            assertThat(ans).isEqualTo(session.correctInput(Character.toString(tmp - 'a' + 'A')));
        }
    }

    @Test
    @DisplayName("Корректный ввод")
    void test8() {
        Session session = new Session("xvut");
        boolean ans = true;
        assertThat(ans).isEqualTo(session.tryLetter('x'));
    }

    @Test
    @DisplayName("Некорректный ввод")
    void test9() {
        Session session = new Session("xvut");
        boolean ans = false;
        assertThat(ans).isEqualTo(session.tryLetter('e'));
    }

    @Test
    @DisplayName("Тест количества ошибок")
    void test10() {
        Session session = new Session("xvut");
        boolean ans = true;
        session.tryLetter('a');
        assertThat(ans).isEqualTo(session.mistakesUp());
        session.tryLetter('b');
        assertThat(ans).isEqualTo(session.mistakesUp());
        session.tryLetter('c');
        assertThat(ans).isEqualTo(session.mistakesUp());
        session.tryLetter('d');
        assertThat(ans).isEqualTo(session.mistakesUp());
        session.tryLetter('e');
        assertThat(ans).isEqualTo(session.mistakesUp());
        session.tryLetter('f');
        assertThat(ans).isEqualTo(session.mistakesUp());
        session.tryLetter('g');
        assertThat(ans).isEqualTo(session.mistakesUp());

        ans = false;
        session.tryLetter('a');
        assertThat(ans).isEqualTo(session.mistakesUp());
    }

    @Test
    @DisplayName("отгадал слово")
    void test11() {
        Session session = new Session("game");
        boolean ans = false;

        session.tryLetter('g');
        assertThat(ans).isEqualTo(session.guessTheWord());
        session.tryLetter('a');
        assertThat(ans).isEqualTo(session.guessTheWord());
        session.tryLetter('m');
        assertThat(ans).isEqualTo(session.guessTheWord());

        session.tryLetter('e');
        ans = true;
        assertThat(ans).isEqualTo(session.guessTheWord());
    }
}
