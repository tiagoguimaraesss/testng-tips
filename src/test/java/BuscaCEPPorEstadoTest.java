import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;

public class BuscaCEPPorEstadoTest {

    Map<String, String> parametrosDePesquisa;

    @BeforeMethod
    public void montaOsParametrosDePesquisa() {
        parametrosDePesquisa = new HashMap<>();
        parametrosDePesquisa.put("estado", "RS");
        parametrosDePesquisa.put("cidade", "Porto Alegre");
        parametrosDePesquisa.put("logradouro", "João Goulart");
    }

    @Test(description = "Busca número de CEP por estado, cidade e logradouro")
    public void deveriaBuscarCEPPorEstadoCidadeELogradouroValidoTest() {
        given().
             baseUri("https://viacep.com.br").
             basePath("/ws").
             pathParams(parametrosDePesquisa).
        when().
             get("{estado}/{cidade}/{logradouro}/json").
        then().
             statusCode(SC_OK).
             body("[0].cep", equalTo("90010-120"));
    }

}
