import modelos.EnderecoPostal;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static especificacao.ViaCEPSpec.getSpec;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

public class BuscaEnderecoPorCEPTest {

    @Test(dataProvider = "cepsValidos")
    public void deveriaBuscarEnderecoPorCEPValidoTest(int cep, EnderecoPostal enderecoPostalEsperado) {
        EnderecoPostal enderecoPostalAtual = given().
                                                 spec(getSpec()).
                                                 pathParam("cep", cep).
                                             when().
                                                 get("/{cep}/json").
                                             then().
                                                 statusCode(SC_OK).
                                                 extract().as(EnderecoPostal.class);

        assertThat(enderecoPostalAtual).usingRecursiveComparison().isEqualTo(enderecoPostalEsperado);
    }

    @DataProvider(name = "cepsValidos")
    private static Object[][] cepsValidos() {
        EnderecoPostal enderecoPostalEsperado = new EnderecoPostal("90010-120", "Avenida Presidente João Goulart", "",
                                                                  "Centro Histórico", "Porto Alegre", "RS",
                                                                   "4314902", "", "51", "8801");

        return new Object[][] {
                {90010120, enderecoPostalEsperado}
        };
    }

}
