package com.college;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Detail.class)
                .addAnnotatedClass(ElectronicsPassport.class)
                .addAnnotatedClass(RepairRequest.class)
                .addAnnotatedClass(InstalledDetail.class)
                .buildSessionFactory();

        try (Session session = factory.openSession()) {
            List<RepairRequest> requests = session.createQuery(
                    "FROM RepairRequest request JOIN FETCH request.electronicsPassport",
                    RepairRequest.class)
                    .getResultList();

            for (RepairRequest request : requests) {
                ElectronicsPassport passport = request.getElectronicsPassport();
                System.out.printf("Request %d: %s - %s (%s)%n",
                        request.getId(),
                        request.getDateOfRequest(),
                        passport.getNameOfElectronic(),
                        passport.getTypeOfElectronic());
            }
        } finally {
            factory.close();
        }
    }
}
