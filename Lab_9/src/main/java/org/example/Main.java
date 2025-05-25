package org.example;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Main {

    public static void main(String[] args) {
        // Створення головного вікна для програми
        JFrame frame = new JFrame("Обчислення роботи A = F * s");

        // Встановлюємо поведінку при закритті вікна (завершити програму)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Встановлюємо розмір вікна: ширина 400px, висота 250px
        frame.setSize(400, 250);

        // Використовуємо GridLayout для розташування компонентів у таблиці 5x2
        // з відступами по 10 пікселів
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        // Створення полів для вводу: сила, відстань і робота
        JTextField fText = new JTextField();
        JTextField sText = new JTextField();
        JTextField aText = new JTextField();

        // Кнопка для обчислення результату
        JButton calcButton = new JButton("Обчислити");

        // Мітка для виведення результату або повідомлень про помилки
        JLabel resultLabel = new JLabel("");

        // Додаємо мітки та відповідні поля вводу до вікна
        frame.add(new JLabel("Сила F (Н):"));
        frame.add(fText);
        frame.add(new JLabel("Відстань s (м):"));
        frame.add(sText);
        frame.add(new JLabel("Робота A (Дж):"));
        frame.add(aText);
        frame.add(calcButton);
        frame.add(resultLabel);

        // Масив для збереження валідності введених значень (F, s, A)
        boolean[] isValid = new boolean[3];

        // Створюємо Runnable для оновлення полів при введенні тексту
        Runnable updateFields = () -> {
            // Отримуємо текст з полів вводу та обрізаємо зайві пробіли
            String fStr = fText.getText().trim();
            String sStr = sText.getText().trim();
            String aStr = aText.getText().trim();

            // Перевіряємо валідність кожного введеного значення
            boolean fOk = isValidInput(fStr);
            boolean sOk = isValidInput(sStr);
            boolean aOk = isValidInput(aStr);

            // Оновлюємо масив валідності для кожного значення
            isValid[0] = fOk;
            isValid[1] = sOk;
            isValid[2] = aOk;

            // Встановлюємо, що всі поля редагуються
            fText.setEditable(true);
            sText.setEditable(true);
            aText.setEditable(true);
            resultLabel.setText("");

            // Перевіряємо, яке поле не заповнене, і відповідно виводимо підказку
            if (fOk && sOk && !aOk) {
                aText.setEditable(false); // Не можна редагувати поле "Робота"
                resultLabel.setText("Буде обчислено A = F * s");
            } else if (fOk && aOk && !sOk) {
                sText.setEditable(false); // Не можна редагувати поле "Відстань"
                resultLabel.setText("Буде обчислено s = A / F");
            } else if (sOk && aOk && !fOk) {
                fText.setEditable(false); // Не можна редагувати поле "Сила"
                resultLabel.setText("Буде обчислено F = A / s");
            }
        };

        // Створюємо слухач для оновлення полів вводу при зміні тексту
        DocumentListener listener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { updateFields.run(); }
            public void removeUpdate(DocumentEvent e) { updateFields.run(); }
            public void changedUpdate(DocumentEvent e) { updateFields.run(); }
        };

        // Додаємо слухачі для кожного з полів вводу
        fText.getDocument().addDocumentListener(listener);
        sText.getDocument().addDocumentListener(listener);
        aText.getDocument().addDocumentListener(listener);

        // Додаємо слухач для кнопки обчислення
        calcButton.addActionListener(e -> {
            try {
                // Перевіряємо, що введено два значення для обчислення
                if (isValid[0] && isValid[1] && !isValid[2]) {
                    // Обчислюємо роботу A = F * s
                    double F = Double.parseDouble(fText.getText());
                    double s = Double.parseDouble(sText.getText());
                    double A = F * s;
                    aText.setText(String.format("%.2f", A)); // Виводимо результат у поле "Робота"
                    resultLabel.setText("A = " + A + " Дж"); // Виводимо результат у мітку
                } else if (isValid[0] && !isValid[1] && isValid[2]) {
                    // Обчислюємо відстань s = A / F
                    double F = Double.parseDouble(fText.getText());
                    double A = Double.parseDouble(aText.getText());
                    if (F == 0) throw new ArithmeticException(); // Перевірка на ділення на 0
                    double s = A / F;
                    sText.setText(String.format("%.2f", s)); // Виводимо результат у поле "Відстань"
                    resultLabel.setText("s = " + s + " м");
                } else if (!isValid[0] && isValid[1] && isValid[2]) {
                    // Обчислюємо силу F = A / s
                    double s = Double.parseDouble(sText.getText());
                    double A = Double.parseDouble(aText.getText());
                    if (s == 0) throw new ArithmeticException(); // Перевірка на ділення на 0
                    double F = A / s;
                    fText.setText(String.format("%.2f", F)); // Виводимо результат у поле "Сила"
                    resultLabel.setText("F = " + F + " Н");
                } else {
                    // Якщо введено менше ніж два значення
                    resultLabel.setText("<html><font color='red'>❗ Введіть рівно 2 значення.</font></html>");
                }
            } catch (NumberFormatException ex) {
                // Якщо введено не число
                resultLabel.setText("<html><font color='red'>❗ Введено не число. Перевірте формат вводу.</font></html>");
            } catch (ArithmeticException ex) {
                // Якщо спробували поділити на 0
                resultLabel.setText("<html><font color='red'>❗ Ділення на 0. Перевірте значення сили або відстані.</font></html>");
            }
        });

        // Робимо вікно видимим
        frame.setVisible(true);
    }

    // Метод для перевірки валідності вводу (перевірка на число і перевірка, чи не від'ємне)
    private static boolean isValidInput(String str) {
        try {
            double val = Double.parseDouble(str); // Перевірка чи є число
            return val >= 0; // Число має бути не від'ємним
        } catch (Exception e) {
            return false; // Якщо не вдалося перетворити в число
        }
    }
}
