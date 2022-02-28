import com.petstore.Steps.Steps;
import com.petstore.pojo.Request.Pet;
import com.petstore.utils.DataGenerator;
import org.testng.annotations.Test;

public class CheckExistingPet extends BaseTest {

    private final Steps petSteps = new Steps();
    private final Pet fullDataPet = DataGenerator.createPetWithFullDetails();
    private final String notFoundId = "-1";

    @Test
    public void getPet(){
        petSteps.createPet(fullDataPet).assertPet(fullDataPet);
    }

    @Test
    public void getPetNegative(){
        petSteps.getNoPetById(notFoundId);
    }
}
