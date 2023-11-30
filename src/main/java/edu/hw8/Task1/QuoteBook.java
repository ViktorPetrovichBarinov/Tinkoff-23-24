package edu.hw8.Task1;

import java.util.ArrayList;

public class QuoteBook {
    private ArrayList<String> dictionary = new ArrayList<>();

    public QuoteBook() {
        dictionary.addLast("Не переходи на личности там, где их нет.");
        dictionary.addLast("Не позволяй школе вмешиваться в твоё образование.");
        dictionary.addLast("Сходят с ума только те, у кого он есть.");
        dictionary.addLast("У меня отличная память на лица, но для вас она сделает исключение.");
        dictionary.addLast("Не надо мне по два раза повторять одно и то же. Мне и с первого раза не интересно.");
        dictionary.addLast("Глупые мысли редко запаздывают.");
        dictionary.addLast("Ревность - это болезнь… выздоравливай скорее.");
        dictionary.addLast("Что я сделал, чтобы у тебя сложилось впечатление,"
                                   + " что меня действительно волнует то, что ты думаешь?");
        dictionary.addLast("Я бы согласился с тобой, но тогда мы оба были бы неправы.");
        dictionary.addLast("Зеркала не умеют говорить, к счастью для тебя, они также не умеют смеяться.");
        dictionary.addLast("Чистая совесть - признак плохой памяти.");
        dictionary.addLast("Если твои противники перешли на личные оскорбления,"
                                   + " будь уверена — твоя победа не за горами.");
        dictionary.addLast("А я тебе говорил, что ты глупый? Так вот,"
                                   + " я забираю свои слова обратно... Ты просто бог идиотизма.");
        dictionary.addLast("Чем ниже интеллект, тем громче оскорбления.");
    }

    public ArrayList<String> quoteFinderByKeyWord(String key) {
        int dictionaryLength = dictionary.size();
        String lowerKey = key.toLowerCase();
        ArrayList<String> quotesWithKeyWord = new ArrayList<>();
        for (int i = 0; i < dictionaryLength; i++) {
            if (dictionary.get(i).toLowerCase().contains(lowerKey)) {
                quotesWithKeyWord.add(dictionary.get(i));
            }
        }
        if (quotesWithKeyWord.isEmpty()) {
            return null;
        }
        return quotesWithKeyWord;
    }
}
