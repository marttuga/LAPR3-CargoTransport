package lapr.project.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerMaterialsTest {

    ContainerMaterials containerMaterials= new ContainerMaterials();

    @Test
    void chooseTemperature5() {
        int temperature= -5;
        String a=containerMaterials.chooseTemperature(temperature);
        String b="\nPara -5ºC, proposta dum contentor com: \nchapas externas em aço não ferroso, \ncamadas " +
                "intermédias de espuma de poliuretano, \ncamada interior de chapa inox ";

        assertEquals(a,b);
    }
    @Test
    void chooseTemperature7() {
        int temperature= 7;
        String a=containerMaterials.chooseTemperature(temperature);
        String b ="\nPara 7ºC, proposta dum contentor com: \nchapas externas em aço Corten , \ncamadas " +
                "intermédias de lã de rocha , \ncamada interior de chapa ";

        assertEquals(a,b);
    }
    @Test
    void chooseTemperatureWrong() {
        int temperature= 20;
        String a=containerMaterials.chooseTemperature(temperature);
        String b ="\nUm estudo terá de ser realizado para outras temperaturas diferentes de -5ºC e 7ºC";

        assertEquals(a,b);
    }
}