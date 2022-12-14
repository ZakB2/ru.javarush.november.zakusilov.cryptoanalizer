package ru.javarush.november.zakusilov.cryptoanalizer.utils;

import java.util.Scanner;

public class KeyInput {

    private KeyInput() {
    }

    private static final String ERROR_TEXT = "Ошибка, введено неверное значение ключа.";

    public static int keyTest(Scanner scanner, int charactersNumber) {
        int key = 0;
        while (key < 1 || key >= charactersNumber) {
            ReaderWriter.printLine("Введите ключ шифрования. Ключ должен быть целым положительным числом.");
            try {
                key = Integer.parseInt(scanner.nextLine());
                if (key < 1) {
                    ReaderWriter.printErrorLine(ERROR_TEXT + "\b, ключ не может быть меньше 1.");
                }
                if (key >= charactersNumber) {
                    if (key % charactersNumber != 0) {
                        key = key % charactersNumber;
                    } else {
                        ReaderWriter.printErrorLine(ERROR_TEXT + "\b, данное значение не применимо.");
                    }
                }
            } catch (NumberFormatException e) {
                ReaderWriter.printErrorLine(ERROR_TEXT + "\b, ключ не может быть вещественным числом или текстом.");
            }
        }
        return key;
    }
}