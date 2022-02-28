import com.petstore.Steps.Steps;
import com.petstore.pojo.Request.Pet;
import com.petstore.utils.DataGenerator;
import org.testng.annotations.Test;

public class UpdatePet extends BaseTest{

    private final Steps petSteps = new Steps();
    private final Pet fullDataPet = DataGenerator.createPetWithFullDetails();
    private final Pet updatedPet = fullDataPet.toBuilder().name("SayMyName").build();

    @Test
    public void updateFullDataPet() {
        petSteps.createPet(fullDataPet)
                .putPet(updatedPet);
    }
}

