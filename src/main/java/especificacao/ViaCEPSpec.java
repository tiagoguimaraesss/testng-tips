package especificacao;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ViaCEPSpec {

    private ViaCEPSpec() {
        throw new UnsupportedOperationException("Está é uma classe utilitária e não pode ser instanciada!");
    }

    public static RequestSpecification getSpec() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://viacep.com.br");
        requestSpecBuilder.setBasePath("/ws");

        return requestSpecBuilder.build();
    }

}
