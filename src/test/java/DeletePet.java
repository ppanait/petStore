import com.petstore.Steps.Steps;
import com.petstore.pojo.Request.Pet;
import com.petstore.utils.DataGenerator;
import org.testng.annotations.Test;

public class DeletePet extends BaseTest{
    private final Steps petSteps = new Steps();
    private final Pet fullDataPet = DataGenerator.createPetWithFullDetails();

    @Test
    public void deletePet() {
        petSteps.createPet(fullDataPet)
                .deletePet(fullDataPet.getId().toString())
                .getNoPetById(fullDataPet.getId().toString());
    }
}
