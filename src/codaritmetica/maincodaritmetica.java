package codaritmetica;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import sun.security.krb5.internal.crypto.Des;

import javax.xml.soap.SAAJResult;
import javax.xml.soap.Text;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class maincodaritmetica implements Initializable {

    //TABLECOLUMNS

    public TableColumn sicoldescod;
    public TableColumn picoldescod;
    public TableColumn probcumdescod;
    public TableColumn sicol;
    public TableColumn picol;
    public TableColumn subintcol;


    //TEXTFIELDS

    public TextField getSiDescod;
    public TextField probcumdescod1;
    public TextField getSi;
    public TextField getPi;
    public TextField subinter;
    public TextField dadosinseridos;
    public TextField upLine1;
    public TextField downLine1;
    public TextField upLine2;
    public TextField downLine2;
    public TextField upLine3;
    public TextField downLine3;
    public TextField upLine4;
    public TextField downLine4;
    public TextField upLine5;
    public TextField downLine5;
    public TextField upLine6;
    public TextField downLine6;
    public TextField upLine7;
    public TextField downLine7;
    public TextField upLine8;
    public TextField downLine8;
    public TextField upLine9;
    public TextField downLine9;
    public TextField upLine10;
    public TextField downLine10;
    public TextField upLine11;
    public TextField downLine11;
    public TextField upLine12;
    public TextField downLine12;
    public TextField char1;
    public TextField char2;
    public TextField char3;
    public TextField char4;
    public TextField char5;
    public TextField char6;
    public TextField char7;
    public TextField char8;
    public TextField char9;
    public TextField char10;
    public TextField char11;
    public TextField char12;
    public TextField binaryCode;
    public Label binaryCode2;
    public Label decimalCode;
    public Label saida;
    public TextField firstLine;
    public TextField SecondLine;
    public TextField descodfield1;
    public TextField descodfield2;
    public TextField descodfield3;
    public TextField descodfield4;
    public TextField descodfield5;
    public TextField descodfield6;
    public TextField descodfield7;
    public TextField descodfield8;
    public TextField descodfield9;
    public TextField descodfield10;
    public TextField descodfield11;
    public TextField descodfield12;

    //TABLEVIEWS

    public TableView tabledescod;
    public TableView tablealfabeto;

    //BUTTONS

    public Button btn_add;
    public Button btn_add2;
    public Button btn_decimal;
    public Button seguintebutton;
    public Button seguintebutton2;
    public Button guardardados;
    public Button seguirCod;
    public Button comecarCod;
    public Button descodificar;
    public Button button_descod;

    //TABS

    public Tab alfaTab;
    public Tab descodTab;
    public Tab dadosacomprimir;
    public Tab codificacao;
    public Tab codi;
    public Tab coditab;
    public Tab dadosacomprimirTab;
    public Tab codifiTab;

    //TABPANES

    public TabPane descodPane;
    public TabPane tabPane;
    public TabPane codTabPane;

    //PANES

    public Pane compressao;
    public Pane paneCod;
    public Pane firstPaneCod;
    public Pane paneCode1;
    public Pane paneCode2;
    public Pane paneCode3;
    public Pane paneCode4;
    public Pane paneCode5;
    public Pane paneCode6;
    public Pane paneCode7;
    public Pane paneCode8;
    public Pane paneCode9;
    public Pane paneCode10;
    public Pane paneCode11;
    public Pane paneCode12;
    public Pane binaryPane;

    //AnchorPane

    public AnchorPane CodificacaoPane;
    public AnchorPane InitialPane;

    //HBOX

    public HBox labelList;
    public HBox labelList1;

    //ARRAYLISTS

    public ArrayList<Alfabeto> listalfabetos = new ArrayList();
    public ArrayList<Pane> panelist = new ArrayList<>();
    public ArrayList<TextField> upTextFieldsList = new ArrayList<>();
    public ArrayList<TextField> downTextFieldsList = new ArrayList<>();
    public ArrayList<TextField> chars = new ArrayList<>();
    public ArrayList<TextField> valoresDescod = new ArrayList<>();
    public ArrayList<Double> probCum = new ArrayList<>();
    public ArrayList<String> fi = new ArrayList();


    //DOUBLES

    public double allpercentage;
    public double pii = 0;
    public double pi2;
    public Double lastPii;
    public Double firstPii;
    public Double subintervalo_superior;
    public Double subintervalo_inferior;

    //INTEGER

    public Integer size = 0;
    public Integer next = 0;


    StringBuilder binary = new StringBuilder("0.0");
    public String intervalo;
    public String dadosparacompressao;
    public Character letraa;


    public void buttonAdd(ActionEvent actionEvent) {
        BigDecimal valorExato = new BigDecimal(pii).setScale(2, RoundingMode.HALF_EVEN);
        pi2 = pii + Double.parseDouble(getPi.getText());
        BigDecimal pi2ValorExato = new BigDecimal(pi2).setScale(2, RoundingMode.HALF_EVEN);
        intervalo = "[" + valorExato + ";" + pi2ValorExato + "]";
        Alfabeto alfabeto = new Alfabeto(getSi.getText(), Double.parseDouble(getPi.getText()), intervalo);
        allpercentage += Double.parseDouble(getPi.getText());
        tablealfabeto.getItems().add(alfabeto);
        pii = pi2;
        getSi.clear();
        getPi.clear();
        listalfabetos.add(alfabeto);
        size++;
    }


    public void seguinte(ActionEvent actionEvent) {


        allpercentage = Math.round(allpercentage);

        if (allpercentage != 1) {
            System.out.println("ERRO !! Corriga a percentagem do Alfabeto, percentagem não é igual a 1");
        } else {
            seguintebutton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    codTabPane.getSelectionModel().select(dadosacomprimirTab);
                }
            });
        }
    }


    public void guardardadospressed(ActionEvent actionEvent) {

        dadosparacompressao = dadosinseridos.getText();
        guardardados.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                codTabPane.getSelectionModel().select(codifiTab);
            }
        });


    }

    public void comecarCodifc(ActionEvent actionEvent) {

        comecarCod.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                paneCode1.setVisible(true);
                Character letra = dadosparacompressao.charAt(0);
                addNumbersToUpLine(letra);
                initializepanes();
                initializeDownTextFields();
                initializeUpTextFields();
                initializechars();

                seguirCod.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        letraa = dadosparacompressao.charAt(next + 1);
                        addNumberToDownLine(letraa, next, lastPii, firstPii);
                        if (letraa.compareTo(dadosparacompressao.charAt(dadosparacompressao.length() - 1)) == 0) {
                            convertToBinary(firstPii, lastPii);
                            allpercentage = 0;
                        }
                        next++;
                    }

                });
            }

        });


    }

    public void addNumbersToUpLine(Character letra) {
        for (int i = 0; i < listalfabetos.size(); i++) {
            Character letraTeste = listalfabetos.get(i).getSi().charAt(0);
            if (letraTeste.compareTo(letra) == 0) {
                String[] lastPi = listalfabetos.get(i).getLastpi().split(";");
                String number = lastPi[0];
                String number2 = lastPi[1];
                number = number.substring(1);
                number2 = number2.substring(0, number2.length() - 1);
                lastPii = Double.parseDouble(number);
                firstPii = Double.parseDouble(number2);
                upLine1.setText(firstPii.toString());
                downLine1.setText(lastPii.toString());
                char1.setText(letra.toString());
                listalfabetos.get(0).setSub_lower(0.00);
                listalfabetos.get(0).setSub_higher(Double.parseDouble(number2));
            }
        }
    }


    public void addNumberToDownLine(Character letraaa, Integer line, Double down, Double up) {
        for (int i = 0; i < listalfabetos.size(); i++) {
            Character letraAlfabeto = listalfabetos.get(i).getSi().charAt(0);
            if (letraAlfabeto.compareTo(letraaa) == 0) {
                String[] intervalo = listalfabetos.get(i).getLastpi().split(";");
                String number = intervalo[0];
                String number1 = intervalo[1];
                number = number.substring(1);
                number1 = number1.substring(0, number1.length() - 1);
                listalfabetos.get(i).setSub_lower(Double.parseDouble(number));
                listalfabetos.get(i).setSub_higher(Double.parseDouble(number1));
                subintervalo_superior = Double.parseDouble(number1);
                subintervalo_inferior = Double.parseDouble(number);
            }
        }

        Pane test = panelist.get(line);
        firstPii = down + ((up - down) * subintervalo_superior);
        lastPii = down + ((up - down) * subintervalo_inferior);
        test.setVisible(true);
        TextField upField = upTextFieldsList.get(line);
        TextField downField = downTextFieldsList.get(line);
        TextField chr = chars.get(line);
        upField.setText(firstPii.toString());
        downField.setText(lastPii.toString());
        chr.setText(letraaa.toString());

    }




    public void convertToBinary(double High, double Low) {
        int k = 1;
        while (convertToDecimal(binary.toString()) < Low) {
            if (k == 1)
                binary.setCharAt(binary.length() - 1, '1');
            else
                binary.append('1');

            if (convertToDecimal(binary.toString()) > High)
                binary.setCharAt(binary.length() - 1, '0');

            k++;
        }
        binaryCode.setText(binary.toString());
        binaryPane.setVisible(true);
        binaryCode2.setText(binary.toString());
    }

    public static double convertToDecimal(String binary) {
        int placesAfterPoint = binary.length() - binary.indexOf(".") - 1;
        long numerator = Long.parseLong(binary.replace(".", ""), 2);
        double value = ((double) numerator) / (1L << placesAfterPoint);

        return value;
    }

    public void decimalC(ActionEvent actionEvent) {
        double d = convertToDecimal(binary.toString());
        decimalCode.setText(String.valueOf(d));
    }

    public void gerarTabela(ActionEvent actionEvent) {
        String s=" ";
        for(int i = 0; i < listalfabetos.size(); i++)
        {
            int j = listalfabetos.size();
            String[] intervalo = listalfabetos.get(i).getLastpi().split(";");
            String number = intervalo[0];
            String number1 = intervalo[1];
            number = number.substring(1);
            number1 = number1.substring(0,number1.length()-1);
            subintervalo_superior = Double.parseDouble(number1);
            subintervalo_inferior = Double.parseDouble(number);
            Double probcum = subintervalo_inferior;
            BigDecimal valorExato = new BigDecimal(probcum).setScale(2, RoundingMode.HALF_EVEN);
            probCum.add(probcum);
            Integer p = listalfabetos.size();
            Descodificacao alfabetoo = new Descodificacao(listalfabetos.get(i).getSi(),p-i, Math.round(subintervalo_inferior * 100.0)/100.0);
            tabledescod.getItems().add(alfabetoo);
        }
        Descodificacao d1 = new Descodificacao(s, 0, 1.0);
        tabledescod.getItems().add(d1);
        probCum.add(1.00);
    }



     public void Desc() {
        initializeValorDescod();
        int k = 0;
        Character letradescomp = null;
        Double valor = convertToDecimal(binary.toString());
        double a_alto = 1, a_baixo = 0, largura = 1, ii = 0;
        for (int i = 0; i < dadosparacompressao.length(); i++) {


            for (int j = 0; j <= listalfabetos.size(); j++) {
                ii = (valor - a_baixo)/largura;
                System.out.println(ii);
                if (probCum.get(k) <= ii && probCum.get(k+1) > ii) {

                    /* FUNÇÕES DE TESTE PARA IMPRIMIR NO TERMINAL
                    System.out.println(probCum.get(k)+"  " + probCum.get(k+1));
                    System.out.println("TETSTETETE");
                    */

                    letradescomp = listalfabetos.get(k).getSi().charAt(0);
                    System.out.println(letradescomp);
                    fi.add(letradescomp.toString());
                    String[] intervalo = listalfabetos.get(k).getLastpi().split(";");
                    String number = intervalo[0];
                    String number1 = intervalo[1];
                    number = number.substring(1);
                    number1 = number1.substring(0, number1.length() - 1);
                    subintervalo_superior = Double.parseDouble(number1);
                    subintervalo_inferior = Double.parseDouble(number);
                    a_alto = a_baixo + largura * probCum.get(k+1);
                    a_baixo = a_baixo + largura * subintervalo_inferior;
                    System.out.println("Valor a_alto: " + a_alto + " valor a_baixo: " + a_baixo);
                    largura = a_alto - a_baixo;
                    k = 0;
                    if(letradescomp == dadosparacompressao.charAt(dadosparacompressao.length()-1))
                        return;
                }
                else
                {
                    k++;
                }
            }

        }
    }

    public void seguinte2(ActionEvent actionEvent) {

        allpercentage = Math.round(allpercentage);

        if (allpercentage != 1) {
            System.out.println("ERRO !! Corriga a percentagem do Alfabeto, percentagem não é igual a 1");
        } else {
            seguintebutton2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    descodPane.getSelectionModel().select(descodTab);
                }
            });
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        sicol.setCellValueFactory(new PropertyValueFactory<>("si"));
        picol.setCellValueFactory(new PropertyValueFactory<>("pi"));
        subintcol.setCellValueFactory(new PropertyValueFactory<>("lastpi"));
        sicoldescod.setCellValueFactory(new PropertyValueFactory<>("sides"));
        picoldescod.setCellValueFactory(new PropertyValueFactory<>("ides"));
        probcumdescod.setCellValueFactory(new PropertyValueFactory<>("probacum"));

    }

    public void buttonDescod(ActionEvent actionEvent) {
        button_descod.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("TESTE");
                Desc();
                for(int i = 0; i < dadosparacompressao.length(); i++)
                {
                    TextField text = valoresDescod.get(i);
                    text.setText(fi.get(i));
                    text.setVisible(true);
                }
            }
        });
    }


    public void initializepanes() {
        panelist.add(paneCode2);
        panelist.add(paneCode3);
        panelist.add(paneCode4);
        panelist.add(paneCode5);
        panelist.add(paneCode6);
        panelist.add(paneCode7);
        panelist.add(paneCode8);
        panelist.add(paneCode9);
        panelist.add(paneCode10);
        panelist.add(paneCode11);
        panelist.add(paneCode12);
    }

    public void initializeUpTextFields() {
        upTextFieldsList.add(upLine2);
        upTextFieldsList.add(upLine3);
        upTextFieldsList.add(upLine4);
        upTextFieldsList.add(upLine5);
        upTextFieldsList.add(upLine6);
        upTextFieldsList.add(upLine7);
        upTextFieldsList.add(upLine8);
        upTextFieldsList.add(upLine9);
        upTextFieldsList.add(upLine10);
        upTextFieldsList.add(upLine11);
        upTextFieldsList.add(upLine12);
    }

    public void initializeDownTextFields() {
        downTextFieldsList.add(downLine2);
        downTextFieldsList.add(downLine3);
        downTextFieldsList.add(downLine4);
        downTextFieldsList.add(downLine5);
        downTextFieldsList.add(downLine6);
        downTextFieldsList.add(downLine7);
        downTextFieldsList.add(downLine8);
        downTextFieldsList.add(downLine9);
        downTextFieldsList.add(downLine10);
        downTextFieldsList.add(downLine11);
        downTextFieldsList.add(downLine12);
    }

    public void initializechars() {
        chars.add(char2);
        chars.add(char3);
        chars.add(char4);
        chars.add(char5);
        chars.add(char6);
        chars.add(char7);
        chars.add(char8);
        chars.add(char9);
        chars.add(char10);
        chars.add(char11);
        chars.add(char12);
    }

    public void initializeValorDescod()
    {
        valoresDescod.add(descodfield1);
        valoresDescod.add(descodfield2);
        valoresDescod.add(descodfield3);
        valoresDescod.add(descodfield4);
        valoresDescod.add(descodfield5);
        valoresDescod.add(descodfield6);
        valoresDescod.add(descodfield7);
        valoresDescod.add(descodfield8);
        valoresDescod.add(descodfield9);
        valoresDescod.add(descodfield10);
        valoresDescod.add(descodfield11);
        valoresDescod.add(descodfield12);
    }
}
