package lapr.project.services;

public class ContainerMaterials {

    public String chooseTemperature(int temperature){
        String materials;
        if (temperature==-5){
            materials= "\nPara -5ºC, proposta dum contentor com: \nchapas externas em aço não ferroso, \ncamadas " +
                   "intermédias de espuma de poliuretano, \ncamada interior de chapa inox ";

        }else if (temperature==7){
             materials=  "\nPara 7ºC, proposta dum contentor com: \nchapas externas em aço Corten , \ncamadas " +
                    "intermédias de lã de rocha , \ncamada interior de chapa ";

        }else {
            materials= "\nUm estudo terá de ser realizado para outras temperaturas diferentes de -5ºC e 7ºC";
        }
     return materials;
    }
}
