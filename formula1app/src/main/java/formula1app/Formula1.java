package formula1app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import soapcsomag.MNBArfolyamServiceSoap;

import soapcsomag.MNBArfolyamServiceSoapGetDateIntervalStringFaultFaultMessage;
import soapcsomag.MNBArfolyamServiceSoapImpl;


public class Formula1 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Formula1.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("Formula1 adatbazis");

        VBox foNode = new VBox();
        Button bt1 = new Button("Gomb1");
        foNode.getChildren().add(bt1);

        stage.setScene(scene);
        stage.show();

        // Create();

        bt1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               // Create();
            }
        });
    }

    void Create(){
        System.out.println("Beír()........");
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        //FormModel form =new FormModel(12, "Horváth Éva","minden rendben", "2023.11.25 12:04");
        FormModel form = new FormModel();

/*        FormModel form =new FormModel();
        form.setName("Horváth Éva");
        form.setMessage("minden rendben");
        form.setSent("2023.11.25 12:04");*/

        session.save(form);
        t.commit();
    }

    public static void main(String[] args) {

        launch();

        MNBArfolyamServiceSoapImpl impl = new MNBArfolyamServiceSoapImpl();
        MNBArfolyamServiceSoap service =
                impl.getCustomBindingMNBArfolyamServiceSoap();
        try {
            System.out.println(service.getInfo());
            System.out.println(service.getCurrentExchangeRates());
            System.out.println(service.getExchangeRates("2022-08-14","2022-09-14","EUR"));
        } catch (Exception e) {
            System.err.print(e);
        }

    }
}