import java.util.ArrayList;
import java.util.Scanner;

public class Practicum {
    public static void main(String[] args) {


        actionChoose();

    }

    public static class stats {
        static ArrayList animals = new ArrayList();
    }

    public static byte actionChoose (){
        Scanner input = new Scanner(System.in);
        System.out.println("""
                
                Выберите действие: 
                1. Показать список всех животных в зоопарке.
                2. Добавить животное в список.
                3. Удалить животное из списка.
                4. Очистить список
                5. Проверка наличия животного в зоопарке
                6. Выход""");
        byte chosseAct = input.nextByte();
        if (0 < chosseAct && chosseAct <= 6)
                menu(chosseAct);
        else{
            System.out.println("Ошибка! Не верный вариант ответа.");
            actionChoose();
        }
        return 0;
    }

    public static void menu(byte i){
        if (i == 1)
            showAnimals();
        else if (i == 2)
            addAnimal();
        else if (i == 3)
            removeAnimal();
        else if (i == 4){
            clearAllAnimals();
        }
        else if (i == 5){
            checkAnimal();
        }
        else
            System.exit(0);
    }

    public static void showAnimals(){
        if (stats.animals.size() >= 1) {
            System.out.println("Список животных:");
            for (int i = 0; i < stats.animals.size(); i++) {
                System.out.println((i+1) + ". " + stats.animals.get(i));
            }
        }
        else
            System.out.println("Список животных пуст.");
        actionChoose();
    }

    public static void addAnimal(){
        Scanner input = new Scanner(System.in);
        System.out.println("Введите название животного");
        String animal = input.nextLine();
        stats.animals.add(animal);
        System.out.println("""
                   Список успешно обновлён!
                   Желаете добавить ещё животных?
                   1. Да
                   2. Нет""");
        byte checker = input.nextByte();
        if (checker == 1)
            addAnimal();
        else if (checker == 2)
            actionChoose();
        else{
            System.out.println("Введено некорректное значение!\nВы отправлены на главное меню.");
            actionChoose();
        }
    }

    public static void removeAnimal(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название животного которого вы хотите удалить:");
        String animalName = in.nextLine();
        if (stats.animals.contains(animalName)){
            short i = (short)stats.animals.indexOf(animalName);
            stats.animals.remove(i);
        }
        else
            System.out.println("Данное жиаотное не найдено!");
        System.out.println("""
                Хотите удалить из списка какое-нибудь другое животное?
                1. Да
                2. Нет""");
        byte checker = in.nextByte();
        if (checker == 1)
            removeAnimal();
        else if (checker == 2)
            actionChoose();
        else {
            System.out.println("Введено некорректное значение!\nВы отправлены на главное меню.");
            actionChoose();
        }
    }

    public static void checkAnimal() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите интересующее вас животное:");
        String animalName = in.nextLine();
        if (stats.animals.contains(animalName)) {
            System.out.println("Да, в нашем зоопарке есть " + animalName);
        }
        else
            System.out.println("К сожалению, в нашем зоопарке нет таких животных как " + animalName);
        System.out.println("""
                   Хотие посмотреть наличие других животных?
                   1. Да
                   2. Нет""");
        byte checker = in.nextByte();
        if (checker == 1)
            checkAnimal();
        else if (checker == 2)
            actionChoose();
        else {
            System.out.println("Введено некорректное значение!\nВы отправлены на главное меню.");
            actionChoose();
        }
    }

    public static void clearAllAnimals(){
        Scanner input = new Scanner(System.in);
        System.out.println("Вы точно хотите очистить ВЕСЬ список?\n1. Да\n2. Нет ");
        byte checker = input.nextByte();
        int controll = 0;
        if (checker == 1 && !stats.animals.isEmpty()){
            for (int i = stats.animals.size() -1; i >= 0; i--, controll++){
                stats.animals.remove(i);
            }
            System.out.println("Поздравляем!\nСписок успешно очищен!\n Удалено " + controll + " записей.");
            actionChoose();
        }
        else if (stats.animals.isEmpty()){
            System.out.println("Cписок уже пуст!\nВы отправлены на главное меню.");
            actionChoose();
        }
        else if (checker == 2){
            System.out.println("Мы рады что вы не стали все удалять)");
            actionChoose();
        }
        else {
            System.out.println("Введено некорректное значение!\nВы отправлены на главное меню.");
            actionChoose();
        }
    }
}
