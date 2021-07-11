import modelos.EnderecoPostal;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class BuscaEnderecoPorCEPTest {

    @Test
    public void deveriaBuscarEnderecoPorCEPValidoTest() {
        EnderecoPostal enderecoPostalDoCEPInformado = given().
                                                          baseUri("https://viacep.com.br").
                                                          basePath("/ws").
                                                          pathParam("cep", 90010120).
                                                      when().
                                                          get("/{cep}/json").
                                                      then().
                                                          statusCode(SC_OK).
                                                          extract().as(EnderecoPostal.class);
    }

}
