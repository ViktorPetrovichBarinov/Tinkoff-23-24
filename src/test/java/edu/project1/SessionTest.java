package edu.project1;

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
        session.isTryLetter('a');
        session.isTryLetter('b');
        session.isTryLetter('c');
        session.isTryLetter('d');
        session.isTryLetter('e');
        session.isTryLetter('f');
        session.isTryLetter('g');

        String ans = "h i j k l m n o p q r s t u v w x y z";

        assertThat(ans).isEqualTo(session.availableLetters());
    }

    @Test
    @DisplayName("алфавит без последних 7 букв")
    void test3() {
        Session session = new Session("abcd");
        session.isTryLetter('z');
        session.isTryLetter('y');
        session.isTryLetter('w');
        session.isTryLetter('x');
        session.isTryLetter('v');
        session.isTryLetter('u');
        session.isTryLetter('t');

        String ans = "a b c d e f g h i j k l m n o p q r s";

        assertThat(ans).isEqualTo(session.availableLetters());
    }

    @Test
    @DisplayName("ни одной буквы не угадано")
    void test4() {
        Session session = new Session("abcd");
        session.isTryLetter('z');
        session.isTryLetter('y');
        session.isTryLetter('w');
        session.isTryLetter('x');
        session.isTryLetter('v');
        session.isTryLetter('u');
        session.isTryLetter('t');

        String ans = "****";

        assertThat(ans).isEqualTo(session.currentUserWord());
    }

    @Test
    @DisplayName("все буквы угаданы")
    void test5() {
        Session session = new Session("xvut");
        session.isTryLetter('z');
        session.isTryLetter('y');
        session.isTryLetter('w');
        session.isTryLetter('x');
        session.isTryLetter('v');
        session.isTryLetter('u');
        session.isTryLetter('t');

        String ans = "xvut";

        assertThat(ans).isEqualTo(session.currentUserWord());
    }

    @Test
    @DisplayName("корректный ввод")
    void test6() {
        Session session = new Session("xvut");
        boolean ans = true;
        for (char tmp = 'a'; tmp <= 'z'; tmp ++) {
            assertThat(ans).isEqualTo(session.isCorrectInput(Character.toString(tmp)));
        }
    }

    @Test
    @DisplayName("Некорректный ввод")
    void test7() {
        Session session = new Session("xvut");
        boolean ans = false;
        for (char tmp = 'a'; tmp <= 'z'; tmp ++) {
            assertThat(ans).isEqualTo(session.isCorrectInput(Character.toString(tmp - 'a' + 'A')));
        }
    }

    @Test
    @DisplayName("Корректный ввод")
    void test8() {
        Session session = new Session("xvut");
        boolean ans = true;
        assertThat(ans).isEqualTo(session.isTryLetter('x'));
    }

    @Test
    @DisplayName("Некорректный ввод")
    void test9() {
        Session session = new Session("xvut");
        boolean ans = false;
        assertThat(ans).isEqualTo(session.isTryLetter('e'));
    }

    @Test
    @DisplayName("Тест количества ошибок")
    void test10() {
        Session session = new Session("xvut");
        boolean ans = true;
        session.isTryLetter('a');
        assertThat(ans).isEqualTo(session.isMistakeCheck());
        session.isTryLetter('b');
        assertThat(ans).isEqualTo(session.isMistakeCheck());
        session.isTryLetter('c');
        assertThat(ans).isEqualTo(session.isMistakeCheck());
        session.isTryLetter('d');
        assertThat(ans).isEqualTo(session.isMistakeCheck());
        session.isTryLetter('e');
        assertThat(ans).isEqualTo(session.isMistakeCheck());
        session.isTryLetter('f');
        assertThat(ans).isEqualTo(session.isMistakeCheck());
        session.isTryLetter('g');
        assertThat(ans).isEqualTo(session.isMistakeCheck());

        ans = false;
        session.isTryLetter('a');
        assertThat(ans).isEqualTo(session.isMistakeCheck());
    }

    @Test
    @DisplayName("отгадал слово")
    void test11() {
        Session session = new Session("game");
        boolean ans = false;

        session.isTryLetter('g');
        assertThat(ans).isEqualTo(session.isGuessTheWord());
        session.isTryLetter('a');
        assertThat(ans).isEqualTo(session.isGuessTheWord());
        session.isTryLetter('m');
        assertThat(ans).isEqualTo(session.isGuessTheWord());

        session.isTryLetter('e');
        ans = true;
        assertThat(ans).isEqualTo(session.isGuessTheWord());
    }
}
