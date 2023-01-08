// Подключаем библиотеку для работы с жидкокристаллическим
// экраном (англ. Liquid Crystal Display или просто LCD)
#include <LiquidCrystal.h>
 // на диоде, защищающем от неверной полярности, падает доля
// напряжения (англ. voltage drop). Необходимо это учитывать
#define DIODE_DROP 0.7
// Объявляем объект, для управления дисплеем. Для его создания
// необходимо указать номера пинов, к которым он подключен в
// порядке: RS E DB5 DB6 DB7 DB8
const int rs = 13, en = 12, d4 = 11, d5 = 10, d6 = 9, d7 = 8;
LiquidCrystal lcd(rs, en, d4, d5, d6, d7);
String ivan = "Eugene Shedko";
String boris = "Eugene Shedko";

void setup() {
  lcd.begin(16, 2);
  Serial.begin(9600);
}

void loop() {
  // устанавливаем курсор в позицию (0,0):
  int col1 = 0;
  int col2 = 0;
  // выводим цифры от 0 до 9:
  for (int i = 0; i < max(ivan.length(), boris.length()); i++) {
    
    if (i < ivan.length()) {
      lcd.setCursor(col1, 0);
      lcd.print(ivan[i]);
      col1++;
    }
    
    if (i < boris.length()) {
      lcd.setCursor(col2, 1);
      lcd.print(boris[i]);
      col2++;
    }
    
    lcd.scrollDisplayLeft();
    delay(100);
  }
}
