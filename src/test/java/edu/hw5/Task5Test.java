package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task5.isLicencePlateNumberValid;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {

    @Test
    @DisplayName("Примеры валидных номеров")
    void test1() {
        assertThat(isLicencePlateNumberValid("А123ВЕ777")).isTrue();
        assertThat(isLicencePlateNumberValid("О777ОО177")).isTrue();
    }

    @Test
    @DisplayName("Примеры невалидных номеров")
    void test2() {
        assertThat(isLicencePlateNumberValid("123АВЕ777")).isFalse();
        assertThat(isLicencePlateNumberValid("А123ВГ77")).isFalse();
        assertThat(isLicencePlateNumberValid("А123ВЕ7777")).isFalse();
    }

    @Test
    @DisplayName("Примеры валидных номеров с двумя цифрами в коде региона")
    void test3() {
        assertThat(isLicencePlateNumberValid("А123ВЕ77")).isTrue();
        assertThat(isLicencePlateNumberValid("О777ОО17")).isTrue();
    }

    @Test
    @DisplayName("Примеры невалидных номеров с буквами не имеющими аналога в английском языке")
    void test4() {
        assertThat(isLicencePlateNumberValid("А123ВП77")).isFalse();
        assertThat(isLicencePlateNumberValid("А123ЙВ77")).isFalse();

    }
}
