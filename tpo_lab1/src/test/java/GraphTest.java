import org.example.tasks.Graph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GraphTest {


    @DisplayName("Простой бфс на графе")
    @Test
    void BfsTest() {
        Graph graph = new Graph(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(4, 5);
        graph.addEdge(3, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(2, 1);
        graph.addEdge(4, 1);
        graph.addEdge(3, 1);
        graph.addEdge(5, 4);
        graph.addEdge(5, 3);


        int[] result = graph.BFS(0);

        Assertions.assertEquals(2, result[2]);
    }


    @DisplayName("Бфс на кольце")
    @Test
    void BfsTest2() {
        Graph graph = new Graph(6);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 0);


        int[] result = graph.BFS(0);



        Assertions.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5}, result);
    }

    @DisplayName("две компоненты связности")
    @Test
    void BfsTest3() {

        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        int[] result = graph.BFS(0);


        Assertions.assertEquals(5, result[3]);


    }



















}
