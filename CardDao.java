import java.io.FileNotFoundException;
import java.util.List;

public interface CardDao {

    List<Card> getCards() throws FileNotFoundException;

}
