import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    public int teste1() {
        int indice = 13, soma = 0, k = 0;

        while(k<indice){
            k++;
            soma+= k;
            System.out.println(soma);
        }
        return soma;
    }

    public boolean teste2() {
        int valor1 = 0, valor2 = 1, f = 0, procurado = 15;

        while(f < procurado){
            f = valor1+valor2;
            if(f == procurado){
                return true;
            }
            valor1 = valor2;
            valor2 = f;
        }
        return false;
    }
    public boolean teste2(int procurado) {
        int valor1 = 0, valor2 = 1, f = 0;

        while(f < procurado){
            f = valor1+valor2;
            if(f == procurado){
                return true;
            }
            valor1 = valor2;
            valor2 = f;
        }
        return false;
    }
    public void teste3(){
        ObjectMapper json = new ObjectMapper();
        try {

            int diaUtil = 0;
            FaturamentoMensal[] faturamento = json.readValue(new File("src\\main\\resources\\Dados.json"), new TypeReference<FaturamentoMensal[]>() {});

            FaturamentoMensal objMenor = faturamento[0], objMaior =faturamento[0];
            double maior =0, menor =0, media, total = 0;
            for(int i = 0; i < faturamento.length; i++){
              if(faturamento[i].getValor() > objMaior.getValor()) objMaior = faturamento[i];
              if(faturamento[i].getValor()>0)if(faturamento[i].getValor() < objMenor.getValor()) objMenor = faturamento[i];
              if(faturamento[i].getValor() > 0) diaUtil++;
              total+= faturamento[i].getValor();
            }
            media = total/diaUtil;
            System.out.println(media);
            System.out.println(objMenor);
            System.out.println(objMaior);
            System.out.println(media);
            for(int i = 0; i < faturamento.length; i++){
            if(faturamento[i].getValor() >= media) System.out.println(faturamento[i]);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void teste4() {
        Map<String, Double> cidades = new HashMap<>();
        cidades.put("SP",67836.43);
        cidades.put("RJ",36678.66);
        cidades.put("MG",29229.88);
        cidades.put("ES",27165.48);
        cidades.put("Outros estados",19849.53);
        double total = cidades.values().stream().mapToDouble(Double::doubleValue).sum();;
        System.out.println(total);

        for(Map.Entry<String, Double> cidade: cidades.entrySet()){
            double porcentagem = (cidade.getValue()*100) / total;
            cidades.put(cidade.getKey(), porcentagem);
            System.out.printf("%s: %.2f%%%n", cidade.getKey(), cidade.getValue());
        }

    }
    public void teste5() {
        String entrada = "Lacucaracha", saida = "";

        char[] letras = entrada.toCharArray();

        for(int i = (letras.length-1); i >=0; i--){
            saida+= letras[i];
        }
        System.out.println(saida);
    }
    public void teste5(String entrada) {
        String saida = "";

        char[] letras = entrada.toCharArray();

        for(int i = (letras.length-1); i >=0; i--){
            saida+= letras[i];
        }
        System.out.println(saida);
    }

    public static void main(String[] args) {
        Main iniciar = new Main();

        System.out.println("A soma final é de: " + iniciar.teste1());
        System.out.println(iniciar.teste2());
        System.out.println(iniciar.teste2(21));
        iniciar.teste4();
        iniciar.teste5();
        iniciar.teste5("Armando Cruz");
        iniciar.teste3();
    }
}