import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Controller {

    @FXML
    private TextField agora,agoraFpa,lianiki,lianikiFpa,kerdos,fpa,posostoKerdous,decimals;

    private int decimalsValue,fpaInt;
    private double agoraPrice,agoraFpaPrice,posostoKerdousDouble,lianikiPrice,lianikiFpaPrice,kerdosPrice;

    public void initialize() {
        try {
            getDecimals();
            getFpa();
            getPosostoKerdous();
            agoraPrice=0;
            agoraFpaPrice=0;
            lianikiPrice=0;
            lianikiFpaPrice=0;
            kerdosPrice=0;


            System.out.println("ok initialize");
        }catch (NumberFormatException e){
            System.out.println("error initialize");
        }
    }

    public void getDecimals(){
        try {
            if (!decimals.getText().matches("")) {
                decimalsValue = Integer.parseInt(decimals.getText());
                if (decimalsValue < 0) {
                    decimalsValue = 0;
                    decimals.setText("" + decimalsValue);
                }
            }else{
                decimalsValue = 0;
                //decimals.setText("" + decimalsValue);
            }
            typedAgora();

        }catch (NumberFormatException e){
            System.out.println("error decimals");
            decimals.setText(""+decimalsValue);
        }
    }

    public void getFpa(){
        try {
            if (!fpa.getText().matches("")) {
                fpaInt = Integer.parseInt(fpa.getText());
                if (fpaInt < 0) {
                    fpaInt = 0;
                    fpa.setText("" + fpaInt);
                }
                if (fpaInt >50){
                    fpaInt = 50;
                    fpa.setText("" + fpaInt);
                }
            }else{
                fpaInt = 0;
               //fpa.setText("" + fpaInt);
            }
            typedAgora();
        }catch (NumberFormatException e){
            System.out.println("error fpa value");
            fpa.setText(""+fpaInt);
        }
    }


    public void getPosostoKerdous(){
        try {
            if (!posostoKerdous.getText().matches("")) {
                posostoKerdousDouble = Double.parseDouble(posostoKerdous.getText());
                if (posostoKerdousDouble < 0) {
                    posostoKerdousDouble = 0;
                    posostoKerdous.setText("" + posostoKerdousDouble);
                }

            }else{
                posostoKerdousDouble = 0;
                //posostoKerdous.setText("" + posostoKerdousDouble);
            }
            typedAgora();
        }catch (NumberFormatException e){
            System.out.println("error pososto kerdous value");
            posostoKerdous.setText(""+posostoKerdousDouble);
        }
    }

    public void typedAgora(){

        try{

            if (!agora.getText().matches("")) {
                agoraPrice = Double.parseDouble(agora.getText());
                if (agoraPrice < 0) {
                    agoraPrice = 0;
                    agora.setText("" + agoraPrice);
                }

            }else{
                agoraPrice = 0;
                //agora.setText("" + agoraPrice);
            }







            agoraFpaPrice= agoraPrice * (fpaInt +100)/100;

            agoraFpa.setText(""+round(agoraFpaPrice));

            lianikiPrice=agoraPrice * (posostoKerdousDouble +100)/100;
            lianiki.setText(""+round(lianikiPrice));

            lianikiFpaPrice= lianikiPrice * (fpaInt +100)/100;
            lianikiFpa.setText(""+round(lianikiFpaPrice));

            kerdosPrice=lianikiPrice-agoraPrice;
            kerdos.setText(""+round(kerdosPrice));

        }catch (NumberFormatException e){
            System.out.println("type number please");
            agora.setText(""+agoraPrice);
        }

    }

    public void typedAgoraFPA(){

        try{

            if (!agoraFpa.getText().matches("")) {
                agoraFpaPrice = Double.parseDouble(agoraFpa.getText());
                if (agoraFpaPrice < 0) {
                    agoraFpaPrice = 0;
                    agoraFpa.setText("" + agoraFpaPrice);
                }

            }else{
                agoraFpaPrice = 0;
               // agoraFpa.setText("" + agoraFpaPrice);
            }




            agoraPrice= agoraFpaPrice / (((double)fpaInt +100)/100);
            agora.setText(""+round(agoraPrice));

            lianikiPrice=agoraPrice * (posostoKerdousDouble +100)/100;
            lianiki.setText(""+round(lianikiPrice));

            lianikiFpaPrice= lianikiPrice * (fpaInt +100)/100;
            lianikiFpa.setText(""+round(lianikiFpaPrice));

            kerdosPrice=lianikiPrice-agoraPrice;
            kerdos.setText(""+round(kerdosPrice));

        }catch (NumberFormatException e){
            System.out.println("type number please");
            agoraFpa.setText(""+agoraFpaPrice);
        }

    }






    public double round(double value) {
        int places=decimalsValue;
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
