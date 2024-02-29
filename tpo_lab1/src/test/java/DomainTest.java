import org.example.tasks.third_task.Assertion;
import org.example.tasks.third_task.FeatureRate;
import org.example.tasks.third_task.HumanBeing;
import org.example.tasks.third_task.HumanFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DomainTest {

    @DisplayName("обычный тест, проверяет что все работает")
    @Test
    void defaultTest() {
        HumanBeing author = new HumanBeing("Author");
        HumanBeing zafod = new HumanBeing("Zafod Biblebrox");


        Assertion as1 = new Assertion(author, zafod, HumanFeature.АВАНТЮРИСТ, null);


        zafod.setPublicOpinion(HumanFeature.СЪЕХАЛА_КРЫША);
        zafod.setFeatureRate(FeatureRate.ОКОНЧАТЕЛЬНО_И_БЕСПОВОРОТНО);


        Assertions.assertNull(as1.getRate());
    }

    @DisplayName("обзываем человека очень много раз")
    @Test
    void casualTest() {
        HumanBeing test1 = new HumanBeing("Test1");
        HumanBeing test2 = new HumanBeing("Test2");

        Assertion as1 = new Assertion(test1, test2, HumanFeature.НАРЦИССИСТ, FeatureRate.НЕВЕРОЯТНО);
        Assertion as2 = new Assertion(test1, test2, HumanFeature.НАРЦИССИСТ, FeatureRate.НЕВЕРОЯТНО);
        Assertion as3 = new Assertion(test1, test2, HumanFeature.НАРЦИССИСТ, FeatureRate.НЕВЕРОЯТНО);
        Assertion as4 = new Assertion(test1, test2, HumanFeature.НАРЦИССИСТ, FeatureRate.НЕВЕРОЯТНО);
        Assertion as5 = new Assertion(test1, test2, HumanFeature.НАРЦИССИСТ, FeatureRate.НЕВЕРОЯТНО);
        Assertion as6 = new Assertion(test1, test2, HumanFeature.НАРЦИССИСТ, FeatureRate.НЕВЕРОЯТНО);
        Assertion as7 = new Assertion(test1, test2, HumanFeature.НАРЦИССИСТ, FeatureRate.НЕВЕРОЯТНО);
        Assertion as8 = new Assertion(test1, test2, HumanFeature.НАРЦИССИСТ, FeatureRate.НЕВЕРОЯТНО);

        Assertions.assertEquals(0, test2.getCurrentState());

    }


    @DisplayName("Обзываем и хвалим одинаковое количество раз")
    @Test
    void casualTest2() {
        HumanBeing test1 = new HumanBeing("Test1");
        HumanBeing test2 = new HumanBeing("Test2");

        double startState = test2.getCurrentState();

        Assertion as1 = new Assertion(test1, test2, HumanFeature.НАРЦИССИСТ, FeatureRate.НЕВЕРОЯТНО);
        Assertion as2 = new Assertion(test1, test2, HumanFeature.АВАНТЮРИСТ, FeatureRate.НЕВЕРОЯТНО);
        Assertion as3 = new Assertion(test1, test2, HumanFeature.НАРЦИССИСТ, FeatureRate.НЕВЕРОЯТНО);
        Assertion as4 = new Assertion(test1, test2, HumanFeature.АВАНТЮРИСТ, FeatureRate.НЕВЕРОЯТНО);
        Assertion as5 = new Assertion(test1, test2, HumanFeature.НАРЦИССИСТ, FeatureRate.НЕВЕРОЯТНО);
        Assertion as6 = new Assertion(test1, test2, HumanFeature.АВАНТЮРИСТ, FeatureRate.НЕВЕРОЯТНО);
        Assertion as7 = new Assertion(test1, test2, HumanFeature.НАРЦИССИСТ, FeatureRate.НЕВЕРОЯТНО);
        Assertion as8 = new Assertion(test1, test2, HumanFeature.АВАНТЮРИСТ, FeatureRate.НЕВЕРОЯТНО);
        Assertion as9 = new Assertion(test1, test2, HumanFeature.НАРЦИССИСТ, FeatureRate.НЕВЕРОЯТНО);
        Assertion as10 = new Assertion(test1, test2, HumanFeature.АВАНТЮРИСТ, FeatureRate.НЕВЕРОЯТНО);

        Assertions.assertEquals(startState, test2.getCurrentState());

    }

    @DisplayName("Хвалим очень много раз")
    @Test
    void casualTest3() {
        HumanBeing test1 = new HumanBeing("Test1");
        HumanBeing test2 = new HumanBeing("Test2");

        double startState = test2.getCurrentState();

        for (int i = 0; i < 5; i++) {
            new Assertion(test1, test2, HumanFeature.АВАНТЮРИСТ, FeatureRate.НЕВЕРОЯТНО);
        }

        Assertions.assertEquals(100, test2.getCurrentState());

    }


    @DisplayName("Сперва очень много раз хвалим а потом один раз обзываем")
    @Test
    void casualTest4() {
        HumanBeing test1 = new HumanBeing("Test1");
        HumanBeing test2 = new HumanBeing("Test2");

        double startState = test2.getCurrentState();

        for (int i = 0; i < 100; i++) {
            new Assertion(test1, test2, HumanFeature.АВАНТЮРИСТ, FeatureRate.НЕВЕРОЯТНО);
        }



        new Assertion(test1, test2, HumanFeature.ТЯЖЕЛЫЙ_В_ОБЩЕНИИ, FeatureRate.НЕВЕРОЯТНО);


        Assertions.assertEquals(90, test2.getCurrentState());

    }


    @DisplayName("непонятно, обзывательство или нет")
    @Test
    void casualTest5() {


        HumanBeing author = new HumanBeing("person");
        HumanBeing object = new HumanBeing("object");

        double startState = object.getCurrentState();

        Assertion as = new Assertion(author, object, HumanFeature.ЖУЛИК, null);

        Assertions.assertEquals(startState, object.getCurrentState());

    }

    @DisplayName("Проверяем что ошибка появляется корректно")
    @Test
    void testException() {
        HumanBeing author = new HumanBeing("person");
        HumanBeing object = new HumanBeing("object");

        Assertions.assertThrows(RuntimeException.class, () -> new Assertion(author, object, null, null));

    }

}
