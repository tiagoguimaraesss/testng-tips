import especificacao.ViaCEPSpec;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;

public class BuscaCEPPorEstadoTest {

    Map<String, String> parametrosDePesquisa;

    @BeforeMethod(onlyForGroups = "valido")
    public void montaOsParametrosDePesquisa() {
        parametrosDePesquisa = new HashMap<>();
        parametrosDePesquisa.put("estado", "RS");
        parametrosDePesquisa.put("cidade", "Porto Alegre");
        parametrosDePesquisa.put("logradouro", "João Goulart");
    }

    @Test(description = "Busca número de CEP por estado, cidade e logradouro", groups = "valido")
    public void deveriaBuscarCEPPorEstadoCidadeELogradouroValidoTest() {
        given().
             spec(ViaCEPSpec.getSpec()).
             pathParams(parametrosDePesquisa).
        when().
             get("{estado}/{cidade}/{logradouro}/json").
        then().
             statusCode(SC_OK).
             body("[0].cep", equalTo("90010-120"));
    }

    @Test(description = "Busca número de CEP por estado apenas e retorna erro", groups = "invalido")
    public void deveriaRetornarErroAoBuscarCEPPorEstadoTest() {
        given().
             spec(ViaCEPSpec.getSpec()).
             pathParam("estado", "RS").
        when().
             get("{estado}/json").
        then().
             statusCode(SC_BAD_REQUEST);
    }

}
